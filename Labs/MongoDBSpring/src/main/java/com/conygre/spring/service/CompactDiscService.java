package com.conygre.spring.service;

import java.util.Collection;

import com.conygre.spring.dao.CompactDiscDAO;
import com.conygre.spring.entities.CompactDisc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompactDiscService {
    @Autowired
    CompactDiscDAO daCompactDisc;

    void addCDToCatalog(CompactDisc cd) {
        daCompactDisc.addCompactDisc(cd);
    }

    Collection<CompactDisc> getCatalog() {
        return daCompactDisc.getAllDiscs();
    }
}