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

public class StudentDetails extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1;
    String x[] = {"Sr.No","Reg Number","Password", "Name", "Gender", "Address", "State", "City", "Email", "PhoneNo","Reg Date & Time"};
    String y[][] = new String[100][11];
    int i=0,j =0;
    public StudentDetails(){
        super("Student Details");
        setSize(1200,650);
        setLocation(100,100);
        
        try{
            
            Conne c1 = new Conne();
            String q = "select * from student";
            ResultSet rs = c1.s.executeQuery(q);
            while(rs.next())
            {
                y[i][j++] = Integer.toString(i+1);
                y[i][j++] = rs.getString("RegNumber");
                y[i][j++] = rs.getString("Password");
                y[i][j++] = rs.getString("Name");
                y[i][j++] = rs.getString("Gender");
                y[i][j++] = rs.getString("Address");
                y[i][j++] = rs.getString("State");
                y[i][j++] = rs.getString("City");
                y[i][j++] = rs.getString("Email");
                y[i][j++] = rs.getString("PhoneNo");
                y[i][j++] = rs.getString("RegistrationTime");
                i++;
                j = 0;   
            }
            t1 = new JTable(y,x);    
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception:"+e);
        }
        
        b1 = new JButton("Print");
        add(b1,"South");
        
        
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
         
        b1.addActionListener(this);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{
            t1.print();
        }catch(Exception e){}
    }
    
    public static void main(String args[])        
    {
        new StudentDetails();
    }
    
}
