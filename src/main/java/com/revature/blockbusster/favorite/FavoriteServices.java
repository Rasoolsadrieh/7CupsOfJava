package com.revature.blockbusster.favorite;

import com.revature.blockbusster.customer.CustomerDao;
import com.revature.blockbusster.order.Order;
import com.revature.blockbusster.util.interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Favorite create(Favorite newFavorite) {return favoriteDao.save(newFavorite);}

    @Override
    public Favorite update(Favorite updatedFavorite) {return favoriteDao.save(updatedFavorite);}

    @Override
    public Favorite readById(String favoriteEmail) {return null;}

    public Favorite readByEmail(String favoriteEmail) {return favoriteDao.favoriteHistory(favoriteEmail).get();}

    @Override
    public boolean delete(String favoriteEmail) {return false;}

    public List<Favorite> readAll(){ return (List<Favorite>) favoriteDao.findAll();}


}
