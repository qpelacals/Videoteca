package com.example.accesadades.Videoteca.DTO;


public record PeliculaDTO(
        String id,
        String titulo,
        String genero,
        String director,
        int añoEstreno,
        double duracion,
        String sinopsis,
        double calificacion,
        String idioma
) {}