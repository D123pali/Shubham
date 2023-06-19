<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%@ page import="java.sql.*"  %>
<%
  String UserId=request.getParameter("ruser"); 
  String pass=request.getParameter("renterPass");
  String pass1=request.getParameter("rconformPass");
  if(pass.equals(pass1))
  {
	  try{
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EMS","root","pass");
		  PreparedStatement ps=con.prepareStatement("update EmployeeInfo set Password=? where Emp_Email=?");
		  ps.setString(1,pass);
		  ps.setString(2,UserId);
		 
		  int x=ps.executeUpdate();
		  if(x!=0)
		  {
			  out.print("update Successfully...!");
			  request.getRequestDispatcher("Welcome1.html").include(request, response);
			  //response.sendRedirect("Welcome1.html");
		  }
		  else
		  {
			  out.print("password should be match... ");
			  request.getRequestDispatcher("Welcome1.html").include(request, response);
			  //response.sendRedirect("forgotPass.html");
		  }
		  
	  }
	  catch(Exception e){
		  out.print(e);
	  }
  }
  else
  {
	  out.print("password is not matching...!");
	  
	  
	  
  }
%>
</body>
</html>