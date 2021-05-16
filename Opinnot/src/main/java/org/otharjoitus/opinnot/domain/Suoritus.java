package org.otharjoitus.opinnot.domain;

import java.util.Date;

public class Suoritus {
    private Kurssi kurssi;
    private Opiskelija opiskelija;
    private Date suoritusHetki;
    private Integer arvosana;

    public Suoritus(Kurssi kurssi, Opiskelija opiskelija, Date suoritusHetki, Integer arvosana) {
        this.kurssi = kurssi;
        this.opiskelija = opiskelija;
        this.suoritusHetki = suoritusHetki;
        this.arvosana = arvosana;
    }
    public Suoritus(Kurssi kurssi, Opiskelija opiskelija, Integer arvosana) {
        this(kurssi, opiskelija, new Date(), arvosana);
    }

    public Kurssi getKurssi() {
        return kurssi;
    }

    public String getKurssiNimi() {
        return kurssi.getNimi();
    }

    public Opiskelija getOpiskelija() {
        return opiskelija;
    }

    public String getOpiskelijaNimi() {
        return opiskelija.getNimi();
    }

    public Date getSuoritusHetki() {
        return suoritusHetki;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Suoritus)) {
            return false;
        }
        Suoritus suoritus = (Suoritus) o;
        return getKurssi().equals(suoritus.getKurssi()) && getOpiskelija().equals(suoritus.getOpiskelija()) && getSuoritusHetki().equals(suoritus.getSuoritusHetki());
    }

    public Integer getArvosana() {
        return arvosana;
    }

    public Integer getOpintopisteet() {
        return kurssi.getOpintopisteet();
    }

    @Override
    public String toString() {
        return "Suoritus{" +
                "kurssi='" + kurssi.getNimi() +
                "', opiskelija='" + opiskelija.getNimi() +
                "', suoritusHetki='" + suoritusHetki +
                "'}";
    }
}
