/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuitionManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class RemoveStudent extends JFrame implements ActionListener{
    JButton b1,b2; //b1 for remove ,b2 for cancel
    JTextField t1; 
    JLabel l1,l2;
    
    public RemoveStudent()
    {
        super("Remove Student");
        setSize(420,250);
        setLocation(400,250);
         setVisible(true);
        
        setLayout(null);
        
        l1 = new JLabel("Registration Number");
        l1.setBounds(200, 10, 200, 50);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        add(l1);
        
        t1 = new JTextField(10);
        t1.setBounds(190, 70, 200, 30);
        add(t1);
        
        //delete1.png
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("delete1.png"));
        Image i = ic.getImage().getScaledInstance(200, 150,Image.SCALE_DEFAULT);
        l2 = new JLabel(new ImageIcon(i));
        l2.setBounds(10,10,150,150);
        add(l2);
        
        b1 = new JButton("Remove");
        b2 = new JButton("Cancel");
        b1.setBounds(180,150,100,30);
        add(b1);
        
        b2.setBounds(290,150,100,30);
        add(b2);
        
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setVisible(true);
        
        
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        
        String rgnumber = t1.getText();
       try
       {
           if(ae.getSource() == b1)
           {
               Conne c1 = new Conne();
               String q = "select * from student where RegNumber = '" + rgnumber+"'";
               ResultSet rs = c1.s.executeQuery(q);
               
               if(rs.next())
               {
                String qinsert = "insert into paststudent values('"+rs.getString("RegNumber")+"','"+rs.getString("Password")+"','"+rs.getString("Name")+"','"+rs.getString("Gender")+"','"+rs.getString("Address")+"','"+rs.getString("State")+"','"+rs.getString("City")+"','"+rs.getString("Email")+"','"+rs.getString("PhoneNo")+"','"+rs.getString("RegistrationTime")+"')";
                c1.s.executeUpdate(qinsert);
                
                String q1 = "delete from student where RegNumber = '" + rgnumber+"'";
                c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Student removed SuccessFully !");
                //setVisible(false);
               }
               else
               {
                JOptionPane.showMessageDialog(null, "NO Record Found of this Reg Number!");
               }
           }
           if(ae.getSource() == b2)
           {
               setVisible(false);
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
           System.out.println("Error: "+e);
       }
        
        
    }
    
    public static void main(String args[])
    {
        new RemoveStudent();
    }
}

