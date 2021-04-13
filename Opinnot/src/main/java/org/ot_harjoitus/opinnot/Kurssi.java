package org.ot_harjoitus.opinnot;

import java.util.Objects;

public class Kurssi {
    private Integer koodi;
    private String nimi;
    private Integer opintopisteet;

    public Kurssi(Integer koodi, String nimi, Integer opintopisteet) {
        this.koodi = koodi;
        this.nimi = nimi;
        this.opintopisteet = opintopisteet;
    }

    public Integer getKoodi() {
        return koodi;
    }

    public String getNimi() {
        return nimi;
    }

    public Integer getOpintopisteet() {
        return opintopisteet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kurssi)) return false;
        Kurssi kurssi = (Kurssi) o;
        return getKoodi().equals(kurssi.getKoodi());
    }

}
