package com.example.camisasapi.repository;

import com.example.camisasapi.domain.Camisa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CamisaRepository extends JpaRepository<Camisa, Long> {
    List<Camisa> findByMarcaNombre(String nombreMarca);
}
