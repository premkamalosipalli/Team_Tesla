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
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;

@WebServlet("/execute_payment")
public class ExecutePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String paymentId;
	private String payerId;
	private String emailId;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		paymentId = request.getParameter("paymentId");
		payerId = request.getParameter("PayerID");
		emailId = request.getParameter("email");

		try {
			PaymentServices paymentServices = new PaymentServices();
			Payment payment = paymentServices.executePayment(paymentId, payerId);

			PayerInfo payerInfo = payment.getPayer().getPayerInfo();
			Transaction transaction = payment.getTransactions().get(0);

			request.setAttribute("payer", payerInfo);
			request.setAttribute("transaction", transaction);
			request.setAttribute("emailId", emailId);

			request.getRequestDispatcher("view/receipt.jsp").forward(request, response);

		} catch (PayPalRESTException ex) {
			request.setAttribute("errorMessage", ex.getMessage());
			ex.printStackTrace();
			request.getRequestDispatcher("view/error.jsp").forward(request, response);
		}
	}

}
