public class testmain {

	public static void main(String[] args) {
		String url;
		boolean method1 = false;
		boolean method2 = false;
		boolean method3 = false;
		int method4 = -1;
		String method5 = "";
		boolean method6 = false;
		boolean method7 = false;
		String method8 = "";
		boolean method9 = false;
		boolean method10 = false;
		
		Assignment2 test= new Assignment2();
		
		url = "jdbc:postgresql://localhost:5432/csc343h-c4zhanjq";
		method1 = test.connectDB(url, "c4zhanjq", "");
		System.out.println(method1);
		
		method3 = test.insertCountry(1, "Canada", 100, 1000001);
		System.out.println(method3);

		method4 = test.getCountriesNextToOceanCount(1);
		System.out.println(method4);
		
		method5 = test.getOceanInfo(1);
		System.out.println(method5);
		
		method6 = test.chgHDI(7, 2013, 100);
		System.out.println(method6);
		
		method7 = test.deleteNeighbour(9, 10);
		System.out.println(method7);
		
		method8 = test.listCountryLanguages(7);
		System.out.println(method8);
		
		method9 = test.updateHeight(1, 20);
		System.out.println(method9);
		
		method10 = test.updateDB();
		System.out.println(method10);
		
		method2 = test.disconnectDB();
		System.out.println(method2);
		
	}

}

// move all files including postgresql-9.1-903.jdbc4.jar to same directory
// psql csc343h-c4zhanhw
// \i a2.ddl
// \i data.sql
// \q
// javac testmain.java Assignment2.java
// java -cp postgresql-9.1-903.jdbc4.jar: testmain
