package org.otharjoitus.opinnot.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.otharjoitus.opinnot.domain.Kurssi;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileKurssiDaoTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    File kurssiFile;
    KurssiDao dao;

    @Before
    public void setUp() throws Exception {
        kurssiFile = testFolder.newFile("testfile_kurssit.txt");

        try (FileWriter file = new FileWriter(kurssiFile.getAbsolutePath())) {
            file.write("12345;Testi-Kurssi;10\n\n");
        }

        dao = new FileKurssiDao(kurssiFile.getAbsolutePath());
    }

    @Test
    public void coursesAreReadCorrectlyFromFile() {
        List<Kurssi> kurssit = dao.getAll();
        assertEquals(1, kurssit.size());

        Kurssi kurssi = kurssit.get(0);
        assertEquals("12345", kurssi.getKoodi());
        assertEquals("Testi-Kurssi", kurssi.getNimi());
        assertEquals(Integer.valueOf(10), kurssi.getOpintopisteet());
    }

    @Test
    public void existingCourseIsFound() {
        Kurssi kurssi = dao.findByKoodi("12345");
        assertEquals("12345", kurssi.getKoodi());
        assertEquals("Testi-Kurssi", kurssi.getNimi());
        assertEquals(Integer.valueOf(10), kurssi.getOpintopisteet());
    }

    @Test
    public void nonExistingCourseIsFound() {
        Kurssi kurssi = dao.findByKoodi("non-existing");
        assertEquals(null, kurssi);
    }

    @Test
    public void savedCourseIsFound() throws Exception {
        Kurssi newKurssi = new Kurssi("0123", "New-Kurssi", 100);
        dao.create(newKurssi);

        Kurssi kurssi = dao.findByKoodi("0123");
        assertEquals("0123", kurssi.getKoodi());
        assertEquals("New-Kurssi", kurssi.getNimi());
        assertEquals(Integer.valueOf(100), kurssi.getOpintopisteet());
    }

    @After
    public void tearDown() {
        kurssiFile.delete();
    }
}
