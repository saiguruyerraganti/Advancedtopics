import org.hibernate.HibernateException; 
import org.hibernate.Session;
import org.hibernate.SessionFactory; 
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration; 
public class Insert {
    public static void main(String[] args) {
       try{
           Configuration cn=new Configuration();
           SessionFactory sf=cn.configure("hibernate.cfg.xml").buildSessionFactory();
           Session s=sf.openSession();
           Transaction tn=s.beginTransaction();
           MyPojo obj=new MyPojo();
           obj.setId(3);   
           //obj.setId(2);   obj.setName("alex");    obj.setSal(10000);
          // s.save(obj); // Inserting a Record
           //s.update(obj); //update the record
           s.delete(obj);//delete the record
           
           tn.commit();
       }catch(HibernateException e){
           System.out.println(e.getMessage()); }
    }  }
