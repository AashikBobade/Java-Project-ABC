package firstproject;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddCredits extends JFrame implements ActionListener{ 
    JTextField textField_1,textField_2,textField_3,textField_4;
//    JRadioButton Male, Female;
    JButton Submit;
//    JComboBox c1;

    AddCredits(){
        setLayout(null);      
            
        //COURSE NAME
        JLabel name = new JLabel("Course Name");
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        name.setBounds(60, 100, 150, 27);
        add(name);
            
        textField_1 = new JTextField();
        textField_1.setBounds(250, 100, 150, 27);
        add(textField_1);
            
            
        //Credits
        JLabel Pnrno = new JLabel("Credits");
        Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Pnrno.setBounds(60, 150, 150, 27);
        add(Pnrno);
			
        textField_2 = new JTextField();
        textField_2.setBounds(250, 150, 150, 27);
        add(textField_2);
        
            
        //Descipline
        JLabel Name = new JLabel("Descipline");
        Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Name.setBounds(60, 200, 150, 27);
        add(Name);
            
        textField_3 = new JTextField();
        textField_3.setBounds(250, 200, 150, 27);
        add(textField_3);
            
            
        //AADHAAR Numner
        JLabel Phno = new JLabel("AADHAAR Number");
        Phno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Phno.setBounds(60, 250, 150, 27);
        add(Phno);
			
        textField_4 = new JTextField();
        textField_4.setBounds(250, 250, 150, 27);
        add(textField_4);
	
            
        //UPDATE
        Submit = new JButton("UPDATE");
        Submit.setBounds(250, 330, 150, 30);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.BLACK);
        Submit.addActionListener(this);
        add(Submit);
          
        
//        //Image on the page
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/image4.jpeg"));
//        Image i3 = i1.getImage().getScaledInstance(400, 360,Image.SCALE_DEFAULT);
//        ImageIcon i2 = new ImageIcon(i3);
//        JLabel image = new JLabel(i2);
//        image.setBounds(380,60,400,460);
//        add(image);
    
	
        JLabel AddStudent = new JLabel("Add Credits");
        AddStudent.setForeground(Color.BLACK);
        AddStudent.setFont(new Font("Tahoma", Font.PLAIN, 24));
        AddStudent.setBounds(50, 20, 442, 35);
        add(AddStudent);
            
        getContentPane().setBackground(Color.WHITE);
        setBounds(340,200,500,450);
        setVisible(true);
    }
        public void actionPerformed(ActionEvent ae){
            String name = textField_1.getText();
            String credits = textField_2.getText();
            String descipline = textField_3.getText();
            String aadhaar = textField_4.getText();
               
                
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Name cannot be empty");
                    return;
            }
            if (credits.equals("")){
                JOptionPane.showMessageDialog(null,"Age cannot be empty");
                    return;
            }
            if (descipline.equals("")){
                JOptionPane.showMessageDialog(null,"Mobile cannot be empty");
                return;
            }
            if (aadhaar.equals("")){
                JOptionPane.showMessageDialog(null,"Aadhar cannot be empty");
                return;
            }
                
            try {
                Conn c = new Conn();
                String query = "INSERT INTO credits values( '"+aadhaar+"','"+name+"', '"+credits+"', '"+descipline+"')";
                        
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Credits Added Successfully");
                setVisible(false);
                    
            } catch (Exception e) {
                    
                e.printStackTrace();
                    
            }
        }
        
    public static void main(String[] args){
        new AddCredits();
    }
}