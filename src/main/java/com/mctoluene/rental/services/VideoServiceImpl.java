package com.mctoluene.rental.services;

import com.mctoluene.rental.dtos.request.PaginationFilter;
import com.mctoluene.rental.dtos.request.VideoDetail;
import com.mctoluene.rental.dtos.response.VideoPrice;
import com.mctoluene.rental.entities.Video;
import com.mctoluene.rental.entities.VideoType;
import com.mctoluene.rental.interfaces.VideoService;
import com.mctoluene.rental.repositories.VideoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {
    private final VideoRepository videoRepository;

    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public Page getVideos(PaginationFilter validFilter) {
        Page videos = null;
        try {
            Pageable pageable = PageRequest.of(validFilter.getPageNumber(), validFilter.getPageSize());
            videos = videoRepository.findAll(pageable);
        }catch (Exception ex){
            // this should be a logger
            System.out.println("Failed to get videos: " + ex.getMessage());
        }
        return videos;
    }

    @Override
    public VideoPrice getPrice(VideoDetail detail) {
        VideoPrice videoPrice = new VideoPrice();
        try {
            Video video = videoRepository.findFirstByTitle(detail.getTitle());
            if (video != null){
                BeanUtils.copyProperties(video, videoPrice);
                videoPrice.setPrice(calculatePrice(video, detail.getDays()));
            }
        }catch (Exception ex){
            videoPrice = null;
            // this should be a logger
            System.out.println("Failed to get price: " + ex.getMessage());
        }
        return videoPrice;
    }

    private static double calculatePrice(Video video, int days){
        VideoType videoType = video.getVideoType();
        double price = videoType.getRate() * days;
        String type = videoType.getType();

        if (type.equals("Children’s Movie"))
            price += (double) video.getMaximumAge() / 2;
        if (type.equals("New Release"))
            price -= video.getYear();
        return  price;
    }
}
