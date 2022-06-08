package by.sak.dormitory.rest;

import by.sak.dormitory.dto.DormitoryCreateUpdateDto;
import by.sak.dormitory.dto.DormitoryReadDto;
import by.sak.dormitory.service.DormitoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dormitories")
@RequiredArgsConstructor
public class DormitoryRestController {

    private final DormitoryService dormitoryService;

    @GetMapping
    public List<DormitoryReadDto> findAll () {
        return dormitoryService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<DormitoryReadDto> findDormitoryById(@PathVariable int id) {
        return dormitoryService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DormitoryReadDto create (@RequestBody DormitoryCreateUpdateDto dormitoryCreateUpdateDto){ //TODO IF FORM DELETE REQUESTBODY
        return dormitoryService.create(dormitoryCreateUpdateDto);
    }

    @PutMapping("/{id}")
    public DormitoryReadDto update(@PathVariable("id") Integer id, @RequestBody DormitoryCreateUpdateDto dormitoryCreateUpdateDto) {
        return dormitoryService.update(id, dormitoryCreateUpdateDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable("id") Integer id) {
        if (!dormitoryService.delete(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
