package com.movie.booking.controller;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.movie.booking.Service.PaymentServices;
import com.movie.booking.entity.MovieOrderEntity;
import com.movie.booking.entity.OrderDetail;
import com.movie.booking.entity.RegistrationEntity;
import com.movie.booking.model.DbConnection;
import com.movie.booking.model.MovieOrderDb;
import com.paypal.base.rest.PayPalRESTException;

@WebServlet("/authorize_payment")
public class AuthorizePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbConnection con = new DbConnection();
	PreparedStatement pstmt;
	ResultSet resultset;
	MovieOrderDb orderList = new MovieOrderDb();
	private boolean orderStatus = true;

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (orderStatus != false) {
			try {
			orderList.insertMovie(request.getParameter("user"), request.getParameter("movieName"),
					Integer.parseInt(request.getParameter("quantity")), orderStatus);

			List<MovieOrderEntity> movieOrderList = orderList.getOrder(request.getParameter("movieName"), orderStatus);

			int order_id = movieOrderList.get(0).getOrder_id();
			int reg_id = movieOrderList.get(0).getReg_id();
			String movieName = movieOrderList.get(0).getMovieName();
			String email = movieOrderList.get(0).getEmail();
			float movieCost = movieOrderList.get(0).getMovieCost();
			int quantity = movieOrderList.get(0).getQuantity();
			float totalCost = movieOrderList.get(0).getTotalCost();
			boolean orderStatus = movieOrderList.get(0).isOrderStatus();
			float shippingCost = 0;
			float taxCost = 2;
			float ticketCost = shippingCost + taxCost + totalCost;

			RegistrationEntity registrationEntity = orderList.retrieveUser(request.getParameter("user"));

			OrderDetail orderDetail = new OrderDetail(movieName, totalCost, shippingCost, taxCost, ticketCost);

			try {
				PaymentServices paymentServices = new PaymentServices();
				String approvalLink = paymentServices.authorizePayment(orderDetail, registrationEntity);

				response.sendRedirect(approvalLink);

			} catch (PayPalRESTException ex) {
				request.setAttribute("errorMessage", ex.getMessage());
				ex.printStackTrace();
				request.getRequestDispatcher("view/error.jsp").forward(request, response);
			}

			orderList.updateOrderStatus(email, orderStatus);

		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		}
	}

}
