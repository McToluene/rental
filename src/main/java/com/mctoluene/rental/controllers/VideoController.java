package com.mctoluene.rental.controllers;

import com.mctoluene.rental.dtos.request.VideoDetail;
import com.mctoluene.rental.dtos.response.Response;
import com.mctoluene.rental.dtos.response.VideoPrice;
import com.mctoluene.rental.interfaces.VideoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("video")
public class VideoController {
    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping
    public Page getVideos(Pageable page) {
        return videoService.getVideos(page);
    }

    @PostMapping("/{id}/price")
    public Response<VideoPrice> calculatePrice(@PathVariable Long id, @RequestBody VideoDetail videoDetail) {
        VideoPrice videoPrice = videoService.getPrice(videoDetail, id);
        return new Response<>(videoPrice, "Price fetched successfully", true);
    }
}