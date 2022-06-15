//package com.revature.movieapp.util.web.servlets;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.movieapp.customer.Customer;
//import com.revature.movieapp.customer.CustomerServices;
//import com.revature.movieapp.util.exceptions.AuthenticationException;
//import com.revature.movieapp.util.exceptions.InvalidRequestException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//// @WebServlet("/auth") // this requires a default No-Args constructor, but we make our own constructor in line 24
//@RestController
//@RequestMapping("/auth")
//public class AuthServlet {
//
//    private final CustomerServices customerServices;
//
//    @Autowired
//    public AuthServlet(CustomerServices customerServices){
//        this.customerServices = customerServices;
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void authorizeCustomer(@RequestBody LoginCreds loginCreds, HttpSession httpSession){
//        Customer authCustomer = customerServices.authenticateCustomer(loginCreds.getEmail(), loginCreds.getPassword());
//        httpSession.setAttribute("authCustomer", authCustomer);
//    }
//
//    @DeleteMapping
//    public void logout(HttpSession session){
//        session.invalidate();
//    }
//
//}
