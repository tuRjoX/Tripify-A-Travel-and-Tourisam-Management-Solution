import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class About extends JFrame
{
	private Container c;
	private ImageIcon icon, logo;
	private JLabel label1, label2, label3, label4, label5,label6, imgLabel1, imgLabel2, imgLabel3 ;
	private Font f1,f2,f3,f4,f5,f6,f7,f8,f9;
    private JButton btn1, btn2, btn3;

	About()
	{
		// Frame Layout
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("About Us");
		this.setSize(850,550);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
		
		c = this.getContentPane();
        c.setLayout(null);
		c.setBackground(Color.decode("#F6FCFF"));
		
		// Icon
        icon = new ImageIcon(getClass().getResource("/images/P1.png"));
        this.setIconImage(icon.getImage());
		
		// Logo and Images
        logo = new ImageIcon(getClass().getResource("/images/about.png"));
        imgLabel1 = new JLabel(logo);
        imgLabel1.setBounds(45, 250, logo.getIconWidth(), logo.getIconHeight());
        c.add(imgLabel1);
		
		logo = new ImageIcon(getClass().getResource("/images/mail.png"));
        imgLabel2 = new JLabel(logo);
        imgLabel2.setBounds(550, 325, logo.getIconWidth(), logo.getIconHeight());
        c.add(imgLabel2);
		
		// Fonts
        f1 = new Font("Tahoma", Font.BOLD, 15);
        f2 = new Font("Times New Roman", Font.BOLD, 45);
        f3 = new Font("Times New Roman", Font.BOLD, 35);
        f4 = new Font("Tahoma", Font.PLAIN, 15);
		
		// JButtons
		btn2 = new JButton("E-mail");
        btn2.setBounds(690, 455, 110, 25);
        btn2.setFont(f1);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#000000"));
        c.add(btn2);
		
		btn3 = new JButton("Back");
        btn3.setBounds(30, 30, 80, 25);
        btn3.setFont(f1);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#000000"));
        c.add(btn3);
		
		// Title
        label1 = new JLabel();
        label1.setText("About Us");
        label1.setBounds(325, 10, 300, 50);
        label1.setFont(f2);
		label1.setForeground(Color.decode("#FF0000"));
        c.add(label1);
		
		label2 = new JLabel();
        label2.setText("Our Team");
        label2.setBounds(30, 75, 300, 50);
        label2.setFont(f3);
		label2.setForeground(Color.decode("#0000FF"));
        c.add(label2);
		
		String text = "<html>Turjo Das Dip (22-48558-3)<br>" +
              "Shaily Saha (22-48530-3)<br>" +
              "Pretom Chandra Roy (22-48556-3)<br>" +
              "Kingkor Karmoker Mughdho (22-48573-3)<br>" +
              "Mutahhara Takia Jaman (22-48334-3)</html>";

		JLabel label3 = new JLabel(text);
		label3.setBounds(30, -30, 300, 400);
		label3.setFont(f4);
		label3.setForeground(Color.decode("#000000"));
		c.add(label3);
		
		label4 = new JLabel();
        label4.setText("Our Mission & Vision");
        label4.setBounds(425, 75, 425, 50);
        label4.setFont(f3);
		label4.setForeground(Color.decode("#0000FF"));
        c.add(label4);
		
		String text1 = "<html>To provide exceptional travel experiences<br>" +
              "by offering personalized and convenient<br>" +
              "services. <br><br>" +
              "To become the leading travel and tourism<br>" +
              "management system that offers best to the<br>" +
              "customers.</html>";
		JLabel label5 = new JLabel(text1);
		label5.setBounds(430, -15, 300, 400);
		label5.setFont(f4);
		label5.setForeground(Color.decode("#000000"));
		c.add(label5);
		
		label6 = new JLabel();
        label6.setText("E-mail Us >>");
        label6.setBounds(475, 440, 425, 50);
        label6.setFont(f3);
		label6.setForeground(Color.decode("#0000FF"));
        c.add(label6);

		
        
		//Ratings
		btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                Dashboard frame = new Dashboard("");
                frame.setVisible(true);
            }
        });
		
		// E-mail Button
		btn2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				try 
				{
					URI mailto = new URI("mailto:tripifyyy@gmail.com");
					Desktop.getDesktop().mail(mailto);
				} 
				catch (IOException | URISyntaxException ex) 
				{
					ex.printStackTrace();
				}
			}
		});

	}
}