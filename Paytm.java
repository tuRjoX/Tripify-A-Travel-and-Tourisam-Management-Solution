import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Paytm extends JFrame implements ActionListener {
	
	// Initialize the JFrame
	public Paytm() {
		setBounds(500, 200, 800, 600);
		
		// Create a JPanel with a background image
		ImageIcon i1 = new ImageIcon("bkash-rocket-nagad_-2002280630.png");
		Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
		ImageIcon  i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 800, 600);
		add(image); 
		
		// Create text fields and labels
		JPasswordField value = new JPasswordField();
		JTextField label2 = new JTextField();
		JTextField name = new JTextField();
		JTextField number = new JTextField();
		
        value.setBounds(210,400,100,35);		
		value.setBounds(230, 400, 100, 35);
		label2.setBounds(210, 150, 120, 35);
		number.setBounds(210,250,130,35);
		
		JLabel lP = new JLabel("Password:");
		JLabel l = new JLabel("exp month:");
		JLabel l1 = new JLabel("exp year:");
		JLabel l2 = new JLabel("name:");
		JLabel l3 = new JLabel("Number:");
			
		lP.setBounds(145, 400, 80, 30);    
		l.setBounds(138, 200, 100, 30);
		l2.setBounds(170, 150, 100, 30);
		l3.setBounds(150,250,100,30);
			
			String[] options = {"Bkash", "Rocket", "Nagad"};
			JComboBox<String> dropdown = new JComboBox<>(options);
			dropdown.setBounds(220, 200, 100, 30);
			image.add(dropdown);
			
		image.add(lP);
		image.add(l);
		image.add(l2);
		image.add(value);
		image.add(label2);
		image.add(name);
		image.add(number);
		image.add(l3);

		
		// Create the back button
		JButton back = new JButton("back");
		back.setBounds(610, 20, 80, 80);
		back.addActionListener(this);
		image.add(back);
		
		JButton b = new JButton("paid");
		   b.setBounds(400,400,100,40);
		   b.addActionListener(this);
		   image.add(b);
		   			b.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
		String input = JOptionPane.showInputDialog(null,"enter correct info");
        if (input.equals("done")) {
            // do something if the condition is true			
			JOptionPane.showMessageDialog(null, "payment done.you can go back");
        
		}else {
            // do something else if the condition is false
			JOptionPane.showMessageDialog( null, "payment not done");
        }
        }
     });

		
		// Set the frame visible after adding all components
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		// Create an instance of the Payment class
		setVisible(false);
		new Payment();
	}
}