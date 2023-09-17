package dev.robgleason.services;

import dev.robgleason.dto.UserEntityDto;
import dev.robgleason.entity.UserEntity;
import dev.robgleason.exception.ResourceNotFoundException;
import dev.robgleason.exception.UserNotFoundException;
import dev.robgleason.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Transactional

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserEntityDto getUserById(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with id " + userId));
        return modelMapper.map(user, UserEntityDto.class);

    }

    @Override
    public UserEntityDto createUser(UserEntityDto userEntityDto) {
        UserEntity user = modelMapper.map(userEntityDto, UserEntity.class);
        UserEntity savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserEntityDto.class);
    }

    @Override
    public UserEntityDto getUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username);
        return modelMapper.map(user, UserEntityDto.class);

    }

    private UserEntity findByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("user not found with username " + username);
        }
        return user;
    }


    @Override
    public UserEntityDto getUserByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("user not found with email " + email);
        }
        return modelMapper.map(user, UserEntityDto.class);

    }

    private UserEntity findByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("user not found with email  " + email);
        }
        return user;
    }


    @Override
    public List<UserEntityDto> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserEntityDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserEntityDto updateUser(UserEntityDto userEntityDto) {
        UserEntity existingUser = userRepository.findById(userEntityDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userEntityDto.getId()));


        existingUser.setUsername(userEntityDto.getUsername());
        existingUser.setPassword(userEntityDto.getPassword());
        existingUser.setCity(userEntityDto.getCity());
        existingUser.setCountry(userEntityDto.getCountry());
        existingUser.setEmail(userEntityDto.getEmail());
        existingUser.setFirstName(userEntityDto.getFirstName());
        existingUser.setLastName(userEntityDto.getLastName());

        UserEntity updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserEntityDto.class);
    }

    @Override
    public void deleteUser(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User with id " + userId + " " + "does not exist"));
        userRepository.deleteById(userId);
    }

    @Override
    public void deleteUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new ResourceNotFoundException("user not found with username " + username);
        }
        userRepository.deleteUserByUsername(username);
    }

    @Override
    public void deleteUserByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new ResourceNotFoundException("user not found with email " + email);
        }
        userRepository.deleteUserByEmail(email);
    }
}
