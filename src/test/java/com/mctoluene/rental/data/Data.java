package com.mctoluene.rental.data;

import com.mctoluene.rental.entities.Video;
import com.mctoluene.rental.entities.VideoType;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Video> generate(){
        VideoType regular = new VideoType("Regular", 10);
        VideoType children = new VideoType("Children’s Movie", 8);
        VideoType newRelease = new VideoType("New Release", 15);

        List<Video> videosList = new ArrayList<>();
        videosList.add(new Video("Diary of a Chambermaid", regular, "Drama"));
        videosList.add(new Video("Perfect Sense", regular, "Action"));
        videosList.add(new Video("Razortooth", regular, "Comedy"));

        Video video = new Video("Eva", children, "Drama");
        video.setMaximumAge(14);
        videosList.add(video);

        video = new Video("Mumia Abu-Jamal: A Case for Reasonable Doubt?", children, "Drama");
        video.setMaximumAge(12);
        videosList.add(video);

        video = new Video("YellowBrickRoad", newRelease, "Horror");
        video.setYear(2);
        videosList.add(video);

        return videosList;
    }
}
