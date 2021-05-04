package org.otharjoitus.opinnot.ui;

import org.otharjoitus.opinnot.domain.Kurssi;
import org.otharjoitus.opinnot.domain.KurssiSuoritusService;
import org.otharjoitus.opinnot.domain.Opiskelija;
import org.otharjoitus.opinnot.domain.Suoritus;
import org.otharjoitus.opinnot.utils.Utils;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class KurssiSuoritusUI {
    private Scanner scanner;
    private Map<String, String> generalCommands;
    private Map<String, String> adminCommands;
    private Map<String, String> opiskelijaCommands;
    private KurssiSuoritusService service;
    private String studentLoggedin;
    private boolean adminLoggedin;

    public KurssiSuoritusUI(Scanner s) throws IOException {
        scanner = s;
        service = Utils.getDefaultService();

        generalCommands = new TreeMap<>();
        generalCommands.put("x", "x lopeta");
        generalCommands.put("1", "1 ylläpitäjä, kirjaudu sisään");
        generalCommands.put("2", "2 opiskelija, kirjaudu sisään");

        adminCommands = new TreeMap<>();
        adminCommands.put("x", "x lopeta");
        adminCommands.put("3", "3 hae kurssit");
        adminCommands.put("4", "4 hae opiskelijat");
        adminCommands.put("5", "5 hae suoritukset");
        adminCommands.put("6", "6 lisää kurssi");
        adminCommands.put("7", "7 lisää opiskelija");
        adminCommands.put("8", "8 lisää suoritus");

        opiskelijaCommands = new TreeMap<>();
        opiskelijaCommands.put("x", "x lopeta");
        opiskelijaCommands.put("3", "3 hae kurssit");
        opiskelijaCommands.put("5", "5 hae suoritukset");
    }

    public void start() {
        while (true) {
            Map<String, String> commands = generalCommands;
            if (studentLoggedin != null && !studentLoggedin.isEmpty()) {
                commands = opiskelijaCommands;
            } else if (adminLoggedin) {
                commands = adminCommands;
            }

            printHelp();

            System.out.println();
            System.out.print("komento: ");
            String command = scanner.nextLine();
            if (!commands.containsKey(command)) {
                System.out.println("virheellinen komento.");
                printHelp();
            }

            if (command.equals("x")) {
                break;
            } else if (command.equals("1")) {
                adminKirjautuminen();
            } else if (command.equals("2")) {
                opiskelijanKirjautuminen();
            } else if (command.equals("3")) {
                tulostaKurssit();
            } else if (command.equals("4")) {
                tulostaOpiskelijat();
            } else if (command.equals("5")) {
                tulostaSuoritukset();
            } else if (command.equals("6")) {
                lisaaKurssi();
            } else if (command.equals("7")) {
                lisaaOpiskelija();
            } else if (command.equals("8")) {
                lisaaSuoritus();
            }

        }
    }

    private void tulostaKurssit() {
        service.getKurssit().stream().forEachOrdered(System.out::println);
    }

    private void tulostaOpiskelijat() {
        service.getOpiskelijat().stream().forEachOrdered(System.out::println);
    }

    private void tulostaSuoritukset() {
        if (studentLoggedin == null) {
            service.getSuoritukset().stream().forEachOrdered(System.out::println);
        } else {
            service.getSuoritukset().stream().forEachOrdered(System.out::println);
        }
    }

    private void lisaaKurssi() {
        System.out.print("koodi: ");
        String koodi = scanner.nextLine();
        System.out.print("nimi: ");
        String nimi = scanner.nextLine();
        System.out.print("op: ");
        String op = scanner.nextLine();
        Kurssi kurssi = new Kurssi(koodi, nimi, Integer.parseInt(op));
        try {
            service.lisaaKurssi(kurssi);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void lisaaOpiskelija() {
        System.out.print("opiskelija tunnus: ");
        String koodi = scanner.nextLine();
        System.out.print("nimi: ");
        String nimi = scanner.nextLine();
        System.out.print("sähköposti: ");
        String sposti = scanner.nextLine();
        System.out.print("salasana: ");
        String salasana = scanner.nextLine();
        Opiskelija opiskelija = new Opiskelija(koodi, nimi, sposti, salasana);
        try {
            service.lisaaOpiskelija(opiskelija);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void lisaaSuoritus() {
        System.out.print("kurssikoodi: ");
        String koodi = scanner.nextLine();
        System.out.print("opiskelija tunnus: ");
        String tunnus = scanner.nextLine();
        Kurssi kurssi = service.getKurssi(koodi);
        Opiskelija opiskelija = service.getOpiskelija(tunnus);
        Suoritus suoritus = new Suoritus(kurssi, opiskelija);
        try {
            service.lisaaSuoritus(suoritus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void adminKirjautuminen() {
        System.out.print("salasana: ");
        String salasana = scanner.nextLine();
        if (!salasana.equals("salasana")) {
            System.out.println("Virheellinen salasana!");
        } else {
            System.out.println("Tervetuloa admin!");
            adminLoggedin = true;
        }
    }


    private void opiskelijanKirjautuminen() {
        System.out.print("email: ");
        String email = scanner.nextLine();
        System.out.print("salasana: ");
        String salasana = scanner.nextLine();

        Opiskelija opiskelija = service.getOpiskelijaSahkopostilla(email);
        if (opiskelija == null || !opiskelija.getSalasana().equals(salasana)) {
            System.out.println("Virheellinen käyttäjätunnus tai salasana!");
            return;
        }
        studentLoggedin = service.getOpiskelijat().get(0).getTunnus();
    }

    private void printHelp() {
        System.out.println("Opintorekisteri palvelu.");

        Map<String, String> commands = generalCommands;
        if (studentLoggedin != null && !studentLoggedin.isEmpty()) {
            commands = opiskelijaCommands;
            System.out.print("Opiskelijan ");
        } else if (adminLoggedin) {
            commands = adminCommands;
            System.out.print("Ylläpitäjän ");
        }

        System.out.println("käytössä olevat komennot:");
        commands.values()
                .stream()
                .sorted()
                .forEachOrdered(System.out::println);
    }


}
