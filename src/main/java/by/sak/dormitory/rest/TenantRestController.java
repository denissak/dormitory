package by.sak.dormitory.rest;

import by.sak.dormitory.dto.TenantCreateUpdateDto;
import by.sak.dormitory.dto.TenantReadDto;
import by.sak.dormitory.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tenant")
public class TenantRestController {

    private final TenantService tenantService;

    @Autowired
    public TenantRestController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping
    public List<TenantReadDto> findAll () {
        return tenantService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<TenantReadDto> findTenantById(@PathVariable int id) {
        return tenantService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TenantReadDto create (@RequestBody TenantCreateUpdateDto tenantCreateUpdateDto){ //TODO IF FORM DELETE REQUESTBODY
        return tenantService.create(tenantCreateUpdateDto);
    }

    @PutMapping("/{id}")
    public TenantReadDto update(@PathVariable("id") Integer id, @RequestBody TenantCreateUpdateDto tenantCreateUpdateDto) {
        return tenantService.update(id, tenantCreateUpdateDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable("id") Integer id) {
        if (!tenantService.delete(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
