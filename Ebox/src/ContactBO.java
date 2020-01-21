import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ContactBO {

    void Database(Contact c)
	{
	try {
		Class.forName("com.mysql.jdbc.Driver");//load class
		ResourceBundle rb = ResourceBundle.getBundle("mysql");//create object for resource bundle
		String url = rb.getString("db.url");//set url
		String username = rb.getString("db.username");//set username
		String password = rb.getString("db.password");//set password
		Connection con = DriverManager.getConnection(url,username,password);//Establish connection
		//insert details into database
		PreparedStatement ps = con.prepareStatement("INSERT INTO contact(firstName,lastName,email,phoneNo) VALUES(?,?,?,?)");
		ps.setString(1, c.getFirstname());//set data into required fields
		ps.setString(2, c.getLastname());
		ps.setString(3, c.getEmail());
		ps.setString(4, c.getPhone()+"");
		            
		int r =ps.executeUpdate();//execute update
		if(r>0){//if executed,
			ContactDAO cd= new ContactDAO();//create object for ContactDAO class
			cd.display();//call display method
		     
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