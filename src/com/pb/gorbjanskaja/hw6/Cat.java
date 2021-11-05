package com.pb.gorbjanskaja.hw6;

import java.util.Objects;

public class Cat extends Animal {
    private int caughtMouse;

    public Cat(String food, String location, int caughtMouse) {
        super(food, location);
        this.caughtMouse = caughtMouse;
    }
    public void makeNoise() {
        System.out.println("Кот мяукает");
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        Cat cat = (Cat) o;
        return caughtMouse == cat.caughtMouse && Objects.equals(getFood(), cat.getFood())
                && Objects.equals(getLocation(), cat.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(caughtMouse);
    }

    @Override
    public String toString() {
        return " Cat{" +
                "пойманых мышей " + caughtMouse +
                '}';
    }
}
