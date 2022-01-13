package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CancelView {

    private GridBagConstraints gbc;

    private JPanel cancelPanel;
    private JTextField ticketIDField;
    private JLabel ticketIDLabel;

    private JLabel cancelConfirmLabel;
    private JButton cancelButton;
    private JButton backButton;

    public CancelView() {

        cancelPanel = new JPanel();
        cancelPanel.setBounds(0, 0, 400, 400);
        cancelPanel.setLayout(new GridBagLayout());
        ticketIDField = new JTextField();
        ticketIDLabel = new JLabel("Ticket ID");
        cancelConfirmLabel = new JLabel();
        cancelButton = new JButton("Cancel Ticket");
        backButton = new JButton("Back");
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        cancelPanel.add(ticketIDLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        cancelPanel.add(ticketIDField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        cancelPanel.add(cancelButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        cancelPanel.add(backButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        cancelPanel.add(cancelConfirmLabel, gbc);
    }

    public JPanel getCancelPanel() {
        return cancelPanel;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void addActionListenerCancelButton(ActionListener listenForCancelButton){
        cancelButton.addActionListener(listenForCancelButton);
    }
    public void addActionListenerBackButton(ActionListener listenForBackButton){
        backButton.addActionListener(listenForBackButton);
    }
    public String getTicketNumberText(){
        return ticketIDField.getText();
    }

    public void setConfimationLabeText(String cancelationResult){
         cancelConfirmLabel.setText(cancelationResult);
    }

}
