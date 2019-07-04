package com.spring.demo.rest;

import com.spring.demo.entity.ReservationEntity;
import com.spring.demo.entity.ResetPassword;
import com.spring.demo.entity.RoomEntity;
import com.spring.demo.entity.User;
import com.spring.demo.model.request.ReservationRequest;
import com.spring.demo.model.request.ResetPasswordRequest;
import com.spring.demo.model.response.ReservationResponse;
import com.spring.demo.model.response.ReserveResponse;
import com.spring.demo.model.response.ResetPasswordResponse;
import com.spring.demo.repository.*;
import converter.RoomEntityToReservationResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
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



}
