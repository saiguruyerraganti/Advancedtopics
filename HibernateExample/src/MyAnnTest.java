import java.util.ArrayList;
import java.util.List;

public class MyAnnTest {
	
	@MySampleAnn(name= "saiguru",desc = "checkingAnnotations")
	
	public void myTestMethod()
	{
		List<String> interests=new <String>ArrayList();
		
		System.out.println(""+this.getClass().toString());
						
		interests.add("reading books");
		interests.add("Listening msuic");
		
		interests.forEach(System.out::println);
		
	}

}
