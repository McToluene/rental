package com.mctoluene.rental.repositories;

import com.mctoluene.rental.entities.Video;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VideoRepository extends PagingAndSortingRepository<Video, Long> {
    Video findFirstByTitle(String title);
}
