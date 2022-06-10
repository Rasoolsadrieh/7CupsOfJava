package com.revature.movieapp.creditcard;

import com.revature.movieapp.customer.Customer;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "credit_card")

public class CreditCard {

    @Id
    @Column(name = "cc_number")
    private String cc_number;
    @Column(name = "cc_name")
    private String cc_name;



    @Column(name = "cvv")
    private int cvv;
    @Column(name = "exp_date")
    private String exp_date;
    @Column(name = "zip")
    private int zip;

    @Column(name = "credit_limit")
    private int credit_limit;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_username", referencedColumnName = "email")
    private Customer customer;

    public CreditCard() {
    }

    public CreditCard(String cc_number, String cc_name, int cvv, String exp_date, int zip, int credit_limit, Customer customer) {
        this.cc_number = cc_number;
        this.cc_name = cc_name;
        this.cvv = cvv;
        this.exp_date = exp_date;
        this.zip = zip;
        this.credit_limit = credit_limit;
        this.customer = customer;
    }


    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof CreditCard)) return false;
//        CreditCard creditCard = (CreditCard) o;
//        return getCvv() == creditCard.getCvv() && getExpDate() == creditCard.getExpDate() && getZip() == creditCard.getZip() && getLimit() == creditCard.getLimit() && Objects.equals(getCcName(), creditCard.getCcName()) && Objects.equals(getCcNumber(), creditCard.getCcNumber()) && Objects.equals(getCustomerUsername(), creditCard.getCustomerUsername());
//    }
//    @Override
//    public int hashCode() {
//        return Objects.hash(getCcNumber(), getCcName(), getCvv(), getExpDate(), getZip(), getLimit(), getCustomerUsername());
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCard)) return false;
        CreditCard that = (CreditCard) o;
        return getCvv() == that.getCvv() && getZip() == that.getZip() && credit_limit == that.credit_limit && cc_number.equals(that.cc_number) && cc_name.equals(that.cc_name) && exp_date.equals(that.exp_date) && customer.equals(that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cc_number, cc_name, getCvv(), exp_date, getZip(), credit_limit, customer);
    }

    public String getCc_number() {
        return cc_number;
    }

    public void setCc_number(String cc_number) {
        this.cc_number = cc_number;
    }

    public String getCc_name() {
        return cc_name;
    }

    public void setCc_name(String cc_name) {
        this.cc_name = cc_name;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getCredit_limit() {
        return credit_limit;
    }

    public void setCredit_limit(int credit_limit) {
        this.credit_limit = credit_limit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cc_number='" + cc_number + '\'' +
                ", cc_name='" + cc_name + '\'' +
                ", cvv=" + cvv +
                ", exp_date='" + exp_date + '\'' +
                ", zip=" + zip +
                ", credit_limit=" + credit_limit +
                ", customer=" + customer +
                '}';
    }
}

