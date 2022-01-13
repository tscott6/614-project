package controller;

import java.awt.event.*;

// import javax.swing.Action;

import view.*;

public class CardInfoforPaymentController {

    protected PayAnnualFeeController myPayAnnualFeeController = null;
    protected CardInfoforPaymentView myCardInfoforPaymentView = null;
    protected CancelController myCancelController = null;

    public CardInfoforPaymentController(CardInfoforPaymentView cardInfoforPaymentView,
            PayAnnualFeeController payAnnualFeeController) {
        this.myCardInfoforPaymentView = cardInfoforPaymentView;
        this.myPayAnnualFeeController = payAnnualFeeController;
        this.myCardInfoforPaymentView.addActionListenerpayNowButton(cardInfoListener);
        this.myCardInfoforPaymentView.addActionListenerBackButton(cardInfoListener);
        System.out.println("In Card Info For Payment Constructor from annual fee");
    }

    public CardInfoforPaymentController(CardInfoforPaymentView cardInfoforPaymentView,
            CancelController cancelContoller) {
        this.myCardInfoforPaymentView = cardInfoforPaymentView;
        this.myCancelController = cancelContoller;
        this.myCardInfoforPaymentView.addActionListenerpayNowButton(cardInfoListener);
        this.myCardInfoforPaymentView.addActionListenerBackButton(cardInfoListener);
        System.out.println("In Card Info For return Constructor for cancel");
    }
    
	ActionListener cardInfoListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(getCardInfoforPaymentView().getPayNowButton())) {
	            System.out.println("Pay Now or Refund button clicked");
	            startPaymentProcess();
	        } 
	        else if (e.getSource().equals(getCardInfoforPaymentView().getBackButton())) {
	            System.out.println("CardInfoforPaymentController Back button clicked");

	            if (getCardInfoforPaymentView().getPayNowButton().getText() == "Pay Now") {
	                getPayAnnualFeeController().changeApplicationViewWrapper(
	                        getCardInfoforPaymentView().getCardInfoforPaymentPanel(),
	                        getPayAnnualFeeController().getPayAnnualFeeView().getpayAnnualFeePanel());
	            } else {
	                getCancelController().changeApplicationViewWrapper(
	                        getCardInfoforPaymentView().getCardInfoforPaymentPanel(),
	                        getCancelController().getCancelView().getCancelPanel());

	            }

	        }
	
		}
	};   

    public CardInfoforPaymentView getCardInfoforPaymentView() {
        return this.myCardInfoforPaymentView;
    }

    public PayAnnualFeeController getPayAnnualFeeController() {
        return this.myPayAnnualFeeController;
    }

    public CancelController getCancelController() {
        return this.myCancelController;
    }

    private void startPaymentProcess() {
        // TODO: Call payment function
        this.myCardInfoforPaymentView.setpaymentProcessStatus(true);
    }

}
