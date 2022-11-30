package com.judah.caranddriver;

import com.judah.caranddriver.models.Driver;

public class CarTest {

	public static void main(String[] args) {
		Driver driver1 = new Driver();
		System.out.println(driver1.getGas());
		driver1.drive();
		driver1.drive();
		driver1.drive();
		driver1.drive();
		System.out.println(driver1.getGas());
		driver1.useBoosters();
		System.out.println(driver1.getGas());
		driver1.refuel();
		driver1.refuel();
		driver1.refuel();
		System.out.println(driver1.getGas());

	}

}
