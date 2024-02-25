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

public class ViewBookedHotel extends JFrame implements ActionListener{
	JButton back;
	ResultSet rs;

	public ViewBookedHotel(String username){
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ico.jpg"));    
		setIconImage(icon); 
		
		setBounds(0,0,1000,600);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
		text.setFont(new Font("tahoma",Font.BOLD,20));
		text.setBounds(60,0,400,30);
		add(text);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(30,50,150,25);
		add(lblusername);
		
		JLabel labelusername = new JLabel();
		labelusername.setBounds(220,50,150,25);
		add(labelusername);
		
		JLabel lblpackage = new JLabel("Hotel Name");
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
		
		JLabel lbldays= new JLabel("Total Days");
		lbldays.setBounds(30,200,150,25);
		add(lbldays);
		
		JLabel labeldays = new JLabel();
		labeldays.setBounds(220,200,150,25);
		add(labeldays);
		
		JLabel lblac= new JLabel("AC/Non-AC");
		lblac.setBounds(30,250,150,25);
		add(lblac);
		
		JLabel labelac = new JLabel();
		labelac.setBounds(220,250,150,25);
		add(labelac);
		
		JLabel lblfood= new JLabel("Food Included?");
		lblfood.setBounds(30,300,150,25);
		add(lblfood);
		
		JLabel labelfood = new JLabel();
		labelfood.setBounds(220,300,150,25);
		add(labelfood);
		
		JLabel lblid = new JLabel("ID");
		lblid.setBounds(30,350,150,25);
		add(lblid);
		
		JLabel labelid = new JLabel();
		labelid.setBounds(220,350,150,25);
		add(labelid);
		
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(30,400,150,25);
		add(lblnumber);
		
		JLabel labelnumber = new JLabel();
		labelnumber.setBounds(220,400,150,25);
		add(labelnumber);
		
		JLabel lblprice = new JLabel("Price");
		lblprice.setBounds(30,450,150,25);
		add(lblprice);
		
		JLabel labelprice = new JLabel();
		labelprice.setBounds(220,450,150,25);
		add(labelprice);
		
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(130,490,100,25);
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
		    rs = c.s.executeQuery("select * from bookhotel");
			while(rs.next()){
				labelusername.setText(rs.getString(1));
				labelid.setText(rs.getString(7));
				labelnumber.setText(rs.getString(8));
				labelpackage.setText(rs.getString(2));
				labelprice.setText(rs.getString(9));
				labelpersons.setText(rs.getString(3));
				labelfood.setText(rs.getString(6));
				labelac.setText(rs.getString(5));
				labeldays.setText(rs.getString(4));
				
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