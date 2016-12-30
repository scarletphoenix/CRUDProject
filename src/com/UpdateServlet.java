package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Queries q =new Queries();
		String id,name;
		float salary;
		RequestDispatcher rd;
		int r;
		
		id = request.getParameter("id");
		name = request.getParameter("name");
		salary = Float.parseFloat(request.getParameter("salary"));
		r = q.updateQuery(id, name, salary);
		request.setAttribute("rowsAffected", r);
		request.setAttribute("Id", id);
		request.setAttribute("Name", name);
		request.setAttribute("Salary", salary);
		rd = request.getRequestDispatcher("update.jsp");
		rd.include(request, response);
	}

}
