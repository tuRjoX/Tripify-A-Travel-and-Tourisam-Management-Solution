import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookHotel extends JFrame implements ActionListener{
	
	
	Choice chotel, cac,cfood;
	JTextField tfpersons,tfdays;
	String username;
	JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
	JButton checkprice,bookpackage,back;
	
	 BookHotel(String username){
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ico.jpg"));    
		setIconImage(icon); 
		
		this.username = username;
		
		setBounds(0,0,1100,600);
		setLocationRelativeTo(null);
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		
		JLabel text= new JLabel("BOOK HOTEL");
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
		
		JLabel lblpackage = new JLabel("Select hotel");
		lblpackage.setFont(new Font("tahoma",Font.PLAIN,16));
		lblpackage.setBounds(40,110,150,20);
		add(lblpackage);
		
		chotel = new Choice();
		chotel.setBounds(250,110,200,20);
		add (chotel);
		
		try{
			Conn c= new Conn();
			ResultSet rs = c.s.executeQuery("Select * from hotel");
			while(rs.next()){
			chotel.add(rs.getString("name"))	;
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
		
		JLabel lbldays = new JLabel("Number of days");
		lbldays.setFont(new Font("tahoma",Font.PLAIN,16));
		lbldays.setBounds(40,190,150,25);
		add(lbldays);
		
		tfdays= new JTextField("");
		tfdays.setBounds(250,190,200,25);
		add(tfdays);
		
		JLabel lblac = new JLabel("AC/Non-AC");
		lblac.setFont(new Font("tahoma",Font.PLAIN,16));
		lblac.setBounds(40,230,150,25);
		add(lblac);
		
		cac = new Choice();
		cac.add("AC");
		cac.add("Non-AC");
		cac.setBounds(250,230,200,20);
		add(cac);
		
		JLabel lblfood = new JLabel("Food Included");
		lblfood.setFont(new Font("tahoma",Font.PLAIN,16));
		lblfood.setBounds(40,270,150,25);
		add(lblfood);
		
		cfood = new Choice();
		cfood.add("Yes");
		cfood.add("No");
		cfood.setBounds(250,270,200,20);
		add (cfood);
		
		JLabel lblid = new JLabel("ID");
		lblid.setFont(new Font("tahoma",Font.PLAIN,16));
		lblid.setBounds(40,310,150,20);
		add(lblid);
		
		labelid = new JLabel();
		labelid.setBounds(250,310,200,25);
		add( labelid);
		
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setFont(new Font("tahoma",Font.PLAIN,16));
		lblnumber.setBounds(40,350,150,25);
		add(lblnumber);
		
	    labelnumber = new JLabel();
		labelnumber.setBounds(250,350,150,25);
		add(labelnumber);
		
		JLabel lbltotal = new JLabel("Total Price");
		lbltotal.setFont(new Font("tahoma",Font.PLAIN,16));
		lbltotal.setBounds(40,390,150,20);
		add(lbltotal);
		
	    labelprice = new JLabel();
		labelprice.setBounds(250,390,200,25);
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
		 checkprice.setBounds(60,490,120,25);
		 checkprice.addActionListener(this);
		 add(checkprice);
		 
		 
		 bookpackage=new JButton("Book Hotel");
		 bookpackage.setBackground(Color.BLACK);
		 bookpackage.setForeground(Color.WHITE);
		 bookpackage.setBounds(200,490,120,25);
		 bookpackage.addActionListener(this);
		 add(bookpackage);
		 
		 back=new JButton("Back");
		 back.setBackground(Color.BLACK);
		 back.setForeground(Color.WHITE);
		 back.setBounds(340,490,120,25);
		 back.addActionListener(this);
		 add(back); 
		 
	    ImageIcon i1=new ImageIcon(getClass().getResource("/images/bookhotel.jpg"));
		Image i2 =i1 .getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l11=new JLabel(i3);
		l11.setBounds (500,50,600,300);
		add(l11);
		
		setVisible(true);
	 }
	 
	 public void actionPerformed(ActionEvent ae){
		 if (ae.getSource()==checkprice){
			 try{
			 Conn c = new Conn();
			 ResultSet rs =c.s.executeQuery("Select * from hotel where name='" +chotel.getSelectedItem()+"'");
			 while (rs.next()){
				 int cost = Integer.parseInt(rs.getString("costperperson"));
				 int food = Integer.parseInt(rs.getString("foodincluded"));
			     int ac = Integer.parseInt(rs.getString("acroom"));
				 
				 int persons = Integer.parseInt(tfpersons.getText());
				 int days = Integer.parseInt(tfdays.getText());
				 String acselected =cac.getSelectedItem();
				 String foodselected = cfood.getSelectedItem();
				 
				 if (persons*days> 0){
					 int total=0;
					 total+=acselected. equals ("AC") ? ac: 0;
					 total += foodselected.equals("Yes") ? food: 0;
					 total += cost;
					 total = total*persons*days;
					 
					 labelprice.setText(total+"TK/-");
				 } else{
					 JOptionPane.showMessageDialog(null,"Please Enter a Valid Number");
				 }
			 } }catch(Exception e) {
				 e.printStackTrace();
			 } 
			 }
			 else if(ae.getSource()==bookpackage){
				 try{
					 Conn c= new Conn();
					 c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelprice.getText()+"')");
					 JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
					 setVisible(false);
					 new Package_Hotel("");
				 }catch(Exception e){
					 e.printStackTrace();
				 }
			 }else{
				 setVisible(false);
				 new Package_Hotel("");
			 }
	       }
	 }