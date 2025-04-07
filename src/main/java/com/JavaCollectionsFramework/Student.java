package com.JavaCollectionsFramework;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class Student extends Human {
    private String faculty;

    public String getFaculty() {
        return faculty;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }


}
