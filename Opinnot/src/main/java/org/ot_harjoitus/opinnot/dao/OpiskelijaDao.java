package org.ot_harjoitus.opinnot.dao;

import org.ot_harjoitus.opinnot.domain.Opiskelija;

import java.util.List;

public interface OpiskelijaDao  {
    Opiskelija create(Opiskelija opiskelija) throws Exception;

    Opiskelija findByTunnus(String opiskelijaTunnus);

    List<Opiskelija> getAll();
}