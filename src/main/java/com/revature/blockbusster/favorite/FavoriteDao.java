package com.revature.blockbusster.favorite;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteDao extends CrudRepository<Favorite, String> {

}
