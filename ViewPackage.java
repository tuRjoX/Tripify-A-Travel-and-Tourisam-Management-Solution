import javax.swing.*;    
import java.awt.*; 
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextField;
import java.sql.*;

public class ViewPackage extends JFrame implements ActionListener{
	JButton back;
	ResultSet rs;

	public ViewPackage(String username){
		
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ico.jpg"));    
		setIconImage(icon); 
		
		setBounds(0,0,1000,600);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("VIEW PACKAGE DETAILS");
		text.setFont(new Font("tahoma",Font.BOLD,20));
		text.setBounds(60,0,300,30);
		add(text);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(30,50,150,25);
		add(lblusername);
		
		JLabel labelusername = new JLabel();
		labelusername.setBounds(220,50,150,25);
		add(labelusername);
		
		JLabel lblpackage = new JLabel("Package");
		lblpackage.setBounds(30,100,150,25);
		add(lblpackage);
		
		JLabel labelpackage = new JLabel();
		labelpackage.setBounds(220,100,150,25);
		add(labelpackage);
		
		JLabel lblpersons= new JLabel("Total Persons");
		lblpersons.setBounds(30,150,150,25);
		add(lblpersons);
		
		JLabel labelpersons = new JLabel();
		labelpersons.setBounds(220,150,150,25);
		add(labelpersons);
		
		JLabel lblid = new JLabel("Id");
		lblid.setBounds(30,200,150,25);
		add(lblid);
		
		JLabel labelid = new JLabel();
		labelid.setBounds(220,200,150,25);
		add(labelid);
		
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(30,250,150,25);
		add(lblnumber);
		
		JLabel labelnumber = new JLabel();
		labelnumber.setBounds(220,250,150,25);
		add(labelnumber);
		
		JLabel lblprice = new JLabel("Price");
		lblprice.setBounds(30,300,150,25);
		add(lblprice);
		
		JLabel labelprice = new JLabel();
		labelprice.setBounds(220,300,150,25);
		add(labelprice);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(130,350,100,25);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/images/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(450,20,500,400);
		add(image);
	
		
		try{
			Conn c =  new Conn();
		    rs = c.s.executeQuery("select * from bookpackage");
			while(rs.next()){
				labelusername.setText(rs.getString(1));
				labelid.setText(rs.getString(4));
				labelnumber.setText(rs.getString(5));
				labelpackage.setText(rs.getString(2));
				labelprice.setText(rs.getString(6));
				labelpersons.setText(rs.getString(3));
			}
		}catch(Exception e){
			System.out.println(e);
		}
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
			setVisible(false);
			new Package_Hotel("");
	}
}