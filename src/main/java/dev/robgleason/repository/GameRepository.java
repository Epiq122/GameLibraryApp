package dev.robgleason.repository;

import dev.robgleason.entity.CollectionEntity;
import dev.robgleason.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface GameRepository extends JpaRepository<GameEntity, Long> {


}

