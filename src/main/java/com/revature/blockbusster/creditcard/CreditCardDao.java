package com.revature.blockbusster.creditcard;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardDao extends CrudRepository<CreditCard, String> {

}
