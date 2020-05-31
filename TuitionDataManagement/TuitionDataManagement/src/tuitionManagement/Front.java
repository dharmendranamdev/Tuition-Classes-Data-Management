package tuitionManagement;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;

public class Front extends JFrame implements ActionListener{
    
    JMenuBar mb;
    JMenu std;
    /*...............student's query menu......................*/
    JMenu stdQuery;
    JMenuItem query;
    JMenuItem  newstudent,paststudent,student_details,remove_student;
    
    /*-----------------Fees Menu-------------------------------*/
    JMenu feesMenu;
    JMenuItem fees;
    public Front()
    {
        super("CoachingClassManagement 1.0");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dharmendra\\Documents\\NetBeansProjects\\TuitionDataManagement\\src\\disk2.png");    
        setIconImage(icon);    
        /*---------------------------------adding pic-----------------------*/
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("frontpic.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1900, 950,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        add(l1);
        /*--------------------------Menu bar---------------------------------*/
        mb = new JMenuBar();
        /*----------------------- student menu-------------------------------*/
        std = new JMenu("Student");
        newstudent = new JMenuItem("New Student");
        student_details = new JMenuItem("Student Detail");
        paststudent = new JMenuItem("Past Student");
        remove_student = new JMenuItem("Remove student");
        // -------------------- + new student--------------------------------
        newstudent.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("newstudent.jpeg"));
        Image image1 = icon1.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        newstudent.setIcon(new ImageIcon(image1));
        newstudent.setMnemonic('N');
        newstudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newstudent.setBackground(Color.WHITE);
        // -------------------- student details--------------------------------
        student_details.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("studentdetail.jpeg"));
        Image image2 = icon2.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        student_details.setIcon(new ImageIcon(image2));
        student_details.setMnemonic('D');
        student_details.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        student_details.setBackground(Color.WHITE);
        //---------------------past student-----------------------------
        paststudent.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("paststudent.jpeg"));
        Image image3 = icon3.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        paststudent.setIcon(new ImageIcon(image3));
        paststudent.setMnemonic('P');
        paststudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        paststudent.setBackground(Color.WHITE);
        //---------------------delete student-----------------------------
        remove_student.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("delete.png"));
        Image image4 = icon4.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        remove_student.setIcon(new ImageIcon(image4));
        remove_student.setMnemonic('R');
        remove_student.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        remove_student.setBackground(Color.WHITE);
        
        
        //---------------------Student's Query Menu
        stdQuery = new JMenu("Student's Queries");
        
        query = new JMenuItem("Receive Question");
        
        
        
             
        // -------------------- +  Receive Quetion MenuItem--------------------------------
        query.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon5= new ImageIcon(ClassLoader.getSystemResource("query2.png"));
        Image image5 = icon5.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
         query.setIcon(new ImageIcon(image5));
         query.setMnemonic('Q');
         query.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
         query.setBackground(Color.WHITE);
        
        stdQuery.add(query);
        
        //------------------------Fees Menu---------------------------
        feesMenu = new JMenu("Student Fees");
        fees = new JMenuItem("Fees");
        
        //------------------------+ fees Menu Item------------------------------
        fees.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon6= new ImageIcon(ClassLoader.getSystemResource("payment_fees_paid_benefit-512.png"));
        Image image6 = icon6.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        fees.setIcon(new ImageIcon(image6));
        fees.setMnemonic('F');
        fees.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        fees.setBackground(Color.WHITE);
        
        feesMenu.add(fees);
        
        
        
        
        
        
        
        
       
        /*--------------------- Action Event ------------------------------*/
        
        //--------------For Student Menu--------------------
        newstudent.addActionListener(this);
        student_details.addActionListener(this);
         paststudent.addActionListener(this);
        remove_student.addActionListener(this);
        
        //-------------For Student Query Menu------------------------
        query.addActionListener(this);
        
        //--------For  Student Fees Menu--------------------------
        fees.addActionListener(this);
       
        std.add(newstudent);
        std.add(student_details);
        std.add(paststudent);
        std.add(remove_student);
        
        mb.add(std); 
        mb.add(stdQuery);
        
        mb.add(feesMenu);
        
        //------------------------adding menu bar into frame-----------------------
        setJMenuBar(mb); 
        setSize(1920,1030);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String message = ae.getActionCommand();
        
        if(message.equals("New Student")){
            new NewStudent();
       }
        else if(message.equals("Student Detail")){
            new StudentDetails();
        }
        else if(message.equals("Past Student")){
            new PastStudent();   
        }
        else if(message.equals("Remove student"))
        {
            System.out.println("remove");
            new RemoveStudent();
        }
        else if(message.equals("Receive Question"))
        {
            System.out.println("receive Question");
            new ReceiveQuestion();
        }
        else if(message.equals("Fees"))
        {
            System.out.println("Fees");
            new PaymentDetails();
        }
    }
    public static void main(String args[])
    { new Front();}
}
