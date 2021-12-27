package com.pb.gorbjanskaja.hw11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] Args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        // для красивой печати (json с отступами)
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        // для работы с полями типа LocalDate
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        mapper.registerModule(module);


        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person("Ivan", LocalDate.of(1987, 2, 18), "0977777777",
                "Odessa"));
        people.add(new Person("Olga", LocalDate.of(2005, 7, 11), "0633333333",
                        "Kiev"));
        people.add(new Person("Alex", LocalDate.of(1985, 5, 16), "0500000000",
                        "Dnepr"));

        while (true) {
              System.out.println("Phone book" + "\n" +
                            "1 - to add a contact " + "\n" +
                            "2 - to delete a contact " + "\n" +
                            "3 - to search for a contact " + "\n" +
                            "4 - for output sorted by the specified field " + "\n" +
                            "5 - for editing element fields" + "\n" +
                    "Enter the number of the operation You need");
            Scanner init = new Scanner(System.in);
            int choice = init.nextInt();
            switch (choice) {
                case 1:
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Enter new contact name");
                    String name = scan.nextLine();
                    System.out.println("Enter new contact date of birth in the format Year-month-day");
                    String dateString = scan.nextLine();
                    LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    System.out.println("Enter new contact telephone number");
                    String telephone = scan.nextLine();
                    System.out.println("Enter new contact address");
                    String adress = scan.nextLine();
                    people.add(new Person(name, date, telephone,
                            adress));
                    break;
                case 2:  //
                    Scanner scan3 = new Scanner(System.in);
                    System.out.println("Enter a name or telephone number to delete");
                    String deleteName = scan3.nextLine();
                    Iterator<Person> iterator = people.iterator();
                    while (iterator.hasNext()) {
                        Person item = iterator.next();
                        if (item.getName().equals(deleteName) || item.getPhone().equals(deleteName))
                            iterator.remove();
                    }

                    System.out.println("Telephone book after remove: ");
                    System.out.println(people);
                    break;

                case 3:
                    Scanner scan2 = new Scanner(System.in);
                    System.out.println("Enter a name or telephone number to search ");
                    String searchName = scan2.nextLine();
                    for (Person i : people) {
                        if (i.getName().equals(searchName) || i.getPhone().equals(searchName)) {
                            System.out.println("Found contact is " + i);
                        }
                        //  else System.out.println("Contact not found");
                    }
                    break;
                case 4:
                    System.out.println("Enter 1 to sort by name and 2 to sort by phone number");
                    int choice2 = init.nextInt();
                    switch (choice2) {
                        case 1:
                        Collections.sort(people);
                        System.out.println("Phonebook after sorting by name");
                        people.forEach(new Consumer<Person>() {
                            @Override
                            public void accept(Person person) {
                               // System.out.print(person.getName() + " " + person.getPhone() + " - ");
                                System.out.print(person);
                            }
                        });
                        break;
                        case 2:
                            Comparator telephoneNumberComparator = new CompareTelephoneNumber();
                            Collections.sort(people,telephoneNumberComparator);
                            System.out.println("Phonebook after sorting by phone number");
                            System.out.println(people);
                            break;
                    } break;
                case 5:
                    Scanner scan4 = new Scanner(System.in);
                    System.out.println("Enter a name or telephone number to editing");
                    String editeName = scan4.nextLine();
                    Iterator<Person> iterator2 = people.iterator();
                        while (iterator2.hasNext()) {
                        Person item = iterator2.next();
                        if (item.getName().equals(editeName) || item.getPhone().equals(editeName))
                            {
                            System.out.println("Edit contact name");
                            String name1 = scan4.nextLine();
                            item.setName(name1);
                            System.out.println("Edit contact date of birth in the format Year-month-day");
                            String dateString1 = scan4.nextLine();
                            LocalDate date1 = LocalDate.parse(dateString1,
                                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                            item.setDateOfBirth(date1);
                            System.out.println("Edit contact telephone number");
                            String telephone1 = scan4.nextLine();
                            item.setPhone(telephone1);
                            System.out.println("Edit contact address");
                            String adress1 = scan4.nextLine();
                            item.setAdress(adress1);
                    }
                        }
                    System.out.println("Telephone book after editing: ");
                    System.out.println(people);
                    break;
            }
            String peopleJson = mapper.writeValueAsString(people);
            System.out.println(peopleJson);


            contactWrite();
            contactRead();
        }

    }
    public static void contactWrite() throws IOException {
        ArrayList<Person> people = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        String peopleJson = mapper.writeValueAsString(people);
        File file = Paths.get("contacts.data").toFile();
        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(peopleJson);
        System.out.println("The data is written to the file! ");
        objectOutputStream.close();
        System.out.println(new String(Files.readAllBytes(Paths.get("contacts.data"))));

    }
    public static void contactRead() throws IOException, ClassNotFoundException {
        ArrayList<Person> newContacts = new ArrayList<>();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("contacts.data"));
        //newContacts = (ArrayList<Person>)objectInputStream.readObject();

        ObjectMapper mapper = new ObjectMapper();
        newContacts = mapper.readValue((String) objectInputStream.readObject(),ArrayList.class);

        for (Person c : newContacts) {
            System.out.println(c.toString());
        }
    }

}
