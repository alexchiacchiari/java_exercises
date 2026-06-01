package com.it.unimol.enumeration;

public enum TipoProdotto {
    CAFFE(1),
    CIOCCOLATO(2),
    TE(3);

    private final int code;

    TipoProdotto(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TipoProdotto fromCode(int code) {
        for (TipoProdotto t : values()) {
            if (t.code == code) return t;
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}
