import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class StaticSelect {

	public static void main(String[] args) {
		
		try
		{
			Configuration cf=new Configuration();
			
			SessionFactory sf=cf.configure("hibernate.cfg.xml").buildSessionFactory();
			
			Session s=sf.openSession();
			
			//Query q=s.createQuery("from MyPojo");
			
			//Query q=s.createQuery("from MyPojo where id =2");
			
            Query q=s.createQuery("from MyPojo where id=:Idno");
            Object id = null;
			q.setParameter("Idno", id);

			
			List l=q.list();
			Iterator it=l.iterator();
			
			while(it.hasNext())
			{
				MyPojo m=(MyPojo)it.next();
				
				System.out.println("Id : "+m.getId());
				System.out.println("Name :"+m.getName());
				System.out.println("Sal : "+m.getSal());
			}
			
			
			
		}catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}

	}

}
