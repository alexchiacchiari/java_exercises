package com.it.unimol.app;

import com.it.unimol.enumeration.TipoProdotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test per la classe {@link Prodotto}.
 */
class ProdottoTest {

    private Prodotto prodotto;

    @BeforeEach
    void setUp() {
        prodotto = new Prodotto("Arabica", TipoProdotto.CAFFE, "Lavazza", 2023, 12.50f, 5.0f, 80);
    }

    /**
     * Verifica che il costruttore inizializzi correttamente tutti i campi
     * e che i getter restituiscano i valori attesi.
     */
    @Test
    void testCostruttoreEGetters() {
        assertEquals("Arabica", prodotto.getNome());
        assertEquals(TipoProdotto.CAFFE, prodotto.getTipoProdotto());
        assertEquals("Lavazza", prodotto.getMarca());
        assertEquals(2023, prodotto.getAnno());
        assertEquals(12.50f, prodotto.getPrezzo(), 0.001f);
        assertEquals(5.0f, prodotto.getQty(), 0.001f);
        assertEquals(80, prodotto.getQtyCaffeina());
    }

    /**
     * Verifica che i setter aggiornino correttamente i campi del prodotto.
     */
    @Test
    void testSetter() {
        prodotto.setNome("Ceylon");
        prodotto.setTipoProdotto(TipoProdotto.TE);
        prodotto.setMarca("Twinings");
        prodotto.setAnno(2024);
        prodotto.setPrezzo(8.00f);
        prodotto.setQty(3.5f);
        prodotto.setQtyCaffeina(40);

        assertEquals("Ceylon", prodotto.getNome());
        assertEquals(TipoProdotto.TE, prodotto.getTipoProdotto());
        assertEquals("Twinings", prodotto.getMarca());
        assertEquals(2024, prodotto.getAnno());
        assertEquals(8.00f, prodotto.getPrezzo(), 0.001f);
        assertEquals(3.5f, prodotto.getQty(), 0.001f);
        assertEquals(40, prodotto.getQtyCaffeina());
    }

    /**
     * Verifica che {@code toString()} includa i valori principali del prodotto.
     */
    @Test
    void testToString() {
        String risultato = prodotto.toString();

        assertTrue(risultato.contains("Arabica"));
        assertTrue(risultato.contains("CAFFE"));
        assertTrue(risultato.contains("Lavazza"));
        assertTrue(risultato.contains("2023"));
    }
}
