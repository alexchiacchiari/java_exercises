package com.it.unimol.ui;

import com.it.unimol.app.*;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class UI {
    private Scanner scanner;

    public UI() {
        this.scanner = new Scanner(System.in);
    }

    public Integer menuPrincipale() {
        System.out.println("\n=== MENU PRINCIPALE ===");
        System.out.println("1. Inserisci treno.");
        System.out.println("2. Modifica anno revisione treno.");
        System.out.println("3. Ricerca treni in base a tipo e marca.");
        System.out.println("4. Stampa statistiche.");
        System.out.println("0. Per uscire.");
        System.out.print("Scegli operazione: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void creaTreno(Deposito deposito) {
        System.out.println("1. Inserisci treno.");

        System.out.println("Inserisci Id:");
        String id=scanner.nextLine();

        System.out.println("Inserisci marca:");
        String marca = scanner.nextLine();

        System.out.println("Inserisci modello:");
        String modello = scanner.nextLine();

        System.out.println("Inserisci anno di produzione:");
        Integer annoProduzione = Integer.parseInt(scanner.nextLine());

        System.out.println("Inserisci anno revisione:");
        Integer annoRevisione = Integer.parseInt(scanner.nextLine());

        System.out.println("Inserisci numero di carrozze:");
        Integer numCarrozze= Integer.parseInt(scanner.nextLine());

        System.out.println("Inserisci posti a sedere (capacità):");
        Integer capacita = Integer.parseInt(scanner.nextLine());

        System.out.println("Inserisci potenza (kW):");
        Integer potenza = Integer.parseInt(scanner.nextLine());

        System.out.println("Seleziona tipologia:");
        System.out.println("1.Freccia.");
        System.out.println("2.Intercity.");
        System.out.println("3.Regionale");

        try {
            Integer tipo = Integer.parseInt(scanner.nextLine());
            System.out.println("Hai selezionato la tipologia: " + tipo); // Qui puoi continuare a usare la variabile 'tipo' (es. con uno switch)
            if (tipo == 1) {
                deposito.aggiungiTreno(new Treno(id,
                        marca,
                        TipoTreno.dalCodice(tipo),
                        modello,
                        annoProduzione,
                        numCarrozze,
                        annoRevisione,
                        capacita,
                        potenza));
            } else {
                System.out.println("Inserisci capacità serbatoio: ");
                Integer capacitaserbatoio = Integer.parseInt(scanner.nextLine());

                deposito.aggiungiTreno(new TrenoSerbatoio(id,
                        marca,
                        TipoTreno.dalCodice(tipo),
                        modello,
                        annoProduzione,
                        numCarrozze,
                        annoRevisione,
                        capacita,
                        potenza,
                        capacitaserbatoio));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERRORE]: Devi inserire un numero intero (1, 2 o 3), non un carattere!");
            return;
        }
    }

    public void modificaTreno(Deposito deposito) {
        System.out.println("2. Modifica anno revisione treno");
        System.out.println("Cerca il treno tramite ID");
        String idSearch = scanner.nextLine();
        Treno modifica = deposito.ricercaId(idSearch);
        //System.out.println(modifica);
        deposito.stampaStatistiche(modifica);

        // Facciamo la modifica solo se il treno esiste davvero
        if (Objects.nonNull(modifica)) {
            System.out.print("Modificare anno di revisione? (s/n): ");
            Character scelta = scanner.next().toLowerCase().charAt(0);
            if(scelta.equals('s')) {
                System.out.print("Inserisci il nuovo anno per la revisione: ");
                Integer nuovoAnno = Integer.parseInt(scanner.nextLine());

                deposito.modificaRevisione(modifica, Boolean.TRUE, nuovoAnno);
                System.out.println("Operazione completata.");
            }

        }
    }

    public void stampaStatistiche(Deposito deposito) {
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
    }

    public void ricercaTreno(Deposito deposito) {
        System.out.println("Ricerca treno per marca e modello.");
        System.out.println("Inserisci nome costruttore: ");
        String ricercaMarca = scanner.nextLine();
        System.out.println("Inserisci modello treno:");
        String ricercaModello = scanner.nextLine();
        deposito.cercaModello(ricercaModello, ricercaMarca);
    }

    public void exit() {
        System.out.println("arrivederci e grazie");
        System.exit(0);
    }

    public void opzNonValida() {
        System.out.println("Opzione non valida.");
    }

    public void loop(Deposito deposito) {
        while(true){
            switch (menuPrincipale()){
                case 1:
                    creaTreno(deposito);
                    deposito.salva();
                    break;
                case 2:
                    modificaTreno(deposito);
                    deposito.salva();
                    break;
                case 3:
                    ricercaTreno(deposito);
                    break;
                case 4:
                    stampaStatistiche(deposito);
                    break;
                case 0:
                    exit();
                    break;
                default:
                    opzNonValida();
                    break;
            }
        }
    }
}
