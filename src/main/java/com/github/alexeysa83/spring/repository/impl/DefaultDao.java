package com.github.alexeysa83.spring.repository.impl;

import com.github.alexeysa83.spring.model.Entity;
import com.github.alexeysa83.spring.repository.BaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultDao implements BaseDao {

       @Override
    public Entity create(String name) {
           return new Entity(name);
    }
}
