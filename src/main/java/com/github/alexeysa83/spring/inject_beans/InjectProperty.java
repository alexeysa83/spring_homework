package com.github.alexeysa83.spring.inject_beans;

import com.github.alexeysa83.spring.service.BaseService;

public class InjectProperty {

    private final BaseService propertyService;
    private final BaseService anotherPropertyService;

    public InjectProperty(BaseService propertyService, BaseService anotherPropertyService) {
        this.propertyService = propertyService;
        this.anotherPropertyService = anotherPropertyService;
    }

    public BaseService getPropertyService() {
        return propertyService;
    }

    public BaseService getAnotherPropertyService() {
        return anotherPropertyService;
    }
}
