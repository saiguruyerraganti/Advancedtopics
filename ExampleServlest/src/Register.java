import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet
{  
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     {  
          response.setContentType("text/html");  
          PrintWriter out = response.getWriter();  
          
          String name = request.getParameter("Name");  
          String address = request.getParameter("Address"); 
          String state =request.getParameter("state"); 
          int mobile = Integer.parseInt(request.getParameter("pnumber").trim());
          String email = request.getParameter("email");
          String contact = request.getParameter("contact");  
          String dov = request.getParameter("dov"); 
          String describe = request.getParameter("describe"); 
         
          
          
          try
          {  
               //load the driver
               Class.forName("oracle.jdbc.driver.OracleDriver");  
               //create connection object
               Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","saiguru","saiguru");  
               // create the prepared statement object
               PreparedStatement ps=con.prepareStatement("insert into info values(?,?,?,?,?,?,?,?)");  
  
               ps.setString(1,name);  
               ps.setString(2,address); 
               ps.setString(3, state);
               ps.setInt(4, mobile);
               ps.setString(5,email);  
               ps.setString(6,contact); 
               ps.setString(7,dov);  
               ps.setString(8, describe);
               
              
  
               int i = ps.executeUpdate();  
               if(i>0)  
               out.print("You are successfully registered...");  
  
          }catch(NumberFormatException ne)
          {
        	  out.println("please input only numbers ");
          }
          catch (Exception ex)
          {
               ex.printStackTrace();
          }  
          out.close();  
     }  
}