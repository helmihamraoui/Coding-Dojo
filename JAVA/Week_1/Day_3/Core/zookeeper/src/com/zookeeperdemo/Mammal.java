package com.zookeeperdemo;

public class Mammal {
	private int energy;
	// Constructor add the energy level
	public Mammal() {
		this.energy = 100;
	}
	
    public int getEnergy() {
		return this.energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

    // Method to display the energy level
    public int displayEnergy() {
        System.out.println("Energy level: " + this.energy);
        return this.energy;
    }

}
