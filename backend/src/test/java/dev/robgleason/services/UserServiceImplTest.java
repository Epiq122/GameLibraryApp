package dev.robgleason.services;

import dev.robgleason.dto.UserEntityDto;
import dev.robgleason.entity.UserEntity;
import dev.robgleason.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;


    @Mock
    private ModelMapper modelMapper;

    @Test
    void createUser() {
        // Arrange
        UserEntityDto userEntityDto = new UserEntityDto();
        userEntityDto.setUsername("Epiq");

        UserEntity user = new UserEntity();
        user.setUsername("Epiq");

        when(modelMapper.map(userEntityDto, UserEntity.class)).thenReturn(user);

        UserEntity savedUser = new UserEntity();
        savedUser.setId(1L);
        savedUser.setUsername("Epiq");

        when(userRepository.save(user)).thenReturn(savedUser);

        UserEntityDto createdUserDto = userService.createUser(userEntityDto);

        assertNotNull(createdUserDto);

        assertEquals("Epiq", createdUserDto.getUsername());
        assertEquals(1L, createdUserDto.getId());

    }
}
