package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstLoginServlet
 */
@WebServlet("/FirstLoginServlet")
public class FirstLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			new Connector();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Queries q =new Queries();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		String button = request.getParameter("button");
		
		if(button.equals("SIGNUP")){
			boolean flag = q.insert(username, pass);
			if(flag)
				{
				out.println("<h2>Succesfully, signed up as "+username+"</h2>");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.forward(request, response);
				}
			else
				{
				out.println("<h2>User already exists</h2>");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.forward(request, response);
				}
		}
		else
			{
			boolean flag = q.check(username, pass);
			if(flag){
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.forward(request, response);
				
			}
			else{
				out.print("<h2>Invalid username/password. Try again.</h2>");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.forward(request, response);
			}
		
		
		}
	}

}
