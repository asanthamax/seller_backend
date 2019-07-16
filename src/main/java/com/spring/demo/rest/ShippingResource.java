package com.spring.demo.rest;

import com.spring.demo.entity.ShippingMethod;
import com.spring.demo.errors.FileStorageException;
import com.spring.demo.errors.RequestNotFoundException;
import com.spring.demo.services.FileStorageService;
import com.spring.demo.services.ShippingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(ResourceConstants.SHIP_V1)
@Api(value = "shipping details endpoint", description = "this is the endpoint to do shiiping method related crud operations", tags = ("shipping_details"))
public class ShippingResource {

    private final FileStorageService fileStorageService;

    private final ShippingService shippingService;

    @Autowired
    public ShippingResource(FileStorageService fileService, ShippingService shipService){

        this.fileStorageService = fileService;
        this.shippingService = shipService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('READ_SHIPPING')")
    @ApiOperation(value = "get all shipping methods", notes = "Retrieve all the shipping methods available", nickname = "getAllShippings")
    public ResponseEntity<List<ShippingMethod>> getAllShippings() throws RequestNotFoundException {

        try{

            return new ResponseEntity<>(this.shippingService.getShippings(), HttpStatus.ACCEPTED);
        }catch (DataAccessException ex){

            throw new RequestNotFoundException(ex.getMessage(), ex);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('READ_SHIPPING')")
    @ApiOperation(value = "get single shipping", notes = "get single shipping details by shipping id", nickname = "getSingleShipping")
    public ResponseEntity<ShippingMethod> getSingleShipping(@PathVariable("id") Long id) throws RequestNotFoundException {

        try{

            return new ResponseEntity<>(this.shippingService.getSingleShipping(id), HttpStatus.ACCEPTED);
        }catch (RequestNotFoundException ex){

            throw new RequestNotFoundException(ex.getMessage(), ex);
        }
    }

    @RequestMapping(value = "/save_shipping", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('READ_WRITE_SHIPPING')")
    @ApiOperation(value = "add new shpping method", notes = "add a new shipping method from here", nickname = "saveShippingDetails")
    public ResponseEntity saveShippingDetails(@RequestParam("file")MultipartFile file, @RequestParam("company") String shippingCompany
                                                ,@RequestParam("ship_code")String shippingCode, @RequestParam("ship_method")String shippingMethod
                                                ,@RequestParam("ship_charge")Double shipping_charge) throws FileStorageException {

            try {
                String fileName = fileStorageService.storeFile(file);
                String logoURl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/uploads/").path("shipping").path(fileName).toUriString();
                ShippingMethod shipMethod = new ShippingMethod(shippingCompany, logoURl, shippingCode, shippingMethod, shipping_charge);
                this.shippingService.saveShippingMethod(shipMethod);
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }catch (FileStorageException e) {

                throw new FileStorageException(e.getMessage(), e);
            }
    }

    @RequestMapping(value = "/update_shipping", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('READ_WRITE_SHIPPING')")
    @ApiOperation(value = "update shpping method", notes = "update shipping method from here", nickname = "updateShippingDetails")
    public ResponseEntity updateShippingDetails(@RequestParam("file")MultipartFile file, @RequestParam("company") String shippingCompany
            ,@RequestParam("ship_code")String shippingCode, @RequestParam("ship_method")String shippingMethod
            ,@RequestParam("ship_charge")Double shipping_charge, @RequestParam("id") Long id) throws FileStorageException {

        try {
            String logoURl = fileStorageService.storeFile(file);
            ShippingMethod shipMethod = new ShippingMethod(shippingCompany, logoURl, shippingCode, shippingMethod, shipping_charge);
            shipMethod.setId(id);
            this.shippingService.saveShippingMethod(shipMethod);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch (FileStorageException e) {

            throw new FileStorageException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/delete_shipping", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('READ_WRITE_SHIPPING')")
    @ApiOperation(value = "delete new shpping method", notes = "delete a new shipping method from here", nickname = "saveShippingDetails")
    public ResponseEntity deleteShippingDetails(@RequestParam("file")MultipartFile file, @RequestParam("company") String shippingCompany
            ,@RequestParam("ship_code")String shippingCode, @RequestParam("ship_method")String shippingMethod
            ,@RequestParam("ship_charge")Double shipping_charge, @RequestParam("id") Long id) throws FileStorageException{

        try {
            String fileName = fileStorageService.storeFile(file);
            String logoURl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/uploads/").path("shipping").path(fileName).toUriString();
            ShippingMethod shipMethod = new ShippingMethod(shippingCompany, logoURl, shippingCode, shippingMethod, shipping_charge);
            shipMethod.setId(id);
            this.shippingService.deleteShippingMethod(shipMethod);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch(FileStorageException e){

            throw new FileStorageException(e.getMessage(), e);
        }
    }
}
