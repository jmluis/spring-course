package com.conygre.spring.dao;

import java.util.Collection;
import com.conygre.spring.entities.CompactDisc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CompactDiscDAOMongo implements CompactDiscDAO {
    @Autowired
    MongoTemplate template;

    @Override
    public void addCompactDisc(CompactDisc disc) {
        template.insert(disc);
    }

    @Override
    public CompactDisc getCompactDiscByTitle(String title) {
        Query query = new Query();
        query.addCriteria(Criteria.where("title").is(title));
        CompactDisc disc = template.findOne(query, CompactDisc.class);      
        return disc;
    }

    @Override
    public Collection<CompactDisc> getDiscsByArtist(String artist) {
        Query query = new Query();
        query.addCriteria(Criteria.where("artist" ).is(artist));
        return template.find(query, CompactDisc.class);
    }

    @Override
    public Collection<CompactDisc> getAllDiscs() {
        return template.find(new Query(), CompactDisc.class);
    }
    
}