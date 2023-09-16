package dev.robgleason.dto;

import dev.robgleason.entity.GameEntity;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameEntityDto implements Serializable {
    Long id;
    String title;
    String genre;
    Integer releaseYear;
    String coverArtUrl;
    String description;
}
