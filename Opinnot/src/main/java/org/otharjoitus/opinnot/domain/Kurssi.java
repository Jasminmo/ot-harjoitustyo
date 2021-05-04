package org.otharjoitus.opinnot.domain;

/**
 * Yksin kertainen kurssi-luokka.
 */
public class Kurssi {
    private String koodi;
    private String nimi;
    private Integer opintopisteet;

    public Kurssi(String koodi, String nimi, Integer opintopisteet) {
        this.koodi = koodi;
        this.nimi = nimi;
        if (opintopisteet > 0) {
            this.opintopisteet = opintopisteet;
        } else {
            throw new IllegalArgumentException("opintopisteet <= 0");
        }
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

    /**
     * Tarkistaa onko this sama kuin o.
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Kurssi)) {
            return false;
        }
        Kurssi kurssi = (Kurssi) o;
        return getKoodi().equals(kurssi.getKoodi());
    }

    @Override
    public String toString() {
        return "Kurssi{" +
                "koodi='" + koodi + '\'' +
                ", nimi='" + nimi + '\'' +
                ", opintopisteet=" + opintopisteet +
                '}';
    }
}
