package com.example.springAuth.controller.order.models;

import java.util.ArrayList;
import java.util.UUID;

public class OrderResponseModel {

    private Long orderId;
    private UUID uuid;
    private Long personId;
    private ArrayList<Long> productIds;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setUuid() {
        this.uuid = UUID.randomUUID();
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public ArrayList<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(ArrayList<Long> productIds) {
        this.productIds = productIds;
    }
}
