package dev.robgleason.services;


import dev.robgleason.dto.GameEntityDto;
import dev.robgleason.dto.ReviewsEntityDto;
import dev.robgleason.entity.GameEntity;
import dev.robgleason.entity.ReviewsEntity;
import dev.robgleason.exception.GameNotFoundException;
import dev.robgleason.exception.ReviewNotFoundException;
import dev.robgleason.repository.GameRepository;
import dev.robgleason.repository.ReviewsRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private ReviewsRepository reviewsRepository;
    private GameRepository gameRepository;
    private ModelMapper modelMapper;

    @Override
    public ReviewsEntityDto getReviewById(Long reviewId) {
        ReviewsEntity review = reviewsRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException("review not found with id " + reviewId));

        return modelMapper.map(review, ReviewsEntityDto.class);
    }

    @Override
    public List<ReviewsEntityDto> getAllReviews() {
        List<ReviewsEntity> reviews = reviewsRepository.findAll();
        if (reviews.isEmpty()) {
            return Collections.emptyList();
        }
        return reviews.stream()
                .map(review -> modelMapper.map(review, ReviewsEntityDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReviewsEntityDto createReview(ReviewsEntityDto reviewsEntityDto) {
        ReviewsEntity review = modelMapper.map(reviewsEntityDto, ReviewsEntity.class);
        Long gameId = reviewsEntityDto.getGameId();

        GameEntity game = gameRepository.findById(gameId)
                .orElseThrow(() -> new GameNotFoundException("Game with ID " + gameId + " not found"));

        review.setGame(game);

        ReviewsEntity savedReview = reviewsRepository.save(review);
        return modelMapper.map(savedReview, ReviewsEntityDto.class);
    }

    @Override
    public ReviewsEntityDto updateReview(ReviewsEntityDto reviewsEntityDto) {

        ReviewsEntity existingReview = reviewsRepository.findById(reviewsEntityDto.getId())
                .orElseThrow(() -> new ReviewNotFoundException("review not found with id " + reviewsEntityDto.getId()));
        existingReview.setComment(reviewsEntityDto.getComment());
        existingReview.setRating(reviewsEntityDto.getRating());
        ReviewsEntity updatedReview = reviewsRepository.save(existingReview);
        return modelMapper.map(updatedReview, ReviewsEntityDto.class);
    }

    @Override
    public void deleteReview(Long reviewId) {
        ReviewsEntity reviews = reviewsRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException("review not found with id " + reviewId));
        reviewsRepository.deleteById(reviewId);

    }
}
