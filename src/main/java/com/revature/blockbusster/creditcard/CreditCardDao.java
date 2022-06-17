package com.revature.blockbusster.creditcard;


import com.revature.blockbusster.customer.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardDao extends CrudRepository<CreditCard, String> {

    @Query(value = "FROM CreditCard WHERE customerEmail= :customerEmail")
    List<CreditCard> creditCardHistory(Customer customerEmail);
}
