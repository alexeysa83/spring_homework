package com.github.alexeysa83.spring.inject_beans;

import com.github.alexeysa83.spring.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectField {

    @Autowired
    private BaseService javaService;

    public BaseService getService() {
        return javaService;
    }
}
