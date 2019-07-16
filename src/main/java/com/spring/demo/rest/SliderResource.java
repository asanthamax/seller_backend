package com.spring.demo.rest;

import com.spring.demo.errors.FileStorageException;
import com.spring.demo.errors.RequestNotFoundException;
import com.spring.demo.model.request.SliderRequest;
import com.spring.demo.model.response.SliderResponse;
import com.spring.demo.services.FileStorageService;
import com.spring.demo.services.SliderService;
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

import java.util.List;

@RestController
@RequestMapping(ResourceConstants.SLDR_V1)
@Api(value = "slider endpoint", description = "all sliders related operations are done through this endpoints", tags = ("sliders"))
public class SliderResource {

    private final SliderService sliderService;

    private final FileStorageService storageService;

    @Autowired
    public SliderResource(SliderService service, FileStorageService storageService1){

        sliderService = service;
        storageService = storageService1;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('READ_SLIDE')")
    @ApiOperation(value = "get all slides", notes = "get all available slides in database", nickname = "getAllSlides")
    public ResponseEntity<List<SliderResponse>> getAllSlides() throws RequestNotFoundException{

        try{

            return new ResponseEntity<>(sliderService.getAllSliders(), HttpStatus.ACCEPTED);
        }catch (DataAccessException ex){

            throw new RequestNotFoundException(ex.getMessage(), ex);
        }
    }

    @RequestMapping(value = "/{slideID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('READ_SLIDE')")
    @ApiOperation(value = "get single slide", notes = "get single slide according to given id in endpoint", nickname = "getSingleSlide")
    public ResponseEntity<SliderResponse> getSingleSlide(@PathVariable("slideID") Long sliderID) throws RequestNotFoundException{

        try{

            return new ResponseEntity<>(sliderService.getSlider(sliderID), HttpStatus.ACCEPTED);
        }catch (RequestNotFoundException ex){

            throw new RequestNotFoundException(ex.getMessage(), ex);
        }
    }

    @RequestMapping(value = "/saveSlide", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('READ_WRITE_SLIDE')")
    @ApiOperation(value = "save new slide", notes = "save new slide into database", nickname = "saveSlide")
    public ResponseEntity saveSlide(@RequestParam("file")MultipartFile file, @RequestParam("sliderTitle") String sliderTitle
                                    ,@RequestParam("sliderOrder") int sliderOrder) throws RequestNotFoundException, FileStorageException {

        try {
            String imgURL = storageService.storeFile(file);
            SliderResponse sliderRequest = new SliderResponse();
            sliderRequest.setSliderTitle(sliderTitle);
            sliderRequest.setSlideURL(imgURL);
            sliderRequest.setSliderOrder(sliderOrder);
            sliderRequest.setSliderID((long) 0);
            sliderService.saveSlider(sliderRequest);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch (DataAccessException ex){

            throw new RequestNotFoundException(ex.getMessage(), ex);
        } catch (FileStorageException e) {

            throw new FileStorageException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/deleteSlide/{sliderID}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('READ_WRITE_SLIDE')")
    @ApiOperation(value = "delete slide", notes = "delete given slide from database", nickname = "deleteSlide")
    public ResponseEntity deleteSlide(@PathVariable("sliderID") Long sliderID) throws RequestNotFoundException{

        try {
            sliderService.deleteSlider(sliderID);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch (DataAccessException ex){

            throw new RequestNotFoundException(ex.getMessage(), ex);
        }
    }

    @RequestMapping(value = "/updateSlideContent", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('READ_WRITE_SLIDE')")
    @ApiOperation(value = "updateSlideContent", notes = "update content of slide except slider image", nickname = "updateSlideContent")
    public ResponseEntity updateSlideContent(@RequestBody SliderRequest request) throws RequestNotFoundException{

        try{

            sliderService.updateSliderContent(request);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch (RequestNotFoundException ex){

            throw new RequestNotFoundException(ex.getMessage(), ex);
        }
    }

    @RequestMapping(value = "/updateSlide", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('READ_WRITE_SLIDE')")
    @ApiOperation(value = "update slide image", notes = "update slide image to new image", nickname = "updateSlide")
    public ResponseEntity updateSlide(@RequestParam("file") MultipartFile file, @RequestParam("id") Long sliderID) throws RequestNotFoundException, FileStorageException {

        try{

            String slideURL = storageService.storeFile(file);
            sliderService.updateSlide(slideURL, sliderID);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch (RequestNotFoundException ex){

            throw new RequestNotFoundException(ex.getMessage(), ex);
        } catch (FileStorageException e) {
            throw new FileStorageException(e.getMessage(), e);
        }
    }
}
