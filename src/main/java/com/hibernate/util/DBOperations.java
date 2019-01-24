package com.hibernate.util;

import org.hibernate.Session;

import org.hibernate.query.Query;
import java.util.List;

public class DBOperations {

    /**
     * Function to get the list of data from the database
     * @param tableName - Name of the table to fetch data from
     * @return
     */
    public List<Object> getListFromDB(String tableName) throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Object> data = session.createQuery("FROM " + tableName).list();
        session.close();
        return data;
    }

    /**
     * Function to get the list of data based on the class send
     * @param clazz - Class/model to be fetched
     * @param columnName - Column Name based on which data is to be fetched
     * @param columnValue - Value of the column
     * @param <T> - Generic class
     * @return - List of class to be fetched
     */
    public <T> List<T> selection(Class<? extends  T> clazz, String columnName, Object columnValue){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "FROM " + clazz.getSimpleName();
        if(columnName!=null)
            query = query + " WHERE " + columnName + "=:" + columnName.toUpperCase();

        Query hqlQuery = session.createQuery(query);
        if(columnValue!=null)
            hqlQuery.setParameter(columnName.toUpperCase(), columnValue);
        List<T> rows = (List<T>) hqlQuery.list();
        return rows;
    }

    /**
     * Function to write data to the database
     * @param object - Object to be written in the database
     */
    public void writeToDB(Object object) throws  Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(object);
        session.getTransaction().commit();
        session.close();
    }
}
