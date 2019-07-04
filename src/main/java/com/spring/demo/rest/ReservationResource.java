package com.spring.demo.rest;

import com.spring.demo.entity.ReservationEntity;
import com.spring.demo.entity.ResetPassword;
import com.spring.demo.entity.RoomEntity;
import com.spring.demo.entity.User;
import com.spring.demo.errors.RestServiceException;
import com.spring.demo.model.request.PasswordResetRequest;
import com.spring.demo.model.request.ReservationRequest;
import com.spring.demo.model.request.ResetPasswordRequest;
import com.spring.demo.model.response.PasswordResettedResponse;
import com.spring.demo.model.response.ReservationResponse;
import com.spring.demo.model.response.ReserveResponse;
import com.spring.demo.model.response.ResetPasswordResponse;
import com.spring.demo.repository.*;
import converter.RoomEntityToReservationResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class ReservationResource {

    @Autowired
    PageableRoomRepository pageableRoomRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ConversionService conversionService;

    @Autowired
    ResetPasswordRepository resetPasswordRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('ROOMS_READ')")
    public Page<ReservationResponse> getAvailableRooms(
            @RequestParam(value = "checkin")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checIn,
            @RequestParam(value = "checkout")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkOut, Pageable pageable){

        Page<RoomEntity> roomEntityList = pageableRoomRepository.findAll(pageable);
        return roomEntityList.map(p -> new RoomEntityToReservationResponseConverter().convert(p));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RoomEntity> getRoomById(@PathVariable Long id){

        Optional<RoomEntity> room = roomRepository.findById(id);
        return room.map(roomEntity -> new ResponseEntity<>(roomEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReserveResponse> createReservation(
            @RequestBody
            ReservationRequest reservationRequest
    ){

        ReservationEntity reservation = conversionService.convert(reservationRequest, ReservationEntity.class);
        reservationRepository.save(reservation);

        Optional<RoomEntity> entity = roomRepository.findById(reservationRequest.getRoomId());
        ReserveResponse response = null;
        if(entity.isPresent()) {

            RoomEntity roomEntity = entity.get();
            roomEntity.addReservationEntity(reservation);
            roomRepository.save(roomEntity);
            reservation.setRoomEntity(roomEntity);

            response = conversionService.convert(reservation, ReserveResponse.class);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else{

            return new ResponseEntity<>(response, HttpStatus.FAILED_DEPENDENCY);
        }

    }

    @RequestMapping(path="", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> updateReservation(
            @RequestBody
            ReservationRequest reservationRequest
    ){
        return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{reservationId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteReservation(

            @PathVariable
            long reservationId
    ){

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/forget_password", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ResetPasswordResponse> resetPassword(

            @RequestBody
            ResetPasswordRequest resetPasswordRequest
    ){

        try {

            User user = userRepository.findByUserName(resetPasswordRequest.getEmail());
            if(user == null){

                throw new UsernameNotFoundException(resetPasswordRequest.getEmail());
            }
            LocalDate sourceDate = LocalDate.now();
            LocalDate expireDate = sourceDate.plusDays(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String expire = expireDate.format(formatter);
            Date expireD = new SimpleDateFormat("yyyy-MM-dd").parse(expire);
            ResetPassword resetPassword1 = new ResetPassword(UUID.randomUUID().toString(), expireD, user);
            resetPasswordRepository.save(resetPassword1);
            ResetPasswordResponse response = conversionService.convert(resetPassword1, ResetPasswordResponse.class);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(DataAccessException ex){

            throw new RestServiceException(ex);
        } catch (ParseException e) {

            throw new RestServiceException("Server Error Occurred");
        }
    }

    @RequestMapping(path = "/reset_password", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PasswordResettedResponse> updatePassword(@RequestBody PasswordResetRequest resetRequest){

        try{

            if(!resetRequest.getPassword().equals(resetRequest.getConfirmPassword())){

                throw new RestServiceException("Passwords not matched");
            }
            Optional<User> user = userRepository.findById(resetRequest.getUserId());
            if(!user.isPresent()){

                throw new RestServiceException("Invalid user id,user not found");
            }
            User userToUpdate = user.get();
            Optional<ResetPassword> resetData = resetPasswordRepository.findById(resetRequest.getId());
            if(!resetData.isPresent()){

                throw new RestServiceException("Not a valid request");
            }
            if(!resetData.get().getToken().equals(resetRequest.getToken())){

                throw new RestServiceException("Invalid reset token");
            }
            if(!resetData.get().getExpiryDate().after(new Date())){

                throw new RestServiceException("reset token expired");
            }
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(resetRequest.getPassword());
            userToUpdate.setPassword(encodedPassword);
            userRepository.save(userToUpdate);
            PasswordResettedResponse resettedResponse = new PasswordResettedResponse();
            resettedResponse.setMessage("Password reset successfully!!!");
            resettedResponse.setDatetime(new Date());
            resettedResponse.setStatus(true);
            return new ResponseEntity<>(resettedResponse, HttpStatus.CREATED);
        }catch(RestServiceException ex){

            throw ex;
        }catch(DataAccessException ex){

            throw new RestServiceException(ex);
        }
    }
}
