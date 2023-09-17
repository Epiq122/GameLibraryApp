package dev.robgleason.services;

import dev.robgleason.dto.GameEntityDto;
import dev.robgleason.dto.ReviewsEntityDto;

import java.util.List;

public interface ReviewService {

    ReviewsEntityDto getReviewById(Long reviewId);

    List<ReviewsEntityDto> getAllReviews();

    ReviewsEntityDto createReview(ReviewsEntityDto reviewsEntityDto);

    ReviewsEntityDto updateReview(ReviewsEntityDto reviewsEntityDto);

    void deleteReview(Long reviewId);
}
