import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Contact extends JFrame {
    private Container d;
    private ImageIcon icon, logo;
    private JLabel label1, nameLabel, emailLabel, emptyLabel, imgLabel1, imgLabel2, imgLabel3;
    private JButton btn1, btn2, btn4, btn5;
    private Font f1, f2, f3, f4;
    private JTextField nameField, emailField;
    private JTextArea emptyArea;

    Contact() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Contact Us");
        this.setSize(850, 550);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        d = this.getContentPane();
        d.setLayout(null);
        d.setBackground(Color.decode("#65DFF6"));
		
		// Icon
        icon = new ImageIcon(getClass().getResource("/images/P1.png"));
        this.setIconImage(icon.getImage());
		
		// Logo and Images
        logo = new ImageIcon(getClass().getResource("/images/phone.jpg"));
        imgLabel1 = new JLabel(logo);
        imgLabel1.setBounds(47, 30, logo.getIconWidth(), logo.getIconHeight());
        d.add(imgLabel1);
		
		logo = new ImageIcon(getClass().getResource("/images/location.jpg"));
        imgLabel2 = new JLabel(logo);
        imgLabel2.setBounds(315, 30, logo.getIconWidth(), logo.getIconHeight());
        d.add(imgLabel2);
		
		logo = new ImageIcon(getClass().getResource("/images/Mail.jpg"));
        imgLabel3 = new JLabel(logo);
        imgLabel3.setBounds(583, 30, logo.getIconWidth(), logo.getIconHeight());
        d.add(imgLabel3);
		
        // Fonts
        f1 = new Font("Tahoma", Font.BOLD, 15);
        f2 = new Font("Times New Roman", Font.BOLD, 45);
        f3 = new Font("Times New Roman", Font.BOLD, 35);
        f4 = new Font("Tahoma", Font.BOLD, 15);

        // JTextFields
        nameLabel = new JLabel("Your Name : ");
        nameLabel.setBounds(150, 220, 100, 30);
        nameLabel.setFont(f4);
        d.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(250, 220, 400, 30);
        nameField.setFont(f4);
        d.add(nameField);

        emailLabel = new JLabel("Your E-mail : ");
        emailLabel.setBounds(150, 270, 100, 30);
        emailLabel.setFont(f4);
        d.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(250, 270, 400, 30);
        emailField.setFont(f4);
        d.add(emailField);

        emptyLabel = new JLabel("Comment : ");
        emptyLabel.setBounds(150, 320, 100, 30);
        emptyLabel.setFont(f4);
        d.add(emptyLabel);

        emptyArea = new JTextArea();
        emptyArea.setBounds(250, 320, 400, 120);
        emptyArea.setFont(f4);
        emptyArea.setLineWrap(true);
        d.add(emptyArea);

        // JButton
        btn1 = new JButton("Submit");
        btn1.setBounds(300, 457, 100, 30);
        btn1.setFont(f1);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#000000"));
		
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				try{
				Conn c = new Conn();
				String query = "insert into contacts values ('" + nameField.getText() + "', '" + emailField.getText() + "', '" + emptyArea.getText() + "')";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(d, "Thank you for your submission!");
				setVisible(false);
                Dashboard frame = new Dashboard("");
                frame.setVisible(true);
			}catch (Exception ae) {
            ae.printStackTrace();
			}
                
            }
        });
        d.add(btn1);
		
		// JButtons
		btn4 = new JButton("Back");
        btn4.setBounds(450, 457, 80, 30);
        btn4.setFont(f1);
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(Color.decode("#000000"));
        d.add(btn4);
		
		//Back
		btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                Dashboard frame = new Dashboard("");
                frame.setVisible(true);
            }
        });
        // Title
        label1 = new JLabel();
        label1.setText("Contact Us");
        label1.setBounds(310, 155, 300, 50);
        label1.setFont(f2);
        label1.setForeground(Color.decode("#151983"));
        d.add(label1);
		
        // Upper panel
        JPanel upperPanel = new JPanel();
        upperPanel.setBounds(0, 0, 850, 130);
        upperPanel.setBackground(Color.decode("#00008B"));
        d.add(upperPanel);
		
        // Lower panel
        JPanel lowerPanel = new JPanel();
        lowerPanel.setBounds(0, 130, 850, 420);
        lowerPanel.setBackground(Color.decode("#04D4F0"));
        d.add(lowerPanel);
    }
}
