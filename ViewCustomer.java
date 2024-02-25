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

public class ViewCustomer extends JFrame implements ActionListener{
	JButton back;
	ResultSet rs;
	public ViewCustomer(String username){
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ico.jpg"));    
		setIconImage(icon); 
		
		setBounds(0,0,870,625);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(30,50,150,25);
		add(lblusername);
		
		JLabel labelusername = new JLabel();
		labelusername.setBounds(220,50,150,25);
		add(labelusername);
		
		JLabel lblid = new JLabel("ID");
		lblid.setBounds(30,110,150,25);
		add(lblid);
		
		JLabel labelid = new JLabel();
		labelid.setBounds(220,110,150,25);
		add(labelid);
		
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(30,170,150,25);
		add(lblnumber);
		
		JLabel labelnumber = new JLabel();
		labelnumber.setBounds(220,170,150,25);
		add(labelnumber);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(30,230,150,25);
		add(lblname);
		
		JLabel labelname = new JLabel();
		labelname.setBounds(220,230,150,25);
		add(labelname);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(30,290,150,25);
		add(lblgender);
		
		JLabel labelgender = new JLabel();
		labelgender.setBounds(220,290,150,25);
		add(labelgender);
		
		JLabel lblcountry = new JLabel("Country");
		lblcountry.setBounds(500,50,150,25);
		add(lblcountry);
		
		JLabel labelcountry = new JLabel();
		labelcountry.setBounds(690,50,150,25);
		add(labelcountry);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(500,110,150,25);
		add(lbladdress);
		
		JLabel labeladdress = new JLabel();
		labeladdress.setBounds(690,110,150,25);
		add(labeladdress);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(500,170,150,25);
		add(lblemail);
		
		JLabel labelemail = new JLabel();
		labelemail.setBounds(690,170,150,25);
		add(labelemail);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(350,350,100,25);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/images/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(20,400,600,200);
		add(image);
		
		
		ImageIcon i4 = new ImageIcon(getClass().getResource("/images/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
		JLabel image2 = new JLabel(i6);
		image2.setBounds(600,400,600,200);
		add(image2);
		
		try{
			Conn c =  new Conn();
		    rs = c.s.executeQuery("select * from customer");
			while(rs.next()){
				labelusername.setText(rs.getString(1));
				labelid.setText(rs.getString(2));
				labelnumber.setText(rs.getString(3));
				labelname.setText(rs.getString(4));
				labelgender.setText(rs.getString(5));
				labelcountry.setText(rs.getString(6));
				labeladdress.setText(rs.getString(7));
				labelemail.setText(rs.getString(8));
			}
		}catch(Exception e){
			System.out.println(e);
		}
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
			setVisible(false);
			new Account("");
	}
}