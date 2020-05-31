
package user;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  

public class SignUp extends JFrame implements ActionListener{
    
    JLabel lname,lreg,lgender,ladd,lcity,lemail,lstate,lphone,lpic,lpass;
    JButton btnSubmit,btnCancel;
    Choice c1,c2;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JPasswordField pf;
    
    
    public SignUp()
    {
        super("SignUp");
        //setUndecorated(true);
        setLocation(350,180);
        setSize(650,390);
        
        
        // creatig a panel for arranging some components
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(10,2,10,10));//Panel Layout
        
        p.setBackground(Color.WHITE);
        
        lname = new JLabel("Name");
        t1 = new JTextField();
        p.add(lname);
        p.add(t1);
        
        lreg = new JLabel("Reg.Number");
        t2 = new JTextField();
        p.add(lreg);
        p.add(t2);
        
        
        lgender = new JLabel("Gender");
        c1 = new Choice();
        c1.add("male");
        c1.add("female");
        c1.add("other");
        p.add(lgender);
        p.add(c1);
        
        ladd = new JLabel("Address");
        t3 = new JTextField();
        p.add(ladd);
        p.add(t3);
        
        lstate = new JLabel("State");
        t4 = new JTextField();
        p.add(lstate);
        p.add(t4);
        
        lcity = new JLabel("City");
        t5 = new JTextField();
        p.add(lcity);
        p.add(t5);
        
        
        lemail = new JLabel("Email");
        t6 = new JTextField();
        p.add(lemail);
        p.add(t6);
        
        lphone = new JLabel("Phone Number");
        t7 = new JTextField();
        p.add(lphone);
        p.add(t7);
        
        
        lpass = new JLabel("Set Password");
        pf = new JPasswordField();
        p.add(lpass);
        p.add(pf);
        
        btnSubmit = new JButton("Submit");
        btnCancel = new JButton("Cancel");
        
        btnSubmit.setBackground(Color.BLACK);
        btnSubmit.setForeground(Color.WHITE);
        
        btnCancel.setBackground(Color.BLACK);
        btnCancel.setForeground(Color.WHITE);
        
        p.add(btnSubmit);
        p.add(btnCancel);
        
        //Frame Layout
        setLayout(new BorderLayout());
        
        add(p,"Center");
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("signup1.jpg"));
        Image i3 = ic1.getImage().getScaledInstance(150, 300,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        lpic= new JLabel(ic2);
        
        
        add(lpic,"West");
        
        
        btnSubmit.addActionListener(this);
        btnCancel.addActionListener(this);
        //for changing the color of the whole 
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == btnSubmit)
        {
            String stdname = null;
            String ph = null;
            int validname = 1;
            try
            {
                try
                {
                    stdname = t1.getText();//name
                    char s[] = stdname.toCharArray();


	            for(int i = 0; i < stdname.length(); i++)
	            {
	  	        if(Character.isDigit(s[i]))
	  	 	   validname = 0;
	            }
                }
                catch(Exception e1)
                {
                    JOptionPane.showMessageDialog(null,"Name not valid!");
                }
                
                String rn = t2.getText();//reg  no
                String add = t3.getText();//address
                String state = t4.getText();//state
                String city = t5.getText();//city
                String email = t6.getText();//email
                String pass = pf.getText();
                
                int validphone1 = 0;
                int validphone2 = 1;
                try
                {
                     ph = t7.getText();//name
                     validphone1 = ph.length();
                }
                catch(Exception e2)
                {
                    JOptionPane.showMessageDialog(null,e2.getMessage());
                }
                char phn[] = ph.toCharArray();
                for(int i = 0; i < ph.length();i++)
                { 
                    if(Character.isLetter(phn[i]))
                    {validphone2 = 0;}
                }
                if(validname == 0)
                    JOptionPane.showMessageDialog(null,"Name must be written in character only !"); 
                if(validphone2 == 0)
                    JOptionPane.showMessageDialog(null,"Mobile Number Should contains only digit !"); 
                if(validphone1 != 10)
                    JOptionPane.showMessageDialog(null,"Mobile Number Should be a 10 digit only !"); 
                
                if(validphone1 == 10 && validname == 1 && validphone2 == 1)
                {
                    
                    /*------------Generate Current System Date-------------*/
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String currentdate = dtf.format(now).toString(); //generate ragistration time
                    /*------------get Choice value(male,female,other)------------------------*/
                    String gen = c1.getSelectedItem();

                    /*---------------------insert into student table(Registration of student)----------------------------*/

                    Conne c = new Conne();
                    String q = "insert into student values('"+rn+"','"+pass+"','"+stdname+"','"+gen+"','"+add+"','"+state+"','"+city+"','"+email+"','"+ph+"','"+currentdate+"')";
                    /*
                    INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY)
                     VALUES ('1', 'Rames
                    h', '32', 'Ahmedabad', '2000.00' );
                    */

                    c.s.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Student Ragistered Successfully !");
                    JOptionPane.showMessageDialog(null,"Please note RegNumber for future verification !");
                    setVisible(false);
                    new UserLogin();
                }
                
            }
            catch(Exception e)
            {
                //System.out.println("Exception : "+e.getMessage());
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
           
        }
        if(ae.getSource() == btnCancel)
        {
            setVisible(false);
            new UserLogin();
        }
        
    }
    
    public static void main(String args[])
    {
        new SignUp();
    }
}
