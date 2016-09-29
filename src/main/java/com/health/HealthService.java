package com.health;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class HealthService {

	TreeMap<LocalDate, HealthIndicators> fullReport;
	
	public HealthService() {
		this.fullReport = new TreeMap<>();
	}
	
	
	public void drinkWater(double waterLiter, LocalDate date) {
		fullReport.get(date).addWaterLiter(waterLiter);
	}
	

	public void eatCalories(int i, LocalDate tmpDate) {
		fullReport.get(tmpDate).addCalories(i);
	}
	
	public void makeSteps(int i, LocalDate tmpDate) {
		fullReport.get(tmpDate).addStepsAmount(i);
	}
	
	public void moveHours(double d, LocalDate tmpDate) {
		fullReport.get(tmpDate).addMoveHours(d);
	}
	
	public double dailyWaterRest(LocalDate date) {
		return fullReport.get(date).getWaterRemain();
	}

	public double dailyCaloriesRest(LocalDate tmpDate) {
		return fullReport.get(tmpDate).getCaloriesRemain();
	}
	
	public double dailyStepsRest(LocalDate tmpDate) {
		return fullReport.get(tmpDate).getStepsRemain();
	}
	
	public double dailyHoursRest(LocalDate tmpDate) {
		return fullReport.get(tmpDate).getHoursRemain();
	}
	
	public void setWaterRule(double d, LocalDate tmpDate) {
		isDateExist(tmpDate);
		fullReport.get(tmpDate).setWaterRule(d);
	}


	public void setCaloriesRule(int minCaloriesCount, LocalDate tmpDate) {
		isDateExist(tmpDate);
		fullReport.get(tmpDate).setCaloriesRule(minCaloriesCount);
	}


	public void setStepsRule(int minStepAmount, LocalDate tmpDate) {
		isDateExist(tmpDate);
		fullReport.get(tmpDate).setStepsRule(minStepAmount);
	}


	public void setHoursRule(double minHoursAmount, LocalDate tmpDate) {
		isDateExist(tmpDate);
		fullReport.get(tmpDate).setHoursRule(minHoursAmount);
	}
	
	private void isDateExist(LocalDate date) {
		fullReport.putIfAbsent(date, new HealthIndicators());
	}


	
	public double[] getDailyProcentReport(LocalDate tmpDate) {
		HealthIndicators indicators = fullReport.get(tmpDate);

		double[] resultArray = new double[4];
		resultArray[0] = indicators.calculateWaterPercent();
		resultArray[1] = indicators.calculateHoursPercent();
		resultArray[2] = indicators.calculateCaloriesPercent();
		resultArray[3] = indicators.calculateStepsPercent();
		
		return resultArray;
	}


	public double[] getDatePeriodProcentReport(LocalDate startDate, LocalDate endDate) {
		Collection<HealthIndicators> healthIndicators = fullReport.subMap(startDate, true, endDate, true).values();
		double[] resultArray = new double[4];
		
		 resultArray[0] = sortCollection((o1,o2) -> (int)(o1.calculateWaterPercent() - o2.calculateWaterPercent()), 
				 healthIndicators).calculateWaterPercent();
		 
		 resultArray[1] = sortCollection((o1,o2) -> (int)(o1.calculateCaloriesPercent() - o2.calculateCaloriesPercent()), 
				 healthIndicators).calculateCaloriesPercent();
		 
		 resultArray[2] = sortCollection((o1,o2) -> (int)(o1.calculateStepsPercent() - o2.calculateStepsPercent()), 
				 healthIndicators).calculateStepsPercent();
		 
		 resultArray[3] = sortCollection((o1,o2) -> (int)(o1.calculateHoursPercent() - o2.calculateHoursPercent()), 
				 healthIndicators).calculateHoursPercent();

		return resultArray;
	}
	
	private HealthIndicators sortCollection(Comparator<? super HealthIndicators> comparator, 
			Collection<HealthIndicators> hi) {
		
		return hi.stream()
				.sorted(comparator)
				.collect(Collectors.toList())
				.get(hi.size()/2);
	}
	
	
}
