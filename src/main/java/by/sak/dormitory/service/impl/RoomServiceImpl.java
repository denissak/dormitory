package by.sak.dormitory.service.impl;

import by.sak.dormitory.dto.RoomCreateUpdateDto;
import by.sak.dormitory.dto.RoomReadDto;
import by.sak.dormitory.mapper.RoomCreateUpdateMapper;
import by.sak.dormitory.mapper.RoomReadMapper;
import by.sak.dormitory.repository.RoomRepository;
import by.sak.dormitory.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomReadMapper roomReadMapper;
    private final RoomCreateUpdateMapper roomCreateUpdateMapper;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository, RoomReadMapper roomReadMapper, RoomCreateUpdateMapper roomCreateUpdateMapper) {
        this.roomRepository = roomRepository;
        this.roomReadMapper = roomReadMapper;
        this.roomCreateUpdateMapper = roomCreateUpdateMapper;
    }

    @Override
    public List<RoomReadDto> findAll() {
        return roomRepository.findAll().stream().map(roomReadMapper::convertToRoomReadDto).toList();
    }

    @Override
    public Optional<RoomReadDto> findById(Integer roomId) {
        return roomRepository.findById(roomId).map(roomReadMapper::convertToRoomReadDto);
    }

    @Transactional
    @Override
    public RoomReadDto create(RoomCreateUpdateDto roomCreateUpdateDto) {
        return Optional.of(roomCreateUpdateDto)
                .map(roomCreateUpdateMapper::map)
                .map(roomRepository::save)
                .map(roomReadMapper::convertToRoomReadDto)
                .orElseThrow();
    }

    @Transactional
    @Override
    public Optional<RoomReadDto> update(Integer id, RoomCreateUpdateDto roomCreateUpdateDto) {
        return roomRepository.findById(id).map(room -> roomCreateUpdateMapper.map(roomCreateUpdateDto, room))
                .map(roomRepository::saveAndFlush)
                .map(roomReadMapper::convertToRoomReadDto);
    }

    @Transactional
    @Override
    public boolean delete(Integer id) {
        return roomRepository.findById(id).map(room -> {
                    roomRepository.delete(room);
                    roomRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
