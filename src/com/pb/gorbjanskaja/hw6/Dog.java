package com.pb.gorbjanskaja.hw6;

import java.util.Objects;

public class Dog extends Animal {
    private String petTreat;

    public Dog(String food, String location, String petTreat) {
        super(food, location);
        this.petTreat = petTreat;
    }


    public void makeNoise() {
        System.out.println("Собака лает");
    }
    public void eat() {
        System.out.println("Собака ест");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(petTreat, dog.petTreat) && Objects.equals(getFood(), dog.getFood())
                && Objects.equals(getLocation(), dog.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(petTreat);
    }

    @Override
    public String toString() {
        return " Dog{" +
                "любимое лакомство " + petTreat + '}';
    }
}
