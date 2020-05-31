
package user;


import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class UserLogin extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3;
    JButton btn1,btn2,btnSignup;
    JTextField txf1;
    JPasswordField pf1;
    JPanel p1,p2;
         
    public UserLogin(){
        super("User Login");
        //setUndecorated(true);
        /*
        //title bar image
        Image icon = Toolkit.getDefaultToolkit().getImage("poweredby.png");    
        setIconImage(icon);  
        */
        //getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());
      
        
        
        
        // adding username & password in Panel 1 ( p1 )
        l1 = new JLabel("RegNumber ");
        l1.setFont(new Font("Courier", Font.BOLD,16));
        txf1 = new JTextField(15);
        l2 = new JLabel("Password ");
        l2.setFont(new Font("Courier", Font.BOLD,16));
        pf1 = new JPasswordField(15);
        p1 = new JPanel();
        p1.add(l1);
        p1.add(txf1);
        p1.add(l2);
        p1.add(pf1);
        add(p1,BorderLayout.CENTER);
        
        // adding 2 button cancel & logIn
            
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("loginhub.png"));
        Image i1 = ic1.getImage().getScaledInstance(18, 18,Image.SCALE_DEFAULT);
        btn1 = new JButton("LogIn", new ImageIcon(i1));
        
        
        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("cancel.jpg"));
        Image i2 = ic2.getImage().getScaledInstance(18, 18,Image.SCALE_DEFAULT);
        btn2 = new JButton("Cancel",new ImageIcon(i2));
        
        ImageIcon icSignup = new ImageIcon(ClassLoader.getSystemResource("signup2.png"));
        Image iSignup = icSignup.getImage().getScaledInstance(18, 18,Image.SCALE_DEFAULT);
        btnSignup = new JButton("SignUp",new ImageIcon(iSignup));
        
      
        
        p2 = new JPanel();
        p2.add(btn1);
        p2.add(btn2);
        p2.add(btnSignup);
        add(p2,BorderLayout.SOUTH);
        
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btnSignup.addActionListener(this);
        
        
        //adding image with the help of label l3 (West Direction)
       
        ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("LoginPic.png"));
        Image i3 = ic3.getImage().getScaledInstance(200, 150,Image.SCALE_DEFAULT);
        l3 = new JLabel(new ImageIcon(i3));
        add(l3,BorderLayout.WEST);
        l3.setBackground(Color.red);
        
        setSize(420,250);
        setLocation(400,250);
        setResizable(false);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        
        String regNumber = txf1.getText();
        String password = pf1.getText();
       try
       {
           if(ae.getSource() == btn1)
           {
               Conne c1 = new Conne();
               String q = "select * from student where RegNumber = '" + regNumber+"' and Password = '"+password+"'";
               ResultSet rs = c1.s.executeQuery(q);
               if(rs.next())
               {
                   System.out.println("Successfull Login");
                   new UserWork(regNumber);
                   setVisible(false);
               }
               
               else
               {
                JOptionPane.showMessageDialog(null, "Invalid login !");
                //setVisible(false);   
               }
           }
           if(ae.getSource() == btn2)
           {
               System.exit(0);
           }
           if(ae.getSource() == btnSignup)
           {
               setVisible(false);
               System.out.println("Signup");
               new SignUp();
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
        new UserLogin();
    }
    
}

