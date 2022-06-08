package by.sak.dormitory.rest;

import by.sak.dormitory.dto.PersonalInfoCreateUpdateDto;
import by.sak.dormitory.dto.PersonalInfoReadDto;
import by.sak.dormitory.service.PersonalInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personalInfos")
@RequiredArgsConstructor
public class PersonalInfoRestController {

    private final PersonalInfoService personalInfoService;

    @GetMapping
    public List<PersonalInfoReadDto> findAll () {
        return personalInfoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<PersonalInfoReadDto> findPersonalInfoById(@PathVariable int id) {
        return personalInfoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalInfoReadDto create (@RequestBody PersonalInfoCreateUpdateDto personalInfoCreateUpdateDto){ //TODO IF FORM DELETE REQUESTBODY
        return personalInfoService.create(personalInfoCreateUpdateDto);
    }

    @PutMapping("/{id}")
    public PersonalInfoReadDto update(@PathVariable("id") Integer id, @RequestBody PersonalInfoCreateUpdateDto personalInfoCreateUpdateDto) {
        return personalInfoService.update(id, personalInfoCreateUpdateDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable("id") Integer id) {
        if (!personalInfoService.delete(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
