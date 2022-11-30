package firstproject;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddStudent extends JFrame implements ActionListener{ 
    JTextField textField,textField_1,textField_4,textField_5,textField_6;
    JRadioButton Male, Female;
    JButton Submit;
    JComboBox c1;

    AddStudent(){
        setLayout(null);      
            
        //NAME
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        name.setBounds(60, 20, 150, 27);
        add(name);
            
        textField = new JTextField();
        textField.setBounds(250, 20, 150, 27);
        add(textField);
            
            
        //AGE
        JLabel Pnrno = new JLabel("Age");
        Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Pnrno.setBounds(60, 70, 150, 27);
        add(Pnrno);
			
        textField_1 = new JTextField();
        textField_1.setBounds(250, 70, 150, 27);
        add(textField_1);
            
            
        //GENDER
        JLabel Gender = new JLabel("Gender");
        Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Gender.setBounds(60, 120, 150, 27);
        add(Gender);
		
        Male = new JRadioButton("MALE");
        Male.setBackground(Color.WHITE);
        Male.setBounds(250, 120, 70, 27);
        add(Male);
	
        Female = new JRadioButton("FEMALE");
        Female.setBackground(Color.WHITE);
        Female.setBounds(330, 120, 100, 27);
        add(Female);
            
        ButtonGroup bg=new ButtonGroup(); //grouping two button, to avoid multiple selection
        bg.add(Male);
        bg.add(Female);
            
        //EDUCATIONAL QUALIFICATIONS
        JLabel Address = new JLabel("Educational Details");
        Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Address.setBounds(60, 170, 150, 27);
        add(Address);
			
        String course[] = {"Secondary School","Higher Secondary","Under Graduate","Graduate","Post Graduate","Doctorate"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(250,170,150,30);
        add(c1);
            
            
        //CONTACT DETAILS
        JLabel Name = new JLabel("Contact Details");
        Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Name.setBounds(60, 220, 150, 27);
        add(Name);
            
        textField_4 = new JTextField();
        textField_4.setBounds(250, 220, 150, 27);
        add(textField_4);
            
            
        //AADHAAR Numner
        JLabel Phno = new JLabel("AADHAAR Number");
        Phno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Phno.setBounds(60, 270, 150, 27);
        add(Phno);
			
        textField_5 = new JTextField();
        textField_5.setBounds(250, 270, 150, 27);
        add(textField_5);
	
            
        //EMAIL
        JLabel email = new JLabel("Email");
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email.setBounds(60, 320, 150, 27);
        add(email);
			
        textField_6 = new JTextField();
        textField_6.setBounds(250, 320, 150, 27);
        add(textField_6);
            
            
        //SUBMIT
        Submit = new JButton("SUBMIT");
        Submit.setBounds(250, 370, 150, 30);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.BLACK);
        Submit.addActionListener(this);
        add(Submit);
          
        
        //Image on the page
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/image4.jpeg"));
        Image i3 = i1.getImage().getScaledInstance(400, 360,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(380,60,400,460);
        add(image);
    
	
        JLabel AddStudent = new JLabel("Add Student");
        AddStudent.setForeground(Color.BLACK);
        AddStudent.setFont(new Font("Tahoma", Font.PLAIN, 24));
        AddStudent.setBounds(500, 60, 442, 35);
        add(AddStudent);
            
        getContentPane().setBackground(Color.WHITE);
        setBounds(340,200,730,500);
        setVisible(true);
    }
        public void actionPerformed(ActionEvent ae){
            String name = textField.getText();
            String age = textField_1.getText();
            String mobile = textField_4.getText();
            String aadhar = textField_5.getText();
            String email = textField_6.getText();
                
            String gender = null;
                
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Name cannot be empty");
                    return;
            }
            if (email.equals("")){
                JOptionPane.showMessageDialog(null,"Email cannot be empty");
                    return;
            }
            if (age.equals("")){
                JOptionPane.showMessageDialog(null,"Age cannot be empty");
                    return;
            }
            if (mobile.equals("")){
                JOptionPane.showMessageDialog(null,"Mobile cannot be empty");
                return;
            }
            if (aadhar.equals("")){
                JOptionPane.showMessageDialog(null,"Aadhar cannot be empty");
                return;
            }
                    
            if(Male.isSelected()){
                gender = "M";
                    
            }else if(Female.isSelected()){
                gender = "F";
            }

                            
            String ED = (String)c1.getSelectedItem();
                    
            try {
                Conn c = new Conn();
                String query = "INSERT INTO student values( '"+name+"', '"+age+"', '"+gender+"', '"+mobile+"','"+aadhar+"', '"+email+"','"+ED+"')";
                        
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student Added Successfully");
                setVisible(false);
                    
            } catch (Exception e) {
                    
                e.printStackTrace();
                    
            }
        }
        
    public static void main(String[] args){
        new AddStudent();
    }
}