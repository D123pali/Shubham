package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import pojo.Emp;



public class EmpDao {
	 public static int save(Emp e1)
     {
    	 int status=0;
    	 try {
    		 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=
					 DriverManager.getConnection("jdbc:mysql://localhost:3306/EMS","root","pass");
    		 PreparedStatement ps=
             con.prepareStatement("insert into  EmployeeInfo(Emp_Name,Emp_Last_Name,Gender,Emp_Email,Password,Phone)values(?,?,?,?,?,?)");
    		 ps.setString(1,e1.getFirstName());
    		 ps.setString(2,e1.getLastName());
    		 ps.setString(3,e1.getGender());
    		 ps.setString(4,e1.getEmail());
    		 ps.setString(5,e1.getPassword());
    		 
             ps.setString(6,e1.getPhone());
            
             
             status=ps.executeUpdate();
             con.close();
             
    	 }catch(Exception e)
    	 {
    		 System.out.println(e);
    		 
    	 }
    	 return status;
  }
}
