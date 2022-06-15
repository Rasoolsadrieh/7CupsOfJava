package com.revature.blockbusster.favorite;

import com.revature.blockbusster.customer.Customer;
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
    @Column(name = "favorites_id")
    private String favoriteID;
    @ManyToOne(optional = false)
    @JoinColumn(name = "favorite_email", referencedColumnName = "email")
    private Customer favoriteEmail;
}