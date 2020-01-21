

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class StudentDeatils
 */
@WebServlet("/StudentDeatils")
public class StudentDeatils extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeatils() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String s=req.getParameter("stu_Id");
		String p=req.getParameter("password");
		String n=req.getParameter("stu_Name");
		String m=req.getParameter("stu_MOBNO");
		String d=req.getParameter("stu_dept");
		String mk=req.getParameter("stu_marks");
		String b=req.getParameter("stu_dob");
		String e=req.getParameter("stu_email");
		
	
		
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				System.out.println("connection established");
				SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
				java.util.Date ds=sdf.parse(b);
				java.sql.Date de=new java.sql.Date(ds.getTime());
				con.setAutoCommit(false);
				int i=Integer.parseInt(s);
				PreparedStatement ps=con.prepareStatement("INSERT INTO stulogin VALUES (?,?,?,?,?,?,?,?)");
				ps.setInt(1,i);
				ps.setString(2, p);
				ps.setString(3, n);
				ps.setString(4, m);
				ps.setString(5, d);
				ps.setString(6,mk);
				ps.setDate(7, de);
				ps.setString(8, e);
				
				int res1=ps.executeUpdate();
				if(res1>0){
					System.out.println("Inserted successfully");
				}
				con.commit();
		} catch (ClassNotFoundException c) {
			// TODO Auto-generated catch block
			System.out.println("Class not found ");
		} catch (SQLException sql) {
			// TODO Auto-generated catch block
			System.out.println(sql);
		}catch(NumberFormatException no){
			System.out.println(no);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (java.text.ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PrintWriter out=res.getWriter();
		out.println("Registered");
		

			}

		

	}