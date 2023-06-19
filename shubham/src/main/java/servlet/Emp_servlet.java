package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import pojo.Emp;

/**
 * Servlet implementation class Emp_servlet
 */
@WebServlet("/Emp_servlet")
public class Emp_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	  
	   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String phone1=request.getParameter("phone");
		

		System.out.println(phone1);
		Emp e1=new Emp();
		
		e1.setFirstName(firstName);
		e1.setLastName(lastName);
		e1.setGender(gender);
		e1.setEmail(email);
		e1.setPassword(password);
		   
		e1.setPhone(phone1);
		int status=EmpDao.save(e1);
		if(status!=0)
		{
			out.print("<div align='center'>");
			out.print("<h2>");
			out.print("Your Profile is created sucessfully...!");
			out.print("</h2>");
			out.print("<div>");
			request.getRequestDispatcher("Welcome1.html").include(request, response);
			//response.sendRedirect("Welcome1.html");
		}
		else
		{
			out.print("<h1>enable to add</h1>");
			response.sendRedirect("Welcome1.html");
		}
		
		out.close();
	}

}