/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
/**
 *
 * @author Adarsha186
 */
public class AddEmployee extends JFrame implements ActionListener{
    Random rd = new Random();
    int id_generator = rd.nextInt(999);
    String[] degree = {"Masters Degree", "Associate Degree", "Bachelors Degree", "Doctoral Degree"};
    JTextField j_fname, j_lname, j_residence, j_contact, j_gid, j_email, j_salary, j_role;
    JDateChooser j_doj;
    JComboBox j_education;
    JLabel j_empId;
    JButton add, back;
    
    AddEmployee() {
        setSize(1000, 800);
        setLocation(200, 100);
        setVisible(true);
        setLayout(null);
        
        JLabel header = new JLabel("Add Employee Details");
        header.setFont(new Font("serif", Font.BOLD, 25));
        add(header);
        
        JLabel firstname = new JLabel("First Name");
        firstname.setFont(new Font("serif", Font.PLAIN, 20));
        add(firstname);
        
        j_fname = new JTextField();
        add(j_fname);
        
        JLabel lastname = new JLabel("Last Name");
        lastname.setFont(new Font("serif", Font.PLAIN, 20));
        add(lastname);
        
        j_lname = new JTextField();
        add(j_lname);
        
        JLabel doj = new JLabel("Date of Joining");
        doj.setFont(new Font("serif", Font.PLAIN, 20));
        add(doj);
        
        j_doj = new JDateChooser();
        add(j_doj);
        
        JLabel sal = new JLabel("Salary(per hr)");
        sal.setFont(new Font("serif", Font.PLAIN, 20));
        add(sal);
        
        j_salary = new JTextField();
        add(j_salary);
        
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("serif", Font.PLAIN, 20));
        add(address);
        
        j_residence = new JTextField();
        add(j_residence);
        
        JLabel phone = new JLabel("Phone");
        phone.setFont(new Font("serif", Font.PLAIN, 20));
        add(phone);
        
        j_contact = new JTextField();
        add(j_contact);
        
        JLabel email = new JLabel("Email");
        email.setFont(new Font("serif", Font.PLAIN, 20));
        add(email);
        
        j_email = new JTextField();
        add(j_email);
        
        JLabel edu = new JLabel("Education Level");
        edu.setFont(new Font("serif", Font.PLAIN, 20));
        add(edu);
        
        j_education = new JComboBox(degree);
        j_education.setBackground(Color.WHITE);
        add(j_education);
        
        JLabel role = new JLabel("Role");
        role.setFont(new Font("serif", Font.PLAIN, 20));
        add(role);
        
        j_role = new JTextField();
        add(j_role);
        
        JLabel g_id = new JLabel("Govt. ID");
        g_id.setFont(new Font("serif", Font.PLAIN, 20));
        add(g_id);
        
        j_gid = new JTextField();
        add(j_gid);
        
        JLabel empId = new JLabel("Employee id");
        empId.setFont(new Font("serif", Font.PLAIN, 20));
        add(empId);
        
        j_empId = new JLabel("" + id_generator); 
        j_empId.setFont(new Font("serif", Font.PLAIN, 20));
        add(j_empId);
        
        add = new JButton("Add Details");
        
        add.addActionListener(this);
        add.setBackground(Color.BLUE);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.addActionListener(this);
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        add(back);
        
        header.setBounds(320, 30, 500, 50);
        firstname.setBounds(50, 150, 150, 30);
        j_fname.setBounds(200, 150, 150, 30);
        lastname.setBounds(50, 150, 150, 30);
        j_lname.setBounds(600, 150, 150, 30);
        lastname.setBounds(400, 150, 150, 30);
        doj.setBounds(50, 200, 150, 30);
        j_doj.setBounds(200, 200, 150, 30);
        sal.setBounds(400, 200, 150, 30);
        j_salary.setBounds(600, 200, 150, 30);
        j_residence.setBounds(200, 250, 150, 30);
        phone.setBounds(400, 250, 150, 30);
        j_contact.setBounds(600, 250, 150, 30);
        email.setBounds(50, 300, 150, 30);
        j_email.setBounds(200, 300, 150, 30);
        edu.setBounds(400, 300, 150, 20);
        j_education.setBounds(600, 300, 150, 20);
        role.setBounds(50, 350, 150, 30);
        j_role.setBounds(200, 350, 150, 30);
        g_id.setBounds(400, 350, 150, 30);
        j_gid.setBounds(600, 350, 150, 30);
        empId.setBounds(50, 400, 150, 30);
        j_empId.setBounds(200, 400, 150, 30);
        add.setBounds(250, 550, 150, 40);
        back.setBounds(450, 550, 150, 40);
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    public static void main(String args[]){
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String first_name, last_name, doj, salary, address, phone, email, education, role, govtId, empId;
        if (ae.getSource() == add) {
            first_name = j_fname.getText();
            last_name = j_lname.getText();
            doj = ((JTextField) j_doj.getDateEditor().getUiComponent()).getText();
            salary = j_salary.getText();
            address = j_residence.getText();
            phone = j_contact.getText();
            email = j_email.getText();
            education = (String) j_education.getSelectedItem();
            role = j_role.getText();
            govtId = j_gid.getText();
            empId = j_empId.getText();
            
            try {
                SQL_Conn conn = new SQL_Conn();
                String query = "INSERT INTO employee_data VALUES('"+first_name+"', '"+last_name+"', '"+doj+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+role+"', '"+govtId+"', '"+empId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Success");
                setVisible(false);
                new CRUD();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new CRUD();
        }
    }
}
