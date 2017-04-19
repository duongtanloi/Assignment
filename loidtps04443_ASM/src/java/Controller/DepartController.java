/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.bean.Depart;
import poly.bean.User;
import poly.model.DepartModel;
import poly.model.UserModel;


/**
 *
 * @author WIN7
 */
@Controller
@RequestMapping("/pb")
public class DepartController {
    
   @RequestMapping("/showdepart")
    public String showdepart(ModelMap model) {
        model.put("depart", new Depart());
        DepartModel st = new DepartModel();
        List<Depart> list = new ArrayList<Depart>();
        list = st.showdepart("");
        model.addAttribute("listDepart", list);
        Depart de = new Depart();
        return "dsDepart";
    }
      @RequestMapping("/edit")
    public String edit(HttpServletRequest request, ModelMap model) {
        String id = request.getParameter("txtId");
        String name = request.getParameter("txtName");
       
        Depart de=new Depart(id, name);
        model.addAttribute("depart", de);

        List<Depart> list = new ArrayList<Depart>();
        list = DepartModel.showdepart("");
        model.addAttribute("listDepart", list);
        return "dsDepart";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, ModelMap model,
            @ModelAttribute("depart") Depart depart) {
        String id = request.getParameter("txtId");
        DepartModel.delete(id);
        List<Depart> list = new ArrayList<Depart>();
        list = DepartModel.showdepart("");
        model.addAttribute("listDepart", list);
        return "dsDepart";
    }

    @RequestMapping(params = "btnUpdate")
    public String update(@ModelAttribute("depart") Depart depart, ModelMap model) {

        DepartModel.update(depart);
        List<Depart> list = new ArrayList<Depart>();
        list = DepartModel.showdepart("");
        model.addAttribute("listDepart", list);
        return "dsDepart";
    }

    @RequestMapping(params = "btnInsert")
    public String insert(@ModelAttribute("depart") Depart depart, ModelMap model) {

        DepartModel.insert(depart);
        List<Depart> list = new ArrayList<Depart>();
        list = DepartModel.showdepart("");
        model.addAttribute("listDepart", list);
        return "redirect:pb/showdepart.htm";
    }

}
