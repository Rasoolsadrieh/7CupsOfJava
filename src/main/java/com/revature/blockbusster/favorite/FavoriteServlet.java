package com.revature.blockbusster.favorite;

import com.revature.blockbusster.customer.Customer;
import com.revature.blockbusster.customer.CustomerServices;
import com.revature.blockbusster.util.web.dto.FavoriteInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/favorite")
    public ResponseEntity<Favorite> createFavorite(@RequestBody FavoriteInitializer initFavorite) {

        Favorite newFavorite = new Favorite();
        Customer favoriteEmail = customerServices.readById(initFavorite.getFavoriteEmail());

        newFavorite.setFavoriteID(initFavorite.getFavoriteID());
        newFavorite.setFavoriteEmail(initFavorite.getFavoriteEmail());

        Favorite persistedFavorite = favoriteServices.create(newFavorite);
        return new ResponseEntity<>(persistedFavorite, HttpStatus.CREATED);
    }

    @GetMapping("/favlist")
    public List<Favorite> getAllOrders() {
        return favoriteServices.readAll();
    }

    @PutMapping("/updatecc")
    public ResponseEntity<Favorite> updateFavorite(@RequestBody FavoriteInitializer initFavorite) {
        Favorite newFavorite = new Favorite();
        Customer customerEmail = customerServices.readById(initFavorite.getFavoriteEmail());

        newFavorite.setFavoriteID(initFavorite.getFavoriteID());
        newFavorite.setFavoriteEmail(initFavorite.getFavoriteEmail());

        Favorite persistedFavorite = favoriteServices.update(newFavorite);
        return new ResponseEntity<>(persistedFavorite, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteFav/{favoriteEmail}")
    public ResponseEntity<Favorite> deleteFavorite(@PathVariable String favoriteEmail) {
        favoriteServices.delete(favoriteEmail);
        return new ResponseEntity<Favorite>(HttpStatus.OK);
    }
}