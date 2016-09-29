package com.health;


public class HealthIndicators {

	private double waterLiter;
	private double calories;
	private double stepsAmount;
	private double hoursAmount;
	
	/** rules **/
	private double waterRule;
	private double caloriesRule;
	private double stepsRule;
	private double hoursRule;
	
	public HealthIndicators() {
	}


	public double addWaterLiter(double waterLiter) {
		return this.waterLiter -= waterLiter;
	}

	public double addCalories(double calories) {
		return this.calories -= calories;
	}

	public double addStepsAmount(double stepsAmount) {
		return this.stepsAmount -= stepsAmount;
	}

	public double addMoveHours(double moveHours) {
		return this.hoursAmount -= moveHours;
	}
	
	public double getHoursRemain() {
		return hoursAmount;
	}

	public double getStepsRemain() {
		return stepsAmount;
	}

	public double getCaloriesRemain() {
		return calories;
	}
	
	public double getWaterRemain() {
		return waterLiter;
	}
	
	public void setWaterRule(double liters) {
		this.waterLiter = liters;
		this.waterRule = liters;
	}
	
	public void setCaloriesRule(int calories) {
		this.calories = calories;
		this.caloriesRule = calories;
	}

	public void setStepsRule(int steps) {
		this.stepsAmount  = steps;
		this.stepsRule = steps;
	}
	
	public void setHoursRule(double hours) {
		this.hoursAmount = hours;
		this.hoursRule = hours;
	}


	public double getWaterRule() {
		return waterRule;
	}

	public double getCaloriesRule() {
		return caloriesRule;
	}

	public double getStepsRule() {
		return stepsRule;
	}

	public double getHoursRule() {
		return hoursRule;
	}


	@Override
	public String toString() {
		return "HealthIndicators [waterLiter=" + waterLiter + ", calories=" + calories + ", stepsAmount=" + stepsAmount
				+ ", hoursAmount=" + hoursAmount + ", waterRule=" + waterRule + ", caloriesRule=" + caloriesRule
				+ ", stepsRule=" + stepsRule + ", hoursRule=" + hoursRule + "]";
	}


	public double calculateWaterPercent() {
		return 100.0 - (waterLiter / waterRule * 100);
	}
	
	public double calculateCaloriesPercent() {
		return 100.0 - (calories / caloriesRule * 100);
	}
	
	public double calculateStepsPercent() {
		return 100.0 - (stepsAmount / stepsRule * 100);
	}
	
	public double calculateHoursPercent() {
		return 100.0 - (hoursAmount / hoursRule * 100);
	}
}
