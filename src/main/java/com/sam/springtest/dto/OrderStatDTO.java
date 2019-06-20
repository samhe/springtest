package com.sam.springtest.dto;

import java.math.BigDecimal;

public class OrderStatDTO {
    private String orderNo;
    private BigDecimal orderPrice;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    @Override
    public String toString() {
        return "OrderStatDTO{" +
                "orderNo='" + orderNo + '\'' +
                ", orderPrice=" + orderPrice +
                '}';
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public OrderStatDTO(String orderNo, BigDecimal orderPrice) {
        this.orderNo = orderNo;
        this.orderPrice = orderPrice;
    }

    public void setOrderPrice(Long orderPrice) {
        this.orderPrice = new BigDecimal(orderPrice);
    }

    public OrderStatDTO(String orderNo, Long orderPrice) {
        this.orderNo = orderNo;
        this.orderPrice = new BigDecimal(orderPrice);
    }
}
