package com.example.accesadades.Videoteca.Controller;

import com.example.accesadades.Videoteca.DTO.PeliculaDTO;
import com.example.accesadades.Videoteca.Mappers.PeliculaMapper;
import com.example.accesadades.Videoteca.Model.Pelicula;
import com.example.accesadades.Videoteca.Service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaMapper peliculaMapper;  // Inyección del mapper

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @PostMapping
    public Mono<Pelicula> createPelicula(@RequestBody PeliculaDTO peliculaDTO) {
        return peliculaService.save(peliculaDTO);
    }

    @GetMapping("/{id}")
    public Mono<Pelicula> getPeliculaById(@PathVariable String id) {
        return peliculaService.findById(id);
    }

    @GetMapping
    public Flux<Pelicula> getAllPeliculas() {
        return peliculaService.findAll();
    }

    @PutMapping("/{id}")
    public Mono<Pelicula> updatePelicula(@PathVariable String id, @RequestBody PeliculaDTO peliculaDTO) {
        // Aseguramos que el ID del DTO coincida con el ID del path
        peliculaService.update(peliculaDTO);
        return peliculaService.update(peliculaDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePelicula(@PathVariable String id) {
        return peliculaService.delete(id);
    }

    @GetMapping("/search")
    public Flux<PeliculaDTO> searchByTitulo(@RequestParam String regex) {
        return peliculaService.findByTituloRegex(regex)
                .map(pelicula -> peliculaMapper.toDTO(pelicula));  // Utilizando lambda para aplicar el mapeo
    }
}