package org.ot_harjoitus.opinnot.dao;

import org.ot_harjoitus.opinnot.domain.Suoritus;

import java.util.List;

public interface SuoritusDao {
    Suoritus create(Suoritus s) throws Exception;

    List<Suoritus> getAll();
}