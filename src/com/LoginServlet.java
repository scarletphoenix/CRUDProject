package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			new Connector();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String button = request.getParameter("button");
		RequestDispatcher rd;
		switch(button)
		{
		case "Insert":
			
			rd = request.getRequestDispatcher("/InsertServlet");
			rd.forward(request, response);
			break;
			
		case "Delete":
			rd = request.getRequestDispatcher("/DeleteServlet");
			rd.forward(request, response);
			break;
			
		case "Update":
			rd = request.getRequestDispatcher("/UpdateServlet");
			rd.forward(request, response);
			break;
		
		case "Search":
			rd = request.getRequestDispatcher("/SearchServlet");
			rd.forward(request, response);
			break;
			
		}

	}

}
