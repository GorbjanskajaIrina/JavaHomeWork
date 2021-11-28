package com.pb.gorbjanskaja.hw10;

public class Main {
    public static void main(String[] args) {
        NumBox<Integer> integerNumBox = new NumBox<>(4);
        try {
            integerNumBox.add(7);
            integerNumBox.add(10);
            integerNumBox.add(22);
        }
        catch ( ArrayIndexOutOfBoundsException e) {
            System.out.println("Массив переполнен. Длина массива " + integerNumBox.getSize());
            e.printStackTrace();
        }
        for (int i=0; i< integerNumBox.lengthMas(); i++) {
            System.out.println(integerNumBox.get(i));
        }
        System.out.println("Текущее количество элементов массива " + integerNumBox.lengthMas());
        System.out.println("Среднее арифметическое элементов массива " + integerNumBox.average());
        System.out.println("Сумма элементов массива " + integerNumBox.sum());
        System.out.println("Максимальный эелемент массива " + integerNumBox.max());

        NumBox<Float> floatNumBox = new NumBox<>(4);
        try {
            floatNumBox.add(4.15F);
            floatNumBox.add(1.06F);
            floatNumBox.add(2.72F);
        }
        catch ( ArrayIndexOutOfBoundsException e) {
            System.out.println("Массив переполнен. Длина массива " + floatNumBox.getSize());
            e.printStackTrace();
        }
        for (int i=0; i< floatNumBox.lengthMas(); i++) {
            System.out.println(floatNumBox.get(i));
        }
        System.out.println("Текущее количество элементов массива " + floatNumBox.lengthMas());
        System.out.println("Среднее арифметическое элементов массива " + floatNumBox.average());
        System.out.println("Сумма элементов массива " + floatNumBox.sum());
        System.out.println("Максимальный эелемент массива " + floatNumBox.max());



    }
}
