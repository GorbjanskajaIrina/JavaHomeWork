package com.pb.gorbjanskaja.hw4;

import java.util.Scanner;

public class CapitalLetter {

    static void changeLetter(){

        Scanner Scan = new Scanner(System.in);
        String str = Scan.nextLine();
        char[] str1 = new char[str.length()];

        for(int i=0; i<str.length(); i++)  //переводим сроку в массив символов
        {
            str1[i] = str.charAt(i);
        }
        str1[0] = Character.toUpperCase(str1[0]); //первый символ переводим в верхний регистр

        for(int i=0;i<str.length();i++)
        {
            if(str1[i] == ' ')                 //если перед символом пробел, переводим его в верхний регистр
            {
                //str1[i+1] = Character.toUpperCase(str1[i+1]);
                str1[i+1] = Character.toTitleCase(str1[i+1]);
            }
            System.out.print(str1[i]);
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the expression : ");
        changeLetter();
    }
}