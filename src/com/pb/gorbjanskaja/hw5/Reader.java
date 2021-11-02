package com.pb.gorbjanskaja.hw5;

public class Reader {
    String fullName;
    int libraryPass;
    String faculty;
    String dateOfBirth;
    String telephoneNumber;

    public Reader(String fullName, int libraryPass, String faculty, String dateOfBirth, String telephoneNumber) {
        this.fullName = fullName;
        this.libraryPass = libraryPass;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.telephoneNumber = telephoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void takeBook(int numberOfBooks) {
        System.out.println(fullName + " взял " + numberOfBooks + " книг" );
    }

    public void takeBook(String ... titles) {
        System.out.println(fullName + " взял: " );
        for (String title: titles)
            System.out.println(title);
    }
    public void takeBook(Book ... books) {
        System.out.println(fullName + " взял книги" );
        for (Book book: books)
            System.out.println(book);

    }
    public void returnBook(int numberOfBooks) {
        System.out.println(fullName + " вернул " + numberOfBooks + " книг" );
    }

    public void returnBook(String...titles) {
        System.out.println(fullName + " вернул: " );
        for (String title: titles)
            System.out.println(title);


    }
    String getInfo() {
        return  fullName + " " + libraryPass + " " + faculty +" " + dateOfBirth + " " + telephoneNumber;

    }


}
