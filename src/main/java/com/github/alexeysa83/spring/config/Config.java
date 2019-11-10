package com.github.alexeysa83.spring.config;

import com.github.alexeysa83.spring.repository.UnitBaseDao;
import com.github.alexeysa83.spring.repository.impl.DefaultUnitDao;
import com.github.alexeysa83.spring.service.impl.DefaultUnitService;
import com.github.alexeysa83.spring.service.UnitBaseService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Where is allocated config class?
 */

@Configuration
public class Config {

    @Bean
    @Primary
    public UnitBaseService unitBaseService(UnitBaseDao unitBaseDao) {
        return new DefaultUnitService(unitBaseDao, "JAVA_WARRIOR");
    }


    /**
     * The same config
     */
//    @Bean
//    @Primary
//    public UnitBaseService unitBaseService () {
//        return new DefaultUnitService(unitBaseDao(), "JAVA_WARRIOR");
//    }

    /**
     * Qualifier doesn't work?
     * This annotation may be used on a field or parameter as a qualifier for
     * candidate beans when autowiring. It may also be used to annotate other
     * custom annotations that can then in turn be used as qualifiers.
     */
    @Bean
    @Qualifier(value = "secondService")
    public UnitBaseService unitBaseService2(UnitBaseDao unitBaseDao) {
        return new DefaultUnitService(unitBaseDao, "ANOTHER_JAVA_WARRIOR");
    }

    @Bean
    public UnitBaseDao unitBaseDao() {
        return new DefaultUnitDao(100);
    }
}
