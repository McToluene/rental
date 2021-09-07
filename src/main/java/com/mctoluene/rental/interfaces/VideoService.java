package com.mctoluene.rental.interfaces;

import com.mctoluene.rental.dtos.request.PaginationFilter;
import com.mctoluene.rental.dtos.request.VideoDetail;
import com.mctoluene.rental.dtos.response.VideoPrice;
import org.springframework.data.domain.Page;

public interface VideoService {
    Page getVideos(PaginationFilter validFilter);
    VideoPrice getPrice(VideoDetail detail);
}
