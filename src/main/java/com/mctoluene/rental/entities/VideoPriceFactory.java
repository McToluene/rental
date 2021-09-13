package com.mctoluene.rental.entities;

import com.mctoluene.rental.dtos.response.VideoPrice;
import lombok.*;

@Data
public class VideoPriceFactory {
    private Integer maximumAge;
    private Integer year;
    private VideoType videoType;

    public VideoPrice getVideoPrice(int days) {
        double price = videoType.getRate() * days;
        String type = videoType.getType();
        if (type.equals("Children’s Movie"))
            price += (double) maximumAge / 2;
        if (type.equals("New Release"))
            price -= year;
        return new VideoPrice(price);
    }

}
