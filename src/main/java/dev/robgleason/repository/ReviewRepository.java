package dev.robgleason.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository<ReviewEntity> extends JpaRepository<ReviewEntity, Long> {

    
}
