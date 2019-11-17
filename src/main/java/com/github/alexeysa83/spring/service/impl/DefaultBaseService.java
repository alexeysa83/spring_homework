package com.github.alexeysa83.spring.service.impl;

import com.github.alexeysa83.spring.model.Entity;
import com.github.alexeysa83.spring.repository.BaseDao;
import com.github.alexeysa83.spring.service.BaseService;


public class DefaultBaseService implements BaseService {

    private BaseDao dao;
    private final String name;

    public DefaultBaseService(BaseDao dao, String name) {
        this.dao = dao;
        this.name = name;
        }

    /**
     * Конструктор и сеттер нужны для второго бина в xml config
     */
    public DefaultBaseService(String name) {
        this.name = name;
       }

    public void setDao(BaseDao dao) {
        this.dao = dao;
    }

    @Override
    public String createAndIntroduce() {
        final Entity entity = dao.create(name);
        final boolean isCreated = entity != null;
        if (isCreated) {
            entity.sayMyName();
        }
        return name;
    }
}
