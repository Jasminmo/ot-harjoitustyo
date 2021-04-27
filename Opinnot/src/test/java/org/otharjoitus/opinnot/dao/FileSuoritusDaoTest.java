package org.otharjoitus.opinnot.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.otharjoitus.opinnot.domain.*;

import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileSuoritusDaoTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    File suoritusFile;
    SuoritusDao suoritusDao;
    SimpleDateFormat dateFormat;

    @Before
    public void setUp() throws Exception {
        suoritusFile = testFolder.newFile("testfile_suoritukset.txt");
        dateFormat = new SimpleDateFormat("yyyy-dd-MM");
        KurssiDao kurssiDao = new FakeKurssiDao();
        kurssiDao.create(new Kurssi("12345", "Testi-Kurssi", 10));

        OpiskelijaDao opiskelijaDao = new FakeOpiskelijaDao();
        opiskelijaDao.create(new Opiskelija("01234", "Testi-Oppilas", "sposti@gmail.com", "slsn"));

        try (FileWriter file = new FileWriter(suoritusFile.getAbsolutePath())) {
            file.write("12345;01234;2021-27-04\n");
        }

        suoritusDao = new FileSuoritusDao(suoritusFile.getAbsolutePath(), kurssiDao, opiskelijaDao);
    }

    @Test
    public void suorituksetAreReadCorrectlyFromFile() throws ParseException {
        List<Suoritus> suoritukset = suoritusDao.getAll();
        assertEquals(1, suoritukset.size());

        Suoritus suoritus = suoritukset.get(0);
        assertEquals("12345", suoritus.getKurssi().getKoodi());
        assertEquals("01234", suoritus.getOpiskelija().getTunnus());
        assertEquals(dateFormat.parse("2021-27-04"), suoritus.getSuoritusHetki());
    }

    @Test
    public void savedSuoritusIsFound() throws Exception {
        Kurssi newKurssi = new Kurssi("0123", "New-Kurssi", 100);
        Opiskelija newOpiskelija = new Opiskelija("01234", "New-Oppilas", "new.oppilas@helsinki.fi", "sala");

        Date date = new Date();
        Suoritus newSuoritus = new Suoritus(newKurssi, newOpiskelija, date);
        suoritusDao.create(newSuoritus);

        List<Suoritus> suoritukset = suoritusDao.getAll();
        assertEquals(2, suoritukset.size());

        Suoritus suoritus = suoritukset.get(1);
        assertEquals(newKurssi, suoritus.getKurssi());
        assertEquals(newOpiskelija, suoritus.getOpiskelija());
        assertEquals(date, suoritus.getSuoritusHetki());
    }

    @After
    public void tearDown() {
        suoritusFile.delete();
    }
}
