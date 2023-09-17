package dev.robgleason.dto;

import dev.robgleason.entity.ReviewsEntity;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReviewsEntityDto implements Serializable {
    Long id;
    Integer rating;
    String comment;
    Long gameId;
}
