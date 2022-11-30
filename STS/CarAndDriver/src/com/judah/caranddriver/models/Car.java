package com.judah.caranddriver.models;

public class Car {
	// attributes
	private int gasTankLimit;
	private int gas;
	
	
	public Car() {
		this.setTankLimit(10);
		this.setGas(10);
		
	}
	
	public Car(int gasTankLimit, int gas) {
		this.gasTankLimit = gasTankLimit;
		this.gas = gas;
	}

	public int getTankLimit() {
		return gasTankLimit;
	}

	public void setTankLimit(int gasTankLimit) {
		this.gasTankLimit = gasTankLimit;
	}

	public int getGas() {
		return gas;
	}

	public void setGas(int gas) {
		this.gas = gas;
	}
	
	public void addGas(int gas) {
		this.gas += gas;
	}
	
	public void removeGas(int gas) {
		this.gas -= gas;
	}
}
