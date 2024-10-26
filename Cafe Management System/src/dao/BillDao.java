/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.cj.util.StringUtils;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.Bill;

/**
 *
 * @author Dell
 */
public class BillDao {

    public static String getId() {
        int id = 1;
        try {
            ResultSet rs = DbOperations.getdata("select max(id) from bill");
            if (rs.next()) {
                id = rs.getInt(1);
                id = id + 1;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return String.valueOf(id); 

    }

    public static void save(Bill bill) {
        String query = "insert into bill values('" +bill.getId()+ "','" +bill.getName()+ "','" +bill.getMobile()+ "','" +bill.getEmail()+ "','" +bill.getDate()+ "','" +bill.getTotal()+ "','" +bill.getCreatedBy()+ "')";
        DbOperations.setDataOrDelete(query, "Bill Details Added Succesfully");
    }

    public static ArrayList<Bill> getAllRecordsByInc(String date) {
        ArrayList<Bill> arrayList = new ArrayList<>();
        try {
            String query;
            if(StringUtils.isNullOrEmpty(date)){
                  query="select * from bill";
         }else{
                    query="select * from bill where date='"+date+"'";
            }
            System.out.println("dao.BillDao.getAllRecordsByInc()"+query);
            ResultSet rs = DbOperations.getdata(query);
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobile(rs.getString("mobile"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedBy(rs.getString("createdBy"));
                arrayList.add(bill);

            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return arrayList;
    }
    
    public static ArrayList<Bill> getAllRecordsByDesc(String date) {
        ArrayList<Bill> arrayList = new ArrayList<>();
        try {
             String query;
            if(StringUtils.isNullOrEmpty(date)){
                  query="select * from bill order By id DESC";
         }else{
                    query="select * from bill where date='"+date+"' order By id DESC";
                            }
            ResultSet rs = DbOperations.getdata(query);
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobile(rs.getString("mobile"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedBy(rs.getString("createdBy"));
                arrayList.add(bill);

            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return arrayList;
}
}
