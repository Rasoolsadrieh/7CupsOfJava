package com.revature.blockbusster.order;


import com.revature.blockbusster.customer.Customer;
import com.revature.blockbusster.customer.CustomerServices;
import com.revature.blockbusster.util.web.dto.OrderInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OrderServlet {

    private final OrderServices orderServices;
    private final CustomerServices customerServices;

    @Autowired
    public OrderServlet(OrderServices orderServices, CustomerServices customerServices) {
        this.orderServices = orderServices;
        this.customerServices = customerServices;
    }

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody OrderInitializer initOrder){

        Order newOrder = new Order();
        Customer orderEmail = customerServices.readById(initOrder.getOrderEmail());

        newOrder.setMovieId(initOrder.getMovieId());
        newOrder.setOrderDate(initOrder.getOrderDate());
        newOrder.setOwned(initOrder.isOwned());
        newOrder.setReturnDate(initOrder.getReturnDate());
        newOrder.setOrderEmail(orderEmail);

        Order persistedOrder = orderServices.create(newOrder);
        return new ResponseEntity<>(persistedOrder, HttpStatus.CREATED);
    }
//
//    @GetMapping("/orders/history")
//    public ResponseEntity<Order> findOrderByEmail(@RequestBody Customer orderEmail) {
//
//      //  String oemail = orderEmail.getEmail();
//          Order foundOrder = orderServices.readByEmail(oemail);
//          return new ResponseEntity<>(foundOrder, HttpStatus.ACCEPTED);
//    }
    // need to figure out how to implement find all orders by email
    @GetMapping("/ordersfa")
    public List<Order> getAllOrders(){return orderServices.readAll();}
}
