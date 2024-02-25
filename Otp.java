import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Otp extends JFrame implements ActionListener
{
	JLabel lblenterOtp;
	JTextField tfenterOtp;
	JButton confirm, back;
	
	
	public Otp()
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
		
		lblenterOtp = new JLabel("Enter OTP");
		lblenterOtp.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
		lblenterOtp.setBounds(100,50,125,25);
		p1.add(lblenterOtp);
		
		
		tfenterOtp = new JTextField();
		tfenterOtp.setBounds(100,90,180,35);
		tfenterOtp.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfenterOtp);
		
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
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/images/P3.png"));
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
				String otp = tfenterOtp.getText();
				String query = "select * from account where verificationCode = '"+tfenterOtp.getText()+"'";
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				if(rs.next()){
					 JOptionPane.showMessageDialog(null, "Registration successful.");
					setVisible (false);
					new Login();
				}else{
					JOptionPane.showMessageDialog(null, "OTP Incorrect");
				}
				
		
			 }catch (Exception e){
			e.printStackTrace();}
		 }else{
			 setVisible(false);
			 new VerificationCodeMailer();
		 }
	}
	
}