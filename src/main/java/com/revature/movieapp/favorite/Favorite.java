package com.revature.movieapp.favorite;
import com.revature.movieapp.customer.Customer;
import com.revature.movieapp.creditcard.CreditCard;

import com.revature.movieapp.order.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "favorite")
public class Favorite {


    @Id
    @Column(name = "movieID")
    private String movieID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Customer customer;

}
