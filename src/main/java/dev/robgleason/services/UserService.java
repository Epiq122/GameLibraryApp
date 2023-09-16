package dev.robgleason.services;

import dev.robgleason.dto.UserEntityDto;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {

    UserEntityDto getUserById(Long userId);

    List<UserEntityDto> getAllUsers();

    UserEntityDto createUser(UserEntityDto userEntityDto);

    UserEntityDto updateUser(UserEntityDto userEntityDto);

    void deleteUser(Long userId);
    
}
