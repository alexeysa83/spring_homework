package com.github.alexeysa83.spring;

import com.github.alexeysa83.spring.config.Config;
import com.github.alexeysa83.spring.repository.impl.DefaultDao;
import com.github.alexeysa83.spring.service.BaseService;
import com.github.alexeysa83.spring.service.impl.AnnotationConfigBaseService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ContextTest {

    private final String JAVA_PRIMARY = "JAVA_SERVICE";
    private final String JAVA_SECONDARY = "ANOTHER_JAVA_SERVICE";

    private final String XML_PRIMARY = "XML_SERVICE";
    private final String XML_SECONDARY = "ANOTHER_XML_SERVICE";

    private final String ANNOTATION = "ANNOTATION_SERVICE";

    @Test
    void javaConfigTest() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        assertNotNull(context);

        System.out.println("Java config beans == 2 штуки!");
        final BaseService javaConfig = context.getBean("javaService", BaseService.class);
        assertNotNull(javaConfig);
        String name = javaConfig.createAndIntroduce();
        assertEquals(JAVA_PRIMARY, name);

        final BaseService anotherJavaConfig = context.getBean("anotherJavaService", BaseService.class);
        assertNotNull(anotherJavaConfig);
        name = anotherJavaConfig.createAndIntroduce();
        assertEquals(JAVA_SECONDARY, name);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @Test
    void xmlConfigTest() {
        final GenericXmlApplicationContext context = new GenericXmlApplicationContext("beans_config.xml");
        assertNotNull(context);

        System.out.println("XML config beans == 2 штуки!");
        final BaseService xmlConfig = context.getBean(BaseService.class);
        assertNotNull(xmlConfig);
        String name = xmlConfig.createAndIntroduce();
        assertEquals(XML_PRIMARY, name);

        final BaseService anotherXmlConfig = (BaseService) context.getBean("anotherXmlService");
        assertNotNull(anotherXmlConfig);
        name = anotherXmlConfig.createAndIntroduce();
        assertEquals(XML_SECONDARY, name);
    }

    @Test
    void annotationConfigTest() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DefaultDao.class);
        context.register(AnnotationConfigBaseService.class);
        context.refresh();

        System.out.println("Annotation config beans == 1 штука!");
        final BaseService annotationConfig = context.getBean(BaseService.class);
        assertNotNull(annotationConfig);
        final String name = annotationConfig.createAndIntroduce();
        assertEquals(ANNOTATION, name);
    }
}
