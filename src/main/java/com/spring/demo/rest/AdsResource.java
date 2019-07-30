package com.spring.demo.rest;

import com.spring.demo.entity.AdSlots;
import com.spring.demo.entity.Ads;
import com.spring.demo.errors.RequestNotFoundException;
import com.spring.demo.model.request.AdSaveRequest;
import com.spring.demo.model.response.AdaddResponse;
import com.spring.demo.model.response.AdsResponse;
import com.spring.demo.services.AdsService;
import converter.AdsEntityToAdsResponseConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ResourceConstants.ADS_V1)
@Api(value = "Ads details", description = "Do All CRUD activities of Ads details", tags = ("ads"))
public class AdsResource {

    private final AdsService adsService;


    private final ConversionService conversionService;

    @Autowired
    public AdsResource(AdsService adsService, @Qualifier("conversionService") ConversionService conService) {

        this.adsService = adsService;
        this.conversionService = conService;
    }

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('ADS_READ')")
    @ApiOperation(value = "Retrieve all the ads available", notes = "Get All the Ads running and pending in database", nickname = "getAllAds")
    public Page<AdsResponse> getAllAds(Pageable pageable){

        Page<Ads> allAds = adsService.getAllAds(pageable);
        return allAds.map(p -> new AdsEntityToAdsResponseConverter().convert(p));
    }

    @RequestMapping(path = "/{adId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('ADS_READ')")
    @ApiOperation(value = "get single ad", notes = "get single ad details by ad id", nickname = "getSingleAd")
    public ResponseEntity<AdsResponse> getSingleAd(@PathVariable Long adId) throws RequestNotFoundException {

        try {
            Optional<Ads> ads = adsService.getSingleAd(adId);
            if (ads.isPresent()) {
                AdsResponse adEntity = conversionService.convert(ads.get(), AdsResponse.class);
                return new ResponseEntity<>(adEntity, HttpStatus.ACCEPTED);
            } else {

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception ex){

            throw new RequestNotFoundException(ex.getMessage(), ex);
        }
    }


    @RequestMapping(path = "/ad_save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('ADS_WRITE')")
    @ApiOperation(value = "save single ad", notes = "accept json ad data and response with json body", nickname = "adSave")
    public ResponseEntity<AdaddResponse> saveAd(@RequestBody AdSaveRequest adSaveRequest){

        boolean status = adsService.saveAd(adSaveRequest);
        if(status){

            AdaddResponse adaddResponse = conversionService.convert(adSaveRequest, AdaddResponse.class);
            return new ResponseEntity<>(adaddResponse, HttpStatus.CREATED);
        }else{

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(path = "/get_ad_slots", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('ADS_SLOTS_READ')")
    @ApiOperation(value = "get all ad slots", notes = "get all ad slots available", nickname = "getAllSlots")
    public ResponseEntity<List<AdSlots>> getAllSlots(){

        List<AdSlots> adSlots = adsService.getAllAdSlots();
        return new ResponseEntity<>(adSlots, HttpStatus.ACCEPTED);
    }

}
