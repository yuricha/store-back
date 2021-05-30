package com.uno.store.model;

import lombok.Data;

@Data
public class Client extends User {
    private String idCard;
    private String franchiseName;
}
