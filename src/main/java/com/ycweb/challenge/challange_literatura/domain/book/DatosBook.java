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

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ycweb.challenge.challange_literatura.domain.autor.DatorAutor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosBook( @JsonAlias("title") String title,
                         @JsonAlias("authors") List<DatorAutor> autors,
                         @JsonAlias("languages") List<String> idioma,
                         @JsonAlias("download_count") int numeroDescarga)  {

}
