package org.ot_harjoitus.opinnot;

import java.util.Date;
import java.util.Objects;

public class Suoritus {
    private Kurssi kurssi;
    private Opiskelija opiskelija;
    private Date suoritusHetki;

    public Suoritus(Kurssi kurssi, Opiskelija opiskelija, Date suoritusHetki) {
        this.kurssi = kurssi;
        this.opiskelija = opiskelija;
        this.suoritusHetki = suoritusHetki;
    }

    public Kurssi getKurssi() {
        return kurssi;
    }

    public Opiskelija getOpiskelija() {
        return opiskelija;
    }

    public Date getSuoritusHetki() {
        return suoritusHetki;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Suoritus)) return false;
        Suoritus suoritus = (Suoritus) o;
        return getKurssi().equals(suoritus.getKurssi()) && getOpiskelija().equals(suoritus.getOpiskelija()) && getSuoritusHetki().equals(suoritus.getSuoritusHetki());
    }
}
