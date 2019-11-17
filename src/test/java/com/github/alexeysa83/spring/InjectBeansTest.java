package com.github.alexeysa83.spring;

import com.github.alexeysa83.spring.config.Config;
import com.github.alexeysa83.spring.service.BaseService;
import com.github.alexeysa83.spring.inject_beans.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InjectBeansTest {

    private final String JAVA_PRIMARY = "JAVA_SERVICE";
    private final String JAVA_SECONDARY = "ANOTHER_JAVA_SERVICE";

    private final String PROPERTY_PRIMARY = "PROPERTY_SERVICE";
    private final String PROPERTY_SECONDARY = "ANOTHER_PROPERTY_SERVICE";

       @Test
    void injectField() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Config.class);
        context.register(InjectField.class);
        context.refresh();

        System.out.println("Inject Field Test");
        final InjectField bean = context.getBean(InjectField.class);
        assertNotNull(bean);

        final BaseService service = bean.getService();
        assertNotNull(service);
        final String name = service.createAndIntroduce();
        assertEquals(JAVA_PRIMARY, name);
        System.out.println("------------------------------------------");
    }

    @Test
    void injectSetter() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Config.class);
        context.register(InjectSetter.class);
        context.refresh();

        System.out.println("Inject Setter Test");
        final InjectSetter bean = context.getBean(InjectSetter.class);
        assertNotNull(bean);

        final BaseService service = bean.getService();
        assertNotNull(service);
        final String name = service.createAndIntroduce();
        assertEquals(JAVA_PRIMARY, name);

        System.out.println("------------------------------------------");
    }

    @Test
    void injectConstructor() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Config.class);
        context.register(InjectConstructor.class);
        context.refresh();

        System.out.println("Inject Constructor Test");
        final InjectConstructor bean = context.getBean(InjectConstructor.class);
        assertNotNull(bean);

        final BaseService service = bean.getService();
        assertNotNull(service);
        final String name = service.createAndIntroduce();
        assertEquals(JAVA_PRIMARY, name);

        System.out.println("------------------------------------------");
    }

    @Test
    void injectByName() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Config.class);
        context.register(InjectByName.class);
        context.refresh();

        System.out.println("Inject By Name Test");
        final InjectByName bean = context.getBean(InjectByName.class);
        assertNotNull(bean);

        final BaseService first = bean.getFirst();
        assertNotNull(first);
        final String nameFirst = first.createAndIntroduce();
        assertEquals(JAVA_PRIMARY, nameFirst);

        final BaseService second = bean.getSecond();
        assertNotNull(second);
        final String nameSecond = second.createAndIntroduce();
        assertEquals(JAVA_SECONDARY, nameSecond);

        System.out.println("------------------------------------------");
    }

    @Test
    void injectConstructorList() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Config.class);
        context.register(InjectConstructorList.class);
        context.refresh();

        System.out.println("Inject Constructor List Test");
        final InjectConstructorList bean = context.getBean(InjectConstructorList.class);
        assertNotNull(bean);

        final BaseService first = bean.getFirst();
        assertNotNull(first);
        final String nameFirst = first.createAndIntroduce();
        assertEquals(JAVA_PRIMARY, nameFirst);

        final BaseService second = bean.getSecond();
        assertNotNull(second);
        final String nameSecond = second.createAndIntroduce();
        assertEquals(JAVA_SECONDARY, nameSecond);

        System.out.println("------------------------------------------");
    }

    @Test
    void injectProperty() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Config.class);
        context.register(InjectProperty.class);
        context.refresh();

        System.out.println("Inject Property Test");
        final InjectProperty bean = context.getBean(InjectProperty.class);
        assertNotNull(bean);

        final BaseService property = bean.getPropertyService();
        assertNotNull(property);
        final String nameProperty = property.createAndIntroduce();
        assertEquals(PROPERTY_PRIMARY, nameProperty);

        final BaseService anotherProperty = bean.getAnotherPropertyService();
        assertNotNull(anotherProperty);
        final String nameAnotherProperty = anotherProperty.createAndIntroduce();
        assertEquals(PROPERTY_SECONDARY, nameAnotherProperty);

        System.out.println("------------------------------------------");
    }
}
