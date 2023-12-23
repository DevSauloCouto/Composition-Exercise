package entities;

public class Department {

	private String name;
	
	public Department(String name) {
		this.name = name;
	}
	
	public String getDepartmentName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "name="+name;
	}
	
}
