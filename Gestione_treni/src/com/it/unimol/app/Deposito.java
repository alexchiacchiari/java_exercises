package com.it.unimol.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Deposito {
    private List <Treno> deposito;

    public Deposito() {
        this.deposito = new ArrayList<>();
    }
    public void aggiungiTreno(Treno treno){
        deposito.add(treno);
    }

    public Treno ricercaId(String id){
        for(Treno treno : this.deposito){
            if(id.equalsIgnoreCase(treno.getId())){
                return treno;
            }
        }
        return null;

    }

    public void modificaRevisione(Treno treno, boolean modifica, Integer nuovoAnno){

        if(modifica) {
            treno.setAnnoRevisione(nuovoAnno);
        }
    }

    public void cercaModello(String modello, String marca){
        Integer trovati = 0;
        for (Treno treno : this.deposito){
            if (treno.getMarca().trim().equalsIgnoreCase(marca)){
                if(treno.getModello().trim().equalsIgnoreCase(modello)){
                    stampaStatistiche(treno);
                    trovati++;
                }
            }

        }
        if(trovati == 0){
            System.out.println("Nessun treno corrispondente a :"+ modello+ marca+" presente in deposito");
        }else{
            System.out.println("sono stati trovati: "+trovati+ " treni.");
        }
    }

    public void stampaStatistiche(Treno treno){
        // 1. Clausola di guardia: se il treno è null, ci fermiamo subito
        if (treno == null) {
            System.out.println("Impossibile stampare le statistiche: il treno non esiste.");
            return;
        }

        // 2. Stampiamo le informazioni che TUTTI i treni hanno sicuramente (ereditate dalla classe Treno)
        System.out.print("ID: | " + treno.getId() + " | Marca: " + treno.getMarca() + " | Modello: " +
                treno.getModello()+"| Anno revisione: "+treno.getAnnoRevisione()+"| Numero posti: "+treno.getCapacita()+
                "| Potenza: "+treno.getPotenza()+" Kw.");

        // 3. Andiamo a scoprire che tipo di treno è per stampare i dati specifici
       /* if (treno instanceof Treno) {
            // Facciamo il CAST a Treno per sbloccare il metodo getCapacita()
            Treno freccia = (Treno) treno;
            System.out.println(" | Posti: " + freccia.getCapacita() + " | Potenza: " + freccia.getPotenza() + " Kw");
        }*/
         if (treno instanceof TrenoSerbatoio) {
            // Se anche il TrenoSerbatoio ha la capacità, facciamo il cast a TrenoSerbatoio
            TrenoSerbatoio TrenoSerbatoio = (TrenoSerbatoio) treno;
            System.out.println(" | Posti: " + TrenoSerbatoio.getCapacita() + " | Potenza: " + TrenoSerbatoio.getPotenza() + " Kw");
        }
        else {
            // Caso generico se per caso non fosse nessuno dei due, per evitare di lasciare la riga a metà
            System.out.println(" | Potenza: " + treno.getPotenza() + " Kw");
        }
    }

    public Integer calcolaNumPostiFreccia(){
        Integer numPosti = 0;
        for(Treno treno: this.deposito) {
            if (treno.getTipo().code == 1)
                numPosti+= treno.getCapacita();
        }
        return numPosti;
    }

    public Integer calcolaCapacitaCarrozze(){
        Integer numCarrozze = 0;
        for(Treno x: this.deposito){
            if(x.getTipo().code == 2){
                numCarrozze += x.getNumCarrozze();
            }
        }
        return numCarrozze;
    }

    public Integer CalcolaTotaleSerbatoio(){
        Integer totCapacitaSerbatoio = 0;
        for (Treno treno : this.deposito){
            if(treno instanceof TrenoSerbatoio){
                TrenoSerbatoio TrenoSerbatoio = (TrenoSerbatoio)treno;
                totCapacitaSerbatoio += TrenoSerbatoio.getCapacitaSerbatorio();
            }
        }
        return totCapacitaSerbatoio;
    }

    public Integer calcolaTotTreni(){
        return deposito.size();
    }

    public List<Treno> getDeposito() {
        return deposito;
    }

}
