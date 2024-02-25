import javax.swing.*;    
import java.awt.*;
import java.awt.event.*;  
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class Dashboard extends JFrame implements ActionListener{
	String username;
	JButton account,ph,reviewUs,contactUs,payments;
	JButton logout;
	JButton aboutUs;
	JLabel clockLabel,dateLabel;
	
	Dashboard(String username){
		this.username=username;
		    
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ico.jpg"));    
		setIconImage(icon);
		
		dateLabel = new JLabel();
		dateLabel.setBounds(455, 70, 200, 30);
		dateLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(dateLabel);
		
		clockLabel = new JLabel();
        clockLabel.setBounds(450, 50, 200, 30);
		clockLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(clockLabel);
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateClock();
				updateDate();
            }
        });
        timer.start();
        updateClock();
		updateDate();
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/images/bg.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(250,20,500,470);
		add(image); 
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(0,0,800,570);
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		
		account=new JButton("Account");
		account.setBounds(10,30,200,30);
		account.setBackground(new Color(0,0,0));
		account.setForeground(Color.WHITE);
		account.addActionListener(this);
		add(account);
		
		ph=new JButton("Packages & Hotels");
		ph.setBounds(10,70,200,30);
		ph.setBackground(new Color(0,0,0));
		ph.setForeground(Color.WHITE);
		ph.addActionListener(this);
		add(ph);
		
		payments=new JButton("Payments");
		payments.setBounds(10,110,200,30);
		payments.setBackground(new Color(0,0,0));
		payments.setForeground(Color.WHITE);
		payments.addActionListener(this);
		add(payments);
		
		contactUs=new JButton("Contact Us");
		contactUs.setBounds(10,150,200,30);
		contactUs.setBackground(new Color(0,0,0));
		contactUs.setForeground(Color.WHITE);
		contactUs.addActionListener(this);
		add(contactUs);
		
		reviewUs=new JButton("Review Us");
		reviewUs.setBounds(10,190,200,30);
		reviewUs.setBackground(new Color(0,0,0));
		reviewUs.setForeground(Color.WHITE);
		reviewUs.addActionListener(this);
		add(reviewUs);
		
		aboutUs=new JButton("About Us");
		aboutUs.setBounds(10,230,200,30);
		aboutUs.setBackground(new Color(0,0,0));
		aboutUs.setForeground(Color.WHITE);
		aboutUs.addActionListener(this);
        add(aboutUs);
		
		logout=new JButton("Log Out");
		logout.setBounds(10,430,200,30);
		logout.setBackground(new Color(0,0,0));
		logout.setForeground(Color.WHITE);
		logout.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            new Login();
            dispose();
        }
    }
   });
		add(logout);

	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==account){
			new Account(username);
			setVisible(false);
		}else if(ae.getSource() == ph){
		    new Package_Hotel(username);
			setVisible(false);
		}else if(ae.getSource() == logout) {
			setVisible(false);
			new Login();
        }else if(ae.getSource() == payments){
		    Payment payFrame = new Payment();
            setVisible(false);
            payFrame.setVisible(true);
            dispose();
		}else if(ae.getSource()==aboutUs){
			About aboutFrame = new About();
            setVisible(false);
            aboutFrame.setVisible(true);
            dispose();
		}else if(ae.getSource()==reviewUs){
			Rate rateFrame = new Rate();
            setVisible(false);
            rateFrame.setVisible(true);
            dispose();
		}else if(ae.getSource()==contactUs){
			Contact contactFrame = new Contact();
            setVisible(false);
            contactFrame.setVisible(true);
            dispose();
		}
	}
	void updateClock() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
        String time = dateFormat.format(new Date());
        clockLabel.setText(time);
    }
	void updateDate() {
    SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
    String time = timeFormat.format(new Date());
        dateLabel.setText(time);
	}
}