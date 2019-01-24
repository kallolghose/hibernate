package com.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name="address")
public class AddressDetailsModel {

    @Id
    @Column(name = "ID")
    private String id;

    @OneToOne
    @JoinColumn (name="USERNAME")
    private UserDetailsModel username;
    @Column(name="LINE1")
    private String line1;
    @Column(name="LINE2")
    private String line2;
    @Column(name="STATE")
    private String state;
    @Column(name="CITY")
    private String city;
    @Column(name="COUNTRY")
    private String country;
    @Column(name="PINCODE")
    private Long pincode;


    public UserDetailsModel getUsername() {
        return username;
    }

    public void setUsername(UserDetailsModel username) {
        this.username = username;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
