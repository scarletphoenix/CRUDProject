package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Queries q =new Queries();
		RequestDispatcher rd;
		String[][] table= q.viewAll();
		out.println("<table>");
		out.println("<tr><th>ID</th><th>Name</th><th>Salary</th></tr>");
		for(int i=0;i<table.length;i++){
			out.print("<tr>");
			out.println("<td>"+table[i][0]+"</td>");
			out.println("<td>"+table[i][1]+"</td>");
			out.println("<td>"+table[i][2]+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		rd = request.getRequestDispatcher("viewall.jsp");
		rd.include(request, response);
	}

}
