package com.github.alexeysa83.spring.repository.impl;

import com.github.alexeysa83.spring.model.Unit;
import com.github.alexeysa83.spring.repository.UnitBaseDao;
import org.springframework.stereotype.Repository;

@Repository
/**
 * Constructor params? Different implementations?
 */
public class DefaultUnitDao implements UnitBaseDao {

    private final int unitPower;

    public DefaultUnitDao(int unitPower) {
        this.unitPower = unitPower;
    }

    @Override
    public Unit create(String name) {
        final Unit unit = new Unit(name, unitPower);
        System.out.println(unit + " CREATED");
        return unit;
    }

    @Override
    public String attack(Unit unit) {
        System.out.println(unit + " IS READY TO ATTACK");
        return "ATTACK POWER:" + unit.getPower();
    }
}
