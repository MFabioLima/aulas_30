package applicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidis.Department;
import entidis.HourContract;
import entidis.Worker;
import entidis.enus.WorkerLevel;



public class programo {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
				
		
		System.out.print("Entre com o nome do  departamento:");	
		String departamentName  = sc.nextLine();
		System.out.println("Enter Worker date ");
		System.out.println();
		System.out.print("Nome");
		String workeNeme = sc.nextLine();		
		System.out.print("Level ");
		String workeLevel = sc.nextLine();
		System.out.print("Base salary:");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workeNeme, WorkerLevel.valueOf(workeLevel), baseSalary, new Department(departamentName));
		
		System.out.print("How many contracts to this worker");
		int n = sc.nextInt();
		
	    for(int i=1; i <= n; i++) {
	    	System.out.println("Entre contract #" + i + " data:");
	    	System.out.print("Date (DD/MM/YYYY):");
	    	Date contractDate = sdf.parse(sc.next());
	    	System.out.print("Value per hour: ");
	    	double valuePerHour =sc.nextDouble();
	    	System.out.print("Duration (Hours):");
	    	int hours =sc.nextInt();
	    	HourContract contract = new HourContract(contractDate, valuePerHour, hours);
	    	worker.addContract(contract);
	    	
	    }
		   
	    System.out.println();
	    System.out.print("Enter month and to calculate incone mm/yyyy: ");
	    String monthAndYear =sc.next();
	    int month = Integer.parseInt(monthAndYear.substring(0,2));
	    int year = Integer.parseInt(monthAndYear.substring(3));
	    System.out.println("Name: " + worker.getName() );
	    System.out.println("Department: "+worker.getDepartment().getName());
	    System.out.println("Incone for" + monthAndYear + ":" + String.format("%.2f", worker.income(year, month)));
//	    private static SimpleDateFormat SimpleDateFormat(String string) {
		// TODO Auto-generated method stub
//		return null;
//	    }
	    sc.close();
	}

	 



}
