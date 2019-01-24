package com.framework.model;

import java.util.Date;

public class UserModel {

    private String username;
    private String nameOfUser;
    private String password;
    private AddressModel address;
    private String email;
    private Date dateOfBirth;
    private Long mobileNumber;

    public void setUsername(String username){
        this.username = username;
    }

    public void setNameOfUser(String nameOfUser){
        this.nameOfUser = nameOfUser;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setAddress(AddressModel addressModel){
        this.address = addressModel;
    }

    public void setEmail(String email){
        this.email =  email;
    }

    public void setDateOfBirth(Date dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public void setMobileNumber(Long mobileNumber){ this.mobileNumber = mobileNumber; }

    public String getUsername(){
        return this.username;
    }

    public String getNameOfUser(){
        return this.nameOfUser;
    }

    public String getPassword(){
        return this.password;
    }

    public AddressModel getAddress(){
        return this.address;
    }

    public String getEmail(){
        return this.email;
    }

    public Date getDateOfBirth(){
        return this.dateOfBirth;
    }

    public Long getMobileNumber(){ return this.mobileNumber; }
}
