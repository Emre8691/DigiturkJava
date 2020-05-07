package test.tools.webapp.automation.Smoke;

public class EndsWithExample{
	   public static void main(String args[]){
	       String str1 = new String("This is a test String");
	       String str2 = new String("Test ABC");
	       String str = "dx_dx-f3d77b3d-2b50-a56a-5474-63d665ccca7f_name";
	       int n = str.indexOf("_",str.indexOf("_") + 1);
	       System.out.println(n);
	       String dynamic = str.substring(n+1,str.length());
	       System.out.println(dynamic);
	       boolean var1 = str1.endsWith("String");
	       boolean var2 = str1.endsWith("ABC");
	       boolean var3 = str2.endsWith("String");
	       boolean var4 = str2.endsWith("ABC");
	       System.out.println("str1 ends with String: "+ str1.endsWith("String"));
	       System.out.println("str1 ends with ABC: "+ str.indexOf("_", 5));
	       System.out.println("str2 ends with String: "+ var3);
	       System.out.println("str2 ends with ABC: "+ var4);
	   }
	}