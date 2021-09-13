package com.mctoluene.rental.interfaces;

import com.mctoluene.rental.dtos.request.VideoDetail;
import com.mctoluene.rental.dtos.response.VideoPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VideoService {
    Page getVideos(Pageable pageable);
    VideoPrice getPrice(VideoDetail detail, Long id);
}
