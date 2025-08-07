package com.ycweb.challenge.challange_literatura.domain.book;/*
 * Copyright (c) 2025 yober cieza coronel. Todos los derechos reservados.
 *
 * Este archivo es parte de challange-literatura.
 *
 * challange-literatura es software propietario: no puedes redistribuirlo y/o modificarlo sin el
 * permiso expreso del propietario. Está sujeto a los términos y condiciones
 * que acompañan el uso del software.
 *
 * Cualquier uso no autorizado puede ser sancionado según la ley vigente.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ycweb.challenge.challange_literatura.domain.autor.Autor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "Libro")
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String idioma;

    private int numeroDescarga;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Libro(DatosBook datosBook) {
        this.title = datosBook.title();
        this.autor = datosBook.autors().stream()
                .map(Autor::new)
                .collect(Collectors.toList()).get(0);
        this.idioma = datosBook.idioma().get(0);
        this.numeroDescarga = datosBook.numeroDescarga();
    }

    public Libro(Libro libro) {
        this.id = libro.id;
        this.title = libro.title;
        this.idioma = libro.idioma;
        this.numeroDescarga = libro.numeroDescarga;
        this.autor = libro.autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", idioma='" + idioma + '\'' +
                ", numeroDescarga=" + numeroDescarga +
                '}';
    }
}
