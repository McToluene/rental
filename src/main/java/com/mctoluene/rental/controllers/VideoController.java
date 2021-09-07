package com.mctoluene.rental.controllers;

import com.mctoluene.rental.dtos.request.PaginationFilter;
import com.mctoluene.rental.dtos.request.VideoDetail;
import com.mctoluene.rental.dtos.response.PagedResponse;
import com.mctoluene.rental.dtos.response.Response;
import com.mctoluene.rental.dtos.response.VideoPrice;
import com.mctoluene.rental.interfaces.VideoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("video")
public class VideoController {
    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping
    public PagedResponse get(@RequestParam int pageNumber, @RequestParam int pageSize){
        PaginationFilter filter = new PaginationFilter(pageNumber, pageSize);
        var videos = videoService.getVideos(filter);
        return new PagedResponse<>(videos.getContent(), "Videos fetched successfully", true, filter.getPageNumber(), filter.getPageSize());
    }

    @GetMapping("/price")
    public Response<VideoPrice> getPrice(@RequestParam String name, @RequestParam String title, @RequestParam int days){
        VideoPrice videoPrice = videoService.getPrice(new VideoDetail(name, title, days));
        return new Response<>(videoPrice, "Price fetched successfully", true);
    }
}