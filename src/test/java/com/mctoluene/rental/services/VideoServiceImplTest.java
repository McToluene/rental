package com.mctoluene.rental.services;

import com.mctoluene.rental.data.Data;
import com.mctoluene.rental.dtos.request.VideoDetail;
import com.mctoluene.rental.dtos.response.VideoPrice;
import com.mctoluene.rental.entities.Video;
import com.mctoluene.rental.entities.VideoType;
import com.mctoluene.rental.repositories.VideoRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VideoServiceImplTest {
    private static Page<Video> videos;

    @InjectMocks
    private VideoServiceImpl videoService;

    @Mock
    private VideoRepository videoRepository;

    @BeforeAll
    static void setUp() {
        videos = new PageImpl<>(Data.generate());
    }

    @Test
    void getVideos() {
        Pageable pageable = PageRequest.of(0, 5);
        when(videoRepository.findAll(pageable)).thenReturn(videos);
        Page<Video> videosResult = videoService.getVideos(pageable);
        assertEquals(6, videosResult.getContent().size());
    }

    @Test
    void getPrice() {
        VideoDetail videoDetail = new VideoDetail("Razortooth", 2);
        when(videoRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(videos.getContent().get(1)));
        VideoPrice videoPrice = videoService.getPrice(videoDetail, 1L);
        assertEquals(20.0, videoPrice.getPrice());
    }
}