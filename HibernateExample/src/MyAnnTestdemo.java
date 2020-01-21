import java.lang.reflect.Method;

public class MyAnnTestdemo {

	public static void main(String[] args) throws Exception {
		
		MyAnnTest maat=new MyAnnTest();
		
		Method m=maat.getClass().getMethod("myTestMethod");
		
		MySampleAnn msa=m.getAnnotation(MySampleAnn.class);
		
		System.out.println("Name:"+msa.name());
		System.out.println("Desc:"+msa.desc());
		
		maat.myTestMethod();

	}

}
