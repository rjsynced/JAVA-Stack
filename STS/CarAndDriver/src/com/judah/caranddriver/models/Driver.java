package com.judah.caranddriver.models;

public class Driver extends Car{
	// attributes
	private String name;
	private boolean hasLicense;
	
	public Driver() {
		this.name = "Name no given";
		this.setHasLicense(true);
	}

	public Driver(String name) {
		this.name = name;
		this.setHasLicense(true);
	}
	
	public boolean isHasLicense() {
		return hasLicense;
	}
	
	public void setHasLicense(boolean hasLicense) {
		this.hasLicense = hasLicense;
	}
	
	public String getName() {
		return name;
	}
	
	public void drive() {
		if(super.getGas() > 0) {
			super.removeGas(1);
		} else {
			System.out.println("Not enough gas to drive");
		}
	}
	
	public void useBoosters() {
		if(super.getGas() >= 3) {
			super.removeGas(3);
		} else {
			System.out.println("Not enough gas to NOS");
		}
	}
	
	public void refuel() {
		if(super.getGas() > (super.getTankLimit() -2)) {
			super.setTankLimit(super.getTankLimit());
		} else {
			super.addGas(2);
		}
	}
	
	
	
}
