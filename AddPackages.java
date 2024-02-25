import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class AddPackages extends JFrame implements ActionListener{
    
    JTextField pkname, pkno,pkcost;
    JButton add, back;
   
    AddPackages() {
        setSize(850, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Package");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        JLabel packno = new JLabel("No");
        packno.setBounds(50, 150, 100, 30);
        packno.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(packno);
        
        pkno = new JTextField();
        pkno.setBounds(200, 150, 150, 30);
		pkno.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(pkno);
        
        JLabel packname = new JLabel("Pacakge");
        packname.setBounds(50, 250, 200, 30);
        packname.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(packname);
        
        pkname = new JTextField();
        pkname.setBounds(200, 250, 150, 30);
		pkname.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(pkname);
		
		JLabel cost = new JLabel("Cost");
        cost.setBounds(50, 350, 200, 30);
        cost.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(cost);
        
        pkcost = new JTextField();
        pkcost.setBounds(200, 350, 150, 30);
		pkcost.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(pkcost);
        
        add = new JButton("Add");
        add.setBounds(250, 425, 120, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(add);
        
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
        if (ae.getSource() == add) {
            try {
                String query = "insert into packages values('"+pkno.getText()+"','"+pkname.getText()+"', '"+pkcost.getText()+"')";

                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Package Added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
			new Packages();
        } else {
            setVisible(false);
			new Packages();
        }
    }
    
    public static void main(String[] args) {
        new Packages();
    }
}