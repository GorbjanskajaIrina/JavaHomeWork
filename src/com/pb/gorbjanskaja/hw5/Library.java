package com.pb.gorbjanskaja.hw5;

public class Library {
    public static void main(String[] args){


        Reader reader1 = new Reader("Добров И.В.", 72, "ф-т математики", "06.07.1994", "0976572000");

        reader1.setFullName("Петров В.В.");
        reader1.takeBook(3);
        reader1.takeBook("Приключения", " Словарь", " Энциклопедия");


        Book[] bookArray = new Book[3];


        bookArray[0] = new Book("Приключения", "Иванов И.И.", 2000);
        bookArray[1] = new Book("Словарь", "Сидоров А.В.", 1980);
        bookArray[2] = new Book("Энциклопедия", "Гусев К.В.", 2010);


        for (int i = 0; i<3; i++) {
            reader1.takeBook(bookArray[i].getInfo());
        }

        reader1.returnBook(3);
        reader1.returnBook("Приключения", " Словарь", " Энциклопедия");

        System.out.println("Все книги:");

        for (int i = 0; i<3; i++) {
            System.out.println(bookArray[i].getInfo());
        }
        Reader[] readerArray = new Reader[3];
        readerArray[0] = new Reader("Добров И.В.", 72, "ф-т математики", "06.07.1994", "0976572000");
        readerArray[1] = new Reader("Прокопов С.П.", 456, "ф-т химии", "24.12.1990", "0936783011");
        readerArray[2] = new Reader("Князева", 90, "ф-т физики", "08.02.1998", "0998761124");

        System.out.println("Все читатели:");

        for (int i = 0; i<3; i++) {
            System.out.println(readerArray[i].getInfo());
        }

    }
}
