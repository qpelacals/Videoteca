package com.example.accesadades.Videoteca.Service;

import com.example.accesadades.Videoteca.DTO.PeliculaDTO;
import com.example.accesadades.Videoteca.Mappers.PeliculaMapper;
import com.example.accesadades.Videoteca.Model.Pelicula;
import com.example.accesadades.Videoteca.Repository.PeliculaRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PeliculaService {
    private final PeliculaRepo peliculaRepo;
    private final PeliculaMapper peliculaMapper;

    public PeliculaService(PeliculaRepo peliculaRepo, PeliculaMapper peliculaMapper) {
        this.peliculaRepo = peliculaRepo;
        this.peliculaMapper = peliculaMapper;
    }

    public Mono<Pelicula> save(PeliculaDTO peliculaDTO) {
        Pelicula pelicula = peliculaMapper.toEntity(peliculaDTO);
        return peliculaRepo.save(pelicula);
    }

    public Mono<Pelicula> findById(String id) {
        return peliculaRepo.findById(id);
    }

    public Flux<Pelicula> findAll() {
        return peliculaRepo.findAll();
    }

    public Mono<Pelicula> update(PeliculaDTO peliculaDTO) {
        return peliculaRepo.findById(peliculaDTO.id())
                .map(existingPelicula -> peliculaMapper.toEntity(peliculaDTO))
                .flatMap(peliculaRepo::save);
    }

    public Mono<Void> delete(String id) {
        return peliculaRepo.deleteById(id);
    }
}
