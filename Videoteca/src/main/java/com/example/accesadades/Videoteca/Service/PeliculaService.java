package com.example.accesadades.Videoteca.Service;

import com.example.accesadades.Videoteca.DTO.PeliculaDTO;
import com.example.accesadades.Videoteca.Mappers.PeliculaMapper;
import com.example.accesadades.Videoteca.Model.Pelicula;
import com.example.accesadades.Videoteca.Repository.PeliculaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepo peliculaRepo;

    @Autowired
    private PeliculaMapper peliculaMapper;

    public Mono<Pelicula> save(PeliculaDTO peliculaDTO) {
        return peliculaRepo.save(peliculaMapper.toEntity(peliculaDTO));
    }

    public Mono<Pelicula> findById(String id) {
        return peliculaRepo.findById(id);
    }

    public Flux<Pelicula> findAll() {
        return peliculaRepo.findAll();
    }

    public Mono<Pelicula> update(PeliculaDTO peliculaDTO) {
        return peliculaRepo.findById(peliculaDTO.id())
                .map(existingPelicula -> {
                    Pelicula updatedPelicula = peliculaMapper.toEntity(peliculaDTO);
                    // Preservar el ID existente
                    updatedPelicula.setId(existingPelicula.getId());
                    return updatedPelicula;
                })
                .flatMap(peliculaRepo::save);
    }

    public Mono<Void> delete(String id) {
        return peliculaRepo.deleteById(id);
    }

    public Flux<Pelicula> findByTituloRegex(String regex) {
        return peliculaRepo.findByTituloRegex(regex);
    }
}