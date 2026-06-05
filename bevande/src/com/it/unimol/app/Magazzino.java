package com.it.unimol.app;

import com.it.unimol.enumeration.TipoProdotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Magazzino {
    private List<Prodotto> prodotti;

    private HashMap<String, Double> statistiche;

    public Magazzino() {
        this.prodotti = new ArrayList<>();
        this.statistiche = new HashMap<>();
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    public HashMap<String, Double> getStatistiche() {
        return statistiche;
    }

    public void setStatistiche(HashMap<String, Double> statistiche) {
        this.statistiche = statistiche;
    }


    /**
     * Il metodo ricerca un prodotto all'interno del magazzino
     * @param marca                 marca del prodotto
     * @param tipoProdotto          accetta i possibili tipi definiti in TipoProdotto
     * @return Lista di prodotti trovati
     * */
    public List<Prodotto> ricerca(String nome, String marca, TipoProdotto tipoProdotto) {
        List<Prodotto> prodottiTrovati = new ArrayList<>();
        this.prodotti.forEach(prodotto -> {
            if (nome.equals(prodotto.getNome())) {
                if (marca.equals(prodotto.getMarca())) {
                    for (int i = 0; i < TipoProdotto.values().length; i++) {
                        if (tipoProdotto.equals(TipoProdotto.values()[i]) && tipoProdotto.equals(prodotto.getTipoProdotto())) {
                            prodottiTrovati.add(prodotto);
                        }
                    }
                }
            }
        });

        if (prodottiTrovati.isEmpty()) {
            return Collections.emptyList();
        }

        return prodottiTrovati;
    }

    public void inserisci(Prodotto prodotto) {
        this.prodotti.add(prodotto);
    }

    public void calcolaStatistiche() {
        this.statistiche.put("sommaCioccolato", this.getProdotti().stream()
                                                    .filter(x -> x.getTipoProdotto().equals(TipoProdotto.CIOCCOLATO))
                                                    .mapToDouble(Prodotto::getQty)
                                                    .sum());
        this.statistiche.put("sommaCaffe",this.getProdotti().stream()
                                                .filter(x -> x.getTipoProdotto().equals(TipoProdotto.CAFFE))
                                                .mapToDouble(Prodotto::getQty)
                                                .sum());
        this.statistiche.put("sommaCaffeina", this.statistiche.get("sommaCaffe") +
                                              (float) this.getProdotti().stream()
                                                        .filter(x -> x.getTipoProdotto().equals(TipoProdotto.TE))
                                                        .mapToDouble(Prodotto::getQty)
                                                        .sum());
        this.statistiche.put("totale", this.getProdotti().stream().mapToDouble(Prodotto::getQty).sum());
    }
}
