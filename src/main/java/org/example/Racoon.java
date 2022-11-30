package org.example;

public class Racoon {
    private final String name;
    private final int age;


    public Racoon(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Racoon{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
