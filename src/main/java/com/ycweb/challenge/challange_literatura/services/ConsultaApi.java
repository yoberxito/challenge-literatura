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

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {

    public String ConsultaLibreria(String url) throws IOException, InterruptedException {

        HttpClient client= HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest httpRequest=HttpRequest.newBuilder()
                .uri(URI.create(url)).build();


        HttpResponse<String> httpResponse= client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String jso=httpResponse.body();
        System.out.println(jso);
        return jso;
    }
}
