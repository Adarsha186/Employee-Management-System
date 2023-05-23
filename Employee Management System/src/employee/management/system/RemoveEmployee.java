/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

/**
 *
 * @author Adarsha186
 */
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    
    Choice cEmpId;
    JButton delete, back;
    
    RemoveEmployee() {
        setLayout(null);
        
        JLabel l_empId = new JLabel("Employee ID");
        l_empId.setBounds(50, 50, 100, 30);
        add(l_empId);
        
        cEmpId = new Choice();
        cEmpId.setBounds(200, 50, 150, 30);
        add(cEmpId);
        
        try {
            SQL_Conn c = new SQL_Conn();
            String query = "select * from employee_data";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel l_firstname = new JLabel("First Name");
        l_firstname.setBounds(50, 100, 100, 30);
        add(l_firstname);
        
        JLabel ll_name = new JLabel();
        ll_name.setBounds(200, 100, 100, 30);
        add(ll_name);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 150, 100, 30);
        add(labelphone);
        
        JLabel ll_phone = new JLabel();
        ll_phone.setBounds(200, 150, 100, 30);
        add(ll_phone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);
        
        JLabel ll_email = new JLabel();
        ll_email.setBounds(200, 200, 100, 30);
        add(ll_email);
        
        try {
            SQL_Conn c = new SQL_Conn();
            String query = "select * from employee_data where empId = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                ll_name.setText(rs.getString("firstname"));
                ll_phone.setText(rs.getString("phone"));
                ll_email.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    SQL_Conn c = new SQL_Conn();
                    String query = "select * from employee_data where empId = '"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        ll_name.setText(rs.getString("firstname"));
                        ll_phone.setText(rs.getString("phone"));
                        ll_email.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220, 300, 100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                SQL_Conn c = new SQL_Conn();
                String query = "delete from employee_data where empId = '"+cEmpId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Success");
                setVisible(false);
                new CRUD();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new CRUD();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}