package com.pb.gorbjanskaja.hw11;

import java.util.Comparator;

public class CompareTelephoneNumber implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getPhone().compareTo(p2.getPhone());
    }
}
