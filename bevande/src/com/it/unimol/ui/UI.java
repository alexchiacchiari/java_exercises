package com.it.unimol.ui;

import com.it.unimol.app.Magazzino;
import com.it.unimol.app.Prodotto;
import com.it.unimol.enumeration.TipoProdotto;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class UI {
    private final Scanner scanner;

    public UI() {
        this.scanner = new Scanner(System.in);;
    }

    public Integer menuPrincipale() {
        System.out.println("F1: Inserimento preparato.");
        System.out.println("F2: Modifica preparato.");
        System.out.println("F3: Stampa statistiche.");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Errore: inserire un numero valido (1, 2 o 3).");
            throw e;
        }
    }

    public HashMap<String, String> creaProdotto() {
        HashMap<String, String> values = new HashMap<>();
        try{
            System.out.println("Inserici nome:");
            values.put("nome", scanner.nextLine());

            System.out.println("Inserisci tipo: ");
            System.out.println("1. Caffé");
            System.out.println("2. Cioccolato");
            System.out.println("3. Té");
            values.put("tipo", scanner.nextLine());


            System.out.println("Inserisci Marca: ");
            values.put("marca", scanner.nextLine());

            System.out.println("Insersci anno: ");
            values.put("anno", scanner.nextLine());

            System.out.println("Inserisci prezzo");
            values.put("prezzo", scanner.nextLine());

            System.out.println("Inserisci quantità: ");
            values.put("qty", scanner.nextLine());

            System.out.println("Inserisci quantità caffeina (0 se non presente): ");
            values.put("qtyCaffeina", scanner.nextLine());
            return values;
        } catch (NumberFormatException e) {
            System.out.println("Errore: valore numerico non valido. Inserimento annullato.");
            throw e;
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: tipo prodotto non riconosciuto. Inserimento annullato.");
            throw e;
        }
    }

    public HashMap<String, String> modificaProdotto() {
        HashMap<String, String> values = new HashMap<>();
        try{
            System.out.println("Inserici nome:");
            values.put("nome", scanner.nextLine());

            System.out.println("Inserisci tipo: ");
            System.out.println("1. Caffé");
            System.out.println("2. Cioccolato");
            System.out.println("3. Té");
            values.put("tipo", scanner.nextLine());


            System.out.println("Inserisci Marca: ");
            values.put("marca", scanner.nextLine());

            return values;
        } catch (NumberFormatException e) {
            System.out.println("Errore: valore numerico non valido. Inserimento annullato.");
            throw e;
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: tipo prodotto non riconosciuto. Inserimento annullato.");
            throw e;
        }
    }

    public Boolean verificaProdotto(List<Prodotto> prodottiTrovati) {
        if (prodottiTrovati.isEmpty()) {
            System.out.println("Prodotto non esistente.");
            return true;
        }
        return false;
    }

    public HashMap<Float, Boolean> modificaQty(Prodotto prodotto) {
        HashMap<Float, Boolean> values = new HashMap<>();
        System.out.println("Modifica la quantita: ");
        Float newQty = Float.parseFloat(scanner.nextLine());
        if (newQty.equals(prodotto.getQty())) {
            System.out.println("Nulla da modificare.");
            values.put(newQty, Boolean.FALSE);
            return values;
        }
        values.put(newQty, Boolean.TRUE);
        return values;
    }

    public void stampaStatistiche(Magazzino magazzino) {
        HashMap<String, Double> statistiche = magazzino.getStatistiche();
        System.out.println("Stampa statistiche");
        System.out.println("Quantità totale di preparati alla cioccolata: " + statistiche.get("sommaCioccolato") + "kg");
        System.out.println("Quantità totale di preparati al caffé: " + statistiche.get("sommaCaffe") + "kg");
        System.out.println("Quantità totale di preparati contenenti caffeina: " + statistiche.get("sommaCaffeina") + "kg");
        System.out.println("Quantità totale di preparati: " + statistiche.get("totale") + "kg");
    }

    public void opzioneNonValida() {
        System.out.println("Opzione non valida");
    }

    public void loop(Magazzino magazzino)
        {
            Integer choice = menuPrincipale();
            switch (choice) {
                case 1:
                    HashMap<String, String> inputCrea = creaProdotto();
                    String nome = inputCrea.get("nome");
                    TipoProdotto tipoProdotto = TipoProdotto.fromCode(Integer.parseInt((inputCrea.get("tipo"))));
                    String marca = inputCrea.get("marca");
                    Integer anno =Integer.parseInt(inputCrea.get("anno"));
                    Float prezzo = Float.parseFloat(inputCrea.get("prezzo"));
                    Float qty = Float.parseFloat(inputCrea.get("qty"));
                    Integer qtyCaffeina =  Integer.parseInt(inputCrea.get("qtyCaffeina"));
                    Prodotto prodotto = new Prodotto(nome,
                            tipoProdotto,
                            marca,
                            anno,
                            prezzo,
                            qty,
                            qtyCaffeina);
                    magazzino.inserisci(prodotto);
                    break;
                case 2:
                    HashMap<String, String> inputModifica = modificaProdotto();
                    String nome1 = inputModifica.get("nome");
                    TipoProdotto tipoProdotto1 = TipoProdotto.fromCode(Integer.parseInt((inputModifica.get("tipo"))));
                    String marca1 = inputModifica.get("marca");
                    List<Prodotto> prodottiTrovati = magazzino.ricerca(nome1, marca1, tipoProdotto1);

                    if (verificaProdotto(prodottiTrovati)) {
                        break;
                    } else {
                        //assunzione: no prodotti duplicati
                        Prodotto prodottox = prodottiTrovati.get(0);
                        HashMap<Float, Boolean> values = modificaQty(prodottox);
                        if(values.values().stream().findFirst().get())
                            prodottox.setQty(values.entrySet().stream().findFirst().get().getKey());
                    }
                    break;
                case 3:
                    magazzino.calcolaStatistiche();
                    stampaStatistiche(magazzino);
                    break;
                default:
                    opzioneNonValida();
                    break;
            }
        }

}
