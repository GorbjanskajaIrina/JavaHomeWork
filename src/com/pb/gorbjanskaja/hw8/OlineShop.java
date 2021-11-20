package com.pb.gorbjanskaja.hw8;

import java.util.Scanner;

public class OlineShop {
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        Auth auth = new Auth();
        System.out.println("Для регистрации введите логин");
        String log = scan.nextLine();
        System.out.println("Придумайте пароль");
        String pasw = scan.nextLine();
        System.out.println("Повторите пароль");
        String confPasw = scan.nextLine();

        try {
            auth.signUp(log, pasw, confPasw);
        }
        catch (WrongLoginExeption e) {
            System.out.println("Логин не подходит  " + e.getMessage());
           e.printStackTrace();
        }
        catch (WrongPasswordException e) {
            System.out.println("Пароль не подходит:  " + e.getMessage());
            e.printStackTrace();
            return;
        }

        System.out.println("Зайдите на сайт");
        System.out.println("Введите логин");
        String log2 = scan.nextLine();
        System.out.println("Введите пароль");
        String pasw2 = scan.nextLine();

        try {
            auth.signIn(log2, pasw2);

        }
        catch (WrongLoginExeption e1) {
            System.out.println("Ошибка при входе 1   " + e1.getMessage());
            e1.printStackTrace();
        }
        /*catch (WrongPasswordException e1) {
            System.out.println("Ошибка при входе 2   " + e1.getMessage());
            e1.printStackTrace();
        }*/


    }
}
