package com.revature.blockbusster.favorite;

import com.revature.blockbusster.customer.CustomerDao;
import com.revature.blockbusster.util.interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FavoriteServices implements Serviceable<Favorite> {

    private final FavoriteDao favoriteDao;
    private final CustomerDao customerDao;

    @Autowired
    public FavoriteServices(FavoriteDao favoriteDao, CustomerDao customerDao) {
        this.favoriteDao = favoriteDao;
        this.customerDao = customerDao;
    }

    @Override
    public Favorite create(Favorite newFavorite){ return null;}

    @Override
    public Favorite update(Favorite updatedFavorite) { return null;}

    @Override
    public Favorite readById(String movieId) {return null;}

    @Override
    public boolean delete(String movieId) {return false;}
}
