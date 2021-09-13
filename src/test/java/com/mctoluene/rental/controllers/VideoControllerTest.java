package com.mctoluene.rental.controllers;

import com.mctoluene.rental.data.Data;
import com.mctoluene.rental.dtos.request.VideoDetail;
import com.mctoluene.rental.entities.Video;
import com.mctoluene.rental.interfaces.VideoService;
import com.mctoluene.rental.repositories.VideoRepository;
import com.mctoluene.rental.services.VideoServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VideoController.class)
class VideoControllerTest {
    private static Page<Video> videos;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VideoService videoService;

    @Mock
    private VideoRepository videoRepository;

    @BeforeAll
    static void setUp() {
        videos = new PageImpl<>(Data.generate());
    }

    @Test
    void getVideos() throws Exception {
        Pageable pageable = PageRequest.of(0, 5);
        when(videoService.getVideos(pageable)).thenReturn(videos);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/video")
                .param("pageNumber", String.valueOf(0))
                .param("pageSize", String.valueOf(5))
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();
    }


    @Test
    void getPrice() throws Exception {
        VideoDetail detail = new VideoDetail("Razortooth", 2);
        when(videoRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(videos.getContent().get(1)));
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/video/1/price", detail)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"data\": {\n" +
                        "        \"price\": 20.0\n" +
                        "    },\n" +
                        "    \"succeeded\": true,\n" +
                        "    \"message\": \"Price fetched successfully\"\n" +
                        "}"))
                .andReturn();
    }
}