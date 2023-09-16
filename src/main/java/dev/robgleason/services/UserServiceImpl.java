package dev.robgleason.services;

import dev.robgleason.dto.UserEntityDto;
import dev.robgleason.entity.UserEntity;
import dev.robgleason.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserEntityDto getUserById(Long userId) {


        return null;
    }

    @Override
    public List<UserEntityDto> getAllUsers() {
        return null;
    }

    @Override
    public UserEntityDto createUser(UserEntityDto userEntityDto) {
        UserEntity user = modelMapper.map(userEntityDto, UserEntity.class);
        UserEntity savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserEntityDto.class);
    }

    @Override
    public UserEntityDto updateUser(UserEntityDto userEntityDto) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
}
