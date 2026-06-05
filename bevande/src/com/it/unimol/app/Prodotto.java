package com.it.unimol.app;

import com.it.unimol.enumeration.TipoProdotto;

/**
 * <p>Rappresenta un preparato per bevanda calda gestito dal magazzino.</p>
 *
 * <p>Ogni prodotto è caratterizzato da nome, tipo ({@link TipoProdotto}), marca,
 * anno di produzione, prezzo, quantità (in kg) e quantità di caffeina (in mg).
 * Per prodotti privi di caffeina (es. cioccolato) impostare {@code qtyCaffeina} a 0.</p>
 *
 * @author alex
 * @version 0.0.1
 * @see TipoProdotto
 */
public class Prodotto {

    /** Nome commerciale del preparato (es. "Arabica"). */
    private String nome;

    /** Categoria merceologica: caffè, cioccolato o tè. */
    private TipoProdotto tipoProdotto;

    /** Produttore / brand del preparato. */
    private String marca;

    /** Anno di produzione del lotto. */
    private Integer anno;

    /** Prezzo unitario in euro per kg. */
    private Float prezzo;

    /** Quantità disponibile in magazzino, espressa in chilogrammi (kg). */
    private Float qty;

    /** Quantità di caffeina per 100 g, espressa in milligrammi (mg). Usare 0 se assente. */
    private Integer qtyCaffeina;

    /**
     * Crea un nuovo prodotto con tutti i suoi attributi.
     *
     * @param nome        nome commerciale del preparato
     * @param tipoProdotto categoria merceologica ({@link TipoProdotto})
     * @param marca       produttore / brand
     * @param anno        anno di produzione del lotto
     * @param prezzo      prezzo unitario in euro per kg
     * @param qty         quantità in magazzino espressa in kg
     * @param qtyCaffeina mg di caffeina per 100 g; 0 se il prodotto non contiene caffeina
     */
    public Prodotto(String nome, TipoProdotto tipoProdotto, String marca, Integer anno, Float prezzo, Float qty, Integer qtyCaffeina) {
        this.nome = nome;
        this.tipoProdotto = tipoProdotto;
        this.marca = marca;
        this.anno = anno;
        this.prezzo = prezzo;
        this.qty = qty;
        this.qtyCaffeina = qtyCaffeina;
    }

    /**
     * Restituisce la categoria merceologica del prodotto.
     *
     * @return il {@link TipoProdotto} associato
     */
    public TipoProdotto getTipoProdotto() {
        return tipoProdotto;
    }

    /**
     * Imposta la categoria merceologica del prodotto.
     *
     * @param tipoProdotto nuovo tipo da assegnare
     */
    public void setTipoProdotto(TipoProdotto tipoProdotto) {
        this.tipoProdotto = tipoProdotto;
    }

    /**
     * Restituisce il nome commerciale del preparato.
     *
     * @return il nome del prodotto
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome commerciale del preparato.
     *
     * @param nome nuovo nome da assegnare
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il brand / produttore.
     *
     * @return la marca del prodotto
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Imposta il brand / produttore.
     *
     * @param marca nuovo valore da assegnare
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Restituisce l'anno di produzione del lotto.
     *
     * @return anno di produzione
     */
    public Integer getAnno() {
        return anno;
    }

    /**
     * Imposta l'anno di produzione del lotto.
     *
     * @param anno nuovo anno da assegnare
     */
    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    /**
     * Restituisce la quantità di caffeina per 100 g (mg).
     *
     * @return mg di caffeina, oppure 0 se assente
     */
    public Integer getQtyCaffeina() {
        return qtyCaffeina;
    }

    /**
     * Imposta la quantità di caffeina per 100 g (mg).
     *
     * @param qtyCaffeina nuovo valore in mg; 0 se assente
     */
    public void setQtyCaffeina(Integer qtyCaffeina) {
        this.qtyCaffeina = qtyCaffeina;
    }

    /**
     * Restituisce il prezzo unitario in euro per kg.
     *
     * @return prezzo in €/kg
     */
    public Float getPrezzo() {
        return prezzo;
    }

    /**
     * Imposta il prezzo unitario in euro per kg.
     *
     * @param prezzo nuovo prezzo da assegnare
     */
    public void setPrezzo(Float prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * Restituisce la quantità disponibile in magazzino (kg).
     *
     * @return quantità in kg
     */
    public Float getQty() {
        return qty;
    }

    /**
     * Aggiorna la quantità disponibile in magazzino (kg).
     *
     * @param qty nuova quantità in kg
     */
    public void setQty(Float qty) {
        this.qty = qty;
    }

    /**
     * Restituisce una rappresentazione testuale del prodotto con tutti i suoi campi.
     *
     * @return stringa descrittiva del prodotto
     */
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
