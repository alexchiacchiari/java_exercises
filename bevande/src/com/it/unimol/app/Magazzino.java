package com.it.unimol.app;

import com.it.unimol.enumeration.TipoProdotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Magazzino {
    private List<Prodotto> prodotti;

    public Magazzino() {
        this.prodotti = new ArrayList<>();
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    public List<Prodotto> ricerca(String nome, String marca, TipoProdotto tipoProdotto) {
        List<Prodotto> prodottiTrovati = new ArrayList<>();
        this.prodotti.forEach(prodotto -> {
            if (nome.equals(prodotto.getNome())) {
                if (marca.equals(prodotto.getMarca())) {
                    for (int i = 0; i < TipoProdotto.values().length; i++) {
                        if (tipoProdotto.equals(TipoProdotto.values()[i])) {
                            prodottiTrovati.add(new Prodotto(
                                    prodotto.getNome(),
                                    prodotto.getTipoProdotto(),
                                    prodotto.getMarca(),
                                    prodotto.getAnno(),
                                    prodotto.getPrezzo(),
                                    prodotto.getQty(),
                                    prodotto.getQtyCaffeina()));
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

}
