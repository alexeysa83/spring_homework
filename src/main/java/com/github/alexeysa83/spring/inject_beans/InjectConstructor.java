package com.github.alexeysa83.spring.inject_beans;

import com.github.alexeysa83.spring.service.BaseService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class InjectConstructor {

    private BaseService service;

    public InjectConstructor(@Qualifier ("javaService") BaseService service) {
        this.service = service;
    }

    public BaseService getService() {
        return service;
    }
}
