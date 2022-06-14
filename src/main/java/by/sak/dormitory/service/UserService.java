package by.sak.dormitory.service;

import by.sak.dormitory.dto.UserReadDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<UserReadDto> findById (Integer userId);

    List<UserReadDto> findAll();
}
