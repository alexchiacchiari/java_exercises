package com.it.unimol.biblioteca;/*Seguire le indicazioni riportate in 'Istruzioni attività' e restituire i file .java, .class, .jar

        Biblioteca

Vogliamo scrivere un programma per gestire una biblioteca:










•Dopo avere compilato i file (che saranno contenuti nella cartella src) con il solito comando

javac -d ./ ./src/*.java

vedrete la cartella biblioteca

A questo punto create il jar eseguibile con il comando

jar cfe biblioteca.jar biblioteca.com.it.unimol.biblioteca.Main biblioteca

Il jar sarà eseguibile con il comando

java -jar biblioteca.jar
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//•La classe com.it.unimol.biblioteca.Main, infine, che mostra un menu che permetta di:
// stampare il catalogo;
// inserire un libro;
// ricercare un libro per cognome e nome autore;
// uscire
public class Main {
    public static void main(String[] args) {
        CatalogoLibri catalogoLibri = new CatalogoLibri();
        while(true) {
            System.out.println("Fai una scelta: ");
            System.out.println("1. Stampare il catalogo");
            System.out.println("2. Inserire un libro");
            System.out.println("3. Ricerca per nome e cognome autore");
            System.out.println("0. Esci");
            Scanner scanner = new Scanner(System.in);
            Integer choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 0:
                    System.out.println("Arrivederci e grazie.");
                    System.exit(0);
                case 1:
                    catalogoLibri.stampaCatalogo();
                    break;
                case 2:
                    System.out.println("Inserisci titolo: ");
                    String titolo = scanner.nextLine();
                    System.out.println("Inserisci prezzo: ");
                    Float prezzo = Float.parseFloat(scanner.nextLine());
                    System.out.println("Inserisci casa editrice: ");
                    String ce = scanner.nextLine();
                    System.out.println("Quanti autori ha il libro?");
                    Integer nAutori = Integer.parseInt(scanner.nextLine());
                    ArrayList<Autore> autori = new ArrayList<>();
                    for (int i = 0; i < nAutori; i++) {
                        System.out.println("Inseriamo autori: " + nAutori);
                        System.out.println("Nome Autore: ");
                        String nomeAutore = scanner.nextLine();
                        System.out.println("Cognome Autore: ");
                        String cognomeAutore = scanner.nextLine();
                        Autore autore = new Autore(nomeAutore, cognomeAutore);
                        autori.add(autore);
                    }

                    Libro libro = new Libro(catalogoLibri.getCatalogo().size(),
                                            titolo,
                                            prezzo,
                                            new CasaEditrice(ce),
                                            autori);
                    autori.forEach(autore -> {
                        autore.setLibro(libro);
                    });

                    catalogoLibri.aggiungiLibro(libro);
                    break;
                case 3:
                    System.out.println("Nome Autore da ricercare: ");
                    String nomeAutore = scanner.nextLine();
                    System.out.println("Cognome Autore da ricercare: ");
                    String cognomeAutore = scanner.nextLine();
                    ArrayList<Libro> libriTrovati = catalogoLibri.ricerca(nomeAutore, cognomeAutore);
                    libriTrovati.forEach(System.out::println);
                    break;
                default:
                    System.out.println("Riprova.");
            }
        }
    }
}