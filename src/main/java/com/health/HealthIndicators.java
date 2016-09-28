package com.health;


public class HealthIndicators {

	private double waterLiter;
	private int calories;
	private int stepsAmount;
	private double hoursAmount;
	
	public HealthIndicators() {
	}


	public double addWaterLiter(double waterLiter) {
		return this.waterLiter -= waterLiter;
	}

	public int addCalories(int calories) {
		return this.calories -= calories;
	}

	public int addStepsAmount(int stepsAmount) {
		return this.stepsAmount -= stepsAmount;
	}

	public double addMoveHours(double moveHours) {
		return this.hoursAmount -= moveHours;
	}
	
	public double getHoursAmount() {
		return hoursAmount;
	}

	public int getStepsAmount() {
		return stepsAmount;
	}

	public int getCalories() {
		return calories;
	}
	
	public double getWaterLiter() {
		return waterLiter;
	}
	
	public void setWaterRule(double liters) {
		this.waterLiter = liters;
	}
	
	public void setCaloriesRule(int calories) {
		this.calories = calories;
	}

	public void setStepsRule(int steps) {
		this.stepsAmount  = steps;
	}
	
	public void setHoursRule(double hours) {
		this.hoursAmount = hours;
	}
}
