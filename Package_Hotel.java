import javax.swing.*;    
import java.awt.*;
import java.awt.event.*;  
import javax.swing.ImageIcon;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class Package_Hotel extends JFrame implements ActionListener,Runnable{
	String username;
	JButton bookPackages;
	JButton viewBookedHotel;
	JButton viewPackages;
	JButton bookHotels;
	JButton back;
	JLabel clockLabel,dateLabel;
	Thread t1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JLabel[] label= new JLabel[]{l1,l2,l3,l4,l5,l6,l7,l8};
	public void run (){
		while (true) {
		  try {
			for(int i=0;i<=7; i++){
				label[i].setVisible(true);
				Thread.sleep(2500);
				label[i].setVisible(false);
			}
		    }
		catch (Exception e){
			e.printStackTrace();
	        }
	    }
	}
	
	Package_Hotel(String username){
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ico.jpg"));    
		setIconImage(icon); 
		
		this.username=username;
		
		dateLabel = new JLabel();
		dateLabel.setBounds(355, 70, 200, 30);
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(dateLabel);
		
		clockLabel = new JLabel();
        clockLabel.setBounds(350, 50, 200, 30);
		clockLabel.setForeground(Color.WHITE);
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
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(0,0,800,570);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		
		bookPackages=new JButton("Book Packages");
		bookPackages.setBounds(10,190,200,30);
		bookPackages.setBackground(new Color(0,0,0));
		bookPackages.setForeground(Color.WHITE);
		bookPackages.addActionListener(this);
		add(bookPackages);
		
		viewPackages=new JButton("View Booked Packages");
		viewPackages.setBounds(10,230,200,30);
		viewPackages.setBackground(new Color(0,0,0));
		viewPackages.setForeground(Color.WHITE);
		viewPackages.addActionListener(this);
		add(viewPackages);
		
		bookHotels=new JButton("Book Hotel");
		bookHotels.setBounds(10,270,200,30);
		bookHotels.setBackground(new Color(0,0,0));
		bookHotels.setForeground(Color.WHITE);
		bookHotels.addActionListener(this);
		add(bookHotels);
		
		viewBookedHotel=new JButton("View Booked Hotel");
		viewBookedHotel.setBounds(10,310,200,30);
		viewBookedHotel.setBackground(new Color(0,0,0));
		viewBookedHotel.setForeground(Color.WHITE);
		viewBookedHotel.addActionListener(this);
		add(viewBookedHotel);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(60,430,100,25);
		back.addActionListener(this);
		add(back);
		
		//setBounds(350,200,800,570);
		
		ImageIcon i1= null,i2=null,i3=null,i4=null,i5=null,i6=null,i7=null,i8=null;
		ImageIcon[] image=new ImageIcon[]{i1,i2,i3,i4,i5,i6,i7,i8};
		
		Image j1= null,j2=null,j3=null,j4=null,j5=null,j6=null,j7=null,j8=null;
		Image[] jimage=new Image[]{j1,j2,j3,j4,j5,j6,j7,j8};
		
		
		ImageIcon k1= null,k2=null,k3=null,k4=null,k5=null,k6=null,k7=null,k8=null;
		ImageIcon[] kimage=new ImageIcon[]{k1,k2,k3,k4,k5,k6,k7,k8};
		
		
		for(int i=0;i<=7;i++){
		image[i] = new ImageIcon(ClassLoader.getSystemResource("images/hotel" + (i + 1) + ".jpg"));
		jimage[i]= image[i].getImage().getScaledInstance(800,570,Image.SCALE_DEFAULT);
		kimage[i]=new ImageIcon(jimage[i]);
		label [i] =new JLabel(kimage[i]);
		label[i].setBounds(0,0,800,570);
		add(label[i]);
		}
		t1=new Thread(this);
		t1.start();
		setVisible(true);
			
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == bookPackages){
		    new BookPackage(username);
			setVisible(false);
		}else if(ae.getSource() == bookHotels){
		    new BookHotel(username);
			setVisible(false);
		}else if(ae.getSource() == viewBookedHotel){
		    new ViewBookedHotel(username);
			setVisible(false);
		}else if(ae.getSource() == viewPackages){
		    new ViewPackage(username);
			setVisible(false);
		}
		else{
			setVisible(false);
			new Dashboard("");
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