package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PaymentViewReg extends JFrame {
	
    private JFrame frame;
    private JTextField textField_cvv;
    private JTextField textField_expiryDate;
    
    private JTextArea ticket_display;
    private JTextArea receipt_display;
    
    private JButton submitButton;

    public PaymentViewReg(double amount) { // add and display payment amount
    	
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

        JLabel label_cvv = new JLabel("CVV");
        label_cvv.setBounds(43, 140, 46, 14);
        panel.add(label_cvv);

        JLabel label_expiry = new JLabel("Expiry Date");
        label_expiry.setBounds(43, 180, 80, 14);
        panel.add(label_expiry);


        textField_cvv = new JTextField();
        textField_cvv.setColumns(10);
        textField_cvv.setBounds(213, 140, 122, 20);
        panel.add(textField_cvv);

        textField_expiryDate = new JTextField();
        textField_expiryDate.setColumns(10);
        textField_expiryDate.setBounds(213, 180, 122, 20);
        panel.add(textField_expiryDate);

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
        
        add(panel);
    }
    
	public int getCVV() {
		return Integer.parseInt(textField_cvv.getText());
	}

	public int getExpiryDate() {
		return Integer.parseInt(textField_expiryDate.getText());
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
