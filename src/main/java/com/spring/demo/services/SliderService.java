package com.spring.demo.services;

import com.spring.demo.entity.Sliders;
import com.spring.demo.errors.RequestNotFoundException;
import com.spring.demo.model.request.SliderRequest;
import com.spring.demo.model.response.SliderResponse;
import com.spring.demo.repository.SliderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SliderService {

    private final SliderRepository sliderRepository;

    @Autowired
    public SliderService(SliderRepository repo){

        sliderRepository = repo;
    }

    public List<SliderResponse> getAllSliders() throws DataAccessException{

        List<Sliders> allSliders = sliderRepository.findAll();
        List<SliderResponse> sliderResponses = new ArrayList<>();
        for(Sliders slider: allSliders){

            SliderResponse response = new SliderResponse();
            response.setSliderID(slider.getId());
            response.setSliderOrder(slider.getSliderOrder());
            response.setSliderTitle(slider.getSlideTitle());
            response.setSlideURL(slider.getImgUrl());
            sliderResponses.add(response);
        }
        return sliderResponses;
    }

    public SliderResponse getSlider(Long sliderID) throws DataAccessException, RequestNotFoundException{

        Optional<Sliders> singleSlider = sliderRepository.findById(sliderID);
        if(singleSlider.isPresent()){

            SliderResponse singleResponse = new SliderResponse();
            singleResponse.setSlideURL(singleSlider.get().getImgUrl());
            singleResponse.setSliderTitle(singleSlider.get().getSlideTitle());
            singleResponse.setSliderOrder(singleSlider.get().getSliderOrder());
            singleResponse.setSliderID(singleSlider.get().getId());
            return singleResponse;
        }else{

            throw new RequestNotFoundException("given slider id is not exists in database");
        }

    }

    public void saveSlider(SliderResponse slider) throws DataAccessException{

        Sliders newSlider = new Sliders(slider.getSliderTitle(), slider.getSlideURL(), slider.getSliderOrder(), 1, slider.getSliderTitle());
        sliderRepository.save(newSlider);
    }

    public void deleteSlider(Long sliderID) throws DataAccessException, RequestNotFoundException{

        Optional<Sliders> slider = sliderRepository.findById(sliderID);

        if(slider.isPresent()) {
            sliderRepository.delete(slider.get());
        }else {

            throw new RequestNotFoundException("Given slider ID is not exists in database or already deleted");
        }
    }

    public void updateSliderContent(SliderRequest request) throws DataAccessException, RequestNotFoundException{

        Optional<Sliders> slider = sliderRepository.findById(request.getSliderID());
        if (slider.isPresent()){

            slider.get().setSlideTitle(request.getSliderTitle());
            slider.get().setSliderOrder(request.getSliderOrder());
            sliderRepository.save(slider.get());
        }else {

            throw new RequestNotFoundException("Slider cannot update, not in the database");
        }
    }

    public void updateSlide(String sliderImg, Long sliderID) throws DataAccessException, RequestNotFoundException{

        Optional<Sliders> slider = sliderRepository.findById(sliderID);
        if (slider.isPresent()){

            slider.get().setImgUrl(sliderImg);
            sliderRepository.save(slider.get());
        }else {

            throw new RequestNotFoundException("Slider cannot update, not in the database");
        }
    }

}
