package com.uno.store.service.impl;

import com.uno.store.commons.ResponseDto;
import com.uno.store.commons.Values;
import com.uno.store.model.DetailPurchase;
import com.uno.store.repository.ProductRepository;
import com.uno.store.service.PaymentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired 
	ProductRepository productRepository;
    @Override
    public ResponseDto savePayment(List<DetailPurchase> detailPurchase) {
    	
    	detailPurchase.forEach(detail->{
    		productRepository.discountUnitProduct(detail.getCodeProduct());  
    	});
    	
        return new ResponseDto(Values.APP_CODE_OK,null);
    }
}
