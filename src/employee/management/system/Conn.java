
package employee.management.system;
import java.sql.*;


public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
    
    // 5 steps to conection JDBC
    //1Register Driver
    try{
       
        Class.forName("com.mysql.cj.jdbc.Driver");
    // 2. creating jdbc connection
        c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem", "root", "MyDataBase@98");
         //3.create Statement 
         s = c.createStatement();
         //4.Executemysql Query
         
         
    }catch(Exception e){
    e.printStackTrace();
    }
    
    }
    
}
