/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Adarsha186
 */
public class Read extends JFrame implements ActionListener{
    JTable tb;
    Choice ch;
    JButton search, print, update, back;
    
    Read() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel j1 = new JLabel("Search by Employee Id");
        
        add(j1);
        
        ch = new Choice();
        
        add(ch);
        
        try {
            SQL_Conn c = new SQL_Conn();
            ResultSet rs = c.s.executeQuery("select * from employee_data");
            while(rs.next()) {
                ch.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        tb = new JTable();
        
        try {
            SQL_Conn c = new SQL_Conn();
            ResultSet rs = c.s.executeQuery("select * from employee_data");
            tb.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jp = new JScrollPane(tb);        
        add(jp);
        
        search = new JButton("Search");        
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");

        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.addActionListener(this);
        add(back);
        
        j1.setBounds(20, 20, 150, 20);
        ch.setBounds(180, 20, 150, 20);
        jp.setBounds(0, 100, 900, 600);
        search.setBounds(20, 70, 80, 20);
        print.setBounds(120, 70, 80, 20);
        update.setBounds(220, 70, 80, 20);
        back.setBounds(320, 70, 80, 20);
        
        setSize(800, 700);
        setLocation(250, 150);
        setVisible(true);
    }
    public static void main(String args[]){
        new Read();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from employee_data where empId = '"+ch.getSelectedItem()+"'";
            try {
                SQL_Conn c = new SQL_Conn();
                ResultSet rs = c.s.executeQuery(query);
                tb.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                tb.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            setVisible(false);
            new Update(ch.getSelectedItem());
        } else {
            setVisible(false);
            new CRUD();
        }
    }
}
