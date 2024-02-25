import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment extends JFrame implements ActionListener {

    JButton pay, back;
    JTextField cardNumberField, cvcField;
    JComboBox<String> monthComboBox, yearComboBox;

    public Payment() {
        setBounds(500, 200, 800, 600);
        setLayout(null);

        ImageIcon i1 = new ImageIcon("5869.jpg");
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);

        pay = new JButton("Pay");
        pay.setBounds(370, 400, 100, 40);
        pay.addActionListener(this);
        image.add(pay);

        back = new JButton("Back");
        back.setBounds(250, 400, 100, 40);
        back.addActionListener(this);
        image.add(back);

        JLabel pg = new JLabel("Payment Gateway");
        pg.setBounds(300, 0, 300, 300);
        image.add(pg);
        pg.setFont(new Font("arial", Font.PLAIN, 25));

        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setBounds(50, 250, 150, 30);
        image.add(cardNumberLabel);

        cardNumberField = new JTextField();
        cardNumberField.setBounds(200, 250, 200, 30);
        image.add(cardNumberField);

        JLabel expireDateLabel = new JLabel("Expire Date:");
        expireDateLabel.setBounds(50, 300, 150, 30);
        image.add(expireDateLabel);

        // Month selection using JComboBox
        String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        monthComboBox = new JComboBox<>(months);
        monthComboBox.setBounds(200, 300, 70, 30);
        image.add(monthComboBox);

        // Year selection using JComboBox (you may want to adjust the range)
        String[] years = {"2023", "2024", "2025", "2026", "2027"};
        yearComboBox = new JComboBox<>(years);
        yearComboBox.setBounds(280, 300, 80, 30);
        image.add(yearComboBox);

        JLabel cvcLabel = new JLabel("CVC Number:");
        cvcLabel.setBounds(50, 350, 150, 30);
        image.add(cvcLabel);

        cvcField = new JTextField();
        cvcField.setBounds(200, 350, 100, 30);
        image.add(cvcField);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pay) {
            try {
                // Parsing card number and cvc as integers
                int cardNumber = Integer.parseInt(cardNumberField.getText());
                int cvc = Integer.parseInt(cvcField.getText());

                // Check if the card number is valid (12 digits)
                if (String.valueOf(cardNumber).length() == 12) {
                    // Check if the CVC number is valid (3 digits)
                    if (String.valueOf(cvc).length() == 3) {
                        // Get selected month and year
                        String selectedMonth = (String) monthComboBox.getSelectedItem();
                        String selectedYear = (String) yearComboBox.getSelectedItem();

                        // Validate expiration date
                        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
                        Date expireDate = sdf.parse(selectedMonth + "/" + selectedYear);

                        if (expireDate.after(new Date())) {
                            // Perform payment processing using the entered card information
                            setVisible(false);
                            // Assuming Paytm is a valid class
                            new Paytm();
                        } else {
                            JOptionPane.showMessageDialog(this, "Expiration date must be greater than the current date.", "Invalid Expiration Date", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Please enter a valid CVC number (3 digits).", "Invalid CVC Number", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter a valid card number (12 digits).", "Invalid Card Number", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException | java.text.ParseException ex) {
                JOptionPane.showMessageDialog(this, "Card number and CVC are Invalid.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            // Assuming Dashboard is a valid class
            //Dashboard dashboard = new Dashboard("");
            //dashboard.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Payment();
    }
}
