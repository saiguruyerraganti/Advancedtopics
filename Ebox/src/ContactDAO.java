import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ContactDAO {

    void display()
	{
		
	try
	{
		Class.forName("com.mysql.jdbc.Driver");//load class
		ResourceBundle rb = ResourceBundle.getBundle("mysql");//create object for resource bundle
		String url = rb.getString("db.url");//set url
		String username = rb.getString("db.username");//set username
		String password = rb.getString("db.password");//set password
		Connection con = DriverManager.getConnection(url,username,password);//Establish connection
		System.out.println("After the insert");
		 System.out.format("%-15s %-15s %-30s %-15s\n",
		"FirstName","LastName","Email","PhoneNumber");
		 PreparedStatement ps = con.prepareStatement("SELECT firstName,lastName,email,phoneNo FROM contact");
		 //select required fields from table
		 ResultSet rs=ps.executeQuery();//excute query
		 while(rs.next())//if resultset has data
		 {
		 System.out.format("%-15s %-15s %-30s %-15s\n",//print data
		rs.getString("firstName"),rs.getString("lastName"),rs.getString("email"),rs.getString("phoneNo"));
		 }

	}
	catch(ClassNotFoundException e)
	{
		System.out.println(e);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}