package by.sak.dormitory.rest;

import by.sak.dormitory.dto.ContractCreateUpdateDto;
import by.sak.dormitory.dto.ContractReadDto;
import by.sak.dormitory.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contracts")
public class ContractRestController {

    private final ContractService contractService;

    @Autowired
    public ContractRestController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public List<ContractReadDto> findAll() {
        return contractService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ContractReadDto> findRoomById(@PathVariable int id) {
        return contractService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContractReadDto create(@RequestBody ContractCreateUpdateDto contractCreateUpdateDto) { //TODO IF FORM DELETE REQUESTBODY
        return contractService.create(contractCreateUpdateDto);
    }

    @PutMapping("/{id}")
    public ContractReadDto update(@PathVariable("id") Integer id, @RequestBody ContractCreateUpdateDto contractCreateUpdateDto) {
        return contractService.update(id, contractCreateUpdateDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        if (!contractService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
