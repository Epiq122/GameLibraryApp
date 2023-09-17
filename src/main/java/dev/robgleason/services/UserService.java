package dev.robgleason.services;

import dev.robgleason.dto.UserEntityDto;
import dev.robgleason.entity.UserEntity;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {

    UserEntityDto getUserById(Long userId);

    UserEntityDto getUserByUsername(String username);

    UserEntityDto getUserByEmail(String email);

    List<UserEntityDto> getAllUsers();

    UserEntityDto createUser(UserEntityDto userEntityDto);

    UserEntityDto updateUser(UserEntityDto userEntityDto);

    void deleteUser(Long userId);

    void deleteUserByUsername(String username);

    void deleteUserByEmail(String email);

}
