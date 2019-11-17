package com.github.alexeysa83.spring.inject_beans;

import com.github.alexeysa83.spring.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectSetter {

    private BaseService javaService;

    public BaseService getService() {
        return javaService;
    }

    @Autowired
    public void setJavaService(BaseService javaService) {
        this.javaService = javaService;
    }
}
