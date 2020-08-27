package com.conygre.mongo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.conygre.spring.MongoJavaConfig;
import com.conygre.spring.entities.CompactDisc;
import com.mongodb.BasicDBObject;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoJavaConfig.class, loader = AnnotationConfigContextLoader.class)
public class BasicMongoTest {
    @Autowired
    MongoTemplate template;

    @Test
    public void canInsertSuccessfully() {
        CompactDisc disc1 = new CompactDisc("Aim and Ignite", "fun.", 12.99);
        CompactDisc disc2 = new CompactDisc("Blonde", "Frank Ocean", 12.99);
        CompactDisc disc3 = new CompactDisc("To Pimp a Butterfly", "Kendrick Lamar", 12.99);

        template.insert(disc1);
        template.insert(disc2);
        template.insert(disc3);

        List<CompactDisc> discs = template.findAll(CompactDisc.class);
        discs.forEach(disc -> System.out.println(disc.toString()));

        assertEquals(3, discs.size());
        assertEquals(true, discs.contains(disc1));
    }

    // @After
    public void cleanUp() {
        for (String collectionName : template.getCollectionNames()) {
            if (!collectionName.startsWith("system.")) {
                template.getCollection(collectionName).remove(new BasicDBObject());
            }
        }
    }
}