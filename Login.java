import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.imageio.*;
import javax.swing.ImageIcon;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame implements ActionListener
{
	JButton login, signup, password,guest;
	JTextField tfusername;
    JPasswordField tfpassword;
    JToggleButton eyeButton;
	
	Login(){
	JFrame f=new JFrame("Login Screen");
		
	setSize(900,400);
	setLocation(350,200);
	setLayout(null);
	
	getContentPane().setBackground(Color.WHITE);
	
	JPanel p1 = new JPanel();
	p1.setBackground(Color.WHITE);
	p1.setBounds(0,0,400,400);
	p1.setLayout(null);
	add(p1);
	
	ImageIcon i1 = new ImageIcon(getClass().getResource("/images/P1.png"));
	Image i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);
	JLabel image = new JLabel(i3);
	image.setBounds(100,120,200,200);
	p1.add(image);
	
	JPanel p2 = new JPanel();
	p2.setLayout(null);
	p2.setBounds(400,30,450,300);
	add(p2);
	
	JLabel lblusername = new JLabel("Username");
	lblusername.setBounds(60,20,100,25);
	lblusername.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	p2.add(lblusername);
	
	 tfusername = new JTextField();
	tfusername.setBounds(60,60,300,30);
	tfusername.setBorder(BorderFactory.createEmptyBorder());
	p2.add(tfusername);
	
	JLabel lblpassword = new JLabel("Password");
	lblpassword.setBounds(60,110,100,25);
	lblpassword.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	p2.add(lblpassword);
	
	tfpassword = new JPasswordField();
        tfpassword.setBounds(60, 150, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        eyeButton = new JToggleButton(new ImageIcon(getClass().getResource("/images/eye.png")));
        eyeButton.setBounds(370, 150, 30, 30);
        eyeButton.setBorderPainted(false);
        eyeButton.addActionListener(this);
        p2.add(eyeButton);
	
	
	 login = new JButton("Login");
	login.setBounds(60,200,130,30);
	login.setBackground(Color.BLACK);
	login.setForeground(Color.WHITE);
	login.setBorder(new LineBorder(Color.BLACK));
	login.addActionListener(this);
	p2.add(login);
	
	 signup = new JButton("Signup");
	signup.setBounds(230,200,130,30);
	signup.setBackground(Color.BLACK);
	signup.setForeground(Color.WHITE);
	signup.setBorder(new LineBorder(Color.BLACK));
	signup.addActionListener(this);
	p2.add(signup);
	
	password = new JButton("Forget Password");
	password.setBounds(60,250,130,30);
	password.setBackground(Color.BLACK);
	password.setForeground(Color.WHITE);
	password.setBorder(new LineBorder(Color.BLACK));
	password.addActionListener(this);
	p2.add(password);
	
	guest = new JButton("Guest");
	guest.setBounds(230,250,130,30);
	guest.setBackground(Color.BLACK);
	guest.setForeground(Color.WHITE);
	guest.setBorder(new LineBorder(Color.BLACK));
	guest.addActionListener(this);
	p2.add(guest);
	
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
	
	}
	
	public void actionPerformed(ActionEvent ae)
{
    if (ae.getSource() == eyeButton) {
        if (eyeButton.isSelected()) {
            tfpassword.setEchoChar((char) 0); // Show the password
        } else {
            tfpassword.setEchoChar('*'); // Hide the password
        }
    }else if(ae.getSource() == login)
    {
        try {
            String username = tfusername.getText();
            String pass = tfpassword.getText();
            
            if (username.equals("admin") && pass.equals("admin")) {
                setVisible(false);
                new Packages();
            } else {
                String query = "select * from account where username = '"+username+"' AND password = '"+pass+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Dashboard("");
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else if (ae.getSource() == signup) {
        setVisible(false);
       new Register();
    } else if (ae.getSource() == guest) {
        setVisible(false);
       new CheckPackage();
    }else {
        setVisible(false);
        new Fpassword();
    }
}   
	

}