package com.pb.gorbjanskaja.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        System.out.println("Enter the first expression");
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        System.out.println("Enter the second expression");
        String str2 = scan.nextLine();
        str1 = delNoLet(str1);
        str1 = delNoLet(str1).toLowerCase();
        str2 = delNoLet(str2).toLowerCase();
        System.out.println("Are the first and second expressions an anagram? Result: " + isAnagram(str1, str2));
    }

    public static String delNoLet(String str1) { //метод убирает с текста все что не является буквой

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            if (Character.isLetter(str1.charAt(i))) {
                sb.append(str1.charAt(i));
            }
        }
        return sb.toString();             //возвращает строку без пробелов, цифр и других символов кроме букв
    }

    public static boolean isAnagram(String str1, String str2) { //метод переводит две строки в массив символов
                                                                // и сравнивает эти массивы
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2);     //возвращает результат сравнения  true или falce
    }
}
