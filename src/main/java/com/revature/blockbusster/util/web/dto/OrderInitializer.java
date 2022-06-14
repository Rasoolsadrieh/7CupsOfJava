package com.revature.blockbusster.util.web.dto;

public class OrderInitializer {

    private String movieId;
    private String orderDate;
    private boolean isOwned;
    private String returnDate;
    private String orderEmail;

    public OrderInitializer() {
    }

    public OrderInitializer(String movieId, String orderDate, boolean isOwned, String returnDate, String orderEmail) {
        this.movieId = movieId;
        this.orderDate = orderDate;
        this.isOwned = isOwned;
        this.returnDate = returnDate;
        this.orderEmail = orderEmail;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public void setOwned(boolean owned) {
        isOwned = owned;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getOrderEmail() {
        return orderEmail;
    }

    public void setOrderEmail(String orderEmail) {
        this.orderEmail = orderEmail;
    }
}
