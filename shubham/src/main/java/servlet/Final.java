package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.cj.xdevapi.Statement;

/**
 * Servlet implementation class Final
 */
@WebServlet("/Final")
public class Final extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				response.setContentType("text/html");
				PrintWriter pw=response.getWriter();
				String name=request.getParameter("username");
				String pass=request.getParameter("password");
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EMS","root","pass");
					Statement smt=con.createStatement();
					ResultSet rs=smt.executeQuery("select * from EmployeeInfo where Emp_Email='"+name+"' and Password='"+pass+"'");
					if(rs.next())
					{  
						pw.print("Welcome"+name);
						//response.sendRedirect("customer.html");
					}
					else
					{
						pw.print("username or password is incorrect...!");
						request.getRequestDispatcher("Welcome1.html").include(request, response);
						
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}
	}

}