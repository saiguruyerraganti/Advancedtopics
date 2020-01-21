import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpDao {  
  
    public static  Connection getConnection(){  
     Connection con = null;
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
           con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
        }catch(Exception e){System.out.println(e);}
		return con;  
        
    }  
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","saiguru","saiguru");
			Statement stmt=conn.createStatement();
			stmt.executeUpdate("create table emplogin(name varchar2(20),id number(3),age number(2),details varchar2(30))");
			pw.println("Table created successfully");
			conn.close();
			stmt.close();
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
			catch(ClassNotFoundException cnx)
			{
			pw.println(cnx);
			}
			catch(SQLException sqx)
			{
			pw.println(sqx);
			}
			}
    
    public static int save(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into emplogin(name,password,email,country) values (?,?,?,?)");  
            ps.setString(1,e.getName());  
            ps.setInt(2,e.getId());  
            ps.setInt(3,e.getAge());  
            ps.setString(4,e.getDetails());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update emplogin set name=?,id=?,age=?,details=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setInt(2,e.getId());  
            ps.setInt(3,e.getAge());  
            ps.setString(4,e.getDetails());  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from emplogin where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Emp getEmployeeById(int id){  
        Emp e=new Emp();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from emplogin where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
            	 ps.setString(1,e.getName());  
                 ps.setInt(2,e.getId());  
                 ps.setInt(3,e.getAge());  
                 ps.setString(4,e.getDetails());  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from emplogin");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                ps.setString(1,e.getName());  
                ps.setInt(2,e.getId());  
                ps.setInt(3,e.getAge());  
                ps.setString(4,e.getDetails());   
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  