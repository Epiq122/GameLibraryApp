package dev.robgleason.dto;

import dev.robgleason.entity.UserEntity;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntityDto implements Serializable {

    Long id;
    String username;
    String password;
    String email;
    String firstName;
    String lastName;
    String city;
    String country;
}
