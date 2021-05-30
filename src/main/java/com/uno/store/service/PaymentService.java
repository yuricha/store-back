package com.uno.store.service;

import java.util.List;

import com.uno.store.commons.ResponseDto;
import com.uno.store.model.DetailPurchase;

public interface PaymentService {
    ResponseDto savePayment(List<DetailPurchase> detailPurchase);
}
