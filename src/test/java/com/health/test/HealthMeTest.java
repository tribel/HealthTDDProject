package com.health.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.health.HealthService;

public class HealthMeTest {
	
	public static final double MIN_WATER_COUNT = 2;
	public static final int MIN_CALORIES_COUNT = 1300;
	public static final int MIN_STEP_AMOUNT = 2000;
	public static final double MIN_HOURS_AMOUNT = 2;
	
	HealthService healsService = new HealthService();
	
	
	@Before
	public void initRules() {
		LocalDate tmpDate = LocalDate.of(2016, 9, 1);
		
		healsService.setWaterRule(MIN_WATER_COUNT, tmpDate);
		healsService.setCaloriesRule(MIN_CALORIES_COUNT, tmpDate);
		healsService.setStepsRule(MIN_STEP_AMOUNT, tmpDate);
		healsService.setHoursRule(MIN_HOURS_AMOUNT, tmpDate);
		
        tmpDate = LocalDate.of(2016, 9, 2);
		healsService.setWaterRule(MIN_WATER_COUNT, tmpDate);
		healsService.setCaloriesRule(MIN_CALORIES_COUNT, tmpDate);
		healsService.setStepsRule(MIN_STEP_AMOUNT, tmpDate);
		healsService.setHoursRule(MIN_HOURS_AMOUNT, tmpDate);
	}
	
	@Test
	public void drinkWaterTest() {
		LocalDate tmpDate = LocalDate.of(2016, 9, 1);
		
		healsService.drinkWater(1.2, tmpDate);
		assertEquals(healsService.dailyWaterRest(tmpDate), 0.8, 0.01);
		
		healsService.drinkWater(0.8, tmpDate);
		assertEquals(healsService.dailyWaterRest(tmpDate), 0.0, 0.01);
	}
	
	@Test
	public void eatCaloriesTest() {
		LocalDate tmpDate = LocalDate.of(2016, 9, 1);
		
		healsService.eatCalories(500, tmpDate);
		assertEquals(healsService.dailyCaloriesRest(tmpDate), 800);
		
		healsService.eatCalories(100, tmpDate);
		assertEquals(healsService.dailyCaloriesRest(tmpDate), 700);
	}
	
	@Test
	public void makeStepTest() {
		LocalDate tmpDate = LocalDate.of(2016, 9, 1);
		
		healsService.makeSteps(50, tmpDate);
		assertEquals(healsService.dailyStepsRest(tmpDate), 1950, 0.01);
		
		tmpDate = LocalDate.of(2016, 9, 2);
		healsService.makeSteps(1900, tmpDate);
		assertEquals(healsService.dailyStepsRest(tmpDate), 100, 0.01);
	}
	
	public void moveHours() {
		LocalDate tmpDate = LocalDate.of(2016, 9, 1);
		
		healsService.moveHours(1.3, tmpDate);
		assertEquals(healsService.dailyHoursRest(tmpDate), 0.7, 0.01);
		
	}
}
