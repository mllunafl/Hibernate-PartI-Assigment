package com.example;

/**
 * Created by LunaFlores on 1/5/17.
 */
public class Student {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "com.example.Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
