package com.uno.store.expose;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uno.store.commons.HttpStatusUtil;
import com.uno.store.model.DetailPurchase;
import com.uno.store.service.PaymentService;

@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @PostMapping("/payment")
    public ResponseEntity<String> saveProduct(@RequestBody List<DetailPurchase> detailPurchase){
        return new HttpStatusUtil().getHttpStatusByResponse(paymentService.savePayment(detailPurchase));
    }
}
