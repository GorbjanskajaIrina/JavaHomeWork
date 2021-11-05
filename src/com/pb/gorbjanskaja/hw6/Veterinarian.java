package com.pb.gorbjanskaja.hw6;

public class Veterinarian {
    public Veterinarian() {
    }

    public void treatAnimal(Animal animal) {
            System.out.println("На приеме у ветеринара" + animal +", питается: " + animal.getFood()
                    + ", место обитания: " + animal.getLocation());
        }
}
