package com.revature.blockbusster.util.web.dto;

public class FavoriteInitializer {


    private String favoriteID;
    private String favoriteEmail;

    public FavoriteInitializer() {
    }

    public FavoriteInitializer(String favoriteID, String favoriteEmail) {
        this.favoriteID = favoriteID;
        this.favoriteEmail = favoriteEmail;


    }

    public String getFavoriteID() {
        return favoriteID;
    }

    public void setFavoriteID(String favoriteID) {
        this.favoriteID = favoriteID;
    }

    public String getFavoriteEmail() {
        return favoriteEmail;
    }

    public void setFavoriteEmail(String favoriteEmail) {
        this.favoriteEmail = favoriteEmail;
    }

}