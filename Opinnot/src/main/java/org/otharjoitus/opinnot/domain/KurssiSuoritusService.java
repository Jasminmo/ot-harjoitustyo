package org.otharjoitus.opinnot.domain;

import org.otharjoitus.opinnot.dao.FileKurssiDao;
import org.otharjoitus.opinnot.dao.FileOpiskelijaDao;
import org.otharjoitus.opinnot.dao.FileSuoritusDao;

import java.io.IOException;
import java.util.List;

public class KurssiSuoritusService {

    private FileKurssiDao kurssiDao;
    private FileOpiskelijaDao opiskelijaDao;
    private FileSuoritusDao suoritusDao;

    public KurssiSuoritusService(FileKurssiDao kurssiDao, FileOpiskelijaDao opiskelijaDao, FileSuoritusDao suoritusDao) {
        this.kurssiDao = kurssiDao;
        this.opiskelijaDao = opiskelijaDao;
        this.suoritusDao = suoritusDao;
    }

    public List<Opiskelija> getOpiskelijat() {
        return opiskelijaDao.getAll();
    }

    public List<Kurssi> getKurssit() {
        return kurssiDao.getAll();
    }

    public List<Suoritus> getSuoritukset() {
        return suoritusDao.getAll();
    }

    public void lisaaOpiskelija(Opiskelija opiskelija) throws Exception {
        opiskelijaDao.create(opiskelija);
    }

    public void lisaaKurssi(Kurssi kurssi) throws IOException {
        kurssiDao.create(kurssi);
    }

    public void lisaaSuoritus(Suoritus suoritus) throws IOException {
        suoritusDao.create(suoritus);
    }

    public Kurssi getKurssi(String koodi) {
        return kurssiDao.findByKoodi(koodi);
    }

    public Opiskelija getOpiskelija(String tunnus) {
        return opiskelijaDao.findByTunnus(tunnus);
    }

    public Opiskelija getOpiskelijaSahkopostilla(String s) {
        return opiskelijaDao.findBySahkoposti(s);
    }

}
