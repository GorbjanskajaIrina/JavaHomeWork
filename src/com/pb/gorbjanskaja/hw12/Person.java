package com.pb.gorbjanskaja.hw12;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Person implements Comparable<Person>  {
    private String name;
    private final static long serialVersionUID = 42;
//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @JsonSerialize(using = LocalDateSerializer.class)
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDate dateOfBirth;
    private String phone;
    private String adress;
    private LocalDateTime modify;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public LocalDateTime getModify() {
        return modify;
    }

    public void setModify(LocalDateTime modify) {

        this.modify=LocalDateTime.now();
    }

    public Person(String name, LocalDate dateOfBirth, String phone, String adress) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.adress = adress;
        //this.modify = modify;
        this.modify = LocalDateTime.now();
    }
    public int compareTo(Person p) {
        return this.getName().compareTo(p.getName());
    }

    @Override
    public String toString() {
        return "\n Person{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", modify=" + modify +
                '}';
    }
}

