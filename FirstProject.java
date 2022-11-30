package firstproject;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstProject extends JFrame implements ActionListener{
    
    FirstProject(){
        setSize(2560,1600);// frame size
        setLayout(null);
        setLocation(100,100);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/image1.png"));
        Image i2=i1.getImage().getScaledInstance(1033,725, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(190,25,1033,725);//locationx, locationy, lenght, width
        add(image);
        
        JLabel text=new JLabel("Academic Bank of Credit");
        text.setBounds(330,0,2560,90);
        text.setForeground(Color.red);
        text.setFont(new Font("serif", Font.PLAIN, 40));
        
        image.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(455,360,90,50);
        next.setForeground(Color.black);
        next.setBackground(Color.black);
        next.setFont(new Font("serif", Font.PLAIN, 20));
        next.addActionListener(this);
        image.add(next);
        
        setVisible(true);
        
        while(true){ //flashing the text using infinite loop
            text.setVisible(false);
            try{
                Thread.sleep(500);
            } 
            catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(1200);
            } 
            catch (Exception e){
                e.printStackTrace();
            } 
            
            
        }
    }
    
    public void actionPerformed(ActionEvent ae){ //method overrinding
        setVisible(false);
        new Login();
    }
    
    
    public static void main(String[] args) {
        
        new FirstProject();
    }
    
}
