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
import poly.bean.Depart;
import poly.bean.User;

/**
 *
 * @author WIN7
 */
public class DepartModel {
    public DepartModel(){}
    public static List<Depart> showdepart (String tendepart){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://mssql42827-env-9211201.jelastic.skali.net:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "FYIaar41440");
            String sql = "select * from Departs";
            if(tendepart.length() > 0){
                sql += " where Name like '%"+tendepart+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Depart> list = new ArrayList<Depart>();
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
               
               Depart de=new Depart(id,name);
                list.add(de);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
       return null;
    }
    public static void delete(String id){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String url="jdbc:sqlserver://mssql42827-env-9211201.jelastic.skali.net:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "FYIaar41440");
            String sql = "delete from Departs where Id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, id);
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void update(Depart de){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://mssql42827-env-9211201.jelastic.skali.net:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "FYIaar41440");
            String sql = "update Departs set name=? where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, de.getName());
            stm.setString(2, de.getId());
            
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void insert(Depart de){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String url="jdbc:sqlserver://mssql42827-env-9211201.jelastic.skali.net:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "FYIaar41440");
            String sql = "insert into Departs values(?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, de.getId());
            stm.setString(2, de.getName());
           
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
