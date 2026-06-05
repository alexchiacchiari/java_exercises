package com.it.unimol;

import com.it.unimol.app.Magazzino;
import com.it.unimol.app.Prodotto;
import com.it.unimol.enumeration.TipoProdotto;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
* Seguire le indicazioni riportate in 'Istruzioni attività' e restituire i file .java, .class, .jar
Preparati per bevande calde
Scrivere un programma Java per la gestione di un magazzino di preparati per bevande calde,
* specializzato nella gestione (acquisto, vendita, stoccaggio) di caffè, cioccolato e tè.
*
In tutti i casi, tali preparati sono caratterizzati da nome, tipo, marca, anno di produzione, prezzo, quantità, espressa in kilogrammi (kg).
Nel caso di caffè e tè, dovrà essere memorizzata anche la quantità di caffeina, espressa in milligrammi (mg).
L'utente deve poter accedere alle seguenti funzionalità:

F1: Inserimento preparato.
* Il sistema chiede all'utente il nome del preparato che vuole inserire (caffè, cioccolato o tè)
* e, in base alla risposta, chiede di inserire tutti i campi necessari

F2: Modifica preparato.
* Il sistema chiede nome, tipo e marca del preparato, ne mostra tutti i dettagli
* e chiede all’utente se vuole aumentarne o diminuirne la quantità.

F3: Stampa statistiche.
* Il sistema stampa le seguenti statistiche:
Quantità totale di preparati alla cioccolata;
Quantità totale di preparati al caffè;
Quantità totale di preparati con caffeina;
Quantità totale di preparati presenti in magazzino.
Esempio di stampa:
* - Quantità totale di preparati alla cioccolata: 10 kg
* - Quantità totale di preparati al caffè: 15 kg
* - Quantità totale di preparati con caffeina: 20 kg
* - Quantità totale di preparati presenti in magazzino: 30 kg

Quando il programma si chiude, non è necessario salvare le informazioni. Quando si avvia, ricomincerà da capo, caricando una nuova sessione.

Se si vuole, si possono usare le API stream di Collection almeno per una volta (facoltativo).

È sufficiente implementare un'interfaccia da terminale, non è necessario implementare un'interfaccia grafica.

Vincoli:
1. Gestire almeno una volta un'eccezione nel programma;
2. Definire alcuni casi di test, almeno per una delle classi create;
3. Documentare almeno una delle classi principali.

Valutazione:
Strutturazione del programma (es: divisione di logica applicativa e di presentazione): 10 punti
Eccezioni: 3 punti
Testing: 4 punti
Documentazione: 2 punti
Implementazione completa F1: 3 punti
Implementazione completa F2: 4 punti
Implementazione completa F3: 4 punti
Bonus Collection: 2 punti
* */
public class Main {
    public static void main(String[] args) {
        Magazzino magazzino = new Magazzino();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("F1: Inserimento preparato.");
            System.out.println("F2: Modifica preparato.");
            System.out.println("F3: Stampa statistiche.");
            Integer choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Inserici nome:");
                    String nome = scanner.nextLine();

                    System.out.println("Inserisci tipo: ");
                    System.out.println("1. Caffé");
                    System.out.println("2. Cioccolato");
                    System.out.println("3. Té");
                    TipoProdotto tipo = TipoProdotto.fromCode(Integer.parseInt(scanner.nextLine()));

                    System.out.println("Inserisci Marca: ");
                    String marca = scanner.nextLine();

                    System.out.println("Insersci anno: ");
                    Integer anno = Integer.parseInt(scanner.nextLine());

                    System.out.println("Inserisci prezzo");
                    Float prezzo = Float.parseFloat(scanner.nextLine());

                    System.out.println("Inserisci quantità: ");
                    Float qty = Float.parseFloat(scanner.nextLine());

                    System.out.println("Inserisci quantità caffeina (0 se non presente): ");
                    Integer qtyCaffeina = Integer.parseInt(scanner.nextLine());

                    Prodotto prodotto = new Prodotto(nome, tipo, marca, anno, prezzo, qty, qtyCaffeina);
                    magazzino.getProdotti().add(prodotto);
                    break;
                case 2:
                    System.out.println("Inserici nome:");
                    String nomeProdotto = scanner.nextLine();

                    System.out.println("Inserisci tipo: ");
                    System.out.println("1. Caffé");
                    System.out.println("2. Cioccolato");
                    System.out.println("3. Té");
                    TipoProdotto tipoProdotto = TipoProdotto.fromCode(Integer.parseInt(scanner.nextLine()));

                    System.out.println("Inserisci Marca: ");
                    String marcaProdotto = scanner.nextLine();

                    List<Prodotto> prodottiTrovati = magazzino.ricerca(nomeProdotto, marcaProdotto, tipoProdotto);

                    if (prodottiTrovati.isEmpty()) {
                        System.out.println("Nessun prodotto trovato");
                        break;
                    } else {
                        //assunzione: no prodotti duplicati
                        Prodotto prodottox = prodottiTrovati.get(0);
                        System.out.println("Modifica la quantita: ");
                        Float newQty = Float.parseFloat(scanner.nextLine());
                        if (newQty.equals(prodottox.getQty()))
                            System.out.println("Nulla da modificare.");
                        else
                            prodottox.setQty(newQty);
                    }
                    break;
                case 3:
                    System.out.println("Stampa statistiche");
                    float sumChoco = (float) magazzino.getProdotti().stream()
                                                .filter(x -> x.getTipoProdotto().equals(TipoProdotto.CIOCCOLATO))
                                                .mapToDouble(Prodotto::getQty)
                                                .sum();

                    System.out.println("Quantità totale di preparati alla cioccolata: " + sumChoco + "kg");

                    float sumCoffee = (float) magazzino.getProdotti().stream()
                            .filter(x -> x.getTipoProdotto().equals(TipoProdotto.CAFFE))
                            .mapToDouble(Prodotto::getQty)
                            .sum();

                    System.out.println("Quantità totale di preparati al caffé: " + sumCoffee + "kg");

                    float sumCaf =
                            sumCoffee + (float) magazzino.getProdotti().stream()
                            .filter(x -> x.getTipoProdotto().equals(TipoProdotto.TE))
                            .mapToDouble(Prodotto::getQty)
                            .sum();

                    System.out.println("Quantità totale di preparati contenenti caffeina: " + sumCaf + "kg");
                    //float total = (float) sumCaf + sumChoco;
                    float total = (float) magazzino.getProdotti().stream().mapToDouble(Prodotto::getQty).sum();

                    System.out.println("Quantità totale di preparati: " + total + "kg");
                    break;
                default:
                    System.out.println("Opzione non valida");
                    break;
            }
        }


    }
}