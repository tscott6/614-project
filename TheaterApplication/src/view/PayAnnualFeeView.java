package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PayAnnualFeeView {

    private GridBagConstraints gbc;

    private JPanel payAnnualFeePanel;

    private JLabel leftTimeInDaysLabel;
    private JLabel leftTimeInDaysDescriptionLabel;
    private JLabel paymentAmountLabel;
    private JLabel paymentAmountDescriptionLabel;

    private JButton payAmountButton;
    private JButton backButton;

    public PayAnnualFeeView(Integer leftDays, Integer annualFee) {

        payAnnualFeePanel = new JPanel();
        payAnnualFeePanel.setBounds(0, 0, 800, 800);
        payAnnualFeePanel.setLayout(new GridBagLayout());

        leftTimeInDaysDescriptionLabel = new JLabel("Days left to end of subscription:      ");
        leftTimeInDaysLabel = new JLabel(leftDays.toString());

        paymentAmountDescriptionLabel = new JLabel("Annual subscrition fee:                $");
        paymentAmountLabel = new JLabel(annualFee.toString());

        payAmountButton = new JButton("Pay Annual Amount");
        payAmountButton.setEnabled(leftDays <= 7);

        backButton = new JButton("Back");

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        payAnnualFeePanel.add(leftTimeInDaysDescriptionLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        payAnnualFeePanel.add(leftTimeInDaysLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        payAnnualFeePanel.add(paymentAmountDescriptionLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        payAnnualFeePanel.add(paymentAmountLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        payAnnualFeePanel.add(payAmountButton, gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        payAnnualFeePanel.add(backButton, gbc);
    }

    public JPanel getpayAnnualFeePanel() {
        return payAnnualFeePanel;
    }

    public JButton getPayAmountButton() {
        return payAmountButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setLeftDaysValue(String leftDays) {
        leftTimeInDaysLabel.setText(leftDays);
    }

    public double getPaymentAmount() {
        return Double.parseDouble(paymentAmountLabel.getText());
    }

    public void addActionListenerPayAmountButton(ActionListener listenForPayAmountButton) {
        payAmountButton.addActionListener(listenForPayAmountButton);
    }

    public void addActionListenerBackButton(ActionListener listenForBackButton) {
        backButton.addActionListener(listenForBackButton);
    }

}
