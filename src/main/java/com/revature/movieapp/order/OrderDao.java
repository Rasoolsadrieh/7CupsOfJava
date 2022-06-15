package com.revature.movieapp.order;

import com.revature.movieapp.creditcard.CreditCard;
import com.revature.movieapp.order.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderDao extends CrudRepository<Order, Integer> {


//    @Modifying
//    @Query(value = "INSERT into Order values id= :id, movieID = :movieID, rent, orderDate= :orderDate, returnDate= :returnDate, 0, 3, email= :email")
//    Optional<Order> rentMovie(int id, String movieID,String orderDate, String returnDate, String email);
//
//    @Modifying
//    @Query(value = "Update Order set isComplete= 1 where id= :id")
//    Optional<Order> completeOrder(int id);


}


