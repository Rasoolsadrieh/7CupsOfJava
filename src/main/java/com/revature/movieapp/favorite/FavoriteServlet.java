package com.revature.movieapp.favorite;

import com.revature.movieapp.creditcard.CreditCardServices;
import com.revature.movieapp.order.OrderServices;
import com.revature.movieapp.util.exceptions.InvalidRequestException;
import com.revature.movieapp.util.interfaces.Authable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FavoriteServlet implements Authable {

    private final FavoriteServices favoriteServices;
    private final OrderServices orderServices;
    private final CreditCardServices creditCardServices;

    @Autowired
    public FavoriteServlet(FavoriteServices favoriteServices, OrderServices orderServices, CreditCardServices creditCardServices) {
        this.favoriteServices = favoriteServices;
        this.orderServices = orderServices;
        this.creditCardServices = creditCardServices;
    }

    // TODO: Implement me

    @GetMapping("/favoriteEx")
    public String favoriteException(){
        throw new InvalidRequestException("You don't want to request any favorite");
    }

}
