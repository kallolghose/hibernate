package com.framework.responseModel;

import java.util.ArrayList;

public class LoginResponseModel {

    public ArrayList<String> errors;
    public String responseMessage;
    public String AUTHCHECKSUM;

    public void setErrors(ArrayList<String> errors){
        this.errors = errors;
    }

    public ArrayList<String> getErrors(){
        return this.errors;
    }

    public void setResponseMessage(String responseMessage){
        this.responseMessage  = responseMessage;
    }

    public String getResponseMessage(){
        return this.responseMessage;
    }

    public void setAUTHCHECKSUM(String AUTHCHECKSUM){
        this.AUTHCHECKSUM = AUTHCHECKSUM;
    }

    public String getAUTHCHECKSUM(){
        return this.AUTHCHECKSUM;
    }

}
