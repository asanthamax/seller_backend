package com.spring.demo.services;

import com.spring.demo.entity.Payments;
import com.spring.demo.errors.RequestNotFoundException;
import com.spring.demo.model.request.PaymentsRequest;
import com.spring.demo.model.response.PaymentsResponse;
import com.spring.demo.model.response.PendingPaymentResponse;
import com.spring.demo.repository.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentsService {

    private final PaymentsRepository paymentsRepository;

    @Autowired
    public PaymentsService(PaymentsRepository paymentRepo){

        paymentsRepository = paymentRepo;
    }

    public PaymentsResponse getAllPayables(Pageable pageable) throws DataAccessException{

        Page<Payments> allPayable = paymentsRepository.findPaymentsToPaid("Pending", pageable);
        List<Long> userIds = new ArrayList<>();
        PaymentsResponse response = new PaymentsResponse();
        List<PendingPaymentResponse> paymentsResponses = new ArrayList<>();
        for(Payments payable: allPayable){

           if(!userIds.contains(payable.getSeller().getSellerID())){

               PendingPaymentResponse singleResponse = new PendingPaymentResponse();
               userIds.add(payable.getSeller().getSellerID());
               singleResponse.setAmount(payable.getTotalAmount());
               singleResponse.setNumberOfOrders(payable.getTotalOrders());
               singleResponse.setSellerName(payable.getSeller().getUerID().getFirstName()+" "+payable.getSeller().getUerID().getLastName());
               singleResponse.setUserID(payable.getSeller().getSellerID());
               paymentsResponses.add(singleResponse);
           }
           response.setTotalAmount(payable.getTotalSumAmount());
           response.setTotalPaid(payable.getTotalPaid());
           response.setTotalPayable(payable.getTotalPayable());
        }
        response.setPendingPaymentResponses(paymentsResponses);
        return response;
    }

    public void updateAllPayables(List<PaymentsRequest> paymentsRequest) throws RequestNotFoundException, DataAccessException {

        for(PaymentsRequest payable: paymentsRequest){

            List<Payments> pays = paymentsRepository.findPaymentBySeller(payable.getUserID());
            for (Payments pay: pays){

                pay.setPaymentDate(new Date());
                pay.setPaymentStatus("Paid");
            }
            if(!pays.isEmpty())
                paymentsRepository.saveAll(pays);
            else
                throw new RequestNotFoundException("Not found any payments records to given user id");
        }
    }
}
