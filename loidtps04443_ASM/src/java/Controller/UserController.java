/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import poly.bean.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.apache.tomcat.jni.User.username;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.model.UserModel;

/**
 *
 *
 */
@Controller
@RequestMapping(value = "/login")

public class UserController {

    @RequestMapping(value = "/checklogin")
    public String checklogin(ModelMap model) {
        return "login";
    }

    @RequestMapping(params = "btnlogin")
    public String kiemtra(HttpServletRequest request, ModelMap model, HttpSession session) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://mssql42827-env-9211201.jelastic.skali.net:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "FYIaar41440");
            String username = request.getParameter("txtuser");
            String password = request.getParameter("txtpass");
            String sql = "SELECT * FROM Users WHERE Username = '" + username + "' AND Password = '" + password + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String user = rs.getString("Username");
                String pass = rs.getString("Password");
                String name = rs.getString("Fullname");
                User login = new User(user, pass, name);
                model.addAttribute("login", login);
                session.setAttribute("hoten", name);
                UserModel st = new UserModel();
                List<User> list = new ArrayList<User>();
                list = st.showuser("");
                model.addAttribute("listUser", list);
                User sv = new User();
                sv = list.get(0);
                model.addAttribute("user", sv);
                return "danhsachuser";
            } else {
                model.put("loi", "Tên đăng nhập hoặc mật khẩu bị sai<br>");
                return "login";
            }
        } catch (Exception e) {
            return "Error";
        }
    }

    @RequestMapping(params = "btndangxuat")
    public String dangxuat(ModelMap model, HttpSession session) {
        session.removeAttribute("hoten");
        return "redirect:login/checklogin.htm";
    }

    @RequestMapping("showall")
    public String showall(ModelMap model) {
        UserModel st = new UserModel();
        List<User> list = new ArrayList<User>();
        list = st.showuser("");
        model.addAttribute("listUser", list);
        User sv = new User();
        sv = list.get(0);
        model.addAttribute("user", sv);
        return "danhsachuser";
    }
    //@RequestMapping(value = "/showdsuser")
    //  public String dsuser(ModelMap model) {
    // try {
    //  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    //  String url = "jdbc:sqlserver://localhost:1433;databaseName=Personel";
    //  Connection con = DriverManager.getConnection(url, "sa", "123");
    //  String sql = "SELECT * FROM Users";
    //  Statement stm = con.createStatement();
    //  ResultSet rs = stm.executeQuery(sql);
    //  List<User> list = new ArrayList<User>();
    // while (rs.next()) {
    //     String user = rs.getString("Username");
    //       String pass = rs.getString("Password");
    //      String fname = rs.getString("Fullname");
    //       User sp = new User(user, pass, fname);
    //        list.add(sp);
    //      model.addAttribute("listUser", list);
    //   }
    // } catch (Exception e) {
    //   e.printStackTrace();
    //}
    //  return "danhsachuser";
    //   }
    @RequestMapping("edit")
    public String edit(HttpServletRequest request, ModelMap model) {
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String Fullname = request.getParameter("txtFullname");
        User sv = new User(username, password, Fullname);
        model.addAttribute("user", sv);

        List<User> list = new ArrayList<User>();
        list = UserModel.showuser("");
        model.addAttribute("listUser", list);
        return "danhsachuser";
    }

    @RequestMapping("delete")
    public String delete(HttpServletRequest request, ModelMap model,
            @ModelAttribute("user") User user) {
        String username = request.getParameter("txtUsername");
        UserModel.delete(username);
        List<User> list = new ArrayList<User>();
        list = UserModel.showuser("");
        model.addAttribute("listUser", list);
        return "danhsachuser";
    }

    @RequestMapping(params = "btnUpdate")
    public String update(@ModelAttribute("user") User user, ModelMap model) {

        UserModel.update(user);
        List<User> list = new ArrayList<User>();
        list = UserModel.showuser("");
        model.addAttribute("listUser", list);
        return "danhsachuser";
    }

    @RequestMapping(params = "btnInsert")
    public String insert(@ModelAttribute("user") User user, ModelMap model) {
        UserModel.insert(user);
        List<User> list = new ArrayList<User>();
        list = UserModel.showuser("");
        model.addAttribute("listUser", list);
        return "danhsachuser";
    }
}
