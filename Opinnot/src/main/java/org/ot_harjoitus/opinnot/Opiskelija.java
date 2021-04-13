package org.ot_harjoitus.opinnot;

import java.util.Objects;

public class Opiskelija {
    private final Integer tunnus;
    private final String nimi;
    private String sahkoposti;
    private String salasana;

    public Opiskelija(Integer opiskelijaTunnus, String nimi) {
        this.tunnus = opiskelijaTunnus;
        this.nimi = nimi;
    }

    public Integer getTunnus() {
        return tunnus;
    }

    public String getNimi() {
        return nimi;
    }

    public String getSahkoposti() {
        return sahkoposti;
    }

    public void setSahkoposti(String sahkoposti) {
        this.sahkoposti = sahkoposti;
    }

    public String getSalasana() {
        return salasana;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Opiskelija)) return false;
        Opiskelija that = (Opiskelija) o;
        return getTunnus().equals(that.getTunnus());
    }
}
