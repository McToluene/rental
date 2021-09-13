package com.mctoluene.rental.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToOne
    private VideoType videoType;

    @Column(nullable = false)
    private String genre;
    private Integer maximumAge;
    private Integer year;


    public Video(String title, VideoType videoType, String genre) {
        this.title = title;
        this.videoType = videoType;
        this.genre = genre;
    }
}
