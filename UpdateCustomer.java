import javax.swing.*;    
import java.awt.*; 
import java.io.File;
import java.util.Scanner;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;

public class UpdateCustomer extends JFrame implements ActionListener{
	JLabel labelusername,labelname;
	JComboBox comboid;
	JTextField tfnumber,tfaddress,tfcountry,tfemail,tfid,tfgender;
	JRadioButton rmale,rfemale;
	JButton update,back;
	ResultSet rs;
	
	public UpdateCustomer(String username){
		setBounds(0,0,850,550);
		setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ico.jpg"));
		setIconImage(icon);

		JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
		text.setFont(new Font("Tahoma",Font.BOLD,20));
		text.setBounds(50,0,300,25);
		add(text);

		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(30,50,150,25);
		add(lblusername);

		labelusername = new JLabel();
		labelusername.setBounds(220,50,150,25);
		add(labelusername);

		JLabel lblid = new JLabel("ID");
		lblid.setBounds(30,90,150,25);
		add(lblid);

		tfid = new JTextField();
		tfid.setBounds(220,90,150,25);
		add(tfid);

		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(30,130,150,25);
		add(lblnumber);

		tfnumber = new JTextField();
		tfnumber.setBounds(220, 130, 150, 25);
		add(tfnumber);

		JLabel lblname = new JLabel("Name");
		lblname.setBounds(30,170,150,25);
		add(lblname);

		labelname = new JLabel();
		labelname.setBounds(220,170,150,25);
		add(labelname);

		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(30, 210, 150, 25);
		add(lblgender);

		tfgender = new JTextField();
		tfgender.setBounds(220, 210, 150, 25);
		add(tfgender);

		JLabel lblcountry = new JLabel("Country");
		lblcountry.setBounds(30, 250, 150, 25);
		add(lblcountry);

		tfcountry = new JTextField();
		tfcountry.setBounds(220, 250, 150, 25);
		add(tfcountry);

		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(30, 290, 150, 25);
		add(lbladdress);

		tfaddress = new JTextField();
		tfaddress.setBounds(220, 290, 150, 25);
		add(tfaddress);

		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(30, 330, 150, 25);
		add(lblemail);

		tfemail = new JTextField();
		tfemail.setBounds(220, 330, 150, 25);
		add(tfemail);

		update = new JButton("Update");
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.setBounds(70,430,100,25);
		update.addActionListener(this);
		add(update);

		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(220,430,100,25);
		back.addActionListener(this);
		add(back);

		ImageIcon i1 = new ImageIcon(getClass().getResource("/images/uc.png"));
		Image i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400,0,450,520);
		add(image);
		
		try{
			Conn c =  new Conn();
		    rs = c.s.executeQuery("select * from customer");
			while(rs.next()){
				labelusername.setText(rs.getString(1));
				labelname.setText(rs.getString(4));
				tfid.setText(rs.getString(2));
				tfnumber.setText(rs.getString(3));
				tfgender.setText(rs.getString(5));
				tfcountry.setText(rs.getString(6));
				tfaddress.setText(rs.getString(7));
				tfemail.setText(rs.getString(8));
			}
		}catch(Exception e){
			System.out.println(e);
		}
		setVisible(true);
	}
	
	 public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==update){
			String username = labelusername.getText();
			String id=tfid.getText();
			String number = tfnumber.getText();
			String name= labelname.getText();
			String gender = tfgender.getText();
			String country = tfcountry.getText();
			String address = tfaddress.getText();
			String email = tfemail.getText();
			
			try{
				Conn c = new Conn();
				String query = "update customer set username = '" + username + "', id = '" + id + "', number = '" + number + "', name = '" + name + "', gender ='" + gender + "', country = '" + country + "', address ='" + address + "', email ='" + email + "'";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"Customer Details Updated Sucessfully");
				setVisible(false);
				new Account("");
			} catch (Exception e) {
            e.printStackTrace();
			}
			
		}else{
			setVisible(false);
			new Account("");
			}
		}
    }