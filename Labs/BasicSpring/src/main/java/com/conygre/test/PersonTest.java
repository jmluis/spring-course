package com.conygre.test;

import com.conygre.test.pets.PersonConfiguration;
import com.conygre.test.pets.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PersonTest {
    public static void main(final String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersonConfiguration.class)) {
            Person goals = context.getBean(Person.class);
            goals.getPet().feed();
            System.out.println(goals.getAddress().toString());
          }
    }
}
