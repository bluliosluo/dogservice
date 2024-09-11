package org.chloe.demo.configuration;

import org.chloe.demo.dogtoy.DogSundayToy;
import org.chloe.demo.dogtoy.DogToy;
import org.chloe.demo.dogtoy.DogMondayToy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DogToyConfiguration {

    @Bean(destroyMethod = "shutdown")
    @Qualifier("dogMondayToy")
    public DogToy dogMondayToy() {
        return new DogMondayToy(0, 0);
    }

    @Bean(destroyMethod = "shutdown")
    @Qualifier("dogSundayToy")
    public DogToy dogSundayToy() {
        return new DogSundayToy(0, 0);
    }

}


