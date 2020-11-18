package com.example.covid_19.database;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {
    private final String insert_stmt="INSERT INTO users (name,email,password) VALUES (?,?,?)";
    private final String showAll_stmt="SELECT * FROM `users`";
    private final String check_stmt="Select * from users where name=? and password=?";


    public void insert(User o){
        try {
            database.connection();
            PreparedStatement ps= database.connection().prepareStatement(insert_stmt);
            ps.setString(1, o.getName());
            ps.setString(2, o.getEmail());
            ps.setString(3, o.getPassword());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("There is exp  \n ex: "+ex.getMessage());
        }
    }
    public String showall() {
        try {
            String result="";
            PreparedStatement stmt = database.connection().prepareStatement(showAll_stmt);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String Tmp="";
                Tmp+=""+rs.getInt(1)+"#";
                Tmp+=""+rs.getString(2)+"#";
                Tmp+=""+rs.getString(3)+"#\n";
                result+=Tmp;
                Tmp="";
            }

            return result;
        } catch (Exception e) {
            return e.getMessage() + "";
        }
    }
    public Boolean check(String username , String password){
        User o = null;
        int flag=0;
        try {
            database.connection();
            PreparedStatement ps= database.connection().prepareStatement(check_stmt);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                o=new User( rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4));
                return true;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("There is exp  \n ex: "+ex.getMessage());
        }
        return false;
    }
}
