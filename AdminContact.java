import javax.swing.*;    
import java.awt.*; 
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextField;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class AdminContact extends JFrame implements ActionListener {
    JTable table;
    JButton print, back,logout;
    
    public AdminContact(){
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ico.jpg"));    
		setIconImage(icon); 
		
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
		JLabel heading = new JLabel();
        heading.setText("Contact Details");
        heading.setBounds(325, 10, 300, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
		heading.setForeground(Color.decode("#FF0000"));
        add(heading);
		
        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from contacts");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50, 90, 730, 300);
        add(jsp);
        
        print = new JButton("Print");
        print.setBounds(65, 425, 100, 25);
        print.addActionListener(this);
        add(print);
        
        back = new JButton("Back");
        back.setBounds(215, 425, 100, 25);
        back.addActionListener(this);
        add(back);
        
		logout=new JButton("Log Out");
		logout.setBounds(665, 425, 100, 25);
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
        
        setSize(850, 550);
		setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
				setVisible(false);
				new Packages();
		}else {
            setVisible(false);
        }
    }
}