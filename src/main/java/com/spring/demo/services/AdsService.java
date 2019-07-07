package com.spring.demo.services;

import com.spring.demo.entity.AdSlots;
import com.spring.demo.entity.Ads;
import com.spring.demo.model.request.AdSaveRequest;
import com.spring.demo.repository.AdSlotsRepository;
import com.spring.demo.repository.AdsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdsService {

    private final AdsRepository adsRepository;

    private final AdSlotsRepository adSlotsRepository;

    private final Logger logger = LoggerFactory.getLogger(AdsService.class);

    @Autowired
    public AdsService(AdsRepository ads, AdSlotsRepository adSlots){

        this.adsRepository = ads;
        this.adSlotsRepository = adSlots;
    }

    public boolean saveAd(AdSaveRequest request){

        Optional<Ads> adDetails = adsRepository.findById(request.getAdId());
        if(adDetails.isPresent()){

            Optional<AdSlots> adSlot = adSlotsRepository.findById(request.getAdSlotId());
            if(adSlot.isPresent()){

                Ads adToSave = adDetails.get();
                adToSave.setRemarks(request.getRemarks());
                adToSave.setStatus(request.getStatus());
                adsRepository.save(adToSave);
                logger.info("Given Ad is updated :"+request.getAdId());
                return true;
            }else{

                logger.error("Given Ad Slot is invalid :"+request.getAdSlotId());
                return false;
            }
        }else {

            logger.error("Ad id is not found in database :"+request.getAdId());
            return false;
        }
    }

    public Page<Ads> getAllAds(Pageable pageable){

        return adsRepository.findAll(pageable);
    }

    public Optional<Ads> getSingleAd(Long adId){

        return adsRepository.findById(adId);
    }

    public boolean deleteAd(Long adId){

        Optional<Ads> ads = adsRepository.findById(adId);
        if(ads.isPresent()){

            adsRepository.delete(ads.get());
            logger.info("Requested Ad is deleted :"+adId);
            return true;
        }else{

            logger.error("Requested Ad is not in database :"+adId);
            return false;
        }
    }

    public List<AdSlots> getAllAdSlots(){

        return adSlotsRepository.findAll();
    }
}
