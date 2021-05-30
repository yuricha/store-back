package com.uno.store.model;

import lombok.Data;

@Data
public class Product {
    private String codeProduct;
    private String description;
    private String unit;
    private double salePrice;
    private String purchasePrice;
    private String provider;
    private ProductClassification classification;
}
