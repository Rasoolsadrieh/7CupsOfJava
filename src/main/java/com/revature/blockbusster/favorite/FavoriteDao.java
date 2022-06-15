package com.revature.blockbusster.favorite;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FavoriteDao extends CrudRepository<Favorite, String> {

    @Query(value = "FROM Favorite WHERE favoriteEmail= :favorite_email")
    Optional<Favorite> favoriteHistory(String favoriteEmail);

}
