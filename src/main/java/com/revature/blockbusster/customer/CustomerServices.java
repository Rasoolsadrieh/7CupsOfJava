package com.revature.blockbusster.customer;

import com.revature.blockbusster.util.exceptions.ResourcePersistanceException;
import com.revature.blockbusster.util.interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServices implements Serviceable<Customer> {

    private CustomerDao customerDao;

    @Autowired
    public CustomerServices(CustomerDao customerDao) {this.customerDao = customerDao;}

    @Override
    public Customer create(Customer newCustomer) {
        return customerDao.save(newCustomer);
    }

    @Override
    public Customer update(Customer updatedCustomer) { return customerDao.save(updatedCustomer);}

    @Override
    public boolean delete(String email){
        customerDao.deleteById(email);
        return true;
    }

    @Override
    public Customer readById(String email) throws ResourcePersistanceException {
         return customerDao.findById(email).get();

    }


}
