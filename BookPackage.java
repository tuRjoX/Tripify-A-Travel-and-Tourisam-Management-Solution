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

public class BookPackage extends JFrame implements ActionListener{
	Choice cpack;
	JTextField tfpersons;
	String username;
	JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
	JButton checkprice,bookpackage,back;
	
	 BookPackage(String username){
		 
		 Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ico.jpg"));    
		setIconImage(icon); 
		
		this.username =username;
		
		setBounds(0,0,1100,600);
		setLocationRelativeTo(null);
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		
		JLabel text= new JLabel("BOOK PACKAGE");
		text.setBounds(100,10,200,30);
		text.setFont(new Font("tahoma",Font.BOLD,20));
		add(text);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setFont(new Font("tahoma",Font.PLAIN,16));
		lblusername.setBounds(40,70,100,20);
		add(lblusername);
		
	    labelusername = new JLabel();
		labelusername.setFont(new Font("tahoma",Font.PLAIN,16));
		labelusername.setBounds(250,70,100,20);
		add(labelusername);
		
		JLabel lblpackage = new JLabel("Select Package");
		lblpackage.setFont(new Font("tahoma",Font.PLAIN,16));
		lblpackage.setBounds(40,110,150,20);
		add(lblpackage);
		
		cpack = new Choice();
		cpack.setBounds(250,110,200,20);
		add (cpack);
		try{
			Conn c= new Conn();
			ResultSet rs = c.s.executeQuery("Select * from packages");
			while(rs.next()){
			cpack.add(rs.getString(2))	;
			}
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		JLabel lblpersons = new JLabel("Total Persons");
		lblpersons.setFont(new Font("tahoma",Font.PLAIN,16));
		lblpersons.setBounds(40,150,150,25);
		add(lblpersons);
		
		tfpersons= new JTextField("");
		tfpersons.setBounds(250,150,200,25);
		add(tfpersons);
		
		JLabel lblid = new JLabel("Id");
		lblid.setFont(new Font("tahoma",Font.PLAIN,16));
		lblid.setBounds(40,190,150,20);
		add(lblid);
		
		labelid = new JLabel();
		labelid.setBounds(250,190,200,25);
		add( labelid);
		
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setFont(new Font("tahoma",Font.PLAIN,16));
		lblnumber.setBounds(40,230,150,25);
		add(lblnumber);
		
	    labelnumber = new JLabel();
		labelnumber.setBounds(250,230,150,25);
		add(labelnumber);
		
		JLabel lbltotal = new JLabel("Total Price");
		lbltotal.setFont(new Font("tahoma",Font.PLAIN,16));
		lbltotal.setBounds(40,270,150,20);
		add(lbltotal);
		
	    labelprice = new JLabel();
		labelprice.setBounds(250,270,200,25);
		add(labelprice);
		
		try {
			Conn conn=new Conn();
			String query = "select * from customer";
			ResultSet rs = conn.s.executeQuery(query);
			while (rs.next()){
				labelusername.setText(rs.getString(1));
				labelid.setText(rs.getString(2));
				labelnumber.setText(rs.getString(3));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		 checkprice=new JButton("Check price");
		 checkprice.setBackground(Color.BLACK);
		 checkprice.setForeground(Color.WHITE);
		 checkprice.setBounds(60,380,120,25);
		 checkprice.addActionListener(this);
		 add(checkprice);
		 
		 
		 bookpackage=new JButton("Book Package");
		 bookpackage.setBackground(Color.BLACK);
		 bookpackage.setForeground(Color.WHITE);
		 bookpackage.setBounds(200,380,120,25);
		 bookpackage.addActionListener(this);
		 add(bookpackage);
		 
		 back=new JButton("Back");
		 back.setBackground(Color.BLACK);
		 back.setForeground(Color.WHITE);
		 back.setBounds(340,380,120,25);
		 back.addActionListener(this);
		 add(back); 
		 
		 ImageIcon i1=new ImageIcon(getClass().getResource("/images/bookpackage.jpg"));
	     Image i2 =i1 .getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
		 ImageIcon i3=new ImageIcon(i2);
		 JLabel l11=new JLabel(i3);
		 l11.setBounds (550,50,500,300);
		 add(l11);
		
		setVisible(true);
	 }
		
		public void actionPerformed(ActionEvent ae){
			if (ae.getSource()==checkprice){
				try{
			    Conn c = new Conn();
			    ResultSet rs =c.s.executeQuery("Select * from packages where name='" +cpack.getSelectedItem()+"'");
			 while (rs.next()){
				 int cost = Integer.parseInt(rs.getString(3));
				 int persons = Integer.parseInt(tfpersons.getText());
				 if (persons> 0){
					 int total=0;
					 total = cost*persons;
					 labelprice.setText(total+"TK/-");
				 } else{
					 JOptionPane.showMessageDialog(null,"Please Enter a Valid Number");
				 }
			 } }catch(Exception e) {
				 e.printStackTrace();
			 } 
			 /*
				String packageName = cpack.getSelectedItem();
            int packageCost = packageCosts.get(packageName);
            int persons = Integer.parseInt(tfpersons.getText());
            int totalPrice = packageCost * persons;
            labelprice.setText(totalPrice + "TK/-");*/
			}
			else if (ae.getSource()==bookpackage){
					try { 
					Conn c= new Conn ();
					c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+cpack.getSelectedItem()+"', '"+tfpersons.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelprice.getText()+"')");
					JOptionPane.showMessageDialog(null,"Package Booked Successfully");
					setVisible(false);
					new Package_Hotel("");	
					} catch (Exception e){
						e.printStackTrace();
					}
				} 
				else {
					setVisible(false);
					new Package_Hotel("");
					}
				
		}
}