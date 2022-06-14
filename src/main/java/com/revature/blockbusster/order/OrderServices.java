package com.revature.blockbusster.order;


import com.revature.blockbusster.customer.Customer;
import com.revature.blockbusster.customer.CustomerDao;
import com.revature.blockbusster.util.interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServices implements Serviceable<Order> {

    private OrderDao orderDao;
    private CustomerDao customerDao;


    @Autowired
    public OrderServices(OrderDao orderDao, CustomerDao customerDao) {
        this.orderDao = orderDao;
        this.customerDao = customerDao;
    }

    @Override
    public Order create(Order newOrder) {return orderDao.save(newOrder);}

    @Override
    public Order update(Order updatedOrder) {return orderDao.save(updatedOrder);}

    @Override
    public Order readById(String orderEmail) {return null;}

    public List<Order> readByEmail(Customer orderEmail) {return  orderDao.orderHistory(orderEmail);}

    @Override
    public boolean delete(String orderEmail) {return false;}

    public List<Order> readAll(){ return (List<Order>) orderDao.findAll();}


}
