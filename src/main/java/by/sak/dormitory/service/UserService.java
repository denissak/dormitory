package by.sak.dormitory.service;

import by.sak.dormitory.dto.UserCreateUpdateDto;
import by.sak.dormitory.dto.UserReadDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserReadDto> findAll();

    Optional<UserReadDto> findById(Integer userId);

    UserReadDto create(UserCreateUpdateDto userCreateUpdateDto);

    Optional<UserReadDto> update(Integer id, UserCreateUpdateDto userCreateUpdateDto);

    boolean delete(Integer id);
}
