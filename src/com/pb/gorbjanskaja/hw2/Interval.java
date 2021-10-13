package com.pb.gorbjanskaja.hw2;

import java.util.Scanner;

public class Interval {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int number;

        System.out.println("Please, enter a number");
        number= scan.nextInt();

        if(number>=0 && number<=14) {
            System.out.println("The number is from interval [0-14]");
        }
        if(number>=15 && number<=35) {
            System.out.println("The number is from interval [15-35]");
        }
        if(number>=36 && number<=50) {
            System.out.println("The number is from interval [36-50]");
        }
        if(number>=51 && number<=100) {
            System.out.println("The number is from interval [51-100]");
        }
        if(number>100 || number<0) {
            System.out.println("The number isn't from any of intervals [0-14] [15-35] [36-50] [51-100]");
        }
    }
}
