package com.workintech.dependency.model;

import com.workintech.dependency.enums.Experience;

public class SeniorDeveloper extends Developer{
    public SeniorDeveloper(int id, String name, double salary, Experience experience) {
        super(id, name, salary, experience);
    }
}
