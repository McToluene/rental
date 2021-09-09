package com.mctoluene.rental.entities;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class VideoType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    private Integer rate;

    public VideoType(String type, int rate) {
        this.type = type;
        this.rate = rate;
    }
}

