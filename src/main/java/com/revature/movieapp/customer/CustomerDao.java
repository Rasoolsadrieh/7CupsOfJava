package com.revature.movieapp.customer;

import com.revature.movieapp.util.interfaces.Crudable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;
import java.util.Optional;
// DAO is now an interfact and requires the extension of CrudRepository<DataTypeOfModel, IDDataType>
@Repository
public interface CustomerDao extends CrudRepository<Customer, String> {

    @Query(value = "FROM Customer WHERE email= :email AND password = :password")
    Optional<Customer> authenticateCustomer(String email, String password);
}
