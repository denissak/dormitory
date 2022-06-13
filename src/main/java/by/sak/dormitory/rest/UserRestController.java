package by.sak.dormitory.rest;

import by.sak.dormitory.dto.UserCreateUpdateDto;
import by.sak.dormitory.dto.UserReadDto;
import by.sak.dormitory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserReadDto> findAll () {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<UserReadDto> findRoomById(@PathVariable int id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserReadDto create (@RequestBody UserCreateUpdateDto userCreateUpdateDto){ //TODO IF FORM DELETE REQUESTBODY
        return userService.create(userCreateUpdateDto);
    }

    @PutMapping("/{id}")
    public UserReadDto update(@PathVariable("id") Integer id, @RequestBody UserCreateUpdateDto userCreateUpdateDto) {
        return userService.update(id, userCreateUpdateDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable("id") Integer id) {
        if (!userService.delete(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
