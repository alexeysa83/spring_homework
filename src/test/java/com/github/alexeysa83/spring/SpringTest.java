package com.github.alexeysa83.spring;

import com.github.alexeysa83.spring.config.Config;
import com.github.alexeysa83.spring.model.Unit;
import com.github.alexeysa83.spring.repository.impl.DefaultUnitDao;
import com.github.alexeysa83.spring.service.UnitBaseService;
import com.github.alexeysa83.spring.service.impl.DefaultUnitService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


class SpringTest {

    @Test
    void annotationConfigTest () {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DefaultUnitDao.class);
        context.register(DefaultUnitService.class);
        context.refresh();

        UnitBaseService bean = context.getBean(UnitBaseService.class);
        unitAct(bean);
    }

    @Test
    void javaConfigTest () {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        context.register(Config.class);
//        context.refresh();

        UnitBaseService bean = context.getBean(UnitBaseService.class);
        unitAct(bean);

        bean = context.getBean("unitBaseService2", UnitBaseService.class );
//        bean = context.getBean("secondService", UnitBaseService.class );
        unitAct(bean);
    }

    /**
     * No need to define in xml index or type
     */
    @Test
    void xmlConfigTest () {
        final GenericXmlApplicationContext context = new GenericXmlApplicationContext("beans_config.xml");
//        context.load("beans_config.xml");
//        context.refresh();

        UnitBaseService bean = context.getBean(UnitBaseService.class);
        unitAct(bean);

        bean = (UnitBaseService)context.getBean("unit2");
        unitAct(bean);
    }

    void unitAct (UnitBaseService bean) {
        final Unit warrior = bean.createUnit();
        final String message = bean.attackUnit(warrior);
        System.out.println(message);
    }
}
