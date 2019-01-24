package com.framework.controller;

import com.framework.model.LoginModel;
import com.framework.responseModel.LoginResponseModel;
import com.hibernate.model.UserDetailsModel;
import com.hibernate.util.DBOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api/login")
public class LoginController {

    @ResponseBody
    @RequestMapping(path = "", method = RequestMethod.POST, produces = "application/json")
    public LoginResponseModel getLoginStatus(@RequestBody LoginModel model){

        try {
            if(model!=null){

                DBOperations dbOperations = new DBOperations();

                List<UserDetailsModel> userDetailsModel = dbOperations.selection(UserDetailsModel.class, "username", model.getUsername());
                if(userDetailsModel!=null && userDetailsModel.size()>0) {
                    String storedPassword = userDetailsModel.get(0).getPassword();
                    if (storedPassword.equals(model.getPassword())) {
                        LoginResponseModel responseModel = new LoginResponseModel();
                        responseModel.setResponseMessage("Successful Login");
                        responseModel.setAUTHCHECKSUM("someAuthCheckSum");
                        return responseModel;
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        ArrayList<String> errors = new ArrayList<String>(Arrays.asList("Username/Password not matching"));
        LoginResponseModel response = new LoginResponseModel();
        response.setErrors(errors);
        response.setResponseMessage("Could not login   ");
        return response;
    }

}
