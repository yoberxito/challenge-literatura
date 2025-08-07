package com.ycweb.challenge.challange_literatura.services;/*
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

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConcierteDatos {

    <T> T convierteDatos(String Jso,Class<T> clase) throws JsonProcessingException;
}
