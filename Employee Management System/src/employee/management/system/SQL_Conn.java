/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;
import java.sql.*; 
/**
 *
 * @author Adarsha186
 */
public class SQL_Conn {
    Statement s;
    public SQL_Conn(){
        try{
             Class.forName("com.mysql.cj.jdbc.Driver"); 
             Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","Adarsha@186");
             s = c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
