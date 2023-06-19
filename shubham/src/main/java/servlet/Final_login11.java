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

/**
 * Servlet implementation class Final_login11
 */
@WebServlet("/Final_login11")
public class Final_login11 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=
					 DriverManager.getConnection("jdbc:mysql://localhost:3306/EMS","root","pass");
			 Statement smt=con.createStatement();
			 ResultSet rs=smt.executeQuery("select * from EmployeeInfo where Emp_Email='"+name+"'and password='"+pass+"'");
			
			 if(rs.next())
			 {
				 ResultSet rs1=smt.executeQuery("select Emp_Name from EmployeeInfo where Emp_Email='"+name+"'and password='"+pass+"'");
				 if(rs1.next())
				 {
				 
				 out.print("<div align= center>"); 
				 out.print("<h2>Welcome '"+rs1.getString(1)+"'</h2>");
				 out.print("</div>");
				 
				
				 }
				 else {
					out.print("unable to fetch");
				}
				 out.print("<div align=center>");
				 out.print("<a href='Logout.html'>LOG OFF</a>");
				// out.print("<h2> '"+rs1.getString(1)+"' Logout succesfully </h2>");
				 out.print("</div>");
			 }
			 else {
				 out.print("<div align=center><h2>your userId or password is incorrect plzz check...!</h2></div>");
				 request.getRequestDispatcher("Welcome1.html").include(request, response);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

}