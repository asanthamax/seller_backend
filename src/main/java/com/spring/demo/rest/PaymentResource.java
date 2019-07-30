package com.spring.demo.rest;

import com.spring.demo.errors.RequestNotFoundException;
import com.spring.demo.model.request.PaymentsRequest;
import com.spring.demo.model.response.PaymentsResponse;
import com.spring.demo.services.PaymentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = ResourceConstants.PAY_V1)
@Api(value = "payment details", description = "get all payment related details and update details", tags = ("payments"))
public class PaymentResource {

    private final PaymentsService paymentsService;

    @Autowired
    public PaymentResource(PaymentsService payService){

        paymentsService = payService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('READ_PAYMENTS')")
    @ApiOperation(value = "get all payments to be paid", notes = "get all payments which have payment due", nickname = "getAllPayments")
    public ResponseEntity<PaymentsResponse> getAllPayments(Pageable pageable) throws RequestNotFoundException {

        try{

            return new ResponseEntity<>(paymentsService.getAllPayables(pageable), HttpStatus.ACCEPTED);
        }catch (DataAccessException ex){

            throw new RequestNotFoundException(ex.getMessage(), ex);
        }
    }

    @RequestMapping(value = "/update_payments", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('READ_WRITE_PAYMENTS')")
    @ApiOperation(value = "update all payables", notes = "update all the payable amounts in database", nickname = "updatePayments")
    public ResponseEntity updatePayments(@RequestBody List<PaymentsRequest> paymentsRequest) throws RequestNotFoundException{

        try{

            paymentsService.updateAllPayables(paymentsRequest);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch (RequestNotFoundException ex){

            throw new RequestNotFoundException(ex.getMessage(), ex);
        }
    }

    @RequestMapping(value = "/paid", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('READ_PAYMENTS')")
    @ApiOperation(value = "get all paid payments", notes = "get all paid payments", nickname = "getAllPaid")
    public ResponseEntity<PaymentsResponse> getAllPaid(Pageable pageable) throws RequestNotFoundException{

        try{

            return new ResponseEntity<>(paymentsService.getAllPaids(pageable), HttpStatus.ACCEPTED);
        }catch (DataAccessException ex){

            throw new RequestNotFoundException(ex.getMessage(), ex);
        }
    }

    @RequestMapping(value = "/update_payment_status", method = RequestMethod.PUT)
    @ApiOperation(value = "update all payable payment", notes = "update all the payable payment status in database in a cron job", nickname = "updatePaymentStatus")
    public ResponseEntity updatePaymentStatus() throws RequestNotFoundException{

        try{

            paymentsService.updatePaymentStatus();
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch (DataAccessException ex){

            throw new RequestNotFoundException(ex.getMessage(), ex);
        }
    }
}
