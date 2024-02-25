import javax.swing.*;
import java.sql.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Fpassword extends JFrame implements ActionListener {
     JLabel emailLabel, codeLabel, lblenteremail ;
     JTextField emailField, tfenteremail;
     JButton sendButton, confirm, back;

    public Fpassword() {
		
		setBounds(350,200,850,380);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel p1 = new JPanel();
	    p1.setLayout(null);
	    p1.setBounds(400,30,450,300);
	    add(p1);
		
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ico.jpg"));    
		setIconImage(icon);
		
		lblenteremail = new JLabel("Enter Email ");
		lblenteremail.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
		lblenteremail.setBounds(120,60,200,30);
		p1.add(lblenteremail);
		
		tfenteremail = new JTextField();
		tfenteremail.setBounds(120,95,180,35);
		tfenteremail.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfenteremail);
		
		confirm = new JButton("Confirm");
		confirm.setBackground(Color.BLACK);
		confirm.setForeground(Color.WHITE);
		confirm.setFont(new Font("Tahoma",Font.BOLD,14));
		confirm.setBounds(80,250,100,30);
		confirm.setBorder(new LineBorder(Color.BLACK));
		confirm.addActionListener(this);
		p1.add(confirm);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Tahoma",Font.BOLD,14));
		back.setBounds(250,250,100,30);
		back.setBorder(new LineBorder(Color.BLACK));
		back.addActionListener(this);
		p1.add(back);
		
        emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);
        codeLabel = new JLabel("Verification Code:");
        sendButton = new JButton("Send");
        sendButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(codeLabel);
        panel.add(sendButton);
        add(panel);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/images/P5.png"));
	    Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
	    JLabel image = new JLabel(i3);
	    image.setBounds(100,100,200,200);
	    add(image);

        add(p1);
        setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

   public void actionPerformed(ActionEvent ae) {
        String email = tfenteremail.getText();
        if (ae.getSource() == confirm) {
            try {
                
                   String query =("select * from account where email = '" + email + "'");
				   Conn c = new Conn();
				   ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    String code = rs.getString("otp");

                    
                    Properties props = new Properties();
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.port", "587");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.enable", "true");

                    Session session = Session.getInstance(props, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("tripifyyy@gmail.com", "vyaouvqsuvjoqlxl");
                        }
                    });

                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("tripifyyy@gmail.com"));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                    message.setSubject("Verification Code");
                    message.setText("Your verification code is: " + code);

                    Transport.send(message);

                    JOptionPane.showMessageDialog(this, "Verification code sent to " + email);
					setVisible(false);
					new Otp1();
					
                } else {
                    JOptionPane.showMessageDialog(this, "Email not found");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else if(ae.getSource() == back){
			setVisible(false);
			new Login();
        }else {
			JOptionPane.showMessageDialog(this, "Email field cannot be empty");
		}
    }

   
}