package com.JavaCollectionsFramework;

public class Student extends Human {
    private String faculty;

    public Student(String firstName, String name, String lastName, int age, String faculty) {
        super(firstName, name, lastName, age);
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}