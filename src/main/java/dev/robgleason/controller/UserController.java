package dev.robgleason.controller;


import dev.robgleason.dto.CollectionEntityDto;
import dev.robgleason.dto.UserEntityDto;
import dev.robgleason.services.CollectionsService;
import dev.robgleason.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private CollectionsService collectionsService;


    @PostMapping
    public ResponseEntity<UserEntityDto> createUser(@RequestBody UserEntityDto userEntityDto) {
        UserEntityDto savedUser = userService.createUser(userEntityDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<UserEntityDto> updatedUser(@PathVariable("id") Long userId, @RequestBody UserEntityDto userEntityDto) {
        userEntityDto.setId(userId);
        UserEntityDto updatedUser = userService.updateUser(userEntityDto);
        return ResponseEntity.ok(updatedUser);
    }


    @GetMapping
    public ResponseEntity<List<UserEntityDto>> getAllUsers() {
        List<UserEntityDto> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserEntityDto> getUser(@PathVariable("id") Long userId) {
        UserEntityDto userByIdDto = userService.getUserById(userId);
        return ResponseEntity.ok(userByIdDto);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserEntityDto> getUserByUsername(@PathVariable("username") String username) {
        UserEntityDto userByUsernameDto = userService.getUserByUsername(username);
        return ResponseEntity.ok(userByUsernameDto);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserEntityDto> getUserByEmail(@PathVariable("email") String email) {
        UserEntityDto userByUserEmailDto = userService.getUserByEmail(email);
        return ResponseEntity.ok(userByUserEmailDto);
    }

    @GetMapping("/collections/{id}")
    public ResponseEntity<List<CollectionEntityDto>> getCollectionsByUser(@PathVariable("id") Long userId) {
        List<CollectionEntityDto> collections = collectionsService.getCollectionByUser(userId);
        return ResponseEntity.ok(collections);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("user deleted successfully");
    }

    @DeleteMapping("/username/{username}")
    public ResponseEntity<String> deleteUserByUserName(@PathVariable("username") String username) {
        userService.deleteUserByUsername(username);
        return ResponseEntity.ok("user deleted successfully");
    }

    @DeleteMapping("/email/{email}")
    public ResponseEntity<String> deleteUserByEmail(@PathVariable("email") String email) {
        userService.deleteUserByEmail(email);
        return ResponseEntity.ok("user deleted successfully");
    }


}
