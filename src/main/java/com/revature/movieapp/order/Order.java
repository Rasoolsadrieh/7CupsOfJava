package com.revature.movieapp.order;
import com.revature.movieapp.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Objects;

@Data // this handles toString, hashCode, equals() and your getters and setters
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @Column(name = "movieID")
    private String movieID;

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

}