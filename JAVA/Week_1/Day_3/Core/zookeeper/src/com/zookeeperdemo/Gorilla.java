package com.zookeeperdemo;

public class Gorilla extends Mammal {

    // Method to throw something
    public void throwSomething() {
        this.setEnergy(getEnergy()-5);
        System.out.println("The gorilla has thrown something Energy decreased by 5");
    }

    // Method to eat bananas
    public void eatBananas() {
        this.setEnergy(getEnergy()+10);
        System.out.println("The gorilla eats bananas  Energy increased by 10");
    }

    // Method to climb a tree
    public void climb() {
        this.setEnergy(getEnergy()-10);
        System.out.println("The gorilla has climbed a tree Energy decreased by 10");
    }
}
