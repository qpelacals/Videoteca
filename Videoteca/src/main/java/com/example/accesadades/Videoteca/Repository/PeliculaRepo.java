package com.example.accesadades.Videoteca.Repository;

import com.example.accesadades.Videoteca.Model.Pelicula;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@EnableReactiveMongoRepositories
public interface PeliculaRepo extends ReactiveMongoRepository<Pelicula, String> {
    Flux<Pelicula> findByGenero(String genero);
    Flux<Pelicula> findByTituloContaining(String titulo);
    Flux<Pelicula> findByTituloRegex(String regex);
}