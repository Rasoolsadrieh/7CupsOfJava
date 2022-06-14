package com.revature.movieapp.creditcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;

@RestController
@CrossOrigin
public class CreditCardServlet {

    private final CreditCardServices creditCardServices;

    @Autowired
    public CreditCardServlet(CreditCardServices creditCardServices) {
        this.creditCardServices = creditCardServices;
    }

    @PutMapping("/payment")
    public ResponseEntity<CreditCard> makePayment(String cc_number){
        CreditCard paymentMade = creditCardServices.orderPayment(cc_number);
        return new ResponseEntity<>(paymentMade, HttpStatus.OK);
    }

}
