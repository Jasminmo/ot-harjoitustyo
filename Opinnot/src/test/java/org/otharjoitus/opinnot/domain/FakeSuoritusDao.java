package org.otharjoitus.opinnot.domain;

import org.otharjoitus.opinnot.dao.SuoritusDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FakeSuoritusDao implements SuoritusDao {
    List<Suoritus> suoritukset = new ArrayList<>();

    @Override
    public Suoritus create(Suoritus s) throws IOException {
        suoritukset.add(s);
        return s;
    }

    @Override
    public List<Suoritus> getAll() {
        return suoritukset;
    }
}
