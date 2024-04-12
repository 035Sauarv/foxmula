package com.saurav.springbootlibrary.service;

import com.saurav.springbootlibrary.dao.PaymentRepository;
import com.saurav.springbootlibrary.entity.Payment;
import com.saurav.springbootlibrary.requestmodels.PaymentInfoRequests;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional

public class PaymentService {
    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, @Value("${stripe.key.secret}") String secretKey) {
        this.paymentRepository = paymentRepository;
        Stripe.apiKey = secretKey;
    }


    public PaymentIntent createPaymentIntent(PaymentInfoRequests paymentInfoRequests) throws StripeException {
        List<String> paymentMethodTypes = new ArrayList<>();
        paymentMethodTypes.add("card");

        Map<String, Object> params = new HashMap<>();
        params.put("amount" , paymentInfoRequests.getAmount());
        params.put("currency" , paymentInfoRequests.getCurrency());
        params.put("payment_method_types" , paymentMethodTypes);

        return  PaymentIntent.create(params);
    }

    public ResponseEntity<String> stripePayment(String userEmail) throws Exception {
        Payment payment = paymentRepository.findByUserEmail(userEmail);
        if(payment == null){
            throw  new Exception("payment information is missing");
        }
        payment.setAmount(00.00);
        paymentRepository.save(payment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
