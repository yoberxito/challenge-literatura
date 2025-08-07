package com.ycweb.challenge.challange_literatura.domain.autor;/*
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

import com.ycweb.challenge.challange_literatura.domain.book.Libro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Autor")
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private int birthYear;
    private int deathYear;
    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    public Autor(DatorAutor datorAutor){
        this.name=datorAutor.name();
        this.birthYear=datorAutor.birthYear();
        this.deathYear= datorAutor.deathYear();
    }

    public Autor(Autor autor) {
        this.id = autor.id;
        this.name = autor.name;
        this.birthYear = autor.birthYear;
        this.deathYear = autor.deathYear;
        this.libros = autor.libros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", deathYear=" + deathYear +
                '}';
    }
}
