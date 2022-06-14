package com.revature.blockbusster.order;


import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderDao extends CrudRepository<Order, Integer> {

    @Query(value = "FROM Order WHERE orderEmail= :order_email")
    Optional<Order> orderHistory(String  orderEmail);

}
