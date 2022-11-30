package firstproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;
import javax.swing.table.DefaultTableCellRenderer;

public class Credits extends JFrame implements ActionListener{ 
    JTable table;
    JButton back;

    Credits(){
        
        setLayout(null);    
        
        JLabel AddStudent = new JLabel("Verify Your Credits");
        AddStudent.setForeground(Color.BLUE);
        AddStudent.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        AddStudent.setBounds(320, 20, 300, 35);
        add(AddStudent);
        
//        Image on the page
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/image8.png"));
        Image i3 = i1.getImage().getScaledInstance(236, 214,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(560,140,236,214);
        add(image);
        
        
        
        JLabel l1 = new JLabel("Aadhaar Number");
        l1.setBounds(50,60,150,20);
        add(l1);
        
        JLabel l2 = new JLabel("Course Name");
        l2.setBounds(190,60,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Credits");
        l3.setBounds(330,60,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Discipline");
        l4.setBounds(440,60,100,20);
        add(l4);
        
        // Table
        table=new JTable();
        table.setBounds(40,80,500,350);
        table.setBackground(Color.CYAN);
        table.setBorder(BorderFactory.createLineBorder(Color.black));
        table.setGridColor(Color.BLACK);
        
        DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer();
        tableRenderer.setHorizontalAlignment(JLabel.CENTER); //Aligning the table data centrally.
        table.setDefaultRenderer(Object.class, tableRenderer);
        
        add(table);

        try{
            
//            aadhaarverify a = new aadhaarverify();
//            String ab = a.aadhaar.getText();
//            
            Conn c =new Conn();
            ResultSet rs = c.s.executeQuery("select * from credits where aadhaar_no='123456781234'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        		
        //Back Button
        back = new JButton("Back");
        back.setBounds(250, 460, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
            
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,800,550);
        setVisible(true);
    
        }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Dashboard();
    }
        
    public static void main(String[] args){
        new Credits();
    }
}