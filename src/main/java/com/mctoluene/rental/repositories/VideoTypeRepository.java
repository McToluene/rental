package com.mctoluene.rental.repositories;

import com.mctoluene.rental.entities.VideoType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoTypeRepository extends JpaRepository<VideoType, Long> {
}
