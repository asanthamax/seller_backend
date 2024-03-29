package com.spring.demo.rest;

import com.spring.demo.errors.RestServiceException;
import com.spring.demo.model.response.ProductResponse;
import com.spring.demo.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ResourceConstants.PRODS_V1)
@Api(value = "Product details", description = "Product Details are retrieved in this resource end point", tags = ("product details"))
public class ProductResource {

    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService service){

        this.productService = service;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('READ_PRODUCTS')")
    @ApiOperation(value = "retireve all products", notes = "retrieve all the products into a paginated and sortedly", nickname = "getAllProducts")
    public Page<ProductResponse> getAllProducts(Pageable pageable){

        return productService.getAllProducts(pageable);
    }

    @RequestMapping(path = "/{prodId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('READ_PRODUCTS')")
    @ApiOperation(value = "get single product", notes = "accept product id and retrieve product details belongs to given id", nickname = "getSingleProduct")
    public ResponseEntity<ProductResponse> getSingleProduct(@PathVariable Long prodId){

        try{

            ProductResponse productResponse = productService.getSingleProduct(prodId);
            return new ResponseEntity<>(productResponse, HttpStatus.ACCEPTED);
        }catch (RestServiceException ex){

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(path = "/saveProduct", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('READ_WRITE_PRODUCTS')")
    @ApiOperation(value = "save single product", notes = "save/update single product in database", nickname = "saveProduct")
    public ResponseEntity saveProduct(@RequestBody ProductResponse productResponse){

        try {
            productService.saveProduct(productResponse);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(RestServiceException ex){

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(path = "/deleteProduct/{productId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('READ_WRITE_PRODUCTS')")
    @ApiOperation(value = "delete product", notes = "delete given product id record from database", nickname = "deleteProduct")
    public ResponseEntity deleteProduct(@PathVariable Long productId){

        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
