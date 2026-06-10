package com.example.camisasapi.mapper;

import com.example.camisasapi.domain.Marca;
import com.example.camisasapi.dto.MarcaDto;

public class MarcaMapper {

    public static MarcaDto toDto(Marca marca) {
        if (marca == null) {
            return null;
        }
        return new MarcaDto(marca.getId(), marca.getNombre());
    }

    public static Marca toEntity(MarcaDto dto) {
        if (dto == null) {
            return null;
        }
        Marca marca = new Marca();
        marca.setId(dto.getId());
        marca.setNombre(dto.getNombre());
        return marca;
    }
}
