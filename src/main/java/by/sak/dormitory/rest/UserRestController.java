package by.sak.dormitory.rest;

import by.sak.dormitory.dto.UserReadDto;
import by.sak.dormitory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Optional<UserReadDto> findUserById(@PathVariable int id) {
        return userService.findById(id);
    }
}
