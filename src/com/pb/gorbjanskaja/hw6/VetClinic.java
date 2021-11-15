package com.pb.gorbjanskaja.hw6;

import java.lang.reflect.Constructor;

public class VetClinic {
    public static void main(String[] args) throws Exception {

        Animal animal = new Animal();

        Cat cat1 = new Cat("Kitekat", "Квартира", 22);
        Cat cat2 = new Cat("Рыба", "Квартира", 21);
        Cat cat3 = new Cat("Kitekat", "Квартира", 22);

        animal.makeNoise();

        cat1.makeNoise();

        cat1.eat();

        System.out.println("hashCodes котов:");
        System.out.println(cat1.hashCode());
        System.out.println(cat2.hashCode());
        System.out.println(cat3.hashCode());

        System.out.println("equals cat1  cat2: " + cat2.equals(cat1));
        System.out.println("equals cat1  cat2: " + cat3.equals(cat1));


        Dog dog = new Dog("Pedigree", "Улица", "Косточка");
        Horse horse = new Horse("Овес", "Конюшня", 39, "чистокровный");


        Class vetClazz = Class.forName("com.pb.gorbjanskaja.hw6.Veterinarian");
        Constructor constr = vetClazz.getConstructor(new Class[] {});
        Object obj = constr.newInstance();


        Animal[] animals = new Animal[] {cat1, dog, horse};
        for (Animal an: animals) {
            if (obj instanceof Veterinarian)
                ((Veterinarian) obj).treatAnimal(an);
        }


    }
}
