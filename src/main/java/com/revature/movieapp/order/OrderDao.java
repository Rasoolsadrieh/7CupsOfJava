package com.revature.movieapp.order;

import com.revature.movieapp.order.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderDao extends CrudRepository<Order, Integer> {


    @Query(value = "INSERT into Order values id= :id, movieID = :movieID, rent, 00/00/0000, 00/00/0000, 0, 3, email= :email")
    Optional<Order> rentMovie(int id, String movieID, String email);

    @Query(value = "Update Order set orderDate= :orderDate where id= :id")
    Optional<Order> rentMovieOrderDate(String orderDate, int id);

    @Query(value = "Update Order set returnDate= :returnDate where id= :id")
    Optional<Order> rentMovieReturnDate(String returnDate, int id);

    @Query(value = "Update Order set isComplete= 1 where id= :id")
    Optional<Order> completeOrder(int id);


}
