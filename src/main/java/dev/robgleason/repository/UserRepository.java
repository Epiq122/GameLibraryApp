package dev.robgleason.repository;

import dev.robgleason.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);

    void deleteUserByUsername(String username);

    void deleteUserByEmail(String email);

    Optional<UserEntity> findByUsernameOrEmail(String username, String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);


}
