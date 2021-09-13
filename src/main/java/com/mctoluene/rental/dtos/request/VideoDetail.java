package com.mctoluene.rental.dtos.request;

import lombok.*;

@Data
public class VideoDetail {
    private String name;
    private int days;

    public VideoDetail(String name, int days) {
        this.name = name;
        this.days = days;
    }
}
