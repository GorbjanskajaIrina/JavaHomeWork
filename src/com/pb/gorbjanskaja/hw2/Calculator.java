package com.pb.gorbjanskaja.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double operand1;
        double operand2;
        char sign;

        System.out.println("Please, enter two numbers");
        operand1 = scan.nextDouble();
        operand2 = scan.nextDouble();

        System.out.println("and enter one of the operator: +,-,*,/ ");
        sign = scan.next().charAt(0);

        double result;

        if (operand2 == 0 && sign == '/') {
            System.out.printf("Error! You can't divide by zero");
        } else {
            switch (sign) {
                case '+':
                    result = operand1 + operand2;
                    break;
                case '-':
                    result = operand1 - operand2;
                    break;
                case '*':
                    result = operand1 * operand2;
                    break;
                case '/':
                    result = operand1 / operand2;
                    break;
                default:
                    System.out.printf("Error! Enter correct operator");

                    return;
            }
            System.out.print("The result is: ");
            System.out.printf(operand1 + " " + sign + " " + operand2 + " = " + result);
        }
    }
}

