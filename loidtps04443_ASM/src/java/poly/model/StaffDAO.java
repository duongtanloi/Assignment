/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.model;

import entity.xml.Departs;
import entity.xml.Staffs;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author WIN7
 */
public class StaffDAO {
    public static List<Staffs> layDanhSachSV(String ten){
        List<Staffs> list = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql="from Staffs";
        if(ten.length()>0){
            sql += " where name like '%"+ten+"%'";
        }
        Query query = session.createQuery(sql);
        list = query.list();
        return list;
    }    
    public static List<Staffs> LayDanhSachSinhVien(){
        List<Staffs> dsKhachHang=null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql="from Staffs";
        Query query = session.createQuery(hql);
        dsKhachHang = query.list();
        return dsKhachHang;
    }
    public static Staffs layThongTinSinhVien(String id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Staffs kh = (Staffs)session.get(Staffs.class, id);
        session.close();
        return kh;
    }
    public static boolean themSinhVien(Staffs sv){
        if(StaffDAO.layThongTinSinhVien(sv.getId())!=null)
            return false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.getTransaction().begin();
            session.save(sv);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            System.out.println(e);
            return false;
        }
//        }finally{
//            session.close();
//        }
    }
    public static boolean updateThongTinSinhVien(Staffs sv){
        if(StaffDAO.layThongTinSinhVien(sv.getId())==null)
            return false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.getTransaction().begin();
            session.update(sv);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            System.out.println(e);
            return false;
        }
    }
    public static boolean deleteSinhVien(String id){
        Staffs sv = StaffDAO.layThongTinSinhVien(id);
        if(sv==null)
            return false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.getTransaction().begin();
            session.delete(sv);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            System.out.println(e);
            return false;
        }
    }
    public static Departs depart(String departid){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         Departs depart = new Departs();
         try {
             session.getTransaction().begin();
             depart = (Departs) session.get(Departs.class, departid);
             session.getTransaction().commit();
         } catch(Exception e) {
             e.printStackTrace();
             session.getTransaction().rollback();
         }
         return depart;
    }
}
