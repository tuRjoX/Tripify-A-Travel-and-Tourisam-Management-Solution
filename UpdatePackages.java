import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdatePackages extends JFrame implements ActionListener{
    
    JTextField pkname, pkcost;
    JLabel labelrollno;
    JButton submit, back;
    Choice pkno;
    
    public UpdatePackages() {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ico.jpg"));    
		setIconImage(icon); 
		
        setSize(850, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Package");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 35));
        add(heading);
		
        JLabel packno = new JLabel("Hotel No");
        packno.setBounds(50, 100,150, 20);
        packno.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(packno);
        
        pkno = new Choice();
        pkno.setBounds(200, 100, 200, 20);
		pkno.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(pkno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from packages");
            while(rs.next()) {
                pkno.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
        JLabel packname = new JLabel("Package");
        packname.setBounds(50, 200, 100, 30);
        packname.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(packname);
        
        pkname = new JTextField();
        pkname.setBounds(200, 200, 200, 30);
        pkname.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(pkname);
        
        JLabel cost = new JLabel("Cost");
        cost.setBounds(50, 300, 200, 30);
        cost.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(cost);
        
		pkcost = new JTextField();
        pkcost.setBounds(200, 300, 200, 30);
        pkcost.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(pkcost);
		
		labelrollno = new JLabel();
        labelrollno.setBounds(50, 200, 200, 20);
        labelrollno.setFont(new Font("Tahoma", Font.PLAIN, 20));
        //add(labelrollno);
		
        try {
            Conn c = new Conn();
            String query = "select * from packages where pno='"+pkno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                pkname.setText(rs.getString(2));
                pkcost.setText(rs.getString(3));
                labelrollno.setText(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		pkno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from packages where pno='"+pkno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        pkname.setText(rs.getString(2));
                        pkcost.setText(rs.getString(3));
                        labelrollno.setText(rs.getString(1));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
		
        submit = new JButton("Update");
        submit.setBounds(250, 425, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        back = new JButton("Back");
        back.setBounds(450, 425, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                String query = "update packages set name='"+pkname.getText()+"', cost='"+pkcost.getText()+"'where pno='"+pkno.getSelectedItem()+"';";
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Package Details Updated Successfully");
                setVisible(false);
				new Packages();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
			new Packages();
        }
    }
    
    public static void main(String[] args) {
        new Packages();
    }
}