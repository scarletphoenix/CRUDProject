package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Queries q =new Queries();
		String id,name;
		float salary;
		RequestDispatcher rd;
		String[] r;
		
		id = request.getParameter("id");
		r = q.checkQuery(id);
		if(r[0].equals("NOT FOUND"))
			request.setAttribute("found", "false");
		else
			request.setAttribute("found", "true");
		request.setAttribute("Id", r[0]);
		request.setAttribute("Name", r[1]);
		request.setAttribute("Salary", r[2]);
		rd = request.getRequestDispatcher("search.jsp");
		rd.include(request, response);


}
}