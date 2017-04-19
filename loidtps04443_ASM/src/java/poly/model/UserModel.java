/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import poly.bean.User;

/**
 *
 * @author WIN7
 */
public class UserModel {
    public UserModel(){}
    public static List<User> showuser (String tenuser){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String url="jdbc:sqlserver://mssql42827-env-9211201.jelastic.skali.net:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "FYIaar41440");
            String sql = "select * from Users";
            if(tenuser.length() > 0){
                sql += " where Name like '%"+tenuser+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<User> list = new ArrayList<User>();
            while(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                String fullname = rs.getString("fullname");
                User sp = new User(username, password, fullname);
                list.add(sp);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
       return null;
    }
    public static void delete(String username){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://mssql42827-env-9211201.jelastic.skali.net:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "FYIaar41440");
            String sql = "delete from Users where Username=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void update(User sv){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String url="jdbc:sqlserver://mssql42827-env-9211201.jelastic.skali.net:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "FYIaar41440");
            String sql = "update Users set Password=?,Fullname=? where Username=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, sv.getPassword());
            stm.setString(2, sv.getFullname());
            stm.setString(3, sv.getUsername());
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void insert(User sv){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://mssql42827-env-9211201.jelastic.skali.net:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "FYIaar41440");
            String sql = "insert into Users values(?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, sv.getUsername());
            stm.setString(2, sv.getPassword());
            stm.setString(3, sv.getFullname());
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
