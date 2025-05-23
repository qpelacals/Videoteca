package com.example.accesadades.Videoteca.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "peliculas")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pelicula implements Serializable {
    @Id
    private String id;
    private String titulo;
    private String genero;
    private String director;
    private int añoEstreno;
    private double duracion; // duración en minutos
    private String sinopsis;
    private String idioma;

    public String getId() {
        return id;
    }
}


