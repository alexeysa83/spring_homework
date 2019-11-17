package com.github.alexeysa83.spring.service.impl;

import com.github.alexeysa83.spring.model.Entity;
import com.github.alexeysa83.spring.repository.BaseDao;
import com.github.alexeysa83.spring.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * Эта имплементация нужна, т.к. мы не можем передать аргумент String name в консруктор класса
 * DefaultUnitService, конфигурируя бин с помощью аннотации @Service
 */
@Service
public class AnnotationConfigBaseService implements BaseService {

    private final String NAME = "ANNOTATION_SERVICE";

    private final BaseDao dao;

    public AnnotationConfigBaseService(BaseDao dao) {
        this.dao = dao;
    }

    @Override
    public String createAndIntroduce() {
        final Entity entity = dao.create(NAME);
        final boolean isCreated = entity != null;
        if (isCreated) {
            entity.sayMyName();
        }
        return NAME;
    }
}
