package org.ultrahack.investmentbutler;

public class Person {
    String name;
    String age;


    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getValue() {
        return age;
    }
}