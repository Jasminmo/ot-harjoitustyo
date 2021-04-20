package org.ot_harjoitus.opinnot.domain;

public class Opiskelija {
    private final String tunnus;
    private final String nimi;
    private String sahkoposti;
    private String salasana;

    public Opiskelija(String tunnus, String nimi) {
        this(tunnus, nimi, "", "");
    }

    public Opiskelija(String tunnus, String nimi, String sahkoposti, String salasana) {
        this.tunnus = tunnus;
        this.nimi = nimi;
        this.sahkoposti = sahkoposti;
        this.salasana = salasana;
    }

    public String getTunnus() {
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
