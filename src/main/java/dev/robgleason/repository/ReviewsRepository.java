package dev.robgleason.repository;

import dev.robgleason.entity.ReviewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<ReviewsEntity, Long> {


}
