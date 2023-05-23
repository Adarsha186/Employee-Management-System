/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;  
/**
 *
 * @author Adarsha186
 */

public class CRUD extends JFrame implements ActionListener{
    JButton create, read, update, delete;
    CRUD(){
        setLayout(null);
        setVisible(true);
        setSize(1200,600);
        setLocation(200,150);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/main_page.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(0,0, 1200, 600);
        add(image);
        
        create = new JButton("Add Employee");
        create.setBounds(400, 200, 150, 40);
        create.setFont(new Font("serif", Font.BOLD, 15));
        create.addActionListener(this);
        image.add(create);
        
        read = new JButton("View Employee");
        read.setBounds(600, 200, 150, 40);
        read.setFont(new Font("serif", Font.BOLD, 15));
        read.addActionListener(this);
        image.add(read);
        
        update = new JButton("Update Employee");
        update.setBounds(600, 300, 150, 40);
        update.setFont(new Font("serif", Font.BOLD, 15));
        update.addActionListener(this);
        image.add(update);
        
        delete = new JButton("Remove Employee");
        delete.setBounds(400, 300, 150, 40);
        delete.setFont(new Font("serif", Font.BOLD, 12));
        delete.addActionListener(this);
        image.add(delete);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create) {
            setVisible(false);
            new AddEmployee();
        } 
        else if (e.getSource() == read || e.getSource()==update) {
            setVisible(false);
            new Read();
        }
        else {
            setVisible(false);
            new RemoveEmployee();
        }
    }
    public static void main(String args[]){
        new CRUD();
    }
}
