package com.pb.gorbjanskaja.hw3;

import java.util.Scanner;

public class Array {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите одномерный массив целых чисел размерностью 10 элементов");
        int [] array = new int[10];
        for(int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        System.out.println("Печатаем массив:");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ " ");
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        System.out.println("\nСумма элеметов массива равна " + sum);

        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
            counter += 1;
            }
        }
        System.out.println("Количество положительных элементов " + counter);

        for (int i = 0; i < array.length - 1; i++) {
            // внутренний цикл прохода
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        System.out.println("Печатаем отсортированный методом пузырька массив:");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ " ");
        }

    }
}
