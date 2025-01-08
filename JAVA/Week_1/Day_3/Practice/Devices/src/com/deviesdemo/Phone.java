package com.deviesdemo;

	public class Phone extends Device {

	    // Method to make a call
	    public void makeCall() {
	        if (this.getBattery()>= 5) {
	            this.setBattery(getBattery()-5);
	            System.out.println("You make a call.");
	            this.status();
	        } else {
	            System.out.println("Battery too low to make a call.");
	        }
	    }

	    // Method to play a game
	    public void playGame() {
	        if (this.getBattery() < 25) {
	            System.out.println("Battery too low to play a game.");
	        } else {
	            this.setBattery(getBattery()-20);
	            System.out.println("You play a game.");
	            this.status();
	        }
	    }

	    // Method to charge the phone
	    public void charge() {
	        this.setBattery(getBattery()+50);
	        if (this.getBattery() > 100) {
	            this.setBattery(100);
	        }
	        System.out.println("You charge the phone.");
	        this.status();
	    }
	}
