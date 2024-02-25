import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Register extends JFrame implements ActionListener {
    
	JButton create, back;
	JTextField  tfusername, tfpassword ,tfcomfirmpass, tfemail;
	JPasswordField pfconfirmpass, pfpassword;
	Choice security;
	

    public Register() {
        setTitle("Registration");
        setBounds(350,200,850,380);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
        

        JPanel p1 = new JPanel();
		
		p1.setBounds(0,0,500,400);
		p1.setLayout(null);
		add(p1);
		
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ico.jpg"));    
    setIconImage(icon);

        JLabel lblusername = new JLabel("Username");
		lblusername.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
		lblusername.setBounds(50,20,125,25);
		p1.add(lblusername);

        tfusername = new JTextField();
		tfusername.setBounds(190,20,180,25);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfusername);

        JLabel lblpassword = new JLabel("Password");
		lblpassword.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
		lblpassword.setBounds(50,60,125,25);
		p1.add(lblpassword);

        pfpassword= new JPasswordField();
		pfpassword.setBounds(190,60,180,25);
		pfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(pfpassword);
        
		
		JLabel lblcomfirmpass = new JLabel("Confirm Password:");
		lblcomfirmpass.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
		lblcomfirmpass.setBounds(50,100,125,25);
		p1.add(lblcomfirmpass);
		
		
        pfconfirmpass= new JPasswordField();
		pfconfirmpass.setBounds(190,100,180,25);
		pfconfirmpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(pfconfirmpass);
		
      

        JLabel lblemail = new JLabel("Email:");
		lblemail.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        lblemail.setBounds(50,140,125,25);
        p1.add(lblemail);

        tfemail = new JTextField();
		tfemail.setBounds(190,140,180,25);
		tfemail.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfemail);

		create = new JButton("Create");
		create.setBackground(Color.BLACK);
		create.setForeground(Color.WHITE);
		create.setFont(new Font("Tahoma",Font.BOLD,14));
		create.setBounds(80,250,100,30);
		create.addActionListener(this);
		p1.add(create);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Tahoma",Font.BOLD,14));
		
		back.setBounds(250,250,100,30);
		back.addActionListener(this);
		p1.add(back);
		
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/images/P1.png"));
	    Image i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
	    JLabel image = new JLabel(i3);
	    image.setBounds(580,50,250,250);
	    add(image);
		
		

        add(p1);
        setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String username = tfusername.getText();
            String password = new String(pfpassword.getPassword());
            String confirmPassword = new String(pfconfirmpass.getPassword());
            String email = tfemail.getText();

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords does not match.");
                return;
            }

            
            String verificationCode = String.valueOf((int) (Math.random() * 10000));
			 String otp = String.valueOf((int) (Math.random() * 10000));
            
			String query = "insert into account values ('"+username+"', '"+password+"', '"+confirmPassword+"','"+email+"', '"+verificationCode+"','"+otp+"')";
			
            try 
			{
				 Conn c = new Conn();
				 c.s.executeUpdate(query);
				
               				
				setVisible(false);
				new VerificationCodeMailer();
				
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Registration failed. Please try again later.");
            }
        }else if(ae.getSource() == back)
		{
			setVisible(false);
			new Login();
		}
    }

   
}
