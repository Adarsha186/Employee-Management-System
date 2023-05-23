/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Manager_Authentication extends JFrame implements ActionListener{
    
    JTextField user_name;
    JPasswordField password;
    
    Manager_Authentication() {
        
        setLayout(null);
        
        JLabel uname = new JLabel("Username");
        user_name = new JTextField();
        
        JLabel pwd = new JLabel("Password");
        password = new JPasswordField();
        
        
        JButton login = new JButton("LOGIN");
        
        
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        
        image.setBounds(100, 30, 250, 200);
        uname.setBounds(60, 250, 100, 30);
        user_name.setBounds(150, 250, 150, 30);
        pwd.setBounds(60, 300, 100, 30);
        password.setBounds(150, 300, 150, 30);
        login.setBounds(150, 350, 150, 30);
        
        setSize(450, 450);
        setLocation(450, 200);
        
        setVisible(true);
        
        add(image);
        add(uname);
        add(user_name);
        add(pwd);
        add(password);
        add(login);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            String username = user_name.getText();
            String password = this.password.getText();
            
            SQL_Conn c = new SQL_Conn();
            String query = "select * from user_info where username = '"+username+"' and password = '"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Authentication Success");
                setVisible(false);
                new CRUD();
            }  else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        new Manager_Authentication();
    }
}