package com.spring.demo.rest;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ResourceConstants.CUS_SELL_USERS_V1)
@Api(value = "Customer Seller Details", description = "Do all CRUD activites of customers and sellers", tags = ("customers,sellers"))
public class UsersResource {


}
