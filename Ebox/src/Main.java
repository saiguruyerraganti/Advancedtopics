import java.util.Scanner;

public class Main {
    
	public static void main(String args[])
	{
         System.out.println("Before the insert");
         System.out.format("%-15s %-15s %-30s %-15s\n",
        "FirstName","LastName","Email","PhoneNumber");
		
		Scanner sc= new Scanner(System.in);//Initializing Scanner
		System.out.println("Enter Contact Table Inputs");//Getting inputs from scanner
		System.out.println("Enter The FirstName :");
		String firstName = sc.nextLine();
		System.out.println("Enter The LastName :");
		String lastName = sc.nextLine();
		System.out.println("Enter The Email :");
		String email = sc.nextLine();
		System.out.println("Enter The PhoneNumber :");
		long phoneNumber = sc.nextLong();
		
		Contact c=new Contact();
		
		c.setFirstname(firstName);
		c.setLastname(lastName);
		c.setEmail(email);
		c.setPhone(phoneNumber);
		
		ContactBO cb= new ContactBO();
		cb.Database(c);
		

	}

}