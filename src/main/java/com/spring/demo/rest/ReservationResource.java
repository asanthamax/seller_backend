package com.spring.demo.rest;

import com.spring.demo.entity.ResetPassword;
import com.spring.demo.entity.User;
import com.spring.demo.errors.RequestNotFoundException;
import com.spring.demo.errors.RestServiceException;
import com.spring.demo.model.request.PasswordResetRequest;
import com.spring.demo.model.request.ResetPasswordRequest;
import com.spring.demo.model.response.PasswordResettedResponse;
import com.spring.demo.model.response.ResetPasswordResponse;
import com.spring.demo.repository.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(ResourceConstants.USER_V1)
@Api(value = "User Authentication details", description = "User Authentication related operations handled in the route", tags = ("users"))
public class ReservationResource {

    private final ConversionService conversionService;

    private final ResetPasswordRepository resetPasswordRepository;

    private final UserRepository userRepository;

    @Autowired
    public ReservationResource(ConversionService conversionService, ResetPasswordRepository resetPasswordRepository, UserRepository userRepository) {
        this.conversionService = conversionService;
        this.resetPasswordRepository = resetPasswordRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(path = "/forget_password", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Reset Password", notes = "Accept password reset request and response with user Id and password reset token", nickname = "resetPassword")
    public ResponseEntity<ResetPasswordResponse> resetPassword(

            @RequestBody
            ResetPasswordRequest resetPasswordRequest
    ) throws RequestNotFoundException{

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

            throw new RequestNotFoundException(ex.getMessage(), ex);
        }catch (ParseException e) {

            throw new RequestNotFoundException(e.getMessage(), e);
        }
    }

    @RequestMapping(path = "/reset_password", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Reset to new password", notes = "Accept new password with reset token and user id and update to new password", nickname = "updatePassword")
    public ResponseEntity<PasswordResettedResponse> updatePassword(@RequestBody PasswordResetRequest resetRequest) throws RequestNotFoundException{

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

            throw new RequestNotFoundException(ex.getMessage(), ex);
        }
    }
}
