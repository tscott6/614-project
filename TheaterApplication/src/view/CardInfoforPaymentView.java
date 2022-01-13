package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
// import java.awt.event.ActionEvent;

public class CardInfoforPaymentView {
    private GridBagConstraints gbc;

    private JPanel cardInfoforPaymentPanel;

    private JLabel cardNumberLabel;
    private JLabel cvvLabel;
    private JLabel expiryDateLabel;
    private JLabel slashLabel;
    private JLabel fullNameLabel;
    private JLabel paymentAmountLabel;
    private JLabel paymentAmountValue;

    private JTextArea cardNumberText;
    private JTextArea cvvText;
    private JTextArea expiryYearText;
    private JTextArea expiryMonthText;
    private JTextArea fullNameText;

    private JButton payNowButton;
    private JButton backButton;

    private Boolean paymentProcessStatus;

    public CardInfoforPaymentView(double paymeymentAmount, String payType) {
    	System.out.println("Payment Card constructor");
        cardInfoforPaymentPanel = new JPanel();
        cardInfoforPaymentPanel.setBounds(0, 0, 1024, 1024);
        cardInfoforPaymentPanel.setLayout(new GridBagLayout());

        cardNumberLabel = new JLabel("Card Number:");
        cardNumberText = new JTextArea("Credit/DebitCrad Number");

        cvvLabel = new JLabel("CVV:");
        cvvText = new JTextArea("###");

        expiryDateLabel = new JLabel("Expiry date:");
        expiryMonthText = new JTextArea("MM");
        slashLabel = new JLabel("  /  ");
        expiryYearText = new JTextArea("YY");

        fullNameLabel = new JLabel("Full Name:");
        fullNameText = new JTextArea("Full Name:");

        paymentAmountLabel = new JLabel("Amount:");
        paymentAmountValue = new JLabel(String.valueOf(paymeymentAmount));

        payNowButton = setPayReturnBottonText(payType);
        payNowButton.setEnabled(paymeymentAmount > 0);

        backButton = new JButton("Back");

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        cardInfoforPaymentPanel.add(cardNumberLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        cardInfoforPaymentPanel.add(cardNumberText, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        cardInfoforPaymentPanel.add(cvvLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        cardInfoforPaymentPanel.add(cvvText, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        cardInfoforPaymentPanel.add(expiryDateLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        cardInfoforPaymentPanel.add(expiryMonthText, gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        cardInfoforPaymentPanel.add(slashLabel, gbc);
        gbc.gridx = 3;
        gbc.gridy = 2;
        cardInfoforPaymentPanel.add(expiryYearText, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        cardInfoforPaymentPanel.add(fullNameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        cardInfoforPaymentPanel.add(fullNameText, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        cardInfoforPaymentPanel.add(paymentAmountLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        cardInfoforPaymentPanel.add(paymentAmountValue, gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        cardInfoforPaymentPanel.add(payNowButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 7;
        cardInfoforPaymentPanel.add(backButton, gbc);
    }

    public JPanel getCardInfoforPaymentPanel() {
        return cardInfoforPaymentPanel;
    }

    public JButton getPayNowButton() {
        return payNowButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    private JButton setPayReturnBottonText(String payType) {

        return new JButton(payType);
    }

    public void setpaymentProcessStatus(Boolean paymentProcessStatusResult) {
        paymentProcessStatus = paymentProcessStatusResult;
    }

    public boolean getpaymentProcessStatus() {
        return paymentProcessStatus;
    }

    public void addActionListenerpayNowButton(ActionListener listenForpayNowButton) {
        payNowButton.addActionListener(listenForpayNowButton);
    }

    public void addActionListenerBackButton(ActionListener listenForBackButton) {
        backButton.addActionListener(listenForBackButton);
    }

}
