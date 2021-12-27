package com.pb.gorbjanskaja.hw12;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static  List<Person> people = new ArrayList<>();
    public static ObjectMapper objectMapper= new ObjectMapper();
    public static String DATA_FILE_PATH = "files/phonebook.json";


        public static void main(String[] Args) throws NullPointerException {
        ObjectMapper mapper = new ObjectMapper();
         //   objectMapper = new ObjectMapper();
        // для красивой печати (json с отступами)
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        // для работы с полями типа LocalDate
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        mapper.registerModule(module);
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Phone book" + "\n" +
                    "1 - to add a contact " + "\n" +
                    "2 - to delete a contact " + "\n" +
                    "3 - to search for a contact " + "\n" +
                    "4 - for output sorted by the specified field " + "\n" +
                    "5 - for editing element fields" + "\n" +
                    "6 - for save data to file" + "\n" +
                    "7 - for load data from file" + "\n" +
                    "8 - for exit" + "\n" +
                    "Enter the number of the operation You need");
            String choice = scan.nextLine();
            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    deleteContact();
                    break;
                case "3":
                    findContact();
                    break;
                case "4":
                    System.out.println("Enter 1 to sort by name and 2 to sort by change date");
                    choice = scan.nextLine();
                    switch (choice) {
                        case ("1"):
                            sortByName();
                            break;
                        case ("2"):
                            sortByChageDate();
                            break;
                    }
                    break;
                case "5":
                    editContact();
                    break;
                case "6":
                    //saveToFile();

                    try {
                        //ObjectMapper objectMapper;
                        String json = objectMapper.writeValueAsString(people);
                        Files.write(Paths.get(DATA_FILE_PATH), json.getBytes(StandardCharsets.UTF_8));
                    } catch (Exception ex) {
                        System.out.println("Ошибка при сохранении файла: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                    break;
//                case "7":
//                    loadFromFile();
//                    break;
            }
        }

    }
    public static void addContact () {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter new contact name");
        String name = scan.nextLine();
        System.out.println("Enter new contact date of birth in the format Year-month-day");
        String dateString = scan.nextLine();
        //LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate date = LocalDate.parse(dateString);
        System.out.println("Enter new contact telephone number");
        String telephone = scan.nextLine();
        System.out.println("Enter new contact address");
        String adress = scan.nextLine();
        Person contact = new Person(name, date, telephone, adress);
        people.add(contact);
        System.out.println("Phone book after adding contact");
        System.out.println(people);
    }
    public static void deleteContact () {
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
    }
    public static void findContact () {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Enter a name or telephone number to search ");
        String searchName = scan2.nextLine();
        for (Person i : people) {
            if (i.getName().equals(searchName) || i.getPhone().equals(searchName)) {
                System.out.println("Found contact is " + i);
            }

        }
    }
    public static void sortByName() {
        people.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        System.out.println(people);
    }
    public static void sortByChageDate() {
        people.sort((o1, o2) -> o1.getModify().compareTo(o2.getModify()));
        System.out.println(people);
    }
    public static void editContact() {
        Scanner scan4 = new Scanner(System.in);
        System.out.println("Enter a name or telephone number to editing");
        String editeName = scan4.nextLine();
        Iterator<Person> iterator2 = people.iterator();
        while (iterator2.hasNext()) {
            Person item = iterator2.next();
            if (item.getName().equals(editeName) || item.getPhone().equals(editeName)) {
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
                System.out.println("Telephone book after editting: ");
                System.out.println(people);
            }
        }
    }
//    public static void saveToFile() throws NullPointerException {
//        SimpleModule module = new SimpleModule();
//        module.addSerializer(LocalDate.class, new LocalDateSerializer());
//        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
//        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
//        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
//        objectMapper.registerModule(module);
//        try {
//            String json = objectMapper.writeValueAsString(people);
//            Files.write(Paths.get(DATA_FILE_PATH), json.getBytes(StandardCharsets.UTF_8));
//        } catch (Exception ex) {
//            System.out.println("Ошибка при сохранении файла: " + ex.getMessage());
//            ex.printStackTrace();
//        }
//    }
//    public static void loadFromFile() {
//        ArrayList<Person> newContacts = new ArrayList<>();
//        try {
//            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("contacts.data"));
//            newContacts = (ArrayList<Person>) objectInputStream.readObject();
//
//            ObjectMapper mapper = new ObjectMapper();
//            newContacts = mapper.readValue((String) objectInputStream.readObject(), ArrayList.class);
//
//            for (Person c : newContacts) {
//                System.out.println(c.toString());
//            }
//        } catch (Exception ex) {
//            System.out.println("Ошибка при загрузки из файла: " + ex.getMessage());
//            ex.printStackTrace();
//        }
//    }
}

