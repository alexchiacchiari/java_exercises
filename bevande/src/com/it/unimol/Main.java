package com.it.unimol;

import com.it.unimol.app.Magazzino;
import com.it.unimol.app.Prodotto;
import com.it.unimol.enumeration.TipoProdotto;
import com.it.unimol.ui.UI;

import java.net.Inet4Address;
import java.util.*;

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
        UI ui = new UI();
        while(true) {
            ui.loop(magazzino);
        }
    }
}