package com.JavaCollectionsFramework;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Human implements Comparable<Human> {
    private String firstName;
    private String name;
    private String lastName;
    private String fullName;
    private int age;

    public Human(String firstName, String name, String lastName, int age) {
        this.firstName = firstName;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.fullName = firstName + " " + name + " " + lastName;
    }

    @Override
    public int compareTo(Human other) {
        return this.fullName.compareTo(other.fullName);
    }
}