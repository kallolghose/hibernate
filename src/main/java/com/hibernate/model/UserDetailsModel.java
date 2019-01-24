package com.hibernate.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="userdetails")
public class UserDetailsModel {

    @Id
    @Column(name="USERNAME")
    private String username;
    @Column(name="EMAIL")
    private String email;
    @Column(name="NAME")
    private String name;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="DATEOFBIRTH")
    private Date dateOfBirth;
    @Column(name="MOBILENUMBER")
    private Long mobileNumber;

    public void setUsername(String username){
        this.username = username;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setDateOfBirth(Date dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public void setMobileNumber(Long mobileNumber){
        this.mobileNumber = mobileNumber;
    }

    public String getUsername(){
        return this.username;
    }

    public String getEmail(){
        return this.email;
    }

    public String getName(){
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }

    public Date getDateOfBirth(){
        return this.dateOfBirth;
    }

    public Long getMobileNumber(){
        return this.mobileNumber;
    }
}
