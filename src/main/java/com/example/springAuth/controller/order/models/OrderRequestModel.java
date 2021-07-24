package com.example.springAuth.controller.order.models;

import java.util.ArrayList;

public class OrderRequestModel {

    private ArrayList<Long> productId;
    private Long personId;

    public OrderRequestModel(ArrayList<Long> productId, Long personId) {
        this.productId = productId;
        this.personId = personId;
    }

    public ArrayList<Long> getProductId() {
        return productId;
    }

    public void setProductId(ArrayList<Long> productId) {
        this.productId = productId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
