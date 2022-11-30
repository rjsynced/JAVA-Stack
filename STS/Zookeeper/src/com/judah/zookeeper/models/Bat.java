package com.judah.zookeeper.models;

public class Bat extends Mammal{
	
	public Bat() {
		super();
	}

	public Bat(int energyLevel) {
		super.setEnergyLevel(energyLevel);
		// TODO Auto-generated constructor stub
	}
	
	public void fly() {
		energyLevel -= 50;
		System.out.println("Zuubat used FLY!");
		displayEnergy();
	}
	public void eatHumans() {
		energyLevel += 25;
		System.out.println("Zuubat used CRUNCH");
		displayEnergy();
	}
	public void attackTown() {
		energyLevel -= 100;
		System.out.println("!!Zuubat went beserk!!");
		displayEnergy();
	}
}
