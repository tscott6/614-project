package view;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class PaymentViewOrdinary extends JFrame {

    private JFrame frame;
    private JTextField textField_name;
    private JTextField textField_CCN;
    private JTextField textField_cvv;
    private JTextField textField_expiryDate;
    private JTextField textField_email;
    
    private JTextArea ticket_display;
    private JTextArea receipt_display;
    
    private JButton submitButton;

    public PaymentViewOrdinary(double amount) { // add and display payment amount
    	
        frame = new JFrame();
        frame.setBounds(100, 100, 471, 656);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        this.setSize (550, 700);
        panel.setBounds(10, 11, 435, 595);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel label_payment = new JLabel("Payment Amount: " + String.valueOf(amount));
        label_payment.setBounds(200, 10, 200, 14);
        panel.add(label_payment);

        JLabel label_name = new JLabel("Name");
        label_name.setBounds(43, 60, 46, 14);
        panel.add(label_name);

        JLabel label_card_number = new JLabel("Credit Card Number");
        label_card_number.setBounds(43, 100, 120, 14);
        panel.add(label_card_number);

        JLabel label_cvv = new JLabel("CVV");
        label_cvv.setBounds(43, 140, 46, 14);
        panel.add(label_cvv);

        JLabel label_expiry = new JLabel("Expiry Date");
        label_expiry.setBounds(43, 180, 80, 14);
        panel.add(label_expiry);
        

        JLabel Label_email = new JLabel("Email");
        Label_email.setBounds(43, 220, 46, 14);
        panel.add(Label_email);

        textField_name = new JTextField();
        textField_name.setBounds(213, 60, 122, 20);
        panel.add(textField_name);
        textField_name.setColumns(10);

        textField_CCN = new JTextField();
        textField_CCN.setColumns(10);
        textField_CCN.setBounds(213, 100, 122, 20);
        panel.add(textField_CCN);

        textField_cvv = new JTextField();
        textField_cvv.setColumns(10);
        textField_cvv.setBounds(213, 140, 122, 20);
        panel.add(textField_cvv);

        textField_expiryDate = new JTextField();
        textField_expiryDate.setColumns(10);
        textField_expiryDate.setBounds(213, 180, 122, 20);
        panel.add(textField_expiryDate);

        textField_email = new JTextField();
        textField_email.setColumns(10);
        textField_email.setBounds(213, 220, 122, 20);
        panel.add(textField_email);
        

        submitButton = new JButton("Submit");
        submitButton.setBounds(249, 265, 89, 23);
        panel.add(submitButton);

        ticket_display = new JTextArea();
        ticket_display.setBounds(10, 351, 250, 300);
        panel.add(ticket_display);

        receipt_display = new JTextArea();
        receipt_display.setBounds(300, 351, 250, 300);
        panel.add(receipt_display);

        JLabel ticketLabel = new JLabel("Ticket");
        ticketLabel.setBounds(83, 322, 46, 14);
        panel.add(ticketLabel);

        JLabel receiptLabel = new JLabel("Receipt");
        receiptLabel.setBounds(267, 322, 46, 14);
        panel.add(receiptLabel);
        setVisible(true);
        add(panel);
    }
    
	public String getCreditCardNumber() {
		return textField_CCN.getText();
	}

	public int getCVV() {
		return Integer.parseInt(textField_cvv.getText());
	}

	public int getExpiryDate() {
		return Integer.parseInt(textField_expiryDate.getText());
	}


	public String getEmail() {
		return textField_email.getText();
	}
	
	public void setDisplayReceipt(String Receipt) {
		receipt_display.setText(Receipt);
	}

	public void setDisplayTicket(String Ticket) {
		ticket_display.setText(Ticket);
		
	}

	public void pay_addActionListener(ActionListener payment) {
		submitButton.addActionListener(payment);
	}

}
