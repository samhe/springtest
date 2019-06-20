package com.sam.springtest.repository;

import com.sam.springtest.dto.OrderStatDTO;
import com.sam.springtest.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderNo(String orderNo);

//    @Query("select new com.sam.springtest.dto.OrderStatDTO(oi.order.orderNo, sum(oi.totalPrice))" +
//            " from OrderItem oi group by oi.order.orderNo ")
    @Query("select oi.order.orderNo, sum(oi.totalPrice)" +
            " from OrderItem oi group by oi.order.orderNo ")
    List<OrderStatDTO> findAllOrderStat();
}
