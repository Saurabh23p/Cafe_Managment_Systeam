
package dao;
import javax.swing.JOptionPane;
import java.sql.*;


public class DbOperations {
    public static void  setDataOrDelete(String Query,String msg){
    
    try{
        Connection con = ConnectionProvider.getCon(); 
        Statement stmt = con.createStatement();
        stmt.executeUpdate(Query);
        if(!msg.equals(""))
            JOptionPane.showMessageDialog(null, msg);
    
    }
    catch(Exception e){ 
            e.printStackTrace();

   JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
    
          }
    
    }
    
    public static ResultSet getdata(String query){
    try{
    
        Connection con = ConnectionProvider.getCon();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
        
                }
    catch(Exception e){
           JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
           return null;

    
    }
    }
    
}
