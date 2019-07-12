package com.spring.demo.rest;

import com.spring.demo.errors.RequestNotFoundException;
import com.spring.demo.model.request.MessageRequest;
import com.spring.demo.model.response.MessagesResponse;
import com.spring.demo.services.MessagesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ResourceConstants.MSG_V1)
@Api(value = "send recieve messages", description = "Send and recieve messages through this endpoint", tags = ("messages"))
public class MessageResource {

    private final MessagesService messagesService;

    @Autowired
    public MessageResource(MessagesService msgService){

        this.messagesService = msgService;
    }

    @RequestMapping(value = "/all_messages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('READ_MESSAGES')")
    @ApiOperation(value = "get all messages", notes = "this endpoint retrieve all the messages belongs to order id", nickname = "getAllMessages")
    public Page<MessagesResponse> getAllMessages(Pageable pageable) throws RequestNotFoundException{

        try {

            return messagesService.getAllMessages(pageable);
        }catch (DataAccessException ex){

            throw new RequestNotFoundException(ex.getMessage(), ex);
        }
    }

    @RequestMapping(value = "/save_message", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('READ_WRITE_MESSAGES')")
    @ApiOperation(value = "save new message", notes = "this endpoint will save new message to message thread belongs to order", nickname = "saveMessage")
    public ResponseEntity saveMessgae(@RequestBody MessageRequest messageRequest) throws RequestNotFoundException {

        try {

            messagesService.saveNewMessage(messageRequest);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (RequestNotFoundException ex){

            throw new RequestNotFoundException(ex.getMessage(), ex);
        }
    }

    @RequestMapping(value = "/messages_by_order/{orderID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('READ_MESSAGES')")
    @ApiOperation(value = "get messages by order id", notes = "get all messages by the given order id", nickname = "getMessagesByOrder")
    public Page<MessagesResponse> getMessagesByOrder(Pageable pageable, @PathVariable("orderID") Long orderId) throws RequestNotFoundException{

        try {

            return messagesService.getMessagesByOrder(pageable, orderId);
        }catch (DataAccessException ex){

            throw new RequestNotFoundException(ex.getMessage(), ex);
        }
    }
}
