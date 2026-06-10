package com.it.unimol.app;

public enum TipoTreno {
    FRECCIA(1),
    INTERCITY(2),
    REGIONALE(3);

    public final int code;

    TipoTreno(int code) {
        this.code = code;
    }

    public static TipoTreno dalCodice(int code) {
        for(TipoTreno t: values()) {
            if (t.code == code) return t;
        }
        throw new IllegalArgumentException("Codice sconosciuto: " + code);
    }

}
