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

public class PaymentDetails extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1;
    String x[] = {"Sr.No","DateAndTime","Reg Number","TransactionID","TransactionAmount"};
    String y[][] = new String[100][5];
    int i=0,j =0;
    public PaymentDetails()
    {
        super("Payment By Students ");
        setSize(1200,650);
        setLocation(100,100);
        
        try{
            
            Conne c1 = new Conne();
            String q = "select * from payment";
            ResultSet rs = c1.s.executeQuery(q);
            while(rs.next())
            {
                y[i][j++] = Integer.toString(i+1);
                y[i][j++] = rs.getString("DateAndTime");
                y[i][j++] = rs.getString("RegNumber");
              
                y[i][j++] = rs.getString("TransactionID");
                y[i][j++] = rs.getString("TransactionAmount");
                i++;
                j = 0;   
            }
            t1 = new JTable(y,x);    
            t1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            t1.getColumnModel().getColumn(0).setPreferredWidth(40);
            t1.getColumnModel().getColumn(1).setPreferredWidth(250);
            t1.getColumnModel().getColumn(2).setPreferredWidth(250);
            t1.getColumnModel().getColumn(3).setPreferredWidth(300);
            t1.getColumnModel().getColumn(4).setPreferredWidth(300);
            
            
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
        new PaymentDetails();
    }
    
}
