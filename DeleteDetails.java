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

public class DeleteDetails extends JFrame implements ActionListener{
	JButton back,delete;
	ResultSet rs;
	String username;
	public DeleteDetails(String username){
		this.username=username;
		setBounds(0,0,870,625);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ico.jpg"));
		setIconImage(icon);
		
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
		
		delete = new JButton("Delete");
		delete.setBackground(Color.BLACK);
		delete.setForeground(Color.WHITE);
		delete.setBounds(300,350,100,25);
		delete.addActionListener(this);
		add(delete);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(450,350,100,25);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/images/del.png"));
        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(120,400,600,200);
		add(image);

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
		if(ae.getSource() == delete){
		try{
			Conn c =  new Conn();
			c.s.executeUpdate("delete from customer");
			c.s.executeUpdate("delete from bookpackage");
			c.s.executeUpdate("delete from bookhotel");
			c.s.executeUpdate("delete from contacts");
			c.s.executeUpdate("delete from review");
			
			JOptionPane.showMessageDialog(null,"Data Delete Successfully");
			setVisible(false);
			new Account("");
		}catch(Exception e){
			e.printStackTrace();
		}
	} else if (ae.getSource() == back){
		setVisible(false);
		new Account("");
	}
	}
}