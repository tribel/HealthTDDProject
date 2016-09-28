package mokitoTest.testMockito;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HealthService {

	Map<LocalDate, HealthIndicators> fullReport;
	
	public HealthService() {
		this.fullReport = new  HashMap<>();
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
	
	
	public double dailyWaterRest(LocalDate date) {
		return fullReport.get(date).getWaterLiter();
	}

	public int dailyCaloriesRest(LocalDate tmpDate) {
		return fullReport.get(tmpDate).getCalories();
	}
	
	public double dailyStepsRest(LocalDate tmpDate) {
		return fullReport.get(tmpDate).getStepsAmount();
	}
	
	
	public double dailyHoursRest(LocalDate tmpDate) {
		return fullReport.get(tmpDate).getHoursAmount();
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


	public void moveHours(double d, LocalDate tmpDate) {
		fullReport.get(tmpDate).addMoveHours(d);
	}








	

	
}
