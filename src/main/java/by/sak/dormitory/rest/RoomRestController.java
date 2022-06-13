package by.sak.dormitory.rest;

import by.sak.dormitory.dto.RoomCreateUpdateDto;
import by.sak.dormitory.dto.RoomReadDto;
import by.sak.dormitory.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomRestController {

    private final RoomService roomService;

    @GetMapping
    public List<RoomReadDto> findAll () {
        return roomService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<RoomReadDto> findRoomById(@PathVariable int id) {
        return roomService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoomReadDto create (@RequestBody RoomCreateUpdateDto roomCreateUpdateDto){ //TODO IF FORM DELETE REQUESTBODY
        return roomService.create(roomCreateUpdateDto);
    }

    @PutMapping("/{id}")
    public RoomReadDto update(@PathVariable("id") Integer id, @RequestBody RoomCreateUpdateDto roomCreateUpdateDto) {
        return roomService.update(id, roomCreateUpdateDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable("id") Integer id) {
        if (!roomService.delete(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
