package com.github.alexeysa83.spring.repository;

import com.github.alexeysa83.spring.model.Unit;

public interface UnitBaseDao {

    Unit create (String name);

    String attack (Unit unit);
}
