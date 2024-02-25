import javax.swing.*;  
import java.awt.Graphics.*;
import java.awt.*;
import javax.swing.ImageIcon.*;
import javax.swing.JPanel.*;
import java.awt.event.*;
import javax.swing.text.*;

public class RadioButtonExample extends JFrame implements ActionListener {    
JButton back1,car;
JFrame f;

public class JTextFieldLimit extends PlainDocument {
    private int limit;

    public JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }
   public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;

        if (getLength() + str.length() <= limit && str.matches("\\d+")) {
            super.insertString(offset, str, attr);
        }
    }
}

   public void actionPerformed(ActionEvent e) {
  // Your implementation he

  
}


     public  RadioButtonExample(){   

        setBounds(500,200,800,600);
		setLayout(null);
          
		
		ImageIcon i1 = new ImageIcon("picpay_1_795x595.jpg");
		Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
		ImageIcon  i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 800, 600);
		add(image); 


         f = new JFrame();
           JRadioButton r1=new JRadioButton("mastercard");    
           JRadioButton r2=new JRadioButton("visa card");    
           r1.setBounds(250,50,80,25);    
           r2.setBounds(150,50,80,25);
           image.add(r1);
           image.add(r2);
		   
         back1 = new JButton(new ImageIcon("backicon.png"));
		   back1.setBounds(520, 400, 100, 40);
		   back1.addActionListener(this);
		   image.add(back1);
		     back1.addActionListener(this::actionPerformed1);
		   
		   JButton b = new JButton("paid");
		   b.setBounds(400,400,100,40);
		   b.addActionListener(this);
		   image.add(b);
		   
		   car = new JButton("car");
		   car.setBounds(320, 400, 100, 40);
		   car.addActionListener(this);
		   image.add(car);//new code
		  
		   

			       b.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
        //your actions
	
               }
     });
	 

			 
			//value=pass, label=exp month, label1=exp year ,label2=cnumb name=cardholder
			//cvc=cardcvc
			  
            JPasswordField value = new JPasswordField();
			JTextField label= new JTextField();
			JTextField label1= new JTextField();
			JTextField label2= new JTextField();
			JTextField name= new JTextField();
			JTextField cvc= new JTextField();
		   
		    value.setBounds(210,400,100,35);
		   	label.setBounds(210,200,  30,35);
			label1.setBounds(310, 200, 30,35);
			label2.setBounds(210,150, 120,35);
			name.setBounds(210,300, 140,40);
			cvc.setBounds(210,350, 30,35);
		   
		   //1p=pass, l=month, l1=year l2= cnumb
		   
            JLabel lP=new JLabel("Password:");
			JLabel l=new JLabel("exp month:");
			l.setFont(new Font("Courier", Font.PLAIN, 12));
			JLabel l1=new JLabel("exp year:");
			JLabel l2 = new JLabel("card number:");
			JLabel l3 = new JLabel("card holder name:");
			JLabel l4 = new JLabel("cvc:");
			
			
            lP.setBounds(145,400, 80,30);    
			l.setBounds(138,200, 100,30);
			l1.setBounds(250,200, 100,30);
			l2.setBounds(120,150, 100,30);
			l3.setBounds(100,300, 140,30);
			l4.setBounds(180,350,100,30);
			
            f.add(value);  f.add(lP); f.add(l); 
            f.setSize(300,400);
			
			image.add(lP);
			image.add(l);
			image.add(value);
			image.add(label);
			image.add(label1);
			image.add(l1);
			image.add(l2);
			image.add(label2);
			image.add(name);
			image.add(cvc);
			image.add(l3);
			image.add(l4);
			
			b.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
		String input = JOptionPane.showInputDialog(null,"enter correct info");
        if (input.equals("done")) {
            // do something if the condition is true
			cvc.setDocument(new JTextFieldLimit(3));
			label.setDocument(new JTextFieldLimit(2));
			label1.setDocument(new JTextFieldLimit(2));
			label2.setDocument(new JTextFieldLimit(16));
			name.setDocument(new JTextFieldLimit(20));			
			JOptionPane.showMessageDialog(null, "payment done.you can go back");
        
		}else {
            // do something else if the condition is false
			JOptionPane.showMessageDialog( null, "payment not done");
        }
        }
     });

     back1.setVisible(true);
	 setVisible(true);
 
   }   
   
   public void actionPerformed1(ActionEvent e){
		
			if (e.getSource() == back1) {
    setVisible(false);
    new Payment();
     }
		}  
}