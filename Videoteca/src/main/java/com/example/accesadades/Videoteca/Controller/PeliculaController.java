package com.example.accesadades.Videoteca.Controller;

import com.example.accesadades.Videoteca.DTO.PeliculaDTO;
import com.example.accesadades.Videoteca.Model.Pelicula;
import com.example.accesadades.Videoteca.Service.PeliculaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @PostMapping("/save")
    public Mono<Pelicula> save(@RequestBody PeliculaDTO peliculaDTO) {
        return peliculaService.save(peliculaDTO);
    }

    @GetMapping("/{id}")
    public Mono<Pelicula> findById(@PathVariable String id) {
        return peliculaService.findById(id);
    }

    @GetMapping("/all")
    public Flux<Pelicula> findAll() {
        return peliculaService.findAll();
    }

    @PutMapping("/update")
    public Mono<Pelicula> update(@RequestBody PeliculaDTO peliculaDTO) {
        return peliculaService.update(peliculaDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return peliculaService.delete(id);
    }
}
