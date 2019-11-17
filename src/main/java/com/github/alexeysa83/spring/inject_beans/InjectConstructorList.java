package com.github.alexeysa83.spring.inject_beans;

import com.github.alexeysa83.spring.service.BaseService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InjectConstructorList {

    private final BaseService javaService;

    private BaseService anotherJavaService;

        public InjectConstructorList(List<BaseService> dao) {
        javaService = dao.get(1);
        anotherJavaService = dao.get(0);
    }

    public BaseService getFirst() {
        return javaService;
    }

    public BaseService getSecond() {
        return anotherJavaService;
    }
}
