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
import poly.bean.Staff;

/**
 *
 * @author WIN7
 */
public class StaffModel {

    public StaffModel() {
    }

    public static List<Staff> showstaff(String tenstaff) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://mssql42827-env-9211201.jelastic.skali.net:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "FYIaar41440");
            String sql = "select * from Staffs";
            if (tenstaff.length() > 0) {
                sql += " where Name like '%" + tenstaff + "%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Staff> list = new ArrayList<Staff>();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                Boolean gender = rs.getBoolean("gender");
                String birthday = rs.getString("birthday");
                String photo = rs.getString("photo");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                Float salary = rs.getFloat("salary");
                String note = rs.getString("note");
                String departid = rs.getString("departid");
                Staff st = new Staff(id, name, gender, birthday, photo, email, phone, salary, note, departid);
                list.add(st);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void delete(String id) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://mssql42827-env-9211201.jelastic.skali.net:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "FYIaar41440");
            String sql = "delete from Staffs where Id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, id);
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(Staff st) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://mssql42827-env-9211201.jelastic.skali.net:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "FYIaar41440");
            String sql = "update Staffs set name=?, gender=?, birthday=?, photo=?, email=?, phone=?, salary=?, notes=?, departid=? where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, st.getName());
            stm.setBoolean(2, st.getGender());
            stm.setString(3, st.getBirthday());
            stm.setString(4, st.getPhoto());
            stm.setString(5, st.getEmail());
            stm.setString(6, st.getPhone());
            stm.setFloat(7, st.getSalary());
            stm.setString(8, st.getNote());
            stm.setString(9, st.getDepartid());
            stm.setString(10, st.getId());

            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insert(Staff st) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             String url = "jdbc:sqlserver://mssql42827-env-9211201.jelastic.skali.net:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "FYIaar41440");
            String sql = "insert into Staffs values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, st.getId());
            stm.setString(2, st.getName());
            stm.setBoolean(3, st.getGender());
            stm.setString(4, st.getBirthday());
            stm.setString(5, st.getPhoto());
            stm.setString(6, st.getEmail());
            stm.setString(7, st.getPhone());
            stm.setFloat(8, st.getSalary());
            stm.setString(9, st.getNote());
            stm.setString(10, st.getDepartid());
            

            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
