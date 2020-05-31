package tuitionManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;



public class Start extends JFrame{
    JLabel l1,l2,l3,l4;
    JProgressBar b;
    public Start()
    {
        //super("Tuition Data Management by Dharmendra(18mcmc31)");
        setUndecorated(true);
        setVisible(true);
        setSize(500,300);
        setLocation(400,250);
        setLayout(null);
       
        
        
        //---------set Disk Image in label l1----------------------------------
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("disk.png"));
        Image i1 = ic1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        l1 = new JLabel(new ImageIcon(i1));
        
        l1.setBounds(180,10,100,100);  // location for Disk Image
        
        
        //------------------set text TuitionDatamanagement---------------------
        l2 = new JLabel("Coaching Class Management 1.0");
        l2.setBounds(90,100, 350,70); // position For Text "TuitionDataManagement"
        l2.setFont(new Font("Courier", Font.BOLD,22));
        /*
        ImageIcon ic2= new ImageIcon(ClassLoader.getSystemResource("poweredby.png"));
        Image i2 = ic2.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        l3 = new JLabel(new ImageIcon(i2));*/
       
        //------------------------Powered by Coder's Codline----------------------
        l3 = new JLabel("Powered by Coder's Codline");
        l3.setBounds(130,140, 300,70); // position For Text 
        l3.setFont(new Font("Courier", Font.BOLD,14));
        
        // adding a progress bar -------------------------------------------
       
        b = new JProgressBar(); 
        // set initial value 
        b.setValue(0);
        b.setBounds(50, 200, 370, 15);
        b.setStringPainted(true);  // percentage
       
        //for Loading Message
        l4 = new JLabel("Loading....Please Wait");
        l4.setBounds(170,210,150,30);
        
        
        add(b); // add progress bar to panel
        add(l1); 
        add(l2);
        add(l3);
        add(l4);
        
        getContentPane().setBackground(Color.LIGHT_GRAY ); //Frame Color
        
        //Thread t1 = new Thread(this);
        //t1.start();
        /*---------------------Progress BAr---------------------------*/
        int i = 0; 
        try 
        { 
            while (i <= 100)
            { 
                // fill the menu bar 
                b.setValue(i + 10); 
                // delay the thread 
                Thread.sleep(1500); 
                i += 20; 
            } 
        } 
        catch (Exception e)
        {} 
        setVisible(false);
    }
    public static void prog()
    {
        
    }
    public static void main(String args[])
    {
        new Start();
        new Login();    
    }
}
