package org.ot_harjoitus.opinnot.domain;

public class Kurssi {
    private String koodi;
    private String nimi;
    private Integer opintopisteet;

    public Kurssi(String koodi, String nimi, Integer opintopisteet) {
        this.koodi = koodi;
        this.nimi = nimi;
        this.opintopisteet = opintopisteet;
    }

    public String getKoodi() {
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
