package com.movie.booking;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.booking.entity.MovieOrderEntity;


@WebServlet("/authorize_payment")
public class AuthorizePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbConnection con = new DbConnection();
	PreparedStatement pstmt;
	ResultSet resultset;
	MovieOrderDb orderList = new MovieOrderDb();
	boolean orderStatus = true, updatedOrderStatus;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(orderStatus != false) {
			
		orderList.insertMovie(request.getParameter("user"), request.getParameter("movieName"),
				Integer.parseInt(request.getParameter("quantity")), orderStatus);
		
		List<MovieOrderEntity> movieOrderList = orderList.getOrder(request.getParameter("movieName"), orderStatus);
		
		String movieName = movieOrderList.get(0).getMovieName();
		String email = movieOrderList.get(0).getEmail();
		float movieCost = movieOrderList.get(0).getMovieCost();
		int quantity = movieOrderList.get(0).getQuantity();
		float totalCost = movieOrderList.get(0).getTotalCost();
		
		System.out.println(movieName+"\n"+email+"\n"+movieCost+"\n"+quantity+"\n"+totalCost);
		
		orderList.updateOrderStatus(email,orderStatus);
		
		}
		
		

	}

}
