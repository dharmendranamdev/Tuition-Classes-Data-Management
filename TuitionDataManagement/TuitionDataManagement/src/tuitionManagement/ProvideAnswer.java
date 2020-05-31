/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuitionManagement;


import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ProvideAnswer extends JFrame implements ActionListener{
    JPanel panel;
    JLabel ques,ans,regLabel;
    JTextField regNo;
    JTextArea quesText,ansText;
    JButton getQuestion,submitAnswer,back,mainWindow;
    
    
    public ProvideAnswer(){
        
        
       
        
        
        super("Providing Answer");
       
        
        panel = new JPanel();
        //panel.setLayout(null);
        
        
        panel.setBounds(0,50,970,750);
        panel.setLayout(null);
        
        regLabel = new JLabel("Enter Registration Number");
        regNo = new JTextField();
        getQuestion = new JButton("Get Question ");
       
        ques = new JLabel("Question");
        quesText = new JTextArea(5, 20);
        
        ans = new JLabel("Answer");
        ansText = new JTextArea(5, 20);
        submitAnswer = new JButton("Submit Answer");
         
        
        back = new JButton("Back");
        mainWindow = new JButton("Back to Main Window");
        regLabel.setBounds(50,50,150,40);
        regNo.setBounds(230,55,150,30);
        getQuestion.setBounds(420,55,150,30);
        
        ques.setBounds(50,200,100,40);
        quesText.setBounds(160,130,1000,250);
        
        ans.setBounds(50,450,100,40);
        ansText.setBounds(160,400,1000,250);
        
        submitAnswer.setBounds(600,55,150,30);
        back.setBounds(950,55,150,30);
        mainWindow.setBounds(1150,55,200,30);
        
        
        panel.add(regLabel);
        panel.add(regNo);
        panel.add(getQuestion);
        panel.add(ques);
        panel.add(quesText);
        panel.add(ans);
        panel.add(ansText);
        panel.add(submitAnswer);
        panel.add(back);
        panel.add(mainWindow);
        
        add(panel);
    
        
        getQuestion.addActionListener(this);
        submitAnswer.addActionListener(this);
        back.addActionListener(this);
        mainWindow.addActionListener(this);
        
       
        //getContentPane().setBackground( Color.red );
        setSize(1400,750);
        setLocation(0,0);
        setResizable(false);
        setVisible(true);
        //getContentPane().setBackground(Color.YELLOW);
        
        
    }
    
    
    public void actionPerformed(ActionEvent e) {
        
        try
        {
            
            if(e.getSource() == getQuestion)
            {
                Conne c1 = new Conne();
                String q = "select * from question where regNumber = '" + regNo.getText() +"'";
                ResultSet rs = null;
                rs = c1.s.executeQuery(q);
      
                if(rs.next())
                {
                    //System.out.print("Question is sent by User");
                    String q1  = "select * from question where RegNumber = '"+regNo.getText()+"';";
                    Conne c2 = new Conne();
                    ResultSet rs1 = c2.s.executeQuery(q1);
                    while(rs1.next())
                    {
                        quesText.setText(rs1.getString("Ques"));//value at Ans Column
                    }
                }
                else
                {   
                    JOptionPane.showMessageDialog(null, "OOPS No Question sent by this Registration Number !..");
                }
            }
        
            if(e.getSource() == submitAnswer)
            {
                
                Conne c3 = new Conne();
                String q2 = "insert into answer values('"+regNo.getText()+"','"+ansText.getText()+"')";
                c3.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null,"Question Submitted Successfully on Registration No "+regNo.getText());
                quesText.setText("");
                ansText.setText("");
                regNo.setText("");
            }
            
            if(e.getSource() == back)
            {
                setVisible(false);
                new ReceiveQuestion();
            }
            if(e.getSource() == mainWindow)
            {
                setVisible(false);
                new Front();
            }
              
        }
        catch(Exception aw)
        {
            aw.printStackTrace();
            System.out.println("Error : "+aw.getMessage());
        }
            
    }
    
    public static void main(String args[])
    {
        new ProvideAnswer();
    }
}
