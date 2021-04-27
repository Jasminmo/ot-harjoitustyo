package org.otharjoitus.opinnot.domain;

import org.otharjoitus.opinnot.dao.OpiskelijaDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FakeOpiskelijaDao implements OpiskelijaDao {
    List<Opiskelija> opiskelijat = new ArrayList<>();

    public FakeOpiskelijaDao() {
        opiskelijat.add(new Opiskelija("1","Malli Oppilas"));
    }

    @Override
    public Opiskelija create(Opiskelija o) throws IOException {
        opiskelijat.add(o);
        return o;
    }

    @Override
    public Opiskelija findByTunnus(String tunnus) {
        return opiskelijat.stream().filter(u->u.getTunnus().equals(tunnus)).findFirst().orElse(null);
    }

    @Override
    public List<Opiskelija> getAll() {
        return opiskelijat;
    }
}
