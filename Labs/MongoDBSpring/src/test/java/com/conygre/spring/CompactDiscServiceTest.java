package com.conygre.spring;

import static org.junit.Assert.assertEquals;

import com.conygre.spring.entities.CompactDisc;
import com.conygre.spring.service.CompactDiscService;
import com.mongodb.BasicDBObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoJavaConfig.class, loader = AnnotationConfigContextLoader.class)
public class CompactDiscServiceTest {
    @Autowired
    MongoTemplate template;

    @Autowired
    CompactDiscService svCompactDisc;

    @Test
    public void addCompactDiscsThroughServiceLayer() {
        svCompactDisc.addCDToCatalog(new CompactDisc("Space Oddity", "David Bowie", 12.99));
        assertEquals(1, svCompactDisc.getCatalog().size());
    }

    @After
    @Before
    public void cleanUp() {
        for (String collectionName : template.getCollectionNames()) {
            if (!collectionName.startsWith("system.")) {
                template.getCollection(collectionName).remove(new BasicDBObject());
            }
        }
    }
}