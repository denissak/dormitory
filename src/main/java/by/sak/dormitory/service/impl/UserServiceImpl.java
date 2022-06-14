package by.sak.dormitory.service.impl;

import by.sak.dormitory.dto.UserReadDto;
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

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserReadMapper userReadMapper) {
        this.userRepository = userRepository;
        this.userReadMapper = userReadMapper;
    }

    @Override
    public Optional<UserReadDto> findById(Integer userId) {
        return userRepository.findById(userId).map(userReadMapper::convertToUserReadDto);
    }

    @Override
    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream().map(userReadMapper::convertToUserReadDto).toList();
    }
}
