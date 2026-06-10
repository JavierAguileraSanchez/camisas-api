package com.example.camisasapi.service;

import com.example.camisasapi.domain.Camisa;
import com.example.camisasapi.domain.Marca;
import com.example.camisasapi.exception.ResourceNotFoundException;
import com.example.camisasapi.repository.CamisaRepository;
import com.example.camisasapi.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CamisaService {

    private final CamisaRepository camisaRepository;
    private final MarcaRepository marcaRepository;

    public CamisaService(CamisaRepository camisaRepository, MarcaRepository marcaRepository) {
        this.camisaRepository = camisaRepository;
        this.marcaRepository = marcaRepository;
    }

    public List<Camisa> findAll() {
        return camisaRepository.findAll();
    }

    public Camisa findById(Long id) {
        return camisaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Camisa not found with id " + id));
    }

    public Camisa create(Camisa camisa) {
        Marca marca = marcaRepository.findById(camisa.getMarca().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Marca not found with id " + camisa.getMarca().getId()));
        camisa.setMarca(marca);
        return camisaRepository.save(camisa);
    }

    public Camisa update(Long id, Camisa updatedCamisa) {
        Camisa existing = findById(id);
        existing.setModelo(updatedCamisa.getModelo());
        existing.setTalla(updatedCamisa.getTalla());
        existing.setPrecio(updatedCamisa.getPrecio());
        Marca marca = marcaRepository.findById(updatedCamisa.getMarca().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Marca not found with id " + updatedCamisa.getMarca().getId()));
        existing.setMarca(marca);
        return camisaRepository.save(existing);
    }

    public void delete(Long id) {
        Camisa existing = findById(id);
        camisaRepository.delete(existing);
    }

    public List<Camisa> findByMarcaNombre(String nombreMarca) {
        return camisaRepository.findByMarcaNombre(nombreMarca);
    }
}
