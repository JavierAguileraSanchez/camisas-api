package com.example.camisasapi.controller;

import com.example.camisasapi.domain.Camisa;
import com.example.camisasapi.dto.CamisaDto;
import com.example.camisasapi.dto.CreateCamisaDto;
import com.example.camisasapi.mapper.CamisaMapper;
import com.example.camisasapi.service.CamisaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/camisas")
public class CamisaController {

    private final CamisaService camisaService;

    public CamisaController(CamisaService camisaService) {
        this.camisaService = camisaService;
    }

    @GetMapping
    public List<CamisaDto> findAll(@RequestParam(required = false) String marca) {
        List<Camisa> camisas = (marca == null || marca.isBlank())
                ? camisaService.findAll()
                : camisaService.findByMarcaNombre(marca);
        return camisas.stream().map(CamisaMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CamisaDto findById(@PathVariable Long id) {
        return CamisaMapper.toDto(camisaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CamisaDto> create(@RequestBody CreateCamisaDto dto) {
        Camisa saved = camisaService.create(CamisaMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(CamisaMapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public CamisaDto update(@PathVariable Long id, @RequestBody CreateCamisaDto dto) {
        Camisa updated = camisaService.update(id, CamisaMapper.toEntity(dto));
        return CamisaMapper.toDto(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        camisaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
