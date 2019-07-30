package com.spring.demo.services;

import com.spring.demo.entity.PaymentSeller;
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

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentsService {

    private final PaymentsRepository paymentsRepository;

    @Autowired
    public PaymentsService(PaymentsRepository paymentRepo){

        paymentsRepository = paymentRepo;
    }

    public PaymentsResponse getAllPayables(Pageable pageable) throws DataAccessException{

        Page<Payments> allPayable = paymentsRepository.findPaymentsToPaid("Pending", pageable);
        Page<PaymentSeller> sellerPayment = paymentsRepository.findSellerPayments(pageable, "Pending");
        PaymentsResponse response = new PaymentsResponse();
        List<PendingPaymentResponse> paymentsResponses = new ArrayList<>();
        paymentArrange(allPayable, response, paymentsResponses, sellerPayment, "Pending");
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

    public PaymentsResponse getAllPaids(Pageable pageable) throws DataAccessException{

        Page<Payments> allPayable = paymentsRepository.findPaymentsToPaid("Paid", pageable);
        Page<PaymentSeller> sellerPaids = paymentsRepository.findSellerPayments(pageable, "Paid");
        PaymentsResponse response = new PaymentsResponse();
        List<PendingPaymentResponse> paymentsResponses = new ArrayList<>();
        paymentArrange(allPayable, response, paymentsResponses, sellerPaids, "Paid");
        response.setPendingPaymentResponses(paymentsResponses);
        return response;
    }

    private void paymentArrange(Page<Payments> allPayable, PaymentsResponse response, List<PendingPaymentResponse> paymentsResponses, Page<PaymentSeller> sellerPayments,String paymentStatus) {


        Optional<Payments> payments = allPayable.get().findFirst();
        if (payments.isPresent()) {
            Payments payable = payments.get();
            response.setTotalAmount(payable.getTotalSumAmount());
            response.setTotalPaid(payable.getTotalPaid());
            response.setTotalPayable(payable.getTotalPayable());
        }

        for (PaymentSeller sellerPay: sellerPayments){

            PendingPaymentResponse singleResponse = new PendingPaymentResponse();
            singleResponse.setAmount(sellerPay.getAmount());
            singleResponse.setNumberOfOrders(sellerPay.getNumOrders());
            singleResponse.setSellerName(sellerPay.getUserID().getUerID().getFirstName()+" "+sellerPay.getUserID().getUerID().getLastName());
            singleResponse.setUserID(sellerPay.getUserID().getSellerID());
            paymentsResponses.add(singleResponse);
        }
    }

    public void updatePaymentStatus() throws DataAccessException{

        List<Payments> updateablePayments = paymentsRepository.getPendingPayments();
        for (Payments pay: updateablePayments){

            long milliSecondsDiff = pay.getRecievedDate().getTime() - new Date().getTime();
            long dateDiff = TimeUnit.DAYS.convert(milliSecondsDiff, TimeUnit.MILLISECONDS);
            if(dateDiff >= 30){

                paymentsRepository.updatePaymentStatus(pay.getId());
            }
        }
    }
}
