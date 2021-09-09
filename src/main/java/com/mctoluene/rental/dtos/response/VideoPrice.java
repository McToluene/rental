package com.mctoluene.rental.dtos.response;

import lombok.Data;

@Data
public class VideoPrice {
    private Double price;

    public VideoPrice(Double price) {
        this.price = price;
    }
}