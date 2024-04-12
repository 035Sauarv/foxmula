package com.saurav.springbootlibrary.requestmodels;

import lombok.Data;

@Data
public class PaymentInfoRequests {
    private int amount;
    private String currency;
    private String receiptEmail;
}
