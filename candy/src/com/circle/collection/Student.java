package com.circle.collection;


import java.util.Objects;

public class Student {
    private String name;
    private  int age;
    private float grades;

    public Student(String name, int age, float grades) {
        this.name = name;
        this.age = age;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getGrades() {
        return grades;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Float.compare(student.grades, grades) == 0 &&
                name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, grades);
    }

    @Override
    public String toString() {
        return name + " is " + age + " ," +" grades:" + grades;
    }
}
