/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author Adarsha186
 */
public class Update extends JFrame implements ActionListener{
    JTextField j_education, j_lastname, j_address, j_phone, j_email, j_salary, j_role;
    String[] degree = {"Masters Degree", "Associate Degree", "Bachelors Degree", "Doctoral Degree"};
    JLabel j_empId;
    JButton add, back;
    String empId;
    
    Update(String empId) {
        this.empId = empId;
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Details");
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("First Name");
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        JLabel firstname = new JLabel();
        add(firstname);
        
        JLabel l_lastname = new JLabel("Last Name");
        l_lastname.setFont(new Font("serif", Font.PLAIN, 20));
        add(l_lastname);
        
        j_lastname = new JTextField();
        add(j_lastname);
        
        JLabel labeldob = new JLabel("Date of Joining");
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        JLabel doj = new JLabel();
        add(doj);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        j_salary = new JTextField();
        j_salary.setBounds(600, 200, 150, 30);
        add(j_salary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        j_address = new JTextField();
        add(j_address);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        j_phone = new JTextField();
        add(j_phone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        j_email = new JTextField();
        add(j_email);
        
        JLabel l_education = new JLabel("Higest Education");
        l_education.setFont(new Font("serif", Font.PLAIN, 20));
        add(l_education);
        
        j_education = new JTextField();
        add(j_education);
        
        JLabel l_role = new JLabel("Designation");
        l_role.setFont(new Font("serif", Font.PLAIN, 20));
        add(l_role);
        
        j_role = new JTextField();
        add(j_role);
        
        JLabel l_govtID = new JLabel("Govt. ID");
        l_govtID.setFont(new Font("serif", Font.PLAIN, 20));
        add(l_govtID);
        
        JLabel govtID = new JLabel();
        add(govtID);
        
        JLabel l_empId = new JLabel("Employee ID");
        l_empId.setBounds(50, 400, 150, 30);
        l_empId.setFont(new Font("serif", Font.PLAIN, 20));
        add(l_empId);
        
        j_empId = new JLabel();
        j_empId.setFont(new Font("serif", Font.PLAIN, 20));
        add(j_empId);
        
        try {
            SQL_Conn c = new SQL_Conn();
            String query = "select * from employee_data where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                firstname.setText(rs.getString("firstname"));
                j_lastname.setText(rs.getString("lastname"));
                doj.setText(rs.getString("doj"));
                j_address.setText(rs.getString("address"));
                j_salary.setText(rs.getString("salary"));
                j_phone.setText(rs.getString("phone"));
                j_email.setText(rs.getString("email"));
                j_education.setText(rs.getString("education"));
                govtID.setText(rs.getString("govtId"));
                j_empId.setText(rs.getString("empId"));
                j_role.setText(rs.getString("jrole"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        heading.setBounds(320, 30, 500, 50);
        labelname.setBounds(50, 150, 150, 30);
        firstname.setBounds(200, 150, 150, 30);
        l_lastname.setBounds(400, 150, 150, 30);
        j_lastname.setBounds(600, 150, 150, 30);
        labeldob.setBounds(50, 200, 150, 30);
        labelsalary.setBounds(400, 200, 150, 30);
        doj.setBounds(200, 200, 150, 30);
        labeladdress.setBounds(50, 250, 150, 30);
        j_address.setBounds(200, 250, 150, 30);
        labelphone.setBounds(400, 250, 150, 30);
        j_phone.setBounds(600, 250, 150, 30);
        labelemail.setBounds(50, 300, 150, 30);
        j_email.setBounds(200, 300, 150, 30);
        l_education.setBounds(400, 300, 150, 30);
        j_education.setBounds(600, 300, 150, 30);
        l_role.setBounds(50, 350, 150, 30);
        j_role.setBounds(200, 350, 150, 30);
        l_govtID.setBounds(400, 350, 150, 30);
        govtID.setBounds(600, 350, 150, 30);
        j_empId.setBounds(200, 400, 150, 30);
        add.setBounds(250, 550, 150, 40);
        back.setBounds(450, 550, 150, 40);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String salary = j_salary.getText();
            String address = j_address.getText();
            String phone = j_phone.getText();
            String email = j_email.getText();
            String education = j_education.getText();
            String designation = j_role.getText();
            
            try {
                SQL_Conn c = new SQL_Conn();
                String query = "UPDATE employee_data SET salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email =  '"+email+"', education = '"+education+"', jrole = '"+designation+"' where empId = '"+empId+"'";
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
    public static void main(String args[]){
        new Update("");
    }
}
