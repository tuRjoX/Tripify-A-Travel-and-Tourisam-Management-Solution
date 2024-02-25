

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment  extends JFrame implements ActionListener{
	
	JButton pay, back, card;
	
	public Payment (){
		setBounds(500,200,800,600);
		setLayout(null);

		
		ImageIcon i1 = new ImageIcon("/images/5869.jpg");
		Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
		ImageIcon  i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 800, 600);
		add(image);
		
		pay= new JButton(new ImageIcon ("/images/paycash.png"));
		pay.setBounds(370,400,100,40);
		pay.addActionListener(this);
		image.add(pay);
		
		back = new JButton(new ImageIcon("/images/iconback.png"));
		back.setBounds(250, 400, 100, 40);
		back.addActionListener(this);
		image.add(back);
		
		card = new JButton(new ImageIcon("/images/iconcardpay.png"));
        card.setBounds(490, 400, 90, 40);
        card.addActionListener(this::actionPerformed1);
        image.add(card);

		JLabel pg= new JLabel("payment gateway");
		pg.setBounds(300,0, 200,200);
		image.add(pg);
		pg.setFont(new Font("arial", Font.PLAIN, 25));
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pay) {
            setVisible(false);
            new Paytm();
        } else if (ae.getSource() == back) { // Fix: Use 'else if' instead of 'else'
            setVisible(false);
            Dashboard dashboard = new Dashboard("");
            dashboard.setVisible(true);
        } else {
            setVisible(false);
        }
    }

	public void actionPerformed1(ActionEvent e){
		if (e.getSource() == card){
			
			setVisible(false);
			new RadioButtonExample();
			
		} else {
			setVisible(false);
		}
	}

}