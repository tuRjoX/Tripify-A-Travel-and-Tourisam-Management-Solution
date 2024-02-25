import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.*;
import java.util.List;
import java.sql.*;
import net.proteanit.sql.DbUtils;

import static javax.swing.JOptionPane.showMessageDialog;

@SuppressWarnings("unchecked")
public class AddHotel extends JFrame
{
	private Container d;
    private ImageIcon icon;
    private JLabel label1,label2, label3, label4, label5, label6, label7;
    private Font f1, f2, f3, f4, f5, f6;
    private JTextField tf1, tf2,tf3, tf4, tf5;
    private JComboBox securityQsn;
    private JButton btn1, btn2,btn3, nBtn;
	
	AddHotel()
	{
		// Frame Layout
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Add Hotel");
		this.setSize(850,550);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
		
		d = this.getContentPane();
        d.setLayout(null);
		d.setBackground(Color.decode("#F6FCFF"));
		
		// Icon
        icon = new ImageIcon(getClass().getResource("/images/P1.png"));
        this.setIconImage(icon.getImage());
		
		// Fonts
        f1 = new Font("Tahoma", Font.BOLD, 15);
        f2 = new Font("Times New Roman", Font.BOLD, 45);
        f3 = new Font("Tahoma", Font.BOLD, 15);
		
		// Title
        label1 = new JLabel();
        label1.setText("Enter Information");
        label1.setBounds(250, 10, 500, 50);
        label1.setFont(f2);
		label1.setForeground(Color.decode("#FF0000"));
        d.add(label1);
		
		// Hotel Name
        label2 = new JLabel();
        label2.setText("Hotel No");
        label2.setBounds(100, 95, 500, 50);
        label2.setFont(f3);
        d.add(label2);

        tf1 = new JTextField();
        tf1.setBounds(240, 105, 260, 30);
        tf1.setFont(f3);
        d.add(tf1);

        // Cost Per Person
        label3 = new JLabel();
        label3.setText("Hotel Name");
        label3.setBounds(100, 130, 500, 50);
        label3.setFont(f3);
        d.add(label3);

        tf2 = new JTextField();
        tf2.setBounds(240, 140, 260, 30);
        tf2.setFont(f3);
        d.add(tf2);
		
		// AC Room Cost
        label4 = new JLabel();
        label4.setText("Cost Per Person");
        label4.setBounds(100, 165, 500, 50);
        label4.setFont(f3);
        d.add(label4);

        tf3 = new JTextField();
        tf3.setBounds(240, 175, 260, 30);
        tf3.setFont(f3);
        d.add(tf3);
		
		// Food Cost
        label5 = new JLabel();
        label5.setText("AC Room Cost");
        label5.setBounds(100, 200, 500, 50);
        label5.setFont(f3);
        d.add(label5);

        tf4 = new JTextField();
        tf4.setBounds(240, 210, 260, 30);
        tf4.setFont(f3);
        d.add(tf4);
		
		// Answer
        label7 = new JLabel();
        label7.setText("Food Cost");
        label7.setBounds(100, 245, 500, 50);
        label7.setFont(f3);
        d.add(label7);

        tf5 = new JTextField();
        tf5.setBounds(240, 255, 260, 30);
        tf5.setFont(f3);
        d.add(tf5);
		
		// JButtons
        btn1 = new JButton("Back");
        btn1.setBounds(450, 425, 100, 25);
        btn1.setFont(f1);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#000000"));
        d.add(btn1);
		
		btn2 = new JButton("Add");
        btn2.setBounds(250, 425, 100, 25);
        btn2.setFont(f1);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#000000"));
        d.add(btn2);
		
		// Submit
	btn2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String query = "insert into hotel values('"+tf1.getText()+"','"+tf2.getText()+"', '"+tf3.getText()+"','"+tf4.getText()+"','"+tf5.getText()+"')";

            Conn c = new Conn();
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(d, "Hotel added successfully.");
			setVisible(false);
            Hotel frame = new Hotel();
            frame.setVisible(true);
        } catch (Exception ae) {
            ae.printStackTrace();
			Hotel frame = new Hotel();
			frame.setVisible(true);
        }
    }
});
		
		//Back
		btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                Hotel frame = new Hotel();
                frame.setVisible(true);
            }
        });
		
	}
    
}