package com.example.camisasapi.mapper;

import com.example.camisasapi.domain.Camisa;
import com.example.camisasapi.domain.Marca;
import com.example.camisasapi.dto.CamisaDto;
import com.example.camisasapi.dto.CreateCamisaDto;

public class CamisaMapper {

    public static CamisaDto toDto(Camisa camisa) {
        if (camisa == null) {
            return null;
        }
        return new CamisaDto(
                camisa.getId(),
                camisa.getModelo(),
                camisa.getTalla(),
                camisa.getPrecio(),
                MarcaMapper.toDto(camisa.getMarca())
        );
    }

    public static Camisa toEntity(CreateCamisaDto dto) {
        if (dto == null) {
            return null;
        }
        Camisa camisa = new Camisa();
        camisa.setModelo(dto.getModelo());
        camisa.setTalla(dto.getTalla());
        camisa.setPrecio(dto.getPrecio());
        Marca marca = new Marca();
        marca.setId(dto.getMarcaId());
        camisa.setMarca(marca);
        return camisa;
    }
}
