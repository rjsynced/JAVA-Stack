package com.judah.zookeeper.models;

public class Gorilla extends Mammal{
	
	public Gorilla() {
		super();
	}
	
	public Gorilla(int energyLevel) {
		super.setEnergyLevel(energyLevel);
		
		// TODO Auto-generated constructor stub
	}

	public void yeetSomething() {
		energyLevel -= 5;
		System.out.println("The Gorilla has thrown something at YOU!");
		displayEnergy();
	}
	
	public void eatBananas() {
		energyLevel += 10;
		System.out.println("The Gorilla eats some bananas and is very much satisfied.");
		displayEnergy();
	}
	
	public void climb() {
		energyLevel -=10;
		System.out.println("The Gorilla gets to higher ground via tree! used 1 banana energy");
	}
}
