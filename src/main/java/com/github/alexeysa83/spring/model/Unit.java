package com.github.alexeysa83.spring.model;

public class Unit {

    private String name;
    private int power;

    public Unit(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Unit:" + name + " power=" + power;
    }
}
