package controller;

import java.awt.event.*;
import view.*;
import javax.swing.JPanel;

import model.Payment;

public class PayAnnualFeeController {

    protected RegisteredUserController registeredUserController = null;
    protected PayAnnualFeeView payAnnualFeeView = null;
    protected PaymentControllerRegistered paymentControllerRegistered;

    public PayAnnualFeeController(PayAnnualFeeView payAnnualFeeView,
            RegisteredUserController registeredUserController) {
        this.payAnnualFeeView = payAnnualFeeView;
        this.registeredUserController = registeredUserController;
        this.payAnnualFeeView.addActionListenerPayAmountButton(new PayAnnualFeeAmount());
        this.payAnnualFeeView.addActionListenerBackButton(new PayAnnualFeeAmount());
        System.out.println("In PayAnnualFee Constructor");
    }

    class PayAnnualFeeAmount implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(getPayAnnualFeeView().getPayAmountButton())) {
                System.out.println("Pay Annual fee amount button clicked");
                PayAnnualFeeAmount(getPayAnnualFeeView().getPaymentAmount());

            } else if (e.getSource().equals(getPayAnnualFeeView().getBackButton())) {
                System.out.println("Back button clicked");
                getCurrentRgisteredUserController().changeApplicationView(getPayAnnualFeeView().getpayAnnualFeePanel(),
                        getCurrentRgisteredUserController().getUserDashboard().getUserDashboardPanel());
            }
        }
    }

    private RegisteredUserController getCurrentRgisteredUserController() {
        return registeredUserController;
    }

    public PayAnnualFeeView getPayAnnualFeeView() {
        return this.payAnnualFeeView;
    }

    public void changeApplicationViewWrapper(JPanel oldView, JPanel newView) {

        getCurrentRgisteredUserController().changeApplicationView(oldView, newView);
    }

    public PayAnnualFeeController getPayAnnualFeeController() {
        return this;
    }

    public JPanel getpayAnnualFeePanel() {
        return this.payAnnualFeeView.getpayAnnualFeePanel();
    }

    private void PayAnnualFeeAmount(double paymentAmount) {
        PaymentViewReg paymentViewReg = new PaymentViewReg(paymentAmount);
        Payment thePayment = new Payment();

        paymentControllerRegistered = new PaymentControllerRegistered(
                thePayment,
                paymentViewReg,
                "AnnualFee",
                paymentAmount,
                getCurrentRgisteredUserController().getRegisteredUser(),
                getCurrentRgisteredUserController().getApplication());
        
        registeredUserController.getApplication().getApplicationView().setVisible(false);
        paymentViewReg.setVisible(true);
    }

}
