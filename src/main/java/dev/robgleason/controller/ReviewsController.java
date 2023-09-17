package dev.robgleason.controller;


import dev.robgleason.dto.GameEntityDto;
import dev.robgleason.dto.ReviewsEntityDto;
import dev.robgleason.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/reviews")
@AllArgsConstructor
public class ReviewsController {

    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewsEntityDto> addReview(@RequestBody ReviewsEntityDto reviewsEntityDto) {
        ReviewsEntityDto savedReview = reviewService.createReview(reviewsEntityDto);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReviewsEntityDto>> getAllReviews() {
        List<ReviewsEntityDto> allReviews = reviewService.getAllReviews();
        return ResponseEntity.ok(allReviews);
    }

    @GetMapping("{id}")
    public ResponseEntity<ReviewsEntityDto> getReview(@PathVariable("id") Long reviewId) {
        ReviewsEntityDto reviewsByIdDto = reviewService.getReviewById(reviewId);
        return ResponseEntity.ok(reviewsByIdDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<ReviewsEntityDto> updatedReview(@PathVariable("id") Long reviewId, @RequestBody ReviewsEntityDto reviewsEntityDto) {
        reviewsEntityDto.setId(reviewId);
        ReviewsEntityDto updatedReview = reviewService.updateReview(reviewsEntityDto);
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteReviewById(@PathVariable("id") long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.ok("review deleted successfully");
    }

}
