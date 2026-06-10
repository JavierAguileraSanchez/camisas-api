package com.example.camisasapi.service;

import com.example.camisasapi.domain.Marca;
import com.example.camisasapi.exception.ResourceNotFoundException;
import com.example.camisasapi.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    public Marca findById(Long id) {
        return marcaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Marca not found with id " + id));
    }

    public Marca create(Marca marca) {
        return marcaRepository.save(marca);
    }

    public Marca update(Long id, Marca updatedMarca) {
        Marca existing = findById(id);
        existing.setNombre(updatedMarca.getNombre());
        return marcaRepository.save(existing);
    }

    public void delete(Long id) {
        Marca existing = findById(id);
        marcaRepository.delete(existing);
    }
}
