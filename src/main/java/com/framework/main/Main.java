package com.framework.main;

import com.hibernate.model.AddressDetailsModel;
import com.hibernate.model.UserDetailsModel;
import com.hibernate.util.DBOperations;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String [] args){
        try{
            /*
            UserDetailsModel userDetailsModel = new UserDetailsModel();
            userDetailsModel.setEmail("ghosekallol#@gmail.com");
            userDetailsModel.setName("Kallol Ghose");
            userDetailsModel.setUsername("kallol.ghose");
            userDetailsModel.setPassword("password");
            userDetailsModel.setDateOfBirth(new Date());
            userDetailsModel.setMobileNumber(9999999L);

            AddressDetailsModel addressModel = new AddressDetailsModel();
            addressModel.setId("1");
            addressModel.setLine1("LINE1");
            addressModel.setLine2("");
            addressModel.setCity("NOIDA");
            addressModel.setState("UP");
            addressModel.setCountry("India");
            addressModel.setPincode(201301L);
            addressModel.setUsername(userDetailsModel);
            */

            /*Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //session.persist(userDetailsModel);
            //session.persist(addressModel);
            //session.getTransaction().commit();

            Query query = session.createQuery(" FROM " + UserDetailsModel.class.getName() + " WHERE username=:columnValue");
            query.setParameter("columnValue", "kallol.ghose");
            UserDetailsModel data = (UserDetailsModel) query.uniqueResult();
            System.out.print(data.getEmail());

            session.close();*/
            DBOperations db = new DBOperations();
            /*UserDetailsModel model = (UserDetailsModel) db.getDataFromDB("UserDetailsModel", "username", "kallol,ghose");
            System.out.print(model.getEmail());*/
            List<UserDetailsModel> rows = db.selection(UserDetailsModel.class, "username", "kallol.ghose");
            List<AddressDetailsModel> rows1 = db.selection(AddressDetailsModel.class, "username", rows.get(0));
            System.out.print(rows1.get(0).getId());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
