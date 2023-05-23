/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EMS extends JFrame implements ActionListener {
    
    EMS() {
        setLayout(null);
        
        JLabel header = new JLabel("Employee Management System");
        header.setBounds(80, 30, 1000, 70);
        header.setFont(new Font("monospaced", Font.BOLD | Font.ITALIC, 60));
        header.setForeground(Color.MAGENTA);
        add(header);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front_page.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(50, 100, 1100, 500);
        add(image);
        
        JButton login = new JButton("Login");
        login.setBounds(550, 400, 300, 70);
        login.setFont(new Font("serif",Font.BOLD, 20));
        login.setBackground(Color.LIGHT_GRAY);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        image.add(login);
        
        
        setSize(1200, 650);
        setLocation(200, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Manager_Authentication();
    }
    
    public static void main(String args[]) {
        new EMS();
    }
}
