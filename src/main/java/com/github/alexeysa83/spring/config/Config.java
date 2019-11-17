package com.github.alexeysa83.spring.config;

import com.github.alexeysa83.spring.repository.BaseDao;
import com.github.alexeysa83.spring.repository.impl.DefaultDao;
import com.github.alexeysa83.spring.service.BaseService;
import com.github.alexeysa83.spring.service.impl.DefaultBaseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;

import java.util.Map;

@Configuration
@PropertySource("classpath:app.properties")
public class Config {

    @Bean
    @Order(1)
    public BaseService javaService(BaseDao baseDao) {
        return new DefaultBaseService(baseDao, "JAVA_SERVICE");
    }

    @Bean("anotherJavaService")
    @Order(0)
    public BaseService blabla(BaseDao baseDao) {
        return new DefaultBaseService(baseDao, "ANOTHER_JAVA_SERVICE");
    }

    /**
     * Инжект из проперти файла разными способами: инжект поля и параметра метода
     */
    @Value("#{${names}}")
    private Map <String, String > names;

    @Bean
    public BaseService propertyService(BaseDao baseDao, @Value("#{${names}.key1}") String name) {
        return new DefaultBaseService(baseDao, name);
    }

    @Bean
    public BaseService anotherPropertyService(BaseDao baseDao) {
        return new DefaultBaseService(baseDao, names.get("key2"));
    }

    @Bean
    public BaseDao dao() {
        return new DefaultDao();
    }
}
