package createservlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateTable extends HttpServlet
{
public void doGet(HttpServletRequest req, HttpServletResponse res)
throws IOException, ServletException
{
res.setContentType("text/html");
PrintWriter pw = res.getWriter();
Connection con;
Statement st;
try
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","saiguru","saiguru"); 
	Statement stmt=conn.createStatement();
	stmt.executeUpdate("Create table customerdata(name varchar2(10),"
			+ "password varchar2(10),email varchar2(50),country varchar2(7))");
	
	pw.println("Table Created");
	
try
{
conn.close();
stmt.close();
}
catch(Exception e)
{
pw.println(e);
}
}
catch(ClassNotFoundException cx)
{
pw.println(cx);
}
catch(SQLException sx)
{
pw.println(sx);
}
}
}  
