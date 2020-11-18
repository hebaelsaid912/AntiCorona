package com.example.covid_19.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class database {

    private static  String username="root";
    private static  String password="";
    private static  String dbname="covid";
    private static  String dsn="jdbc:mysql://10.0.2.2:3306/"+database.dbname;

    public static Connection connection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection  handler=null;
        try{
            handler=DriverManager.getConnection(database.dsn,database.username,database.password);
        }catch(Exception e){
        }
        finally{
            if(handler !=null){
                return handler;
            }else{
                return null;
            }
        }
    }
}

