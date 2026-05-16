package com.it.unimol.biblioteca;

import java.util.List;

//La classe Libro con attributi:
// ID (numero progressivo),
// autori (array di oggetti Autore),
// titolo,
// prezzo
// casa editrice;
// un metodo toString e un costruttore con parametri
public class Libro {
    private Integer id;
    private String title;
    private Float price;
    private CasaEditrice casaEditrice;
    private List<Autore> autori;


    public Libro(Integer id, String title, Float price, CasaEditrice casaEditrice, List<Autore> autori) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.casaEditrice = casaEditrice;
        this.autori = autori;
    }

    @Override
    public String toString() {
        StringBuilder autoriString = new StringBuilder(" ");

        for (Autore autore : this.autori) {
            autoriString.append(autore.toString());
            autoriString.append(" ");
        }

        //this.autori.forEach(autore -> autori += autore.getName());
        return "Id: " + this.id + "," +
                "Title: " + this.title + "," +
                "Price: " + this.price + "," +
                "Casa Editrice" + this.casaEditrice.getName() + "," +
                "Autori" + autoriString;
    }

    public List<Autore> getAutori() {
        return autori;
    }

    public void setAutori(List<Autore> autori) {
        this.autori = autori;
    }
}
