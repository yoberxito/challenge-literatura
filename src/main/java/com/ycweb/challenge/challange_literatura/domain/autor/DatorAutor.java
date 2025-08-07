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

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatorAutor(
          @JsonAlias(value = "name") String name,
          @JsonAlias(value = "birth_year")int birthYear,

          @JsonAlias(value = "death_year")int deathYear
) {
}
