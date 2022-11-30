package firstproject;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JButton cancel;
    
    Dashboard(){
        setLayout(null);//set bound wont work if the layout is not set to null
        setBounds(0,0,2560,1600);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/image52.png"));
        Image i2=i1.getImage().getScaledInstance(1336,687, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(50,90,1336,687);
        add(image);
        
        JLabel text = new JLabel("Welcome to the Dashboard");
        text.setBounds(400,10,2560,100);
        text.setForeground(Color.red);
        text.setFont(new Font("serif", Font.PLAIN, 60));
        add(text);
        
        
        JMenuBar mb=new JMenuBar();//Menu Bar
        mb.setBounds(0,0,2560,30);
        add(mb);
        
        JMenu bank = new JMenu("Credit Bank");//Menu
        bank.setForeground(Color.RED);
        mb.add(bank);
        
        JMenuItem credits=new JMenuItem("Credits");//Menu Items
        credits.addActionListener(this);
        bank.add(credits);
        
//        JMenuItem reset=new JMenuItem("Reset Account");//Menu Items
//        bank.add(reset);
//        
//        JMenuItem res=new JMenuItem("Resources");//Menu Items
//        bank.add(res);
        
        JMenu admin = new JMenu("My Data");//Menu 
        admin.setForeground(Color.BLUE);
        mb.add(admin);
        
        JMenuItem addstd=new JMenuItem("Add Student");//Menu Items
        addstd.addActionListener(this);
        admin.add(addstd);
        
        JMenuItem addcredits=new JMenuItem("Add Credits");//Menu Items
        addcredits.addActionListener(this);
        admin.add(addcredits);
//        
//        JMenuItem uni=new JMenuItem("University");//Menu Items
//        admin.add(uni);
                
        cancel = new JButton("EXIT");
        cancel.setBounds(20,50,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand().equals("Add Student")){
            new  AddStudent();
        }
        if (ae.getActionCommand().equals("Add Credits")){
            new  AddCredits();
        }
        if (ae.getActionCommand().equals("Credits")){
            new Credits();
        }
        if (ae.getSource()==cancel){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Dashboard();
    }
    
}
