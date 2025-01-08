package com.zookeeperdemo;

public class ZookeeperTest {
    public static void main(String[] args) {
        // Test the Gorilla class
        Gorilla gorilla = new Gorilla();
        System.out.println(" Testing Gorilla : ");
        gorilla.throwSomething();
        gorilla.throwSomething();
        gorilla.throwSomething();
        gorilla.eatBananas();
        gorilla.eatBananas();
        gorilla.climb();
        gorilla.displayEnergy();

        System.out.println("\n Testing Bat : ");
        // Test the Bat class
        Bat bat = new Bat();
        bat.attackTown();
        bat.attackTown();
        bat.attackTown();
        bat.eatHumans();
        bat.eatHumans();
        bat.fly();
        bat.fly();
        bat.displayEnergy();
    }
}

