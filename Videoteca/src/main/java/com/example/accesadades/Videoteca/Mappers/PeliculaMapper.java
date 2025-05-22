package com.example.accesadades.Videoteca.Mappers;

import com.example.accesadades.Videoteca.DTO.PeliculaDTO;
import com.example.accesadades.Videoteca.Model.Pelicula;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeliculaMapper {

    // Mapeo de Pelicula a PeliculaDTO
    PeliculaDTO toDTO(Pelicula pelicula);

    // Mapeo de PeliculaDTO a Pelicula
    Pelicula toEntity(PeliculaDTO peliculaDTO);
}

