package com.framework.controller;

import com.framework.model.LoginModel;
import com.framework.responseModel.LoginResponseModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/api/login")
public class LoginController {

    @ResponseBody
    @RequestMapping(path = "", method = RequestMethod.POST, produces = "application/json")
    public LoginResponseModel getLoginStatus(@RequestBody LoginModel model){

        try {
            if(model!=null){
                if(model.getUsername().equals("kallol") && model.getPassword().equals("1234")){
                    LoginResponseModel responseModel = new LoginResponseModel();
                    responseModel.setResponseMessage("Successful Login");
                    responseModel.setAUTHCHECKSUM("someAuthCheckSum");
                    return responseModel;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        ArrayList<String> errors = new ArrayList<String>(Arrays.asList("Error Received"));
        LoginResponseModel response = new LoginResponseModel();
        response.setErrors(errors);
        return response;
    }
}
