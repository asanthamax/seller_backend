package com.spring.demo.rest;

import com.spring.demo.entity.Ads;
import com.spring.demo.model.response.AdsResponse;
import com.spring.demo.repository.AdsRepository;
import converter.AdsEntityToAdsResponseConverter;
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

import java.util.Optional;

@RestController
@RequestMapping(ResourceConstants.ADS_V1)
@Api(value = "Ads details", description = "Do All CRUD activities of Ads details", tags = ("ads"))
public class AdsResource {

    private final AdsRepository adsRepository;

    @Autowired
    public AdsResource(AdsRepository adsRepository) {
        this.adsRepository = adsRepository;
    }

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('ADS_READ')")
    @ApiOperation(value = "Retrieve all the ads available", notes = "Get All the Ads running and pending in database", nickname = "getAllAds")
    public Page<AdsResponse> getAllAds(Pageable pageable){

        Page<Ads> allAds = adsRepository.findAll(pageable);
        return allAds.map(p -> new AdsEntityToAdsResponseConverter().convert(p));
    }

    @RequestMapping(path = "/{adId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('ADS_READ')")
    @ApiOperation(value = "get single ad", notes = "get single ad details by ad id", nickname = "getSingleAd")
    public ResponseEntity<Ads> getSingleAd(@PathVariable Long adId){

        Optional<Ads> ads = adsRepository.findById(adId);
        return ads.map(adEntity -> new ResponseEntity<>(adEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

}
