package by.sak.dormitory.service.impl;

import by.sak.dormitory.dto.UserCreateUpdateDto;
import by.sak.dormitory.dto.UserReadDto;
import by.sak.dormitory.mapper.UserCreateUpdateMapper;
import by.sak.dormitory.mapper.UserReadMapper;
import by.sak.dormitory.repository.UserRepository;
import by.sak.dormitory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateUpdateMapper userCreateUpdateMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserReadMapper userReadMapper, UserCreateUpdateMapper userCreateUpdateMapper) {
        this.userRepository = userRepository;
        this.userReadMapper = userReadMapper;
        this.userCreateUpdateMapper = userCreateUpdateMapper;
    }

    @Override
    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream().map(userReadMapper::convertToUserReadDto).toList();
    }

    @Override
    public Optional<UserReadDto> findById(Integer userId) {
        return userRepository.findById(userId).map(userReadMapper::convertToUserReadDto);
    }

    @Override
    public UserReadDto create(UserCreateUpdateDto userCreateUpdateDto) {
        return Optional.of(userCreateUpdateDto)
                .map(userCreateUpdateMapper::map)
                .map(userRepository::save)
                .map(userReadMapper::convertToUserReadDto)
                .orElseThrow();
    }

    @Override
    public Optional<UserReadDto> update(Integer id, UserCreateUpdateDto userCreateUpdateDto) {
        return userRepository.findById(id).map(user -> userCreateUpdateMapper.map(userCreateUpdateDto, user))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::convertToUserReadDto);
    }

    @Override
    public boolean delete(Integer id) {
        return userRepository.findById(id).map(room -> {
                    userRepository.delete(room);
                    userRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
