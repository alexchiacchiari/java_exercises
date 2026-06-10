//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
*Seguire le indicazioni riportate in 'Istruzioni attività' e restituire i file .java, .class, .jar

Gestione Treni

Scrivere un programma Java per la gestione dell’orario dei treni, specializzato nella gestione (inserimento, modifica, deposito)
*  di Freccia, InterCity, Regionale. In tutti i casi, tali treni sono caratterizzati da
*  codice alfanumerico, marca, modello, anno di produzione, anno dell’ultima revisione, num. carrozze, capacità (num. posti totali),
* potenza, espressa in kilowatt (kw). Nel caso di InterCity e Regionale, dovrà essere memorizzata anche
*  la capacità del serbatoio di carburante diesel, espressa in litri.

L'utente deve poter accedere alle seguenti funzionalità:

    F1: Inserimento treno. Il sistema chiede all'utente il tipo di treno che vuole inserire (Freccia, InterCity, Regionale) e, in base alla risposta, chiede di inserire tutti i campi necessari
    F2: Modifica anno di revisione del treno. Il sistema chiede il codice alfanumerico del treno, ne mostra tutti i dettagli e chiede all’utente se vuole anticipare o posticipare l’anno dell’ultima revisione e infine chiede di quanti anni.
    F3: Ricerca treni in base a tipo e marca. Il sistema chiede all'utente il tipo e la marca dei treni che si vogliono cercare. Il sistema mostra la lista di tutti i treni di tale tipologia e marca.
    F4: Stampa statistiche. Il sistema stampa le seguenti statistiche:
        Capacità totale di posti delle Frecce;
        Capacità totale di carrozze degli InterCity;
        Capacità totale in litri dei treni con carburante;
        Quantità totale di treni presenti in deposito.

Esempio di stampa:

- Capacità totale di posti delle Frecce: 1200

- Capacità totale di carrozze degli InterCity: 16

- Capacità totale in litri dei treni con carburante: 2000 litri

- Quantità totale di treni presenti in deposito: 10

Scelta 1:

Quando il programma si chiude, non è necessario salvare le informazioni. Quando si avvia, ricomincerà da capo, caricando una nuova sessione.

Scelta 2:

Ogni volta che viene effettuata la prima operazione, il sistema deve salvare lo stato del programma.

Quando il programma si avvia, dev'essere recuperato lo stato, caricando la sessione precedente.



* Se si vuole, si possono usare le API stream di Collection almeno per una volta (facoltativo).

È sufficiente implementare un'interfaccia da terminale, non è necessario implementare un'interfaccia grafica.

Vincoli:

1.     Gestire almeno una volta un'eccezione nel programma;

2.     Definire alcuni casi di test, almeno per una delle classi create;

3.     Documentare almeno una delle classi principali.

Valutazione:

    Strutturazione del programma (es: divisione di logica applicativa e di presentazione)
        con scelta 1: 6 punti
        con scelta 2: 8 punti
    Eccezioni: 3 punti
    Testing: 3 punti
    Documentazione: 2 punti
    Implementazione completa F1: 3 punti
    Implementazione completa F2: 4 punti
    Implementazione completa F3: 4 punti
    Implementazione completa F4: 3 punti

    Bonus Collection: 2 punti

* */
import com.it.unimol.app.*;
import com.it.unimol.ui.UI;

import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args) {
        Deposito deposito = new Deposito();
        UI ui = new UI();
        ui.loop(deposito);
    }
}

