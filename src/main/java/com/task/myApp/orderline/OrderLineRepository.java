package com.task.myApp.orderline;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer>, JpaSpecificationExecutor<OrderLine> {

    @Query("select o from OrderLine o where o.id = ?1")
    OrderLine findByOderLineId(Integer id);


    OrderLine getReferenceById(Integer orderLineId);
}

