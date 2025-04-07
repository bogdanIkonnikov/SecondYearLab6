package com.JavaCollectionsFramework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Human implements Comparable<Human> {
    private String firstName;
    private String name;
    private String lastName;
    private String fullName = firstName + name + lastName;
    private int age;

    @Override
    public int compareTo(Human other) {
        return this.fullName.compareTo(other.fullName);
    }


}
