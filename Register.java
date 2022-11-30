package firstproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Register extends JFrame implements ActionListener{

    JTextField username;
    JPasswordField password;
    JButton reg, cancel;
    
    Register(){
        
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        
        JLabel user=new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);
        
        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);
        
        JLabel pass=new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);
        
        password = new JPasswordField();
        password.setBounds(150, 70, 150, 30);
        add(password);
        
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);
        
        reg = new JButton("Register");
        reg.setBounds(40,150,120,30);
        reg.setBackground(Color.BLACK);
        reg.setForeground(Color.BLACK);
        reg.addActionListener(this);
        add(reg);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/image7.png"));
        Image i2=i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(350,30,200,200);
        add(image);
        
        
        setBounds(500,200,600,300);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource()==reg){
        
        String user = username.getText();
        String pass = password.getText();
            
        if (user.equals("")){
            JOptionPane.showMessageDialog(null,"Username cannot be empty");
            return;
        }
        if (pass.equals("")){
            JOptionPane.showMessageDialog(null,"Password cannot be empty");
            return;
        }
        
        try {
                Conn c = new Conn();
                String query = "INSERT INTO login values( '"+user+"', '"+pass+"')";

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Registration Successful");
                setVisible(false);
                new Dashboard();
                
        } catch (Exception e) {
                    
            e.printStackTrace();
                    
        }
        
        
    }
    
    else if (ae.getSource()==cancel){
            setVisible(false);
        }    

        
        
    }        
    public static void main(String[] args){
        new Register();
    }
    
}

    
