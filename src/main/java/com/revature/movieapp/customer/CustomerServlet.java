package com.revature.movieapp.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.movieapp.util.exceptions.AuthenticationException;
import com.revature.movieapp.util.exceptions.InvalidRequestException;
import com.revature.movieapp.util.exceptions.ResourcePersistanceException;
import com.revature.movieapp.util.interfaces.Authable;
import com.revature.movieapp.util.web.SecureEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController // @Controller
@CrossOrigin //Resource Sharing, by default it allows all "*"
public class CustomerServlet {

    private final CustomerServices customerServices;

    @Autowired
    public CustomerServlet(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }

    // TODO: Implement ME

    // Create
    @PostMapping("/register")

    public ResponseEntity<Customer> saveCustomer(@RequestBody @Valid Customer customer){
        Customer newCustomer = customerServices.create(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    // Read
    @GetMapping("/customer-findall")
    public List<Customer> getAllCustomers(){
        return customerServices.readAll();
    }

    @GetMapping("/customers")
    @SecureEndpoint(allowedUsers = {"by@mail.com", "abczyx123@mail.com"}, isLoggedIn = true)
    public ResponseEntity<List> findAllCustomers(){
        // ResponseEntity takes an Object for the ResponseBody and an HTTP Status Code
        return new ResponseEntity<>(customerServices.readAll(), HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping("/customerEx")
    public void customerEx(){
        throw new AuthenticationException("Oh no customer not auth");
    }

    @GetMapping("/customer/{email}")
    @SecureEndpoint(isLoggedIn = true)
    public ResponseEntity<Customer> findCustomerById(@PathVariable String email){
        Customer foundCustomer = customerServices.readById(email);
        return new ResponseEntity<>(foundCustomer, HttpStatus.OK);
    }

    @GetMapping("/customer")
    public Customer findCustomerByIdQueryParam(@RequestParam String email){ // @RequestParam is those Query Parameters, .com/customer?email=cj@mail.com
        Customer foundCustomer = customerServices.readById(email);
        return foundCustomer;
    }

    @GetMapping("/data")
    public int showDataTypeInPath(@RequestParam int x){
        return x;
    } // Spring will automatically convert the type based on the parameter

    @GetMapping("/persEx")
    public void throwPersEx(){
        throw new ResourcePersistanceException("How does the handler know what message is being sent here???");
    }

    @SecureEndpoint(allowedUsers = {"by@mail.com", "abczyx123@mail.com"}, isLoggedIn = true)
    @GetMapping("/secEnd")
    public String secureEndpoint(){
        return "Hey look at me from the secured endpoint";
    }



}
