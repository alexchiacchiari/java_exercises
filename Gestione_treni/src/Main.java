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
import java.util.Scanner;
import java.util.InputMismatchException;

void main() {
    Scanner scanner = new Scanner(System.in);
    Deposito deposito = new Deposito();

    while(true){
        System.out.println("\n=== MENU PRINCIPALE ===");
        System.out.println("1. Inserisci treno.");
        System.out.println("2. Modifica anno revisione treno.");
        System.out.println("3. Ricerca treni in base a tipo e marca.");
        System.out.println("4. Stampa statistiche.");
        System.out.println("0. Per uscire.");
        System.out.print("Scegli operazione: ");
        Integer choice = scanner.nextInt();
        scanner.nextLine();
        Integer tipo= 0;
        switch (choice){
            case 1:
                System.out.println("1. Inserisci treno.");

                try {
                    System.out.println("Seleziona tipologia:");
                    System.out.println("1.Freccia.");
                    System.out.println("2.Intercity.");
                    System.out.println("3.Regionale");

                    tipo = scanner.nextInt(); // Se inserisci un char (es. 'A'), salta al catch
                    scanner.nextLine();
                    // Qui puoi continuare a usare la variabile 'tipo' (es. con uno switch)
                    System.out.println("Hai selezionato la tipologia: " + tipo);

                    if (tipo < 1 || tipo > 3) {
                        System.out.println("[ERRORE]: Selezione non valida. Ritorno al menu.");
                        break;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("\n[ERRORE]: Devi inserire un numero intero (1, 2 o 3), non un carattere!");

                    // FONDAMENTALE: Consuma il carattere errato rimasto nel buffer dello scanner
                    scanner.nextLine();
                    break;

                }


                System.out.println("Inserisci Id:");
                String id=scanner.nextLine();

                System.out.println("Inserisci marca:");
                String marca = scanner.nextLine();

                System.out.println("Inserisci modello:");
                String modello = scanner.nextLine();

                System.out.println("Inserisci anno di produzione:");
                Integer annoProduzione = scanner.nextInt();

                System.out.println("Inserisci anno revisione:");
                Integer annoRevisione = scanner.nextInt();

                System.out.println("Inserisci numero di carrozze:");
                Integer numCarrozze= scanner.nextInt();

                System.out.println("Inserisci posti a sedere (capacità):");
                Integer capacita = scanner.nextInt();

                System.out.println("Inserisci potenza (kW):");
                Integer potenza = scanner.nextInt();

                Integer capacitaserbatoio = 0;

                if(tipo == 1){
                    System.out.println("Treno freccia (alettrico) configurato.");
                    Frecciarossa f = new Frecciarossa(id,marca,modello,annoProduzione,numCarrozze,annoRevisione,
                            capacita,potenza);
                    deposito.aggiungiTreno(f);
                } else if (tipo == 2) {
                    System.out.println("Inserisci capacità serbatorio:");
                    capacitaserbatoio = scanner.nextInt();
                    Intercity i = new Intercity(id,marca,modello,annoProduzione,numCarrozze,annoRevisione,capacita,
                            potenza,capacitaserbatoio);
                    deposito.aggiungiTreno(i);
                } else if (tipo == 3) {
                    System.out.println("Inserisci capacità serbatorio:");
                    capacitaserbatoio = scanner.nextInt();
                    Regionale r = new Regionale(id,marca,modello,annoProduzione,numCarrozze,annoRevisione,capacita,
                            potenza,capacitaserbatoio);
                    deposito.aggiungiTreno(r);
                }

                break;
            case 2:
                System.out.println("2. Modifica anno revisione treno");
                System.out.println("Cerca il treno tramite ID");
                String idSearch = scanner.nextLine();
                Treno modifica = deposito.ricercaId(idSearch);
                //System.out.println(modifica);
                deposito.stampaStatistiche(modifica);
                if (modifica != null) { // Facciamo la modifica solo se il treno esiste davvero
                    System.out.print("Modificare anno di revisione? (s/n): ");
                    char scelta = scanner.next().charAt(0);
                    boolean confermato = true;
                    if(scelta == 's'|| scelta == 'S'){
                        confermato = true;
                        System.out.print("Inserisci il nuovo anno per la revisione: ");
                        Integer nuovoAnno = scanner.nextInt();
                        scanner.nextLine(); // Pulisce il buffer

                        deposito.modificaRevisione(modifica, confermato, nuovoAnno);
                        System.out.println("Operazione completata.");
                    }

                }
                break;
            case 3:
                System.out.println("Ricerca treno per marca e modello.");
                System.out.println("Inserisci nome costruttore: ");
                String ricercaMarca = scanner.nextLine();
                System.out.println("Inserisci modello treno:");
                String ricercaModello = scanner.nextLine();

                deposito.cercaModello(ricercaModello, ricercaMarca);
                break;
            case 4:
                System.out.println("3. Stampa statistiche.");
                System.out.println("Inserisci ID treno:");
                Integer numeroPostiFreccia = deposito.calcolaNumPostiFreccia();
                System.out.println("Capacità totale di posti delle Frecce: "+numeroPostiFreccia);
                Integer capacitaCarrozze =deposito.calcolaCapacitaCarrozze();
                System.out.println("Capacità totale di carrozze degli InterCity: "+capacitaCarrozze);
                Integer totCapacitaSerbatoio = deposito.CalcolaTotaleSerbatoio();
                System.out.println("Capacità totale in litri dei treni con carburante: "+totCapacitaSerbatoio+ " litri.");
                Integer totTreni = deposito.calcolaTotTreni();
                System.out.println("Quantità totale di treni presenti in deposito: "+ totTreni);

                break;

            case 0:
                System.out.println("arrivederci e grazie");
                System.exit(0);
                break;
            default:
                System.out.println("Opzione non valida.");
                break;
        }
    }


}
