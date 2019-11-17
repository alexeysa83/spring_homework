package com.github.alexeysa83.spring.model;

public class Entity {

    private String name;

    public Entity(String name) {
        this.name = name;
            }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayMyName() {
        System.out.println(this);
            }

    @Override
    public String toString() {
        return "Entity's name: " + name;
    }
}
