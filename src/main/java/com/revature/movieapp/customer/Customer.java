package com.revature.movieapp.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

 @Entity
 @Table(name = "customer")
public class Customer {




     @Id
     @Column(name = "email")
     private String email;
     @Column(name = "fname")
     private String fname;
     @Column(name = "lname")
     private String lname;
     @Column(name = "dob")
     private String dob;
     @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
     @Column(name = "password")
     private String password;
     @Column(name = "balance")
     private int balance;

     public Customer(String email, String fname, String lname, String dob, String password, int balance) {
         this.email = email;
         this.fname = fname;
         this.lname = lname;
         this.dob = dob;
         this.password = password;
         this.balance = balance;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public String getFname() {
         return fname;
     }

     public void setFname(String fname) {
         this.fname = fname;
     }

     public String getLname() {
         return lname;
     }

     public void setLname(String lname) {
         this.lname = lname;
     }

     public String getDob() {
         return dob;
     }

     public void setDob(String dob) {
         this.dob = dob;
     }

     public String getPassword() {
         return password;
     }

     public void setPassword(String password) {
         this.password = password;
     }

     public int getBalance() {
         return balance;
     }

     public void setBalance(int balance) {
         this.balance = balance;
     }

     @Override
     public String toString() {
         return "Customer{" +
                 "email='" + email + '\'' +
                 ", fname='" + fname + '\'' +
                 ", lname='" + lname + '\'' +
                 ", dob='" + dob + '\'' +
                 ", password='" + password + '\'' +
                 ", balance=" + balance +
                 '}';
     }
 }