package com.ycweb.challenge.challange_literatura;/*
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

import com.ycweb.challenge.challange_literatura.domain.RespuestaAPI;
import com.ycweb.challenge.challange_literatura.domain.autor.Autor;
import com.ycweb.challenge.challange_literatura.domain.book.Libro;
import com.ycweb.challenge.challange_literatura.domain.repository.AutorRepository;
import com.ycweb.challenge.challange_literatura.domain.repository.BookRepository;
import com.ycweb.challenge.challange_literatura.services.ConsultaApi;
import com.ycweb.challenge.challange_literatura.services.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
@SpringBootApplication

public class Principal implements CommandLineRunner {
    @Autowired
    private AutorRepository repository;
    @Autowired
    private BookRepository bookRepository;
    private String URL="http://gutendex.com/books/";

    public static void main(String[] args) throws IOException, InterruptedException  {
        SpringApplication.run(Principal.class, args);

      /*  String URL="http://gutendex.com/books/";



        HttpClient client= HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest httpRequest=HttpRequest.newBuilder()
                .uri(URI.create(URL)).build();


        HttpResponse<String> httpResponse= client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if(httpResponse.statusCode()==200){
            String json=httpResponse.body();
            ObjectMapper objectMapper=new ObjectMapper();

            BookResponse response=objectMapper.readValue(json, BookResponse.class);
            System.out.println(response);
        }


        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.body());*/

    }

    @Override
    public void run(String... args) throws Exception {
        List<Libro> libros =new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int opcion = -1; // cualquier valor distinto de 0 para entrar al while

        while (opcion != 0) {
            System.out.print("""
            Elija la opción a través de su número:
            1- buscar libro por título
            2- listar libros registrados
            3- listar autores registrados
            4- listar autores vivos en un determinado año
            5- listar libros por idioma
            0- salir
            Opción: """);

            opcion = scanner.nextInt();

            //buscar libro por título


            switch (opcion) {
                case 1 -> {
                    Scanner nameBook=new Scanner(System.in);
                    System.out.print("➡️ Ingrese el nombre del libro: ");
                    var nombre=nameBook.nextLine();


                    Libro libro =  buscarLibroPorTitulo(URL+"?search="+nombre.replace(" ","%20"));

                    libros.add(libro);
                }
                case 2 ->
                {
                    System.out.println("Listar libros registrados");
                    List<Libro> list=bookRepository.findAll();
                    System.out.println("Los libros registrados son:\n"+list);

                }
                case 3 -> {
                    System.out.println("Listar autores registrados");
                    List<Autor> autors=repository.findAll();
                    System.out.println("Los autores registrados son:\n"+autors);
                }
                case 4 -> {
                    Scanner nameBook=new Scanner(System.in);
                    System.out.print("Ingrese el año a evaluar: ");
                    var anio=nameBook.nextInt();

                    List<Autor> autors=repository.buscaAutoresVivos(anio);
                    System.out.println("Los autores vivos en el anio: "+anio +" son:"+autors);

                }
                case 5 -> {
                    Scanner nameBook=new Scanner(System.in);
                    System.out.print("Ingrese el idioma a buscar: ");
                    var idioma=nameBook.nextLine();

                    List<Libro> list=bookRepository.findByIdioma(idioma);
                    System.out.println("Libros por idioma\n"+list);
                }
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

    }

    private Libro buscarLibroPorTitulo(String url) throws IOException, InterruptedException {
        var consultaApi=new ConsultaApi();
        ConvierteDatos datos=new ConvierteDatos();
        var json=consultaApi.ConsultaLibreria(url);
        var dato=datos.convierteDatos(json, RespuestaAPI.class);
        Libro libro =new Libro(dato.results().get(0));
        Optional<Autor> autor= repository.findByName(libro.getAutor().getName());
        if(!autor.isPresent()){
            Autor autor1=new Autor(libro.getAutor());
            repository.save(autor1);
            autor= Optional.of(autor1);
        }
        Optional<Libro> libro1=bookRepository.findByTitle(libro.getTitle());
        if (!libro1.isPresent()){
            Libro libro2=new Libro(libro);
            libro2.setAutor(autor.get());
            bookRepository.save(libro2);
            libro1= Optional.of(libro2);
        }
        return libro;

    }

}
