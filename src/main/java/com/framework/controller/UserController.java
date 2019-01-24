package com.framework.controller;

import com.framework.model.AddressModel;
import com.framework.model.UserModel;
import com.framework.responseModel.CreateUserResponseModel;
import com.framework.util.Utilities;
import com.hibernate.model.AddressDetailsModel;
import com.hibernate.model.UserDetailsModel;
import com.hibernate.util.DBOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/api/user")
public class UserController {

    private DBOperations db = new DBOperations();

    @RequestMapping(path="", method = RequestMethod.POST, produces = "application/json")
    public CreateUserResponseModel createUser(@RequestBody UserModel userModel){
        ArrayList<String> errors = new ArrayList<String>();

        try{
            if(userModel!=null){
                boolean emailCheck = Utilities.emailValidator.test(userModel.getEmail());
                boolean usernameCheck = Utilities.checkEmptyStr.test(userModel.getUsername());
                if(emailCheck && usernameCheck){
                    UserDetailsModel udModel = new UserDetailsModel();
                    udModel.setUsername(userModel.getUsername());
                    udModel.setEmail(userModel.getEmail());
                    udModel.setMobileNumber(userModel.getMobileNumber());
                    udModel.setDateOfBirth(userModel.getDateOfBirth());
                    udModel.setPassword(userModel.getPassword());
                    udModel.setName(userModel.getNameOfUser());

                    AddressDetailsModel addressDetailsModel = new AddressDetailsModel();
                    Random newRandom = new Random();
                    int randomNo = newRandom.nextInt(10000) + 10000;
                    addressDetailsModel.setId(userModel.getAddress().getCity()+"_"+userModel.getAddress().getCountry()+"_"+randomNo);
                    addressDetailsModel.setCity(userModel.getAddress().getCity());
                    addressDetailsModel.setState(userModel.getAddress().getStete());
                    addressDetailsModel.setCountry(userModel.getAddress().getCountry());
                    addressDetailsModel.setLine1(userModel.getAddress().getLine1());
                    addressDetailsModel.setLine2(userModel.getAddress().getLine2());
                    addressDetailsModel.setPincode(userModel.getAddress().getPinCode());
                    addressDetailsModel.setUsername(udModel);

                    db.writeToDB(udModel);
                    db.writeToDB(addressDetailsModel);


                    CreateUserResponseModel responseModel = new CreateUserResponseModel();
                    responseModel.setUsername(userModel.getUsername());
                    responseModel.setEmail(userModel.getEmail());
                    responseModel.setResponseMessage("Successful Registration");
                    return responseModel;
                }
                else{
                    errors.add("Email Error/Username Error");
                }
            }
        }
        catch(Exception e){
            errors.add(e.getMessage());
            e.printStackTrace();
        }

        CreateUserResponseModel responseModel = new CreateUserResponseModel();
        responseModel.setErrors(errors);
        responseModel.setResponseMessage("Received some Error");
        return responseModel;
    }

    @RequestMapping(value = "/{username:.+}", method = RequestMethod.GET, produces = "application/json")
    public UserModel getUser(@PathVariable("username")String username){
        System.out.println("USERNAME : " + username);
        ArrayList<String> error = new ArrayList<String>();
        try{
            List<UserDetailsModel> list = db.selection(UserDetailsModel.class, "username", username);
            List<AddressDetailsModel> addressList = db.selection(AddressDetailsModel.class, "username", list.get(0));
            UserDetailsModel userDetailsModel = list.get(0);
            AddressDetailsModel addressDetailsModel = addressList.get(0);

            AddressModel addressModel = new AddressModel();
            addressModel.setLine1(addressDetailsModel.getLine1());
            addressModel.setLine2(addressDetailsModel.getLine2());
            addressModel.setCountry(addressDetailsModel.getCountry());
            addressModel.setCity(addressDetailsModel.getCity());
            addressModel.setStete(addressDetailsModel.getState());
            addressModel.setPinCode(addressDetailsModel.getPincode());


            UserModel userModel = new UserModel();
            userModel.setEmail(userDetailsModel.getEmail());
            userModel.setUsername(userDetailsModel.getUsername());
            userModel.setNameOfUser(userDetailsModel.getName());
            userModel.setMobileNumber(userDetailsModel.getMobileNumber());
            userModel.setDateOfBirth(userDetailsModel.getDateOfBirth());
            userModel.setAddress(addressModel);
            //System.out.println("EMAIL : " + userModel.getEmail());
            return userModel;

        }
        catch(Exception e){
            error.add(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
