package by.sak.dormitory.rest;

import by.sak.dormitory.dto.WorkCreateUpdateDto;
import by.sak.dormitory.dto.WorkReadDto;
import by.sak.dormitory.service.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workplaces")
@RequiredArgsConstructor
public class WorkRestController {
    private final WorkService workService;

    @GetMapping
    public List<WorkReadDto> findAll () {
        return workService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<WorkReadDto> findWorkById(@PathVariable int id) {
        return workService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkReadDto create (@RequestBody WorkCreateUpdateDto workCreateUpdateDto){ //TODO IF FORM DELETE REQUESTBODY
        return workService.create(workCreateUpdateDto);
    }

    @PutMapping("/{id}")
    public WorkReadDto update(@PathVariable("id") Integer id, @RequestBody WorkCreateUpdateDto workCreateUpdateDto) {
        return workService.update(id, workCreateUpdateDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable("id") Integer id) {
        if (!workService.delete(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
