package com.conygre.test.pets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfiguration {
    @Bean
    public Pet pet() {
        return new Cat();
    }

    @Bean
    public Address myFancyNewCondo() {
        return new Address("224 West 49th Street,,New York,NY,10019");
    }

    @Bean
    public Person person(@Autowired Pet pet, @Autowired Address myFancyNewCondo) {
        return new Person(pet, myFancyNewCondo);
    }
}