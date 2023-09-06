package dao;

import javax.swing.JOptionPane;

public class tables {

    public static void main(String[] args) {

        try {
            String userTable = "create table user (id int AUTO_INCREMENT primary key, name varchar(200), email varchar(200), mobile varchar(10), address varchar(200), password varchar(200), securityQuestion varchar(200), answer varchar(200), status varchar(20), UNIQUE(email))";
//Admins detials here bcz when you switch the sysytem the you have to remember admins details 
            String adminDetails = "insert into user(name, email, mobile, address, password, securityQuestion, answer, status) values('Admin', 'admin123@gmail.com', '1234567890', 'India', 'admin@123', 'What is your pet name ?', 'Tom', 'true')";
            String categoryTables = "create table category(id int AUTO_INCREMENT primary key, name varchar(200))";
            String productTable = "create table product (id int AUTO_INCREMENT primary key, name  varchar(200), category varchar(200), price varchar(200))";
            String billTable = "create table bill(id int primary key, name varchar(200), mobile varchar(200), email varchar(200), date varchar(50), total varchar(200), createBy varchar(200))";

            DbOperations.setDataOrDelete(userTable, "User Table Created Succesfully");
            DbOperations.setDataOrDelete(adminDetails, "Admin Details Added Succesfully");
            DbOperations.setDataOrDelete(categoryTables, "Category Table Created Succesfully");
            DbOperations.setDataOrDelete(productTable, "Product Table Created Succesfully");
            DbOperations.setDataOrDelete(billTable, "Bill Table Created Succesfully");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

}
