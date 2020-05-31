
package user;



import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserWork extends JFrame implements ActionListener {
    String rg;
    JButton home,notification,payment,profile,update,query,exit;
    /*--------------Home Button Component As well as Frme will show picture bydefault*/
    JLabel lpic;
    JPanel panelHome;
    
    /*-------Payment Button component------*/
    JPanel panelPay;
    JLabel labelPic,ltId,lta;
    JTextField tidField,tamount;
    JButton submit;
    
    /*------Profile Button component-------------*/
    JLabel lname ,lreg,lgender,ladd,lcity,lemail,lstate,lphone;
    JPanel panelProfile;
    
    /*------update Button Panel-------------------*/
    JLabel l1,msgLabel;
    JPasswordField reenterPassword,newPassword;
    JButton bok,changeName,changePass,changeGender,changeAdd,changeState,changeCity,changeEmail,changePhone;
    Choice c1,c2;
    JPanel panelUpdate,condionalPanel,panelName,panelPass,panelGender,panelAdd,panelState,panelCity,panelEmail,panelPhone;
    JLabel labelName,labelreenterPassword,labelnewPassword,labelGender,labelAdd,labelState,labelCity,labelEmail,labelPhone;
    JTextField any,Name,Gender,Add,State,City,Email,Phone ;
    
    /*--------Notification------------------------*/
    JLabel notice;
    JPanel panelNotification;
    
    /*--------Query --------------------------------*/
            
   JTextArea textArea;
   JButton submitQuery,getAnswer;
   JPanel panelQuery;
   JLabel  labelQuery;
   
    public UserWork(String regNumber)
    {
        super(regNumber);
        rg = regNumber;
        
        //Icon
        
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dharmendra\\Documents\\NetBeansProjects\\UserPointOfView(TuitionDataManagement)\\src\\disk2.png");    
        setIconImage(icon);    
        
        setLayout(null);
        getContentPane().setBackground(Color.orange);
        /*
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("tree.jpg"));
        Image im = ic.getImage().getScaledInstance(970, 750, Image.SCALE_DEFAULT);
        lpic  = new JLabel(new ImageIcon(im));
        lpic.setBounds(0,50,970,750);
        */
        home  = new JButton("Home");
        profile = new JButton("Profile");
        update = new JButton("Update");
        notification = new JButton("Notification");
        payment = new JButton("Payment");
        query =  new JButton("Query");
        exit = new JButton("Exit");
        
        /*------------Buttons Coading in Frame---------------------------*/
        home.setBounds(0,0,140,50);
        profile.setBounds(140,0,140,50);
        update.setBounds(280,0,140,50);
        notification.setBounds(420,0,140,50);
        payment.setBounds(560,0,140,50);
        query.setBounds(700,0,140,50);
        exit.setBounds(840, 0, 140, 50);
       
        //add(lpic);
        add(home);
        add(profile);
        add(update);
        add(notification);
        add(payment);
        add(query);
        add(exit);
       
        home.addActionListener(this);
        profile.addActionListener(this);
        update.addActionListener(this);
        notification.addActionListener(this);
        payment.addActionListener(this);
        query.addActionListener(this);
        exit.addActionListener(this);
        
        /*------------------------------------------------------------------*/
        
        
        
        /*-------------------"Home Panel" as well as By defult shows picture*/
        
        panelHome = new JPanel();
        panelHome.setLayout(null);
        panelHome.setBounds(0,50,970,750);
                          
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("tree.jpg"));
        Image im = ic.getImage().getScaledInstance(970, 750, Image.SCALE_DEFAULT);
        lpic  = new JLabel(new ImageIcon(im));
        lpic.setBounds(0,0,970,750);
        
        panelHome.add(lpic);
        
        add(panelHome);
        //panelHome.setVisible(true);
        /* ------------------End Home Coading-----------------------------*/
        
        
        
        
        /*-------------------profile panel-----------------------*/
        
        try
        {
                         
                          panelProfile= new JPanel();
                          panelProfile.setLayout(null);
                          panelProfile.setBounds(0,50,970,750);
                          
                          String q  = "select * from student where RegNumber = '"+rg+"';";
                          Conne c1 = new Conne();
                          ResultSet rs = c1.s.executeQuery(q);
                          
                          if(rs.next())
                          {
                              lreg = new JLabel("RegNo :        ".concat(rs.getString("RegNumber")));
                              lname = new JLabel("Name :        ".concat(rs.getString("Name")));
                              lgender = new JLabel("Gender :    ".concat(rs.getString("Gender")));
                              ladd = new JLabel("Address :      ".concat(rs.getString("Address")));
                              lstate = new JLabel("State :      ".concat(rs.getString("State")));
                              lcity = new JLabel("City :        ".concat(rs.getString("City")));
                              lemail = new JLabel("Email :      ".concat(rs.getString("Email")));
                              lphone = new JLabel("Phone No. :  ".concat(rs.getString("PhoneNo")));
                           
                          }
                          lreg.setBounds(350, 150, 350, 50);
                          lname.setBounds(350, 110, 350, 50);
                          lgender.setBounds(350, 190, 350, 50);
                          ladd.setBounds(350, 230, 350, 50);
                          lstate.setBounds(350, 290, 350, 50);
                          lcity.setBounds(350, 350, 350, 50);
                          lemail.setBounds(350, 410, 350, 50);
                          lphone.setBounds(350, 470, 350, 50);
                          
                          
                          lreg.setFont(new Font("Courier", Font.BOLD,18));
                          lname.setFont(new Font("Courier", Font.BOLD,18));
                          lgender.setFont(new Font("Courier", Font.BOLD,18));
                          ladd.setFont(new Font("Courier", Font.BOLD,18));
                          lstate.setFont(new Font("Courier", Font.BOLD,18));
                          lcity.setFont(new Font("Courier", Font.BOLD,18));
                          lemail.setFont(new Font("Courier", Font.BOLD,18));
                          lphone.setFont(new Font("Courier", Font.BOLD,18));
                          
                        
                          panelProfile.add(lreg);
                          panelProfile.add(lname);
                          panelProfile.add(lgender);
                          panelProfile.add(ladd);
                          panelProfile.add(lstate);
                          panelProfile.add(lcity);
                          panelProfile.add(lemail);
                          panelProfile.add(lphone);
                          
                          add(panelProfile);
                          
                                     
        }
        catch(Exception e1)
        {
                         System.out.println("Profile:Error:"+e1);
        }
        
        /*-------------------end Profile panel-------------------*/
       
        
        /*-------------------update panel-----------------------*/
        
          
                     panelUpdate = new JPanel();
                     panelUpdate.setLayout(null);
                     panelUpdate.setBounds(0,50,970,750);
          
                     l1 = new JLabel("I want to change my");
                     l1.setFont(new Font("Courier", Font.BOLD,16));
                     l1.setBounds(150,200,250,50);
                     panelUpdate.add(l1);
                     
                     c1 = new Choice();
                     c1.add("none");
                     c1.add("Name");
                     c1.add("Password");
                     c1.add("Gender");
                     c1.add("Address");
                     c1.add("State");
                     c1.add("City");
                     c1.add("Email");
                     c1.add("Phone Number");
                     c1.setBounds(400, 220, 150, 60);
                     panelUpdate.add(c1);
                     
                     bok = new JButton("Select");
                     bok.setBounds(580,220,80,30);
                     panelUpdate.add(bok);                
                     add(panelUpdate);
                    panelUpdate.setVisible(false); 
                     
                     
                     
                    //password panel-------------------------------------------  
                    panelPass = new JPanel();
                    panelPass.setLayout(new GridLayout(2,3,10,10));
                    labelnewPassword = new JLabel("Enter New Password ");
                    labelreenterPassword = new JLabel("Re-Enter Password ");             
                   
                    newPassword = new JPasswordField();
                    reenterPassword = new JPasswordField();
                    changePass = new JButton(" Change ");
                     panelPass.setBounds(150,300,550,70);
                        //labelnewPassword.setBounds(100,0,250,40);
                        //newPassword.setBounds(300,0,250,40);
                        //labelreenterPassword.setBounds(100,60,250,40);
                        //reenterPassword.setBounds(300,60,250,40);
                        //changePass.setBounds(580,50,100,50);
                    panelPass.add(labelnewPassword);
                    panelPass.add(newPassword);
                    panelPass.add(changePass);
                    panelPass.add(labelreenterPassword);
                    panelPass.add(reenterPassword);
                      
                    panelUpdate.add(panelPass);
                    panelPass.setVisible(false);
                    
                    //Name Panel----------------------------------
                    
                    panelName = new JPanel();
                    panelName.setLayout(new GridLayout(1,3,10,10));
                    labelName= new JLabel("Enter New Name");
                    Name = new JTextField();
                    changeName = new JButton(" Confirm ");
                     
                        
                   panelName.setBounds(150,300,550,50);
                   //labelName.setBounds(0,300,200,40);
                   //Name.setBounds(250,300,200,40);
                   //changeName.setBounds(500,300,200,40);
                        
                    panelName.add(labelName);
                    panelName.add(Name);
                    panelName.add(changeName);
                        
                    panelUpdate.add(panelName);
                    panelName.setVisible(false);
                    
                    //panel-Gender--------------------------------------
                    panelGender = new JPanel();
                    panelGender.setLayout(new GridLayout(1,3,10,10));
                    labelGender = new JLabel(" choose ");
                    c2 = new Choice();
                    c2.add("male");
                    c2.add("female");
                    c2.add("other");
                    changeGender = new JButton(" Change ");
                    panelGender.setBounds(150,300,550,50);
                    //labelGender.setBounds(0,300,150,40);
                    //c2.setBounds(200,0,150,40);
                    //changeGender.setBounds(400,0,150,40);
                    panelGender.add(labelGender);
                    panelGender.add(c2);
                    panelGender.add(changeGender);
                    panelUpdate.add(panelGender);
                    panelGender.setVisible(false);
                    
                    //panel-Address
                    panelAdd = new JPanel();
                     panelAdd.setLayout(new GridLayout(1,3,10,10));
                    labelAdd= new JLabel("Enter New Address ");
                    Add = new JTextField();
                    changeAdd = new JButton(" Confirm ");
                    panelAdd.setBounds(150,300,550,50);
                    //labelAdd.setBounds(0,300,150,40);
                    //Add.setBounds(200,0,150,40);
                    //changeAdd.setBounds(400,0,150,40);
                    panelAdd.add(labelAdd);
                    panelAdd.add(Add);
                    panelAdd.add(changeAdd);
                    panelUpdate.add(panelAdd);
                    panelAdd.setVisible(false);
                    
                    //panel-State
                    panelState = new JPanel();
                     panelState.setLayout(new GridLayout(1,3,10,10));
                    labelState= new JLabel("Enter New State Name ");
                    State = new JTextField();
                    changeState = new JButton(" Confirm ");
                    panelState.setBounds(150,300,550,50);
                    //labelState.setBounds(0,300,150,40);
                    //State.setBounds(200,0,150,40);
                    //changeState.setBounds(400,0,150,40);       
                    panelState.add(labelState);
                    panelState.add(State);
                    panelState.add(changeState);
                    panelUpdate.add(panelState);
                    panelState.setVisible(false);
                    
                    
                    //panel- City
                    panelCity = new JPanel();
                    panelCity.setLayout(new GridLayout(1,3,10,10));
                    labelCity= new JLabel("Enter New City Name ");
                    City = new JTextField();
                    changeCity = new JButton(" Confirm ");
                    panelCity.setBounds(150,300,550,50);
                    //labelCity.setBounds(0,300,150,40);
                    //City.setBounds(200,0,150,40);
                    //changeCity.setBounds(400,0,150,40);       
                    panelCity.add(labelCity);
                    panelCity.add(City);
                    panelCity.add(changeCity);
                    panelUpdate.add(panelCity);
                    panelCity.setVisible(false);
                    
                    
                    //panel- email
                    panelEmail = new JPanel();
                    panelEmail.setLayout(new GridLayout(1,3,10,10));
                    labelEmail= new JLabel("Enter New EMail ");
                    Email = new JTextField();
                    changeEmail = new JButton(" Confirm ");
                    panelEmail.setBounds(150,300,550,50);
                    //labelEmail.setBounds(0,300,150,40);
                    //Email.setBounds(200,0,150,40);
                    //changeEmail.setBounds(400,0,150,40);       
                    panelEmail.add(labelEmail);
                    panelEmail.add(Email);
                    panelEmail.add(changeEmail);
                    panelUpdate.add(panelEmail);
                    panelEmail.setVisible(false);
                    
                    //panel -phone
                    panelPhone = new JPanel();
                     panelPhone.setLayout(new GridLayout(1,3,10,10));
                    labelPhone= new JLabel("Enter New Phone No ");
                    Phone = new JTextField();
                    changePhone = new JButton("Confirm");
                    panelPhone.setBounds(150,300,550,50);
                    //labelPhone.setBounds(0,300,150,40);
                    //Phone.setBounds(200,0,150,40);
                    //changePhone.setBounds(400,0,150,40);       
                    panelPhone.add(labelPhone);
                    panelPhone.add(Phone);
                    panelPhone.add(changePhone);
                    panelUpdate.add(panelPhone);
                    panelPhone.setVisible(false);
                    
                    changeName.addActionListener(this);
                    changePass.addActionListener(this);
                    changeGender.addActionListener(this);
                    changeAdd.addActionListener(this);
                    changeState.addActionListener(this);
                    changeCity.addActionListener(this);
                    changeEmail.addActionListener(this);
                    changePhone.addActionListener(this);
                    
                    
        /*-------------------end update panel-------------------*/
        
        bok.addActionListener(this);
        
        
        /*-------------------Notification panel-----------------------*/
                     
        panelNotification = new JPanel();
        panelNotification.setLayout(null);
        panelNotification.setBounds(0, 50, 970, 750);
        String receiveInfo;
        Conne c1 = new Conne();
        String q1 = "select * from notification;";
       try {
            ResultSet rs = c1.s.executeQuery(q1);
            int i = 0;
            while(rs.next())
            {
                notice = new JLabel(rs.getString("notify"));
                notice.setBounds(50+i, 50, 900, 50);
                notice.setFont(new Font("Courier", Font.BOLD,18));
                i= i+ 50;
            }
            /*-------------------End Notification panel--------------------*/
        } catch (SQLException ex) {
            System.out.println("Error from notification panel: "+ex);
        }
        panelNotification.add(notice);
        add(panelNotification);
        
        
        
        
        
        
        
        /*-------------------payment panel----------------------------------*/
        panelPay = new JPanel();
        panelPay.setLayout(null);
        panelPay.setBounds(0,50,970,750);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("myQrCode.jpeg"));
        Image i = ii1.getImage().getScaledInstance(300, 450, Image.SCALE_DEFAULT);
        labelPic = new JLabel(new ImageIcon(i));
        labelPic.setBounds(300, 5, 300,450);

        ltId = new JLabel("Transaction ID ");
        tidField = new JTextField();
        lta = new JLabel("Transaction Amount");
        tamount = new JTextField();
        submit = new JButton("Submit");

        ltId.setBounds(200,500,200,50);
        tidField.setBounds(350,500,250,40);
        lta.setBounds(200,560,250,50);
        tamount.setBounds(350,560,250,40);
        submit.setBounds(650,530,80,40);
        
        submit.addActionListener(this);
        
        panelPay.add(labelPic);
        panelPay.add(ltId);
        panelPay.add(tidField);
        panelPay.add(lta);
        panelPay.add(tamount);
        panelPay.add(submit);

        add(panelPay);
        panelPay.setVisible(false);
        /*------------------End Payment Panel---------------------------------*/
        
        /*-------------------Query---------------------------------*/
        panelQuery = new JPanel();
        panelQuery.setLayout(null);
        panelQuery.setBounds(0,50,970,750);
        labelQuery = new JLabel("Enter your Query or Question( max upto 300 Words ) ");
        textArea = new JTextArea(5, 20);
        submitQuery = new JButton("Submit");
        getAnswer = new JButton("Get Recent Answer");
        labelQuery.setBounds(330,10,300,50);
        textArea.setBounds(150,50,600,250);
        submitQuery.setBounds(400,570,100,40);
        getAnswer.setBounds(550,570,150,40);
        panelQuery.add(labelQuery);
        panelQuery.add(textArea);
        panelQuery.add(submitQuery);
        panelQuery.add(getAnswer);
        //JScrollPane sp = new JScrollPane(textArea);
        //panelQuery.add(sp);
        add(panelQuery);
        panelQuery.setVisible(false);
        
        submitQuery.addActionListener(this);
        getAnswer.addActionListener(this);
        /*-------------------------------------------------------------------*/
        setSize(970,750);
        setLocation(200,0);
        setResizable(false);
        setVisible(true);
        
    
    }
    public void actionPerformed(ActionEvent e)
    {
        
        try{
                if(e.getSource() == exit)
                {
                    try{
                        System.exit(0);
                    }
                    catch(Exception ex)
                    {
                        System.out.println("Error:"+ex);
                    }
                }
                
                if(e.getSource() == home)
                {
                     home.setBackground(Color.LIGHT_GRAY);
                     home.setForeground(Color.BLACK);
                     setVisible(false);
                     new UserWork(rg);
                     panelHome.setVisible(true);
                     panelNotification.setVisible(false);
                     panelProfile.setVisible(false);
                     panelPay.setVisible(false);
                     panelUpdate.setVisible(false);
                     panelQuery.setVisible(false);
                }
                
                if(e.getSource() == profile)
                {
                     panelPay.setVisible(false);
                    
                     profile.setBackground(Color.LIGHT_GRAY);
                     profile.setForeground(Color.BLACK);
                     
                     panelProfile.setVisible(true);
                     panelNotification.setVisible(false);
                     panelHome.setVisible(false);
                     panelPay.setVisible(false);
                     panelUpdate.setVisible(false);
                     panelQuery.setVisible(false);
                     
          
                }
                if(e.getSource() == update)
                {
                   
                    update.setBackground(Color.LIGHT_GRAY);
                    update.setForeground(Color.BLACK);
                    
                     panelUpdate.setVisible(true);
                    panelNotification.setVisible(false);
                      panelProfile.setVisible(false);
                     panelHome.setVisible(false);
                     panelPay.setVisible(false);
                     panelQuery.setVisible(false);
                     
                }
                if(e.getSource() == notification)
                {
                     notification.setBackground(Color.LIGHT_GRAY);
                     notification.setForeground(Color.BLACK);
                     //lpic.setVisible(false);
                     
                     
                    
                     panelNotification.setVisible(true);
                     panelUpdate.setVisible(false);
                     panelProfile.setVisible(false);
                     panelHome.setVisible(false);
                     panelPay.setVisible(false);
                     panelQuery.setVisible(false);
                     
                     
                }
                if(e.getSource() == payment)
                {
                     payment.setBackground(Color.LIGHT_GRAY);
                     payment.setForeground(Color.BLACK);
                  
                    panelUpdate.setVisible(false);
                    panelProfile.setVisible(false);
                    panelHome.setVisible(false);
                    panelNotification.setVisible(false);
                    panelPay.setVisible(true);
                    panelQuery.setVisible(false);
                     
                }
                 //payment submit
                if(e.getSource() == submit)
                {
                    try{
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String currentdate = dtf.format(now).toString();
                    Conne c = new Conne();
                    String q = "insert into payment values('"+currentdate+"','"+rg+"','"+tidField.getText()+"','"+tamount.getText()+"')";
                    c.s.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"We have Received your request ! !");
                    }
                    catch(Exception ep)
                    {
                        System.out.println("payment submit button: "+ep.getMessage());
                    }
                }
                if(e.getSource() == query)
                {
                     //new Quiz(rg);
                     query.setBackground(Color.LIGHT_GRAY);
                     query.setForeground(Color.BLACK);
                     panelQuery.setVisible(true);
                     panelNotification.setVisible(false);
                     panelUpdate.setVisible(false);
                     panelProfile.setVisible(false);
                     panelHome.setVisible(false);
                     panelPay.setVisible(false);
                }
                
               
                
                // update -- select button
                if(e.getSource() == bok)
                {
                    if(c1.getSelectedItem() == "Name") 
                    {
                        panelName.setVisible(true);
                        panelPass.setVisible(false);
                        panelGender.setVisible(false);
                        panelAdd.setVisible(false);
                        panelState.setVisible(false);
                        panelCity.setVisible(false);
                        panelEmail.setVisible(false);
                        panelPhone.setVisible(false);
                    }
                    
                    if(c1.getSelectedItem() == "Password") 
                    {
                         
                        panelName.setVisible(false);
                        panelPass.setVisible(true);
                        panelGender.setVisible(false);
                        panelAdd.setVisible(false);
                        panelState.setVisible(false);
                        panelCity.setVisible(false);
                        panelEmail.setVisible(false);
                        panelPhone.setVisible(false);
                    }
                    if(c1.getSelectedItem() == "Gender") 
                    {
                         panelName.setVisible(false);
                        panelPass.setVisible(false);
                        panelGender.setVisible(true);
                        panelAdd.setVisible(false);
                        panelState.setVisible(false);
                        panelCity.setVisible(false);
                        panelEmail.setVisible(false);
                        panelPhone.setVisible(false);
                    }
                    if(c1.getSelectedItem() == "Address") 
                    {
                        panelName.setVisible(false);
                        panelPass.setVisible(false);
                        panelGender.setVisible(false);
                        panelAdd.setVisible(true);
                        panelState.setVisible(false);
                        panelCity.setVisible(false);
                        panelEmail.setVisible(false);
                        panelPhone.setVisible(false);
                    }
                    if(c1.getSelectedItem() == "State") 
                    {
                         panelName.setVisible(false);
                        panelPass.setVisible(false);
                        panelGender.setVisible(false);
                        panelAdd.setVisible(false);
                        panelState.setVisible(true);
                        panelCity.setVisible(false);
                        panelEmail.setVisible(false);
                        panelPhone.setVisible(false);
                    }
                    if(c1.getSelectedItem() == "City") 
                    {
                         panelName.setVisible(false);
                        panelPass.setVisible(false);
                        panelGender.setVisible(false);
                        panelAdd.setVisible(false);
                        panelState.setVisible(false);
                        panelCity.setVisible(true);
                        panelEmail.setVisible(false);
                        panelPhone.setVisible(false);
                    }
                     if(c1.getSelectedItem() == "Email") 
                    {
                         panelName.setVisible(false);
                        panelPass.setVisible(false);
                        panelGender.setVisible(false);
                        panelAdd.setVisible(false);
                        panelState.setVisible(false);
                        panelCity.setVisible(false);
                        panelEmail.setVisible(true);
                        panelPhone.setVisible(false);
                    }
                     if(c1.getSelectedItem() == "Phone Number") 
                    {
                         panelName.setVisible(false);
                        panelPass.setVisible(false);
                        panelGender.setVisible(false);
                        panelAdd.setVisible(false);
                        panelState.setVisible(false);
                        panelCity.setVisible(false);
                        panelEmail.setVisible(false);
                        panelPhone.setVisible(true);
                    }
                }
                if(e.getSource() == changeName)
                {
                    try{
                    Conne c = new Conne();
                    String q = "UPDATE student SET Name = '"+ Name.getText()+"'WHERE RegNumber ='"+ rg +"'";
                    c.s.executeUpdate(q);
                    }
                    catch(Exception ez)
                    {
                        System.out.println("Change Name Error : "+ez.getMessage());
                    }
                    JOptionPane.showMessageDialog(null,"Name Successfully Updated !");
                    panelName.setVisible(false);
                }
                
                if(e.getSource() == changePass)
                {
                    String k = newPassword.getText();
                    if(k.equals(reenterPassword.getText()))
                    {
                        try{
                           Conne c = new Conne();
                           String q = "UPDATE student SET Password = '"+ k +"'WHERE RegNumber ='"+ rg +"'";
                           c.s.executeUpdate(q);
                        }
                        catch(Exception ez1)
                        {
                           System.out.println("Change Name Error : "+ez1.getMessage());
                        }
                        JOptionPane.showMessageDialog(null,"Password Successfully Updated !");
                        panelPass.setVisible(false);
                
                    }
                    else
                    {
                       JOptionPane.showMessageDialog(null,"Given Password Doesn't match with each other !");
                    }
                }
                
                if(e.getSource() == changeGender)
                {
                    String gen = c2.getSelectedItem();
                    System.out.println(gen);
                    try{
                    Conne c = new Conne();
                    String q = "UPDATE student SET Gender = '"+ gen +"'WHERE RegNumber ='"+ rg +"'";
                    c.s.executeUpdate(q);
                    }
                    catch(Exception ez)
                    {
                        System.out.println("Change Gender Error: "+ez.getMessage());
                    }
                    JOptionPane.showMessageDialog(null,"Gender Info. Successfully Updated !");
                    panelGender.setVisible(false);
                }
                if(e.getSource() == changeAdd)
                {
                    try{
                    Conne c = new Conne();
                    String q = "UPDATE student SET Address = '"+ Add.getText()+"'WHERE RegNumber ='"+ rg +"'";
                    c.s.executeUpdate(q);
                    }
                    catch(Exception ez)
                    {
                        System.out.println("Change Address Error : "+ez.getMessage());
                    }
                    JOptionPane.showMessageDialog(null,"Address Successfully Updated !");
                    panelAdd.setVisible(false);
                }
                if(e.getSource() == changeState)
                {
                    try{
                    Conne c = new Conne();
                    String q = "UPDATE student SET State = '"+ State.getText()+"'WHERE RegNumber ='"+ rg +"'";
                    c.s.executeUpdate(q);
                    }
                    catch(Exception ez)
                    {
                        System.out.println("Change State Error : "+ez.getMessage());
                    }
                    JOptionPane.showMessageDialog(null,"State Name Successfully Updated !");
                    panelState.setVisible(false);
                }
                
                if(e.getSource() == changeCity)
                {
                    try{
                    Conne c = new Conne();
                    String q = "UPDATE student SET City = '"+ City.getText()+"'WHERE RegNumber ='"+ rg +"'";
                    c.s.executeUpdate(q);
                    }
                    catch(Exception ez)
                    {
                        System.out.println("Change City Error : "+ez.getMessage());
                    }
                    JOptionPane.showMessageDialog(null,"City Name Successfully Updated !");
                    panelCity.setVisible(false);
                }
                
                if(e.getSource() == changeEmail)
                {
                    try{
                    Conne c = new Conne();
                    String q = "UPDATE student SET  Email= '"+ Email.getText()+"'WHERE RegNumber ='"+ rg +"'";
                    c.s.executeUpdate(q);
                    }
                    catch(Exception ez)
                    {
                        System.out.println("Change Email Error : "+ez.getMessage());
                    }
                    JOptionPane.showMessageDialog(null,"Email Successfully Updated !");
                    panelEmail.setVisible(false);
                }
                
                if(e.getSource() == changePhone)
                {
                    int len = Phone.getText().length();
                    if(len == 10)
                    {
                    try{
                    Conne c = new Conne();
                    String q = "UPDATE student SET PhoneNo = '"+ Phone.getText()+"'WHERE RegNumber ='"+ rg +"'";
                    c.s.executeUpdate(q);
                    }
                    catch(Exception ez)
                    {
                        System.out.println("Change City Error : "+ez.getMessage());
                    }
                    JOptionPane.showMessageDialog(null,"Phone no Successfully Updated !");
                    panelPhone.setVisible(false);
                    }
                    else{
                         JOptionPane.showMessageDialog(null,"PHone Number should only be 10 Digit !");
                    }
                }//end if
                if(e.getSource() == submitQuery)
                {
                    try{
                    String receiveText = textArea.getText();
                    Conne c = new Conne();
                    String q = "insert into question values('"+rg+"','"+receiveText+"')";
                    c.s.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Query / Question Successfully Submitted !");
                    textArea.setText("Dharmendra");
                    }
                    catch(Exception ew)
                    {
                        System.out.println("Submit query Error :"+ew.getMessage());
                    }
                }
                if(e.getSource() == getAnswer)
                {
                    try{
                          String q  = "select * from answer where RegNumber = '"+rg+"';";
                          Conne c1 = new Conne();
                          ResultSet rs = c1.s.executeQuery(q);
                          while(rs.next())
                          {
                              textArea.setText(rs.getString("Ans"));//value at Ans Column
                          }
                          
                    }
                    catch(Exception er)
                    {
                        System.out.println("GetAnswer Error : "+er.getMessage());
                    }
                }
        }
        catch(Exception ex1)
        {
            System.out.println("Error:"+ex1);
        }
    }
    public static void main(String args[])
    {
        new UserWork("18mcmc19");
    }
}
