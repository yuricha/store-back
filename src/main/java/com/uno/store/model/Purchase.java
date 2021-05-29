package com.uno.store.model;

import lombok.Data;
import java.util.Date;
@Data
public class Purchase {

    private  int item;
    private Date dateShopping;
    private int idProduct;
    private String description;
    private int quantity;
    private double subTotal;
}
