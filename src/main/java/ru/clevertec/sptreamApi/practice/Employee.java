package ru.clevertec.sptreamApi.practice;

import java.util.Objects;

public class Employee {

    private String firstName;
    private String lastName;
    private int id;
    private int age;
    private Position position;

    public Employee(String name, String lastName, int id, int age, Position position) {
        this.firstName = name;
        this.lastName = lastName;
        this.id = id;
        this.age = age;
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public Position getPosition() {
        return position;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && position == employee.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id, age, position);
    }

    @Override
    public String toString() {
        return  '[' + firstName + ' ' + lastName + ", " + id + ", " + age + ", " + position + ']';
    }
}
