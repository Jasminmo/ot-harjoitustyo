package org.otharjoitus.opinnot.dao;

import org.otharjoitus.opinnot.domain.Kurssi;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.util.stream.Collectors;


public class FileKurssiDao implements KurssiDao {
    private List<Kurssi> kurssit;
    private String file;

    public FileKurssiDao(String file) throws IOException {
        kurssit = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                kurssit.add(new Kurssi(parts[0], parts[1], Integer.parseInt(parts[2])));
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }

    @Override
    public List<Kurssi> getAll() {
        return kurssit;
    }

    @Override
    public Kurssi create(Kurssi kurssi) throws IOException {
        boolean isUnique = !kurssit
                .stream()
                .map(k -> k.getKoodi())
                .collect(Collectors.toList())
                .contains(kurssi.getKoodi());
        if (!isUnique) {
            throw new IOException("Kurssikoodi on jo käytössä");
        }
        kurssit.add(kurssi);
        save();
        return kurssi;
    }

    @Override
    public Kurssi findByKoodi(String koodi) {
        return kurssit.stream()
                .filter(k -> k.getKoodi().equals(koodi))
                .findFirst()
                .orElse(null);
    }

    private void save() throws IOException {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Kurssi kurssi : kurssit) {
                writer.write(kurssi.getKoodi() + ";" + kurssi.getNimi() + ";" + kurssi.getOpintopisteet() + "\n");
            }
        }
    }
}

