package com.mctoluene.rental.repositories;

import com.mctoluene.rental.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
