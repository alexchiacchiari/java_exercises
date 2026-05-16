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

import java.util.Collections;
import java.util.Scanner;
//•La classe com.it.unimol.biblioteca.Main, infine, che mostra un menu che permetta di:
// stampare il catalogo;
// inserire un libro;
// ricercare un libro per cognome e nome autore;
// uscire
public class Main {
    public static void main(String[] args) {
        while(true) {
            System.out.println("Fai una scelta: ");
            System.out.println("1. Stampare il catalogo");
            System.out.println("2. Inserire un libro");
            System.out.println("3. Ricerca per nome e cognome autore");
            System.out.println("0. Esci");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Arrivederci e grazie.");
                    System.exit(0);
                case 1:
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Inserisci titolo: ");
                    String titolo = scanner.nextLine();
                    System.out.println("Inserisci prezzo: ");
                    Float prezzo = scanner.nextFloat();
                    System.out.println("Inserisci casa editrice: ");
                    String ce = scanner.nextLine();
                    Libro libro = new Libro(0, titolo, prezzo, new CasaEditrice(ce), Collections.emptyList());
                    break;
                case 3:
                    System.out.println("");
                    break;
                default:
                    System.out.println("Riprova.");
            }
        }
    }
}