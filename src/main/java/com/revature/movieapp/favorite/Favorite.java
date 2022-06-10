package com.revature.movieapp.favorite;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "favorite")
public class Favorite {


    @Id
    @Column(name = "email")
    private String email;
    private int movieID;

    public Favorite() {
    }

    public Favorite(String email, int movieID) {
        this.email = email;
        this.movieID = movieID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Favorite)) return false;
        Favorite favorite = (Favorite) o;
        return movieID == favorite.movieID && email.equals(favorite.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, movieID);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

}
