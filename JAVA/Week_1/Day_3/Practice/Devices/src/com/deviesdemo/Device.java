package com.deviesdemo;

public class Device {
	private int battery;
 
    public int getBattery() {
		return this.battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	// Constructor add the battery to 100
    public Device() {
        this.battery = 100;
    }

    // Method to display the battery status
    public void status() {
        System.out.println("Battery remaining: " + this.battery + "%");
    }
}
