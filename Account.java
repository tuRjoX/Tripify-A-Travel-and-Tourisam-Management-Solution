import javax.swing.*;    
import java.awt.*;
import java.awt.event.*;  

public class Account extends JFrame implements ActionListener{
	String username;
	JButton addPersonalDetails;
	JButton viewPersonalDetails;
	JButton updatePersonalDetails;
	JButton deletePersonalDetails;
	JButton back;
	
	Account(String username){
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ico.jpg"));    
		setIconImage(icon); 
		
		this.username=username;
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/images/account.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(250,20,500,470);
		setLocationRelativeTo(null);
		add(image); 
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(0,0,800,570);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		
		addPersonalDetails=new JButton("Add Personal Details");
		addPersonalDetails.setBounds(10,30,200,30);
		addPersonalDetails.setBackground(new Color(0,0,0));
		addPersonalDetails.setForeground(Color.WHITE);
		addPersonalDetails.addActionListener(this);
		add(addPersonalDetails);
		
		updatePersonalDetails=new JButton("Update Personal Details");
		updatePersonalDetails.setBounds(10,70,200,30);
		updatePersonalDetails.setBackground(new Color(0,0,0));
		updatePersonalDetails.setForeground(Color.WHITE);
		updatePersonalDetails.addActionListener(this);
		add(updatePersonalDetails);
		
		viewPersonalDetails = new JButton("View Personal Details");
		viewPersonalDetails.setBounds(10,110,200,30);
		viewPersonalDetails.setBackground(new Color(0,0,0));
		viewPersonalDetails.setForeground(Color.WHITE);
		viewPersonalDetails.addActionListener(this);
		add(viewPersonalDetails);
		
		deletePersonalDetails=new JButton("Delete Personal Details");
		deletePersonalDetails.setBounds(10,150,200,30);
		deletePersonalDetails.setBackground(new Color(0,0,0));
		deletePersonalDetails.setForeground(Color.WHITE);
		deletePersonalDetails.addActionListener(this);
		add(deletePersonalDetails);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(60,430,100,25);
		back.addActionListener(this);
		add(back);	
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==addPersonalDetails){
			new AddCustomer(username);
			setVisible(false);
		}else if(ae.getSource() == updatePersonalDetails){
		    new UpdateCustomer(username);
			setVisible(false);
		}else if(ae.getSource() == viewPersonalDetails){
		    new ViewCustomer(username);
			setVisible(false);
		}else if(ae.getSource() == deletePersonalDetails){
		    new DeleteDetails(username);
			setVisible(false);
		}
		else{
			setVisible(false);
			new Dashboard("");
			}
	}
}