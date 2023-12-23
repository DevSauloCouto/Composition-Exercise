package entities;

import java.time.LocalDate;

public class HourContract {
	
	private LocalDate date;
	private Double valuePerHour;
	private Integer hours;
	
	public HourContract(LocalDate date, Double value, Integer hours) {
		this.date = date;
		this.valuePerHour = value;
		this.hours = hours;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public Double totalValue() {
		return valuePerHour * hours;
	}
	
	@Override 
	public String toString() {
		return "date="+date+"; valuePerHour="+valuePerHour+"; hours="+hours;
	}
	
}
