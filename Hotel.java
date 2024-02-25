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

public class Hotel extends JFrame
{
	private Container d;
    private ImageIcon icon;
    private JLabel label1;
    private Font f1, f2, f3;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private JButton btn1, btn2, btn3, btn4, btn5, nBtn,logout;
	
	private String[] column = {"H No.","Hotel Name", "Cost Per Person", "AC Room Cost" , "Food Cost"};
    private String[] rows = new String[10];
	
	Hotel()
	{
		// Frame Layout
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Hotel List");
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
        f3 = new Font("Tahoma", Font.PLAIN, 20);
		
		// Title
        label1 = new JLabel();
        label1.setText("Hotels Details");
        label1.setBounds(325, 10, 300, 50);
        label1.setFont(new Font("serif", Font.BOLD, 30));
		label1.setForeground(Color.decode("#FF0000"));
        d.add(label1);
		
		// JTable Layout
        table = new JTable();
        scroll = new JScrollPane(table);
        scroll.setBounds(50, 90, 730, 300);
        scroll.setBackground(Color.WHITE);
        d.add(scroll);
		
		try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		// JButtons
		btn5 = new JButton("Print");
		btn5.setBounds(65, 425, 100, 25);
		d.add(btn5);
		
        btn1 = new JButton("Add");
        btn1.setBounds(215, 425, 100, 25);
        //btn1.setFont(f1);
        //btn1.setForeground(Color.WHITE);
       // btn1.setBackground(Color.decode("#000000"));
        d.add(btn1);
		
		btn2 = new JButton("Update");
        btn2.setBounds(365, 425, 100, 25);
        //btn2.setFont(f1);
        //btn2.setForeground(Color.WHITE);
        //btn2.setBackground(Color.decode("#000000"));
        d.add(btn2);
		
		logout=new JButton("Log Out");
		logout.setBounds(665, 425, 100, 25);
		//logout.setBackground(Color.BLACK);
        //logout.setForeground(Color.WHITE);
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
        
		btn3 = new JButton("Back");
        btn3.setBounds(515, 425, 100, 25);
        //btn3.setFont(f1);
        //btn3.setForeground(Color.WHITE);
        //btn3.setBackground(Color.decode("#000000"));
        d.add(btn3);
		
		//Add
		btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                AddHotel frame = new AddHotel();
                frame.setVisible(true);
            }
        });
		
		//Update
		btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                UpdateHotel frame = new UpdateHotel();
                frame.setVisible(true);
            }
        });
		
		//Back
		btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
				new Packages();
            }
        });
		
		btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
				try {
                table.print();
            } catch (Exception xe) {
                xe.printStackTrace();
            }
            }
        });
	}
}