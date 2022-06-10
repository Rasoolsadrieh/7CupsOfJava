package com.revature.movieapp.order;
import com.revature.movieapp.customer.Customer;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @Column(name = "order_type")
    private int orderType;

    @Column(name = "is_Del")
    private int isDel;

    @Column(name = "is_Own")
    private boolean isOwn;
    @Column(name = "order_date")
    private String orderDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Customer customer;

    public Order() {
    }

    public Order(int id, int orderType, int isDel, boolean isOwn, String orderDate, Customer customer) {
        this.id = id;
        this.orderType = orderType;
        this.isDel = isDel;
        this.isOwn = isOwn;
        this.orderDate = orderDate;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public boolean isOwn() {
        return isOwn;
    }

    public void setOwn(boolean own) {
        isOwn = own;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && orderType == order.orderType && isDel == order.isDel && isOwn == order.isOwn && Objects.equals(orderDate, order.orderDate) && Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderType, isDel, isOwn, orderDate, customer);
    }
}