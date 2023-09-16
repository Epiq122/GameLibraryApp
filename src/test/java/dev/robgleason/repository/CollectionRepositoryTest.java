package dev.robgleason.repository;

import dev.robgleason.entity.CollectionEntity;
import dev.robgleason.entity.GameEntity;
import dev.robgleason.entity.UserEntity;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CollectionRepositoryTest {


    @Autowired
    private CollectionRepository collectionRepository;
    @Autowired
    private UserRepository userRepository;


    @Test
    public void testFindByUser() {
        UserEntity user = new UserEntity();
        user.setUsername("jaqwdqwcko");
        user.setEmail("jaqwdx2@jdqwack.com");
        user.setPassword("pdadqwdwqssword");
        user.setFirstName("Jacdqwk");
        user.setLastName("Jadqwcdqwkson");
        user.setCity("Jacksodqwdqwnville");
        user.setCountry("USqdqwwdA");

        userRepository.save(user);


    }


}
