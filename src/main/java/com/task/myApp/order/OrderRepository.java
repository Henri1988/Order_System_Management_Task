package com.task.myApp.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value="select * from order_management_system.order o where o.order_date = ? order by o.id limit ? offset ?", nativeQuery = true)
    List<Order> findOrdersByDate(LocalDate orderDate, int limit, int offset);

    @Query("select o from Order o where o.customer.id = ?1 order by o.id")
    List<Order> findOrdersByCustomerId(Integer id);

    @Query(value="select * from  order_management_system.order\n" +
            "where id in (select distinct order_id from order_management_system.order_line where product_id = ?1)",
            nativeQuery = true)
    List<Order> findOrdersByProductId(Integer id);
}