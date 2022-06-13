package com.revature.movieapp.order;

import com.revature.movieapp.order.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderDao extends CrudRepository<Order, Integer> {


    @Query(value = "INSERT into Order values id= :id, movieID = :movieID, rent, orderDate= :orderDate, returnDate= :returnDate, 0, 3")
    Optional<Order> rentMovie(int id, String movieID, String orderDate, String returnDate);

    @Query(value = "Update Order set isComplete= :isComplete where id= :id")
    Optional<Order> completeOrder(int isComplete, int id);
}
