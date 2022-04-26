package com.movie.booking.controller;

import static org.junit.Assert.assertEquals;


import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import com.movie.booking.model.LoginDb;


public class JWebUnitTest{


	private LoginServlet loginUser;
    private HttpServletRequest mockedRequest;
    private HttpServletResponse mockedResponse;
    private ServletContext mockedServletContext;
    private HttpSession mockedSession;
    private LoginDb loginDb;
    
    private PrintWriter mockedOut;
    
   @BeforeEach
    void setUp() throws Exception {
    	loginUser = new LoginServlet();
    	mockedRequest = Mockito.mock(HttpServletRequest.class);
        mockedRequest = Mockito.mock(HttpServletRequest.class);
        mockedResponse = Mockito.mock(HttpServletResponse.class);
        mockedSession = Mockito.mock(HttpSession.class);
        mockedServletContext = Mockito.mock(ServletContext.class);
        mockedOut = Mockito.mock(PrintWriter.class);
        loginDb = Mockito.mock(LoginDb.class);
    }
    
    @AfterEach
    void tearDown() throws Exception {
    }
    
    
    @Test
    final void testDoPostSuccessful() throws Throwable{
        
    	loginDb = new LoginDb();
    	Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
        Mockito.when(mockedRequest.getParameter("email")).thenReturn("email");
        Mockito.when(mockedRequest.getParameter("password")).thenReturn("password");
        Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
        Mockito.when(loginDb.userLogin("email", "password"));
        Mockito.when(mockedResponse.getWriter()).thenReturn(mockedOut);

        loginUser.doPost(mockedRequest, mockedResponse);
    	assertEquals("prem@gmail.com", "prem@gmail.com");
        assertEquals("prem@gmail.com", loginDb.userLogin("email", "password"));
        Mockito.verify(mockedOut).println("1");
        Mockito.verify(mockedSession).setAttribute(Mockito.eq("user"), loginDb);
    }

}
