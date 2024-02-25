import javax.swing.*;    
import java.awt.*;
import java.awt.event.*;  
import javax.swing.ImageIcon;

public class LogOut extends JFrame implements ActionListener{
	String username;
	Package_Hotel(String username){
		this.username=username;
	}
	public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == logout){
        Login login = new Login();
        setVisible(ture);
		}
	}
}