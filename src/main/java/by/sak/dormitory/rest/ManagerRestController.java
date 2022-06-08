package by.sak.dormitory.rest;

import by.sak.dormitory.dto.ManagerCreateUpdateDto;
import by.sak.dormitory.dto.ManagerReadDto;
import by.sak.dormitory.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerRestController {

    private final ManagerService managerService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ManagerReadDto> findManagerById(@PathVariable int id) {
        return managerService.findById(id);
    }

    @PutMapping("/{id}")
    public ManagerReadDto update(@PathVariable("id") Integer id, @RequestBody ManagerCreateUpdateDto managerCreateUpdateDto) {
        return managerService.update(id, managerCreateUpdateDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
