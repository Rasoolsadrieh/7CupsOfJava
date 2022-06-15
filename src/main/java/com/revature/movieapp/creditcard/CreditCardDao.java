package com.revature.movieapp.creditcard;

import com.revature.movieapp.order.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditCardDao extends CrudRepository<CreditCard, String> {

    @Modifying
    @Query(value = "Update CreditCard set credit_limit= -3 where cc_number= :cc_number")
    Optional<CreditCard> completePayment(String cc_number);

}
