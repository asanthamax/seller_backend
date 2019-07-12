package com.spring.demo.rest;

import com.spring.demo.errors.RequestNotFoundException;
import com.spring.demo.model.response.OrderResponse;
import com.spring.demo.services.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping(ResourceConstants.ORDR_V1)
@Api(value = "get order details", description = "get all order details and single order details", tags = ("orders"))
public class OrderResource {

    private final OrderService orderService;

    @Autowired
    public OrderResource(OrderService service){

        orderService = service;
    }

    @RequestMapping(value = "/{sellerID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('READ_ORDERS')")
    @ApiOperation(value = "get all orders by seller id", notes = "get all the orders of a seller recieved", nickname = "getAllOrders")
    public Page<OrderResponse> getAllOrders(Pageable pageable, @PathVariable("sellerID") Long sellerID) throws RequestNotFoundException {

        try{

            return orderService.getAllOrders(pageable, sellerID);
        }catch (DataAccessException ex){

            throw new RequestNotFoundException(ex.getMessage(), ex);
        }
    }

    @RequestMapping(value = "/single_order/{orderID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('READ_ORDERS')")
    @ApiOperation(value = "get single order", notes = "get single order by order id", nickname = "getSingleOrder")
    public ResponseEntity<OrderResponse> getSingleOrder(@PathVariable("orderID") Long orderId) throws RequestNotFoundException{

        try{

           OrderResponse response = orderService.getSingleOrder(orderId);
           return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch(RequestNotFoundException ex){

            throw new RequestNotFoundException(ex.getMessage(), ex);
        }
    }
}
