/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entity.xml.Departs;
import entity.xml.Staffs;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.bean.Depart;
import poly.bean.Staff;
import poly.model.DepartModel;
import poly.model.StaffDAO;
import poly.model.StaffModel;

/**
 *
 * @author WIN7
 */
@Controller
@RequestMapping("/nv")
public class StaffController {
    
    DepartModel dm = new DepartModel();
    
    @RequestMapping("showall")
    public String showAll(ModelMap model) {
        StaffDAO st = new StaffDAO();
        List<Staffs> list = new ArrayList<Staffs>();
        list = st.layDanhSachSV("");
        model.addAttribute("listStaff", list);
        
        Staffs sv = new Staffs();
        sv = list.get(0);
        model.addAttribute("staff", sv);
        return "dsStaff";
    }
    
    @RequestMapping("edit")
    public String edit(HttpServletRequest request, ModelMap model) throws ParseException {
        String id = request.getParameter("txtId");
        String name = request.getParameter("txtName");
        boolean gender = Boolean.parseBoolean(request.getParameter("txtGender"));
        String birthday = request.getParameter("txtBirthday");
        String photo = request.getParameter("txtPhoto");
        String email = request.getParameter("txtEmail");
        String phone = request.getParameter("txtPhone");
        double salary = Double.parseDouble(request.getParameter("txtSalary"));
        String note = request.getParameter("txtNote");
        String departid = request.getParameter("txtDepartid");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(birthday);
        Departs depart = StaffDAO.depart(departid);
        Staffs st = new Staffs(id,depart,name,gender,date,photo,email,phone,salary,note);
        model.addAttribute("staff", st);
        List<Staffs> list = new ArrayList<Staffs>();
        list = StaffDAO.layDanhSachSV("");
        model.addAttribute("listStaff", list);
        return "dsStaff";
    }
    
    @RequestMapping("delete")
    public String delete(HttpServletRequest request, ModelMap model,
            @ModelAttribute("staff") Staffs staff) {
        try {
            String id = request.getParameter("txtId");
            
            StaffDAO.deleteSinhVien(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Staffs> list = new ArrayList<Staffs>();
        list = StaffDAO.layDanhSachSV("");
        model.addAttribute("listStaff", list);
        return "dsStaff";
    }
    
    @RequestMapping(params = "btnUpdate")
    public String update(@ModelAttribute("staff") Staffs staff, ModelMap model) {
        StaffDAO.updateThongTinSinhVien(staff);
        List<Staffs> list = new ArrayList<Staffs>();
        list = StaffDAO.layDanhSachSV("");
        model.addAttribute("listStaff", list);
        return "dsStaff";
    }
    
    @RequestMapping(params = "btnInsert")
    public String insert(@ModelAttribute("staff") Staffs staff, ModelMap model) {
        StaffDAO.themSinhVien(staff);
        List<Staffs> list = new ArrayList<Staffs>();
        list = StaffDAO.layDanhSachSV("");
        model.addAttribute("listStaff", list);
        return "dsStaff";
    }
}
