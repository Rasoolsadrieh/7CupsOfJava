package com.revature.blockbusster.favorite;

import com.revature.blockbusster.customer.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FavoriteServlet {

    private final FavoriteServices favoriteServices;
    private final CustomerServices customerServices;

    @Autowired
    public FavoriteServlet(FavoriteServices favoriteServices, CustomerServices customerServices) {
        this.favoriteServices = favoriteServices;
        this.customerServices = customerServices;
    }
}
