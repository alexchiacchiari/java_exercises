package com.it.unimol.biblioteca;

import java.util.ArrayList;
import java.util.List;

//La classe Autore con attributi nome e cognome, un metodo toString e un costruttore con parametri
public class Autore {
    private String name;
    private String surname;
    private List<Libro> libri;

    public Autore(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.libri = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Libro> getLibri() {
        return libri;
    }

    public void setLibri(List<Libro> libri) {
        this.libri = libri;
    }

    public void setLibro(Libro libro) {
        this.libri.add(libro);
    }

    @Override
    public String toString() {
        return "Autore: " + this.name + " " + this.surname;
    }
}
