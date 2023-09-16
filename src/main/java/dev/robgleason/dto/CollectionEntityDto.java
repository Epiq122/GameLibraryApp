package dev.robgleason.dto;

import dev.robgleason.entity.CollectionEntity;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CollectionEntityDto implements Serializable {
    Long id;
}
