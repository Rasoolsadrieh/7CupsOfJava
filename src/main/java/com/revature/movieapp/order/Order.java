package com.revature.movieapp.order;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.revature.movieapp.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Data // this handles toString, hashCode, equals() and your getters and setters
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "movieID")
    private String movieID;

    @Column(name = "order_type")
    private String orderType;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "return_date")
    private String returnDate;

    @Column(name = "is_complete")
    private int isComplete;

    private int balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Customer customer;



}


