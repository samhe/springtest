package com.sam.springtest.repository;

import com.sam.springtest.SpringtestApplication;
import com.sam.springtest.dto.OrderStatDTO;
import com.sam.springtest.entity.Order;
import com.sam.springtest.entity.OrderItem;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SpringtestApplication.class)
@DataJpaTest
@ActiveProfiles("test")
//@AutoConfigureTestDatabase
public class OrderRepositoryIntegrationTest {

    @Autowired

    private TestEntityManager entityManager;

    @Autowired
    private OrderRepository orderRepository;

    // write test cases here
    @Test
    public void whenFindByOrderNo_thenReturnOrder() {
        Order order = new Order("ODR001");
        OrderItem item1 = new OrderItem("good1", 20, new BigDecimal(10), new BigDecimal(200));
        OrderItem item2 = new OrderItem("good2", 5, new BigDecimal(60), new BigDecimal(300));
        order.addItem(item1);
        order.addItem(item2);

        entityManager.persist(order);
        entityManager.flush();


        String expectedOrderNo = "ODR001";
        BigDecimal expectedTotalPrice = new BigDecimal(500);
        Order found = this.orderRepository.findByOrderNo(expectedOrderNo);

        Assertions.assertThat(found.getOrderNo()).isEqualTo(expectedOrderNo);
        Assertions.assertThat(found.getTotalPrice()).isEqualTo(expectedTotalPrice);
    }
    @Test
    public void test_group_by() {
        Order order = new Order("ODR001");
        OrderItem item1 = new OrderItem("good1", 20, new BigDecimal(10), new BigDecimal(200));
        OrderItem item2 = new OrderItem("good2", 5, new BigDecimal(60), new BigDecimal(300));
        order.addItem(item1);
        order.addItem(item2);

        entityManager.persist(order);
        entityManager.flush();


        String expectedOrderNo = "ODR001";
        BigDecimal expectedTotalPrice = new BigDecimal(500);
        List<Order> allOrder = this.orderRepository.findAll();
        System.out.println(allOrder);
        List<OrderStatDTO> orderStat = this.orderRepository.findAllOrderStat();
        System.out.println(orderStat);
    }

}
