package com.zookeeperdemo;

public class Bat extends Mammal {

    // Constructor to set the energy level to 300
    public Bat() {
        this.setEnergy(300);
    }

    // Method for the bat to fly
    public void fly() {
        this.setEnergy(getEnergy()-50);
        System.out.println("The bat takes off into the air Energy decreased by 50");
    }

    // Method for the bat to eat humans
    public void eatHumans() {
        this.setEnergy(getEnergy()+25);
        System.out.println("The bat eats a human and looks satisfied  Energy increased by 25");
    }

    // Method for the bat to attack a town
    public void attackTown() {
        this.setEnergy(getEnergy()-100);
        System.out.println("The bat attacks a town Energy decreased by 100");
    }
}
