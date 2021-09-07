package com.mctoluene.rental.dtos.request;

public class VideoDetail {
    private String name;
    private String title;
    private int days;

    public VideoDetail(String name, String title, int days) {
        this.name = name;
        this.title = title;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
