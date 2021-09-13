package com.mctoluene.rental.services;

import com.mctoluene.rental.dtos.request.VideoDetail;
import com.mctoluene.rental.dtos.response.VideoPrice;
import com.mctoluene.rental.entities.Video;
import com.mctoluene.rental.entities.VideoPriceFactory;
import com.mctoluene.rental.interfaces.VideoService;
import com.mctoluene.rental.repositories.VideoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {
    private final VideoRepository videoRepository;

    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public Page getVideos(Pageable page) {
        Page videos = null;
        try {
            videos = videoRepository.findAll(page);
        } catch (Exception ex) {
            // this should be a logger
            System.out.println("Failed to get videos: " + ex.getMessage());
        }
        return videos;
    }

    @Override
    public VideoPrice getPrice(VideoDetail detail, Long id) {
        VideoPrice videoPrice = null;
        try {
            Optional<Video> video = videoRepository.findById(id);
            if (video.isPresent()) {
                VideoPriceFactory factory = new VideoPriceFactory();
                factory.setVideoType(video.get().getVideoType());
                factory.setYear(video.get().getYear());
                factory.setMaximumAge(video.get().getMaximumAge());
                videoPrice = factory.getVideoPrice(detail.getDays());
            }
        } catch (Exception ex) {
            // this should be a logger
            System.out.println("Failed to get price: " + ex.getMessage());
        }
        return videoPrice;
    }
}
