package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter department's name: ");
		String nameDepartment = sc.nextLine();
		
		System.out.println("Enter Worker data:");
		System.out.print("Name: ");
		String nameWorker = sc.nextLine();
		
		System.out.print("Level: ");
		String levelWorker = sc.nextLine().toUpperCase();
		
		System.out.print("Base salary: ");
		Double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(nameWorker, WorkerLevel.valueOf(levelWorker), baseSalary, new Department(nameDepartment));
		
		System.out.print("How many contracts to this worker? ");
		Integer n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Enter contract #"+(i+1)+" data:");
			sc.nextLine();
			System.out.print("Date (DD/MM/YYYY): ");
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate date = LocalDate.parse(sc.next(), format);
			
			System.out.print("Value Per Hour: ");
			Double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (hours): ");
			Integer durationHours = sc.nextInt();
			
			HourContract hourContract = new HourContract(date, valuePerHour, durationHours);
			worker.addContract(hourContract);
			
		}
		
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		sc.nextLine();
		String dateMonthYear = sc.next();
		Integer month = Integer.parseInt(dateMonthYear.substring(0, 2));
		Integer year = Integer.parseInt(dateMonthYear.substring(3));
	    
		
		System.out.println("Name: "+worker.getName());
		System.out.println("Department: " + worker.getDepartment().getDepartmentName());
		System.out.println("Income for " + dateMonthYear+": "+String.format("%.2f", worker.income(month, year)));
		

		
		
		sc.close();
	}

}
