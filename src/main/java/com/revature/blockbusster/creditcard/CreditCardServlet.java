package com.revature.blockbusster.creditcard;

import com.revature.blockbusster.customer.Customer;
import com.revature.blockbusster.customer.CustomerServices;
import com.revature.blockbusster.util.web.dto.CreditCardInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CreditCardServlet {

    private final CreditCardServices creditCardServices;

    private final CustomerServices customerServices;

    @Autowired
    public CreditCardServlet(CreditCardServices creditCardServices, CustomerServices customerServices){
        this.creditCardServices = creditCardServices;
        this.customerServices = customerServices;
    }

    @PostMapping("/registercc")
    public ResponseEntity<CreditCard> createCreditCard(@RequestBody  CreditCardInitializer initCreditCard){
         CreditCard newCreditCard = new CreditCard();
        Customer customerEmail = customerServices.readById(initCreditCard.getCustomerEmail());

        newCreditCard.setCcNumber(initCreditCard.getCcNumber());
        newCreditCard.setCcName(initCreditCard.getCcName());
        newCreditCard.setCvv(initCreditCard.getCvv());
        newCreditCard.setExpDate(initCreditCard.getExpDate());
        newCreditCard.setZip(initCreditCard.getZip());
        newCreditCard.setLimit(initCreditCard.getLimit());
        newCreditCard.setCustomerEmail(customerEmail);

        CreditCard persistedCreditCard = creditCardServices.create(newCreditCard);
        return new ResponseEntity<>(persistedCreditCard, HttpStatus.CREATED);
    }

    @PutMapping("/updatecc")
    public ResponseEntity<CreditCard> updateCreditCard(@RequestBody CreditCardInitializer initCreditCard){
        CreditCard newCreditCard = new CreditCard();
        Customer customerEmail = customerServices.readById(initCreditCard.getCustomerEmail());

        newCreditCard.setCcNumber(initCreditCard.getCcNumber());
        newCreditCard.setCcName(initCreditCard.getCcName());
        newCreditCard.setCvv(initCreditCard.getCvv());
        newCreditCard.setExpDate(initCreditCard.getExpDate());
        newCreditCard.setZip(initCreditCard.getZip());
        newCreditCard.setLimit(initCreditCard.getLimit());
        newCreditCard.setCustomerEmail(customerEmail);

        CreditCard persistedCreditCard = creditCardServices.update(newCreditCard);
        return new ResponseEntity<>(persistedCreditCard, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletecc/{ccNumber}")
    public ResponseEntity<CreditCard> deleteCreditCard(@PathVariable String ccNumber){
        creditCardServices.delete(ccNumber);
        return new ResponseEntity<CreditCard>(HttpStatus.OK);
    }


}
