package com.pb.gorbjanskaja.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
        public static void main(String [] args) {
            Random random = new Random();
            int number = random.nextInt( 101); //Задаем случайное число от 0 до 100

            System.out.println("Отгадайте число от 1 до 100");
            System.out.println("Для выхода наберите -1");

            Scanner scan = new Scanner(System.in);
            int  playerNumber = scan.nextInt(); //Cчитываем введенное пользователем число
            int attempt = 1;           // Счетчик попыток

            while (playerNumber != number) {
                attempt++;

                if (playerNumber == -1) {
                    System.out.println("Вы вышли из игры");
                    break;
                }
                if (playerNumber > number) {
                    System.out.println("Попробуйте ввести число меньше");
                }
                if (playerNumber < number) {
                    System.out.println("Попробуйте ввести число больше");
                }
                playerNumber = scan.nextInt();
            }

                if (playerNumber == number) {
                    System.out.println("Поздравляем, число " + number + " отгадано с " + attempt + " попытки");
                }
        }
}
