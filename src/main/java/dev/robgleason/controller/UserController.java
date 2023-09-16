package dev.robgleason.controller;


import dev.robgleason.dto.UserEntityDto;
import dev.robgleason.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;


    @PostMapping
    public ResponseEntity<UserEntityDto> createUser(@RequestBody UserEntityDto userEntityDto) {
        UserEntityDto savedUser = userService.createUser(userEntityDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<UserEntityDto> getUser(@PathVariable("id") Long userId) {
        UserEntityDto userByIdDto = userService.getUserById(userId);
        return ResponseEntity.ok(userByIdDto);

    }
}
