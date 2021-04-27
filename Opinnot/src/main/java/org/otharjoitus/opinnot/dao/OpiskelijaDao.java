package org.otharjoitus.opinnot.dao;

import org.otharjoitus.opinnot.domain.Opiskelija;

import java.io.IOException;
import java.util.List;

public interface OpiskelijaDao  {
    Opiskelija create(Opiskelija opiskelija) throws IOException;

    Opiskelija findByTunnus(String opiskelijaTunnus);

    List<Opiskelija> getAll();
}