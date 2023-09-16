package dev.robgleason.repository;

import dev.robgleason.entity.CollectionEntity;
import dev.robgleason.entity.GameEntity;
import dev.robgleason.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface CollectionRepository extends JpaRepository<CollectionEntity, Long> {


}

