package tuitionManagement;


import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class ReceiveQuestion extends JFrame implements ActionListener {
 
        JTable t1;
        
        JButton b1;
        
        JScrollPane sp;
        String x[] = {"Sr.No","Reg Number","Questions"};
        String y[][] = new String[50][3];
        int i=0,j =0;
        public ReceiveQuestion()
        {
            super("Receive question");       
            setSize(1400,700);
            setLocation(0,0);
        
            try
            {
            
                Conne c1 = new Conne();
                String q = "select * from question";
                ResultSet rs = c1.s.executeQuery(q);
                while(rs.next())
                {
                    y[i][j++] = Integer.toString(i+1);
                    y[i][j++] = rs.getString("RegNumber");
                    y[i][j++] = rs.getString("Ques");
                    i++;
                    j = 0;   
                }
                
               t1 = new JTable(y,x);    
            
               t1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
               t1.getColumnModel().getColumn(0).setPreferredWidth(27);
               t1.getColumnModel().getColumn(1).setPreferredWidth(80);
               t1.getColumnModel().getColumn(2).setPreferredWidth(2500);
          
            }
            catch(Exception ae)
            {
                ae.printStackTrace();
                System.out.println("Exception:"+ae);
            }
        
            b1 = new JButton("Get Complete Question & Provide Answer");
            add(b1,"South");
            sp = new JScrollPane(t1);
            add(sp);
            
         
            b1.addActionListener(this);
            //b2.addActionListener(this);
            setVisible(true);
   
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1)
        {
          setVisible(false);
          new ProvideAnswer();
        }
        
    }
    
    public static void main(String args[])        
    {
        new ReceiveQuestion();
    }
}
