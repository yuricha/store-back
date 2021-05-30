package com.uno.store.model;

import lombok.Data;

@Data
public class DetailPurchase {

    private long idDetailPurchase;
    private String codeProduct;
    private long idPurchase;
    private long quantity;
    private double purchasePrice;
}
