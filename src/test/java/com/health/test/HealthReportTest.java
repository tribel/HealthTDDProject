package com.health.test;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.health.HealthService;
import static org.junit.Assert.*;

public class HealthReportTest {

	public static final double MIN_WATER_COUNT = 2;
	public static final int MIN_CALORIES_COUNT = 1300;
	public static final int MIN_STEP_AMOUNT = 2000;
	public static final double MIN_HOURS_AMOUNT = 2;
	
	HealthService healsService = new HealthService();
	
	private void inputValues(LocalDate date) {
		healsService.setWaterRule(MIN_WATER_COUNT, date);
		healsService.setCaloriesRule(MIN_CALORIES_COUNT, date);
		healsService.setStepsRule(MIN_STEP_AMOUNT, date);
		healsService.setHoursRule(MIN_HOURS_AMOUNT, date);
	}
	
	@Before
	public void init() {
		
		LocalDate tmpDate = LocalDate.of(2016, 9, 1);
		
		for(int days = 0; days < 7;  days++) {
			inputValues(tmpDate);
			tmpDate = tmpDate.plusDays(1);
		}
	}
	
	@Test
	public void dailyReport() {
		LocalDate tmpDate = LocalDate.of(2016, 9, 26);
		inputValues(tmpDate);
		double[] cmpArray = {75.0, 65.0, 10.0, 15.0};
		
		healsService.drinkWater(1.5, tmpDate);
		healsService.eatCalories(130, tmpDate);
		healsService.makeSteps(300, tmpDate);
		healsService.moveHours(1.3, tmpDate);
			
		assertTrue(Arrays.equals(cmpArray, healsService.getDailyProcentReport(tmpDate)));
	}
	
	@Test
	public void datePeriodReport() {
		LocalDate startDate = LocalDate.of(2016, 9, 1);
		LocalDate endDate = startDate.plusDays(2);
		
		healsService.eatCalories(1300, startDate);
		healsService.drinkWater(1.5, startDate);
		healsService.moveHours(0.7, startDate);
		healsService.makeSteps(1200, startDate);
		
		healsService.eatCalories(130, LocalDate.of(2016, 9, 2));
		healsService.drinkWater(0.7, LocalDate.of(2016, 9, 2));
		healsService.moveHours(1.5, LocalDate.of(2016, 9, 2));
		healsService.makeSteps(400, LocalDate.of(2016, 9, 2));
		
		healsService.eatCalories(100, LocalDate.of(2016, 9, 3));
		healsService.drinkWater(0.3, LocalDate.of(2016, 9, 3));
		healsService.moveHours(0.5, LocalDate.of(2016, 9, 3));
		healsService.makeSteps(100, LocalDate.of(2016, 9, 3));
		
		double[] resultPercentArray = {35.0, 10.0, 20.0, 35.0};
		
		assertTrue(Arrays.equals(resultPercentArray, healsService.getDatePeriodProcentReport(startDate, endDate)));
	}
	
}
