package com.revature.movieapp.order;

import com.revature.movieapp.creditcard.CreditCardDao;

import java.util.Arrays;
import java.util.Calendar;
import com.revature.movieapp.util.interfaces.Serviceable;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServices implements Serviceable<Order> {
    private OrderDao orderDao;
    private CreditCardDao creditCardDao;
    private final Calendar calendar = Calendar.getInstance();


    @Autowired
    public OrderServices(OrderDao orderDao, CreditCardDao creditCardDao) {
        this.orderDao = orderDao;
        this.creditCardDao = creditCardDao;
    }


    int month = (calendar.get(calendar.MONTH))+1;
    int day = calendar.get(calendar.DAY_OF_MONTH);
    int returnDay = (calendar.get(calendar.DAY_OF_MONTH))+2;
    int year = calendar.get(calendar.YEAR);
    String theDate = month + "/" + day + "/" + year;
    String theReturnDate = month + "/" + returnDay + "/" + year;


    @Override
    public Order create(Order newOrder) {
        return orderDao.save(newOrder);
    }

    @Override
    public List<Order> readAll() {
        return (List<Order>) orderDao.findAll();
    }

    @Override
    public Order readById(String id) {
        int idInt = Integer.parseInt(id);
        return orderDao.findById(idInt).get();
    }

    @Override
    public Order update(Order updatedOrder) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    public Order rentMovie(int id, String movieID, String orderDate, String returnDate, String email) {
        orderDate = theDate;
        returnDate = theReturnDate;
        Optional<Order> persistedOrder = orderDao.rentMovie(id, movieID, orderDate, returnDate, email);
        return persistedOrder.get();
    }



    public Order completeOrder(int id){
        Optional<Order> persistedOrder = orderDao.completeOrder(id);
        return persistedOrder.get();
    }

    public boolean validateInput(Order newOrder){
        if(newOrder == null) {return false;}
        if(newOrder.getId() <= 0) {return false;}
        if(newOrder.getMovieID() == null || newOrder.getMovieID().trim().equals("")) {return false;}
        if(newOrder.getOrderType() != "rent" && newOrder.getOrderType() != "owned") {return false;}
        if(newOrder.getOrderDate() == null || newOrder.getOrderDate().trim().equals("")) {return false;}
        if(newOrder.getReturnDate() == null || newOrder.getReturnDate().trim().equals("")) {return false;}
        if(newOrder.getIsComplete() != 1 && newOrder.getIsComplete() != 0) {return false;}
        if(newOrder.getBalance() <= 0) {return false;}
        return true;
    }

    public boolean validateCustomMovieTransactionInput(Order newOrder){
        if(newOrder == null) {return false;}
        if(newOrder.getId() <= 0) {return false;}
        if(newOrder.getMovieID() == null || newOrder.getMovieID().trim().equals("")) {return false;}
        if(newOrder.getOrderDate() == null || newOrder.getOrderDate().trim().equals("")) {return false;}
        if(newOrder.getReturnDate() == null || newOrder.getReturnDate().trim().equals("")) {return false;}
        return true;
        }

}
