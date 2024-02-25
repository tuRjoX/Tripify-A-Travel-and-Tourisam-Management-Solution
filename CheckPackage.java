import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckPackage extends JFrame implements ActionListener {
    JButton booknow, back;

    public CheckPackage() {
        setBounds(450, 200, 900, 600);
		
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ico.jpg"));    
		setIconImage(icon); 

        String[] package1 = {"GOLD PACKAGE", "6 Days & 7 Nights", "Airport Assistance", "Half Day City Tour",
                "Daily Buffet", "Soft Drinks Free", "Speaking Guide", "Summer Special", "Rs 12000/-", "/images/package1.jpg"};
        String[] package2 = {"SILVER PACKAGE", "5 Days & 7 Nights", "Toll Free ", "Entrance Free Tickets",
                "Meet & Greet at Airport", "Night Safari", "Cruise with Dinner", "Winter Special", "Rs 24000/-",
                "/images/package2.jpg"};
        String[] package3 = {"BRONZE PACKAGE", "6 Days & 5 Nights ", "Return Airfare", "Free Clubbing & Horse Riding",
                "Hard Drinks Free", "Daily Buffet", "BBQ Dinner", "Winter Special", "Rs 32000/-", "/images/package3.jpg"};

        JTabbedPane tab = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1", null, p1);

        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2", null, p2);

        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3", null, p3);

        add(tab);
setLayout(new BorderLayout());
        add(tab, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        booknow = new JButton("Book Now");
        booknow.setBackground(Color.YELLOW);
        booknow.setForeground(Color.BLACK);
        booknow.setFont(new Font("Tahoma", Font.BOLD, 35));
        booknow.addActionListener(this);
        buttonPanel.add(booknow);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public JPanel createPackage(String[] pack) {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);

        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(50, 5, 300, 30);
        l1.setForeground(Color.MAGENTA);
        l1.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(l1);

        JLabel l3 =new JLabel(pack[2]);
	l3.setBounds (30,110,300,30);
	l3.setForeground(Color.BLUE);
	l3.setFont(new Font("tahoma",Font.BOLD,20));
	p1.add(l3);
	
	JLabel l4 =new JLabel(pack[3]);
	l4. setBounds (30,160,300,30);
	l4.setForeground(Color.BLACK);
	l4.setFont(new Font("tahoma",Font.BOLD,20));
	p1.add(l4);
	
	JLabel l5 =new JLabel(pack[4]);
	l5. setBounds (30,210,300,30);
	l5.setForeground(Color.BLUE);
	l5.setFont(new Font("tahoma",Font.BOLD,20));
	p1.add(l5);
	
	JLabel l6 =new JLabel(pack[5]);
	l6. setBounds (30,260,300,30);
	l6.setForeground(Color.BLACK);
	l6.setFont(new Font("tahoma",Font.BOLD,20));
	p1.add(l6);
	
	JLabel l7 =new JLabel(pack[6]);
	l7. setBounds (30,310,300,30);
	l7.setForeground(Color.BLUE);
	l7.setFont(new Font("tahoma",Font.BOLD,20));
	p1.add(l7);
	
	JLabel l8 =new JLabel(pack[7]);
	l8. setBounds (30,360,300,30);
	l8.setForeground(Color.BLACK);
	l8.setFont(new Font("tahoma",Font.BOLD,25));
	p1.add(l8);

	JLabel l10 =new JLabel(pack[8]);
	l10. setBounds (500,400,300,30);
	l10.setForeground(Color.MAGENTA);
	l10.setFont(new Font("tahoma",Font.BOLD,20));
	
	p1.add(l10);
	
	ImageIcon i1=new ImageIcon(getClass().getResource(pack[9]));
	Image i2 =i1 .getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i2);
	JLabel l11=new JLabel(i3);
	l11.setBounds (350,20,500,300);
	p1.add(l11);
	

        return p1;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == booknow) {
            Register register = new Register();
            register.setVisible(true);
            setVisible(false);
        }
    }
}
