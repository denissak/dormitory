package by.sak.dormitory.service;

import by.sak.dormitory.dto.RoomCreateUpdateDto;
import by.sak.dormitory.dto.RoomReadDto;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    List<RoomReadDto> findAll();

    Optional<RoomReadDto> findById(Integer roomId);

    RoomReadDto create(RoomCreateUpdateDto roomCreateUpdateDto);

    Optional<RoomReadDto> update(Integer id, RoomCreateUpdateDto roomCreateUpdateDto);

    boolean delete(Integer id);
}
