package com.github.alexeysa83.spring.service.impl;

import com.github.alexeysa83.spring.model.Unit;
import com.github.alexeysa83.spring.repository.UnitBaseDao;
import com.github.alexeysa83.spring.service.UnitBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultUnitService implements UnitBaseService {

    private final UnitBaseDao dao;
    private final String unitName;

    @Autowired
    public DefaultUnitService (UnitBaseDao dao, String name) {
        this.dao=dao;
        unitName=name;
        }

    @Override
    public Unit createUnit() {
        return dao.create(unitName);
    }

    @Override
    public String attackUnit(Unit unit) {
        return dao.attack(unit);
    }
}
