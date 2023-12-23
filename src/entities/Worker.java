package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker(String name, WorkerLevel level, Double sal, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = sal;
		this.department = department;
	}
	
	public String getName() {
		return name;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income(Integer month, Integer year) {
		
		Double total = 0.0;
		
		List<HourContract> contractsFilters = contracts.stream().filter(x -> x.getDate().getMonthValue() == month && x.getDate().getYear() == year).collect(Collectors.toList());

		for(HourContract hc : contractsFilters) {
			total += hc.totalValue();
		}
		
		return total + baseSalary;
		
	}
	
	@Override
	public String toString() {
		return "name="+name+"; level="+level+"; baseSalary="+baseSalary;
	}
	
	
	
}
