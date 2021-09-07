package com.mctoluene.rental.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VideoType {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String type;

    private int rate;

    public VideoType() {
    }

    public VideoType(String type, int rate) {
        this.type = type;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
