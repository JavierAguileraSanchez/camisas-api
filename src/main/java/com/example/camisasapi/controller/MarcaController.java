package com.example.camisasapi.controller;

import com.example.camisasapi.domain.Marca;
import com.example.camisasapi.dto.MarcaDto;
import com.example.camisasapi.mapper.MarcaMapper;
import com.example.camisasapi.service.MarcaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public List<MarcaDto> findAll() {
        return marcaService.findAll().stream()
                .map(MarcaMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MarcaDto findById(@PathVariable Long id) {
        return MarcaMapper.toDto(marcaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MarcaDto> create(@RequestBody MarcaDto dto) {
        Marca saved = marcaService.create(MarcaMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(MarcaMapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public MarcaDto update(@PathVariable Long id, @RequestBody MarcaDto dto) {
        return MarcaMapper.toDto(marcaService.update(id, MarcaMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        marcaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
