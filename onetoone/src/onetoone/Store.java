package onetoone;
import org.hibernate.*;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;    
    
public class Store {    
public static void main(String[] args) {    
      
    StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
      
    SessionFactory factory=meta.getSessionFactoryBuilder().build();  
    Session session=factory.openSession();  
      
    Transaction t=session.beginTransaction();   
      
    Employe e1=new Employe();    
    e1.setName("Guru");    
    e1.setEmail("Guru@gmail.com");    
        
    Address address1=new Address();    
    address1.setAddressLine1("1-9,vijayawada");    
    address1.setCity("vijayawada");    
    address1.setState("ap");    
    address1.setCountry("India");    
    address1.setPincode(521108);    
        
    e1.setAddress(address1);    
    address1.setEmployee(e1);    
        
    session.persist(e1);    
    t.commit();    
        
    session.close();    
    System.out.println("success");    
}    
}    