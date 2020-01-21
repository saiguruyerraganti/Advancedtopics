package com.javatpoint.mypackage;
import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  
  
    
public class StoreData {    
public static void main(String[] args) {    
        
    //Create typesafe ServiceRegistry object    
    StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
   
    //create meta data object from registry
   Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  

   //build a sessionFactory from meta object
SessionFactory factory = meta.getSessionFactoryBuilder().build(); 

//create session object from session Factory
Session session = factory.openSession();  


//create Transaction object by calling beginTransaction() method of session
Transaction t = session.beginTransaction();   
   

//create  a bean or pojo object
    Employee e1=new Employee();    
    
    //set values to attributes or properties of bean
    e1.setId(1);    
    e1.setFirstName("saiguru");    
    e1.setLastName("yerraganti");    
   
    
    //persist the bean by calling save() method
    session.save(e1);  
    //confirm the transaction
    t.commit();  
    System.out.println("Employee successfully saved");    
    
    //close factory
    factory.close(); 
    //close.session
    session.close();    
        
}    
}   