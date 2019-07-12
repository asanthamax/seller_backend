package com.spring.demo.services;

import com.spring.demo.entity.ShippingMethod;
import com.spring.demo.errors.RequestNotFoundException;
import com.spring.demo.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingService {

    private final ShippingRepository shippingRepository;

    @Autowired
    public ShippingService(ShippingRepository shipRepo){

        this.shippingRepository = shipRepo;
    }

    public List<ShippingMethod> getShippings() throws DataAccessException {

        return this.shippingRepository.findAll();
    }

    public ShippingMethod getSingleShipping(Long id) throws RequestNotFoundException{

        Optional<ShippingMethod> shippingMethod = this.shippingRepository.findById(id);
        if(shippingMethod.isPresent()){

            return shippingMethod.get();
        }else{

            throw new RequestNotFoundException("Shipping method not found");
        }
    }

    public void saveShippingMethod(ShippingMethod shippingMethod) throws DataAccessException{

        this.shippingRepository.save(shippingMethod);
    }

    public void deleteShippingMethod(ShippingMethod shippingMethod) throws DataAccessException{

        this.shippingRepository.delete(shippingMethod);
    }
}
