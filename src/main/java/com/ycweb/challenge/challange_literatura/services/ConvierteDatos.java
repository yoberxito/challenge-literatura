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
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConcierteDatos {
    private ObjectMapper objectMapper=new ObjectMapper();


    @Override
    public <T> T convierteDatos(String jso, Class<T> clase) {
        try {
            System.out.println("Convierte-datos:"+jso);
            return objectMapper.readValue(jso,clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
