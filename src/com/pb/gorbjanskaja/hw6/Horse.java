package com.pb.gorbjanskaja.hw6;

import java.util.Objects;

public class Horse extends Animal {
    private int numRaces;
    private String pedigree;

    public Horse(String food, String location, int numRaces, String pedigree) {
        super(food, location);
        this.numRaces = numRaces;
        this.pedigree = pedigree;
    }


    public void makeNoise() {
        System.out.println("Лошадка ржет");
    }
    public void eat() {
        System.out.println("Лошадка ест");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return numRaces == horse.numRaces && Objects.equals(pedigree, horse.pedigree)
                && Objects.equals(getFood(), horse.getFood()) && Objects.equals(getLocation(), horse.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(numRaces, pedigree);
    }

    @Override
    public String toString() {
        return " Horse{" +
                "заездов " + numRaces +
                ", родословная " + pedigree + '}';
    }
}
