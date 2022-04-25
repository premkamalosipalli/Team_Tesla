package com.movie.booking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.booking.Service.PaymentServices;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;

@SuppressWarnings("serial")
@WebServlet("/review_payment")
public class ReviewPaymentServlet extends HttpServlet {
	
	private String paymentId;
	private String payerId;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		paymentId = request.getParameter("paymentId");
		payerId = request.getParameter("PayerID");

		try {
			PaymentServices paymentServices = new PaymentServices();
			Payment payment = paymentServices.getPaymentDetails(paymentId);

			PayerInfo payerInfo = payment.getPayer().getPayerInfo();
			Transaction transaction = payment.getTransactions().get(0);
			ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();

			request.setAttribute("payer", payerInfo);
			request.setAttribute("transaction", transaction);
			request.setAttribute("shippingAddress", shippingAddress);

			String url = "view/review.jsp?paymentId=" + paymentId + "&PayerID=" + payerId;

			request.getRequestDispatcher(url).forward(request, response);

		} catch (PayPalRESTException ex) {
			request.setAttribute("errorMessage", ex.getMessage());
			ex.printStackTrace();
			request.getRequestDispatcher("view/error.jsp").forward(request, response);
		}
	}

}
