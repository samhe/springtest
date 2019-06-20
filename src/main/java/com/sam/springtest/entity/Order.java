package com.sam.springtest.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDER_MASTER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 20)
    private String orderNo;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.ALL})
//    @OneToMany
    private Set<OrderItem> orderItems;

    public Order(@Size(min = 3, max = 20) String orderNo) {
        this.orderNo = orderNo;
    }

    public void addItem(OrderItem item) {
        if(this.orderItems == null) {
            this.orderItems = new HashSet<>();
        }
        if (!this.orderItems.contains(item)) {
            this.orderItems.add(item);
        }
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getTotalPrice() {
        return this.orderItems.stream().map(item -> item.getTotalPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}