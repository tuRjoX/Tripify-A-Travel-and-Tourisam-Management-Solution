import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class ForgetPassword extends JFrame implements ActionListener
{
	JLabel lblpass, lblconfirmPass;
	JTextField tfpass, tfconfirmPass;
	JButton confirm, back;
	
	
	public ForgetPassword()
	{
		setBounds(350,200,850,380);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
		JPanel p1 = new JPanel();
		p1.setBounds(0,0,500,400);
		p1.setLayout(null);
		add(p1);
		
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ico.jpg"));    
		setIconImage(icon);
		
		lblpass = new JLabel("Enter new password");
		lblpass.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
		lblpass.setBounds(100,55,200,25);
		p1.add(lblpass);
		
		lblconfirmPass = new JLabel("Retype new password");
		lblconfirmPass.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
		lblconfirmPass.setBounds(100,145,200,25);
		p1.add(lblconfirmPass);
		
		
		tfpass = new JTextField();
		tfpass.setBounds(100,90,180,35);
		tfpass.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfpass);
		
		tfconfirmPass = new JTextField();
		tfconfirmPass.setBounds(100,180,180,35);
		tfconfirmPass.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfconfirmPass);
		
		confirm = new JButton("Confirm");
		confirm.setBackground(Color.BLACK);
		confirm.setForeground(Color.WHITE);
		confirm.setFont(new Font("Tahoma",Font.BOLD,14));
		confirm.setBounds(80,250,100,30);
		confirm.addActionListener(this);
		p1.add(confirm);
		
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Tahoma",Font.BOLD,14));
		back.setBounds(250,250,100,30);
		back.addActionListener(this);
		p1.add(back);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/images/P6.png"));
	    Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
	    JLabel image = new JLabel(i3);
	    image.setBounds(580,50,250,250);
	    add(image);
		
		add(p1);
        setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		 if (ae.getSource() == confirm)
		 {
			 try{
				String password = tfpass.getText();
				String confirmPassword = tfconfirmPass.getText();
				
				if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match.");
                return;
				}
            
				String query = "UPDATE account SET password = '"+tfpass.getText()+"'";
                Conn c = new Conn();
				c.s.executeUpdate(query);
                

                JOptionPane.showMessageDialog(this, "Password updated successfully");
				
				setVisible(false);
				new Login();
		
			 }catch (Exception e){
			e.printStackTrace();}
		 }else{
			 setVisible(false);
			 new Fpassword();
		 }
	}
	
}