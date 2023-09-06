/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import javax.swing.JOptionPane;
import java.io.File;

/**
 *
 * @author Dell
 */
public class OpenPdf {
    public static void openById(String id){
    try{
    if((new File("E:\\"+id+ ".pdf")).exists()){

    Process p = Runtime
            .getRuntime()
               .exec("rundl32 url.dll,FileProtocolHandler E:\\"+id+".pdf");

    }
    else{
            JOptionPane.showConfirmDialog(null, "File is not Exists");

    }
    }catch(Exception e){
        JOptionPane.showConfirmDialog(null, e);
    }
    }
    
}
