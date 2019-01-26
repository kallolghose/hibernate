package com.framework.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.framework.serializers.AddressModelSerializer;

@JsonSerialize(using = AddressModelSerializer.class)
public class AddressModel {

    private String line1;
    private String line2;
    private String state;
    private String city;
    private String country;
    private Long pinCode;


    public void setLine1(String line1){
        this.line1 = line1;
    }

    public void setLine2(String line2){
        this.line2 = line2;
    }

    public void setStete(String state){
        this.state = state;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPinCode(Long pinCode){
        this.pinCode = pinCode;
    }
    public String getLine1(){
        return this.line1;
    }

    public String getLine2(){
        return this.line2;
    }

    public String getStete(){
        return this.state;
    }

    public String getCity(){
        return this.city;
    }

    public String getCountry(){
        return this.country;
    }

    public Long getPinCode(){
        return this.pinCode;
    }
}
