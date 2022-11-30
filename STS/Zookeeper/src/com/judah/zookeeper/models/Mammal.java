package com.judah.zookeeper.models;

public class Mammal {
	// attributes
	protected int energyLevel;
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
	public Mammal(int energyLevel) {
		this.setEnergyLevel(100);
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	// method
	public void displayEnergy() {
		System.out.println("Energy Level: " + energyLevel);
	}

}
