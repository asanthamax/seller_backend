package com.spring.demo.services;

import com.spring.demo.entity.PaymentSeller;
import com.spring.demo.entity.Payments;
import com.spring.demo.entity.Seller;
import com.spring.demo.errors.RequestNotFoundException;
import com.spring.demo.model.request.PaymentsRequest;
import com.spring.demo.model.response.PaymentsResponse;
import com.spring.demo.model.response.PendingPaymentResponse;
import com.spring.demo.repository.PaymentsRepository;
import com.spring.demo.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentsService {

    private final PaymentsRepository paymentsRepository;

    private final EntityManager entityManager;

    private final SellerRepository sellerRepository;

    private final ConversionService conversionService;

    @Autowired
    public PaymentsService(PaymentsRepository paymentRepo, SellerRepository sellerRepo, EntityManager manager, @Qualifier("conversionService") ConversionService service){

        paymentsRepository = paymentRepo;
        entityManager = manager;
        sellerRepository = sellerRepo;
        conversionService = service;
    }

    @SuppressWarnings("unchecked")
    public PaymentsResponse getAllPayables(Pageable pageable) throws DataAccessException{

        Page<Payments> allPayable = paymentsRepository.findPaymentsToPaid("Pending", pageable);
        StoredProcedureQuery storedProcedureQuery = this.entityManager.createStoredProcedureQuery("SELLER_PAYMENTS_CAL")
                .registerStoredProcedureParameter("paymentStatus", String.class, ParameterMode.IN);
        storedProcedureQuery.setParameter("paymentStatus", "pending");
        storedProcedureQuery.execute();
        List<Object[]> sellerPaymentObjects = storedProcedureQuery.getResultList();
        List<PaymentSeller> sellerPayment = new ArrayList<>();
        for(Object[] obj: sellerPaymentObjects){

            sellerPayment.add(this.conversionService.convert(obj, PaymentSeller.class));
        }
        Page<PaymentSeller> paySeller = new PageImpl<>(sellerPayment, pageable, sellerPayment.size());
        PaymentsResponse response = new PaymentsResponse();
        List<PendingPaymentResponse> paymentsResponses = new ArrayList<>();
        paymentArrange(allPayable, response, paymentsResponses, paySeller, "Pending");
        Page<PendingPaymentResponse> pagePaymentResponse = new PageImpl<>(paymentsResponses, pageable, paymentsResponses.size());
        response.setPendingPaymentResponses(pagePaymentResponse);
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

    @SuppressWarnings("unchecked")
    public PaymentsResponse getAllPaids(Pageable pageable) throws DataAccessException{

        Page<Payments> allPayable = paymentsRepository.findPaymentsToPaid("Paid", pageable);
        StoredProcedureQuery storedProcedureQuery = this.entityManager.createStoredProcedureQuery("SELLER_PAYMENTS_CAL")
                .registerStoredProcedureParameter("paymentStatus", String.class, ParameterMode.IN);
        storedProcedureQuery.setParameter("paymentStatus", "paid");
        storedProcedureQuery.execute();
        List<Object[]> sellerPaymentObjects = storedProcedureQuery.getResultList();
        List<PaymentSeller> sellerPaid = new ArrayList<>();
        for(Object[] obj: sellerPaymentObjects){

            sellerPaid.add(this.conversionService.convert(obj, PaymentSeller.class));
        }
        Page<PaymentSeller> paids = new PageImpl<>(sellerPaid, pageable, sellerPaid.size());
        PaymentsResponse response = new PaymentsResponse();
        List<PendingPaymentResponse> paymentsResponses = new ArrayList<>();
        paymentArrange(allPayable, response, paymentsResponses, paids, "Paid");
        Page<PendingPaymentResponse> pagePaymentResponse = new PageImpl<>(paymentsResponses, pageable, paymentsResponses.size());
        response.setPendingPaymentResponses(pagePaymentResponse);
        return response;
    }

    private void paymentArrange(Page<Payments> allPayable, PaymentsResponse response, List<PendingPaymentResponse> paymentsResponses, Page<PaymentSeller> sellerPayments,String paymentStatus) {


        Optional<Payments> payments = allPayable.get().findFirst();
        if (payments.isPresent()) {
            Payments payable = payments.get();
            response.setTotalAmount((payable.getTotalSumAmount() != null) ? payable.getTotalSumAmount() : 0.0);
            response.setTotalPaid((payable.getTotalPaid() != null) ? payable.getTotalPaid() : 0.0);
            double totalPayable = payable.getTotalSumAmount() - payable.getTotalPaid();
            response.setTotalPayable(totalPayable);
        }

        for (PaymentSeller sellerPay: sellerPayments){

            PendingPaymentResponse singleResponse = new PendingPaymentResponse();
            singleResponse.setAmount(sellerPay.getAmount());
            singleResponse.setNumberOfOrders(sellerPay.getNumOrders());
            Optional<Seller> seller = sellerRepository.findById(sellerPay.getUserID());
            singleResponse.setSellerName(seller.get().getUerID().getFirstName()+" "+seller.get().getUerID().getLastName());
            singleResponse.setUserID(sellerPay.getUserID());
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
