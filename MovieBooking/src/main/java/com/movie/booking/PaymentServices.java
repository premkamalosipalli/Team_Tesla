package com.movie.booking;

import java.util.*;

import com.movie.booking.entity.OrderDetail;
import com.movie.booking.entity.RegistrationEntity;
import com.paypal.api.payments.*;
import com.paypal.base.rest.*;

public class PaymentServices {
	
	private static final String CLIENT_ID = "ATQjOTUzOZRTrYa0lBUVgIjt-g2EEputYDXoiqAgC8NF1VPycAEcqmhOXHXju9U4jpckt2dVPZvLpGB5";
    private static final String CLIENT_SECRET = "EPncxY39grl959uqxIr_IddliKZd5eiKvON4li40xHGNkz_aMwPimIXPxZiPibwyw5JY4L8vYgfd_c3Q";
    private static final String MODE = "sandbox";
 
    public String authorizePayment(OrderDetail orderDetail,RegistrationEntity registrationEntity)        
            throws PayPalRESTException {       
 
        Payer payer = getPayerInformation(registrationEntity);
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(orderDetail);
         
        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setPayer(payer);
        requestPayment.setIntent("authorize");
 
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
 
        Payment approvedPayment = requestPayment.create(apiContext);
 
        return getApprovalLink(approvedPayment);
 
    }
    
    private Payer getPayerInformation(RegistrationEntity registrationEntity) {
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");
         
        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName(registrationEntity.getFirstName())
                 .setLastName(registrationEntity.getLastName())
                 .setEmail(registrationEntity.getEmail());
         
        payer.setPayerInfo(payerInfo);
         
        return payer;
    }
    
    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8080/MovieBooking/cancel.jsp");
        redirectUrls.setReturnUrl("http://localhost:8080/MovieBooking/review_payment");
         
        return redirectUrls;
    }
    
    private List<Transaction> getTransactionInformation(OrderDetail orderDetail) {
    	Details details = new Details();
		//details.setShipping("1");
		//details.setSubtotal("5");
		//details.setTax("1");
    	
    	details.setShipping(orderDetail.getShipping());
    	details.setSubtotal(orderDetail.getSubtotal());
    	details.setTax(orderDetail.getTax());

		// ###Amount
		// Let's you specify a payment amount.
		Amount amount = new Amount();
		amount.setCurrency("USD");
		
		// Total must be equal to sum of shipping, tax and subtotal.
		amount.setTotal(orderDetail.getTotal());
		amount.setDetails(details);

		// ###Transaction
		// A transaction defines the contract of a
		// payment - what is the payment for and who
		// is fulfilling it. Transaction is created with
		// a `Payee` and `Amount` types
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction
				.setDescription("This is the payment transaction description.");

		// ### Items
		Item item = new Item();
		item.setName(orderDetail.getProductName())
			.setQuantity("1")
			.setCurrency("USD")
			.setPrice(orderDetail.getSubtotal())
			.setTax(orderDetail.getTax());
		ItemList itemList = new ItemList();
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		itemList.setItems(items);
		
		transaction.setItemList(itemList);
		
		
		// The Payment creation API requires a list of
		// Transaction; add the created `Transaction`
		// to a List
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

         
        return transactions;
    }
    
    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;
         
        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();
                break;
            }
        }      
         
        return approvalLink;
    }

    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return Payment.get(apiContext, paymentId);
    }
    
    public Payment executePayment(String paymentId, String payerId)
            throws PayPalRESTException {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);
     
        Payment payment = new Payment().setId(paymentId);
     
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
     
        return payment.execute(apiContext, paymentExecution);
    }
}
