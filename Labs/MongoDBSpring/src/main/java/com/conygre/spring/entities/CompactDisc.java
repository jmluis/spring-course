package com.conygre.spring.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CompactDisc {
    ObjectId id;
    String title;
    String artist;
    double price;

    public CompactDisc(String title, String artist, double price) {
        this.title = title;
        this.artist = artist;
        this.price = price;
    }
    public CompactDisc() { }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getArtist() + " - " + getTitle() + " ($" + getPrice() + ")";
    }

}