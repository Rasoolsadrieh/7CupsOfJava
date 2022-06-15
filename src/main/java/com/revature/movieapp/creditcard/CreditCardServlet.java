package com.revature.movieapp.creditcard;

import com.revature.movieapp.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
@CrossOrigin
public class CreditCardServlet {

    private final CreditCardServices creditCardServices;

    @Autowired
    public CreditCardServlet(CreditCardServices creditCardServices) {
        this.creditCardServices = creditCardServices;
    }

//    @PutMapping("/payment")
//    public ResponseEntity<CreditCard> makePayment(String cc_number){
//        CreditCard paymentMade = creditCardServices.orderPayment(cc_number);
//        return new ResponseEntity<>(paymentMade, HttpStatus.OK);
//    }
//
    @GetMapping("/creditcards-findall")
    public List<CreditCard> getAllCards(){
        return creditCardServices.readAll();
    }

    @PutMapping("/payment")
    public ResponseEntity<CreditCard> updatePayment(@RequestBody CreditCard cc){
        CreditCard newPayment = creditCardServices.updatePayment(cc);
        return new ResponseEntity<>(newPayment, HttpStatus.ACCEPTED);
    }

    @GetMapping("/creditcard")
    public CreditCard findCreditCardByID(@RequestParam String cc_number){
        CreditCard foundCreditCard = creditCardServices.readById(cc_number);
        return foundCreditCard;
    }

}
