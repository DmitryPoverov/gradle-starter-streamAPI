package ru.clevertec.sptreamApi.practice;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Department {

    private int id;
    private int parent;
    private String name;
    private Set<Department> child = new HashSet<>();

/* Instead of these i used Lombok annotations.*/
    public Department(int id, int parent, String name) {
        this.id = id;
        this.parent = parent;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public Set<Department> getChild() {
        return child;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChild(Set<Department> child) {
        this.child = child;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id && parent == that.parent && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parent, name);
    }

    @Override
    public String toString() {
        return "Department{" + id + ", " + parent + ", " + name + '}';
    }
}
