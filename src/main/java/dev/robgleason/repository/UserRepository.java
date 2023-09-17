package dev.robgleason.repository;

import dev.robgleason.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);

    void deleteUserByUsername(String username);

    void deleteUserByEmail(String email);


}
