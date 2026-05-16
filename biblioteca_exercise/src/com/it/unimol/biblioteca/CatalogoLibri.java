package com.it.unimol.biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//•La classe CatalogoLibri con un
// array dinamico di libri,
// un metodo getCatalogo,
// un metodo stampaCatalogo
// un metodo aggiungiLibro
// un metodo ricerca con parametri stringa per effettuare la ricerca per cognome e nome autore nel catalogo
public class CatalogoLibri {
    private List<Libro> libri;

    public CatalogoLibri() {
        libri = new ArrayList<>();
    }
    public List<Libro> getCatalogo() {
        return libri;
    }

    public void aggiungiLibro(Libro libro) {
        this.getCatalogo().add(libro);
    }

    public void stampaCatalogo() {
        this.getCatalogo().forEach(libro -> System.out.println(libro.toString()));
    }

    public List<Autore> ricerca(String name, String surname) {
        List<Autore> autoriTrovati = new ArrayList<>();
        getCatalogo().forEach(libro -> {
            libro.getAutori().forEach(autore -> {
                if (name.equals(autore.getName()) || surname.equals(autore.getSurname())) {
                    autoriTrovati.add(autore);
                }
            });
        });
        if (autoriTrovati.isEmpty()) return Collections.emptyList();
        return autoriTrovati;
    }
}
