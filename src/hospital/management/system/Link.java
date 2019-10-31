/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system;

/**
 *
 * @author bosspavi
 */

import java.sql.*;
import javax.swing.JOptionPane;

public class Link {
   Connection con=null;
   
   public static Connection getConnection(){
       try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");
            return con;
        } 
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Database is not connected. Please connect");
            return null;
        }
   }
}
