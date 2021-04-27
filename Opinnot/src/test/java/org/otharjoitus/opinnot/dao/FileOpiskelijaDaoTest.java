package org.otharjoitus.opinnot.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.otharjoitus.opinnot.domain.Opiskelija;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileOpiskelijaDaoTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    File opiskelijaFile;
    OpiskelijaDao dao;

    @Before
    public void setUp() throws Exception {
        opiskelijaFile = testFolder.newFile("testfile_opiskelijat.txt");

        try (FileWriter file = new FileWriter(opiskelijaFile.getAbsolutePath())) {
            file.write("12345;Malli, Oppilas;oppilas.malli@helsinki.fi;salainen-sana\n\n\n");
        }

        dao = new FileOpiskelijaDao(opiskelijaFile.getAbsolutePath());
    }

    @Test
    public void studentsAreReadCorrectlyFromFile() {
        List<Opiskelija> opiskelijat = dao.getAll();
        assertEquals(1, opiskelijat.size());

        Opiskelija opiskelija = opiskelijat.get(0);
        assertEquals("12345", opiskelija.getTunnus());
        assertEquals("Malli, Oppilas", opiskelija.getNimi());
        assertEquals("oppilas.malli@helsinki.fi", opiskelija.getSahkoposti());
        assertEquals("salainen-sana", opiskelija.getSalasana());
    }

    @Test
    public void existingStudentIsFound() {
        Opiskelija opiskelija = dao.findByTunnus("12345");
        assertEquals("12345", opiskelija.getTunnus());
        assertEquals("Malli, Oppilas", opiskelija.getNimi());
        assertEquals("oppilas.malli@helsinki.fi", opiskelija.getSahkoposti());
        assertEquals("salainen-sana", opiskelija.getSalasana());
    }

    @Test
    public void nonExistingStudentIsFound() {
        Opiskelija opiskelija = dao.findByTunnus("non-existing");
        assertEquals(null, opiskelija);
    }

    @Test
    public void savedStudentIsFound() throws Exception {
        Opiskelija newOpiskelija = new Opiskelija("01234", "New-Oppilas", "new.oppilas@helsinki.fi", "sala");
        dao.create(newOpiskelija);

        Opiskelija opiskelija = dao.findByTunnus("01234");
        assertEquals("01234", opiskelija.getTunnus());
        assertEquals("New-Oppilas", opiskelija.getNimi());
        assertEquals("new.oppilas@helsinki.fi", opiskelija.getSahkoposti());
        assertEquals("sala", opiskelija.getSalasana());
    }

    @After
    public void tearDown() {
        opiskelijaFile.delete();
    }
}
