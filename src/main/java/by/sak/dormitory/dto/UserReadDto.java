package by.sak.dormitory.dto;

import by.sak.dormitory.entity.Role;
import lombok.Value;

@Value
public class UserReadDto {
    Integer id;
    String login;
    String password;
    Role role;
}
