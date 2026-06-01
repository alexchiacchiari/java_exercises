package com.it.unimol.app;

import com.it.unimol.enumeration.TipoProdotto;

/**
 * @author alex
 * @version 0.0.1
 * @implNote Questa superclasse contiene tutti i campi generali per ogni sottoprodotto che l'azienda commercializza.
 * Campi: nome, tipo, marca, anno di produzione, prezzo, quantità, espressa in kilogrammi (kg), quantità caffeina.
 * */
public class Prodotto {
    private String nome;
    private TipoProdotto tipoProdotto;
    private String marca;
    private Integer anno;
    private Float prezzo;
    private Float qty;
    private Integer qtyCaffeina;


    public Prodotto(String nome, TipoProdotto tipoProdotto, String marca, Integer anno, Float prezzo, Float qty, Integer qtyCaffeina) {
        this.nome = nome;
        this.tipoProdotto = tipoProdotto;
        this.marca = marca;
        this.anno = anno;
        this.prezzo = prezzo;
        this.qty = qty;
        this.qtyCaffeina = qtyCaffeina;
    }

    public TipoProdotto getTipoProdotto() {
        return tipoProdotto;
    }

    public void setTipoProdotto(TipoProdotto tipoProdotto) {
        this.tipoProdotto = tipoProdotto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public Integer getQtyCaffeina() {
        return qtyCaffeina;
    }
    public void setQtyCaffeina(Integer qtyCaffeina) {
        this.qtyCaffeina = qtyCaffeina;
    }

    public Float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Float prezzo) {
        this.prezzo = prezzo;
    }

    public Float getQty() {
        return qty;
    }

    public void setQty(Float qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "nome='" + nome + '\'' +
                ", tipoProdotto=" + tipoProdotto +
                ", marca='" + marca + '\'' +
                ", anno=" + anno +
                ", prezzo=" + prezzo +
                ", qty=" + qty +
                ", qtyCaffeina=" + qtyCaffeina +
                '}';
    }
}
