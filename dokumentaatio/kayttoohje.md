# Käyttöohje

Lataa tiedosto [Opiskelija.jar](https://github.com/jasminmo/ot-harjoitustyo/releases/)

## Konfigurointi

Ohjelma olettaa, että sen käynnistyshakemistossa on konfiguraatiotiedosto _config.properties_, joka määrittelee käyttäjät tallettavien tiedostojen nimet.


## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 

```
java -jar Opinnot.jar
```

## Kirjautuminen

Sovellus käynnistyy kirjautumisnäkymään:
<img src="https://raw.githubusercontent.com/jasminmo/ot-harjoitustyo/master/dokumentaatio/kuvat/kirjaudu.png" width="400">

Kirjautuminen onnistuu kirjoittamalla olemassaoleva käyttäjätunnus syötekenttään ja painamalla _login_.

### Ylläpitäjän Kirjautuminen
Admin kirjautuu tunnuksella ```admin``` ja salasanalla ```salasana```.

## Ylläpitäjän näkymä
Ylläpitäjä näkee listauksen kaikista kursseista, opiskelijoista sekä suorituksista.
<img src="https://raw.githubusercontent.com/jasminmo/ot-harjoitustyo/master/dokumentaatio/kuvat/admin.png" width="400">


### Kurssilistaus
Kurssilistauksessa näkyy kaikki järjestelmän sisältämät kurssit.
Uuden kurssin voi lisätä taulukon pohjalla olevan lomakkeen avulla.
Uusi kurssi lisätään tietokantaan, jos kurssikoodi-kenttä on uniikki.

<img src="https://raw.githubusercontent.com/jasminmo/ot-harjoitustyo/master/dokumentaatio/kuvat/kurssit.png" width="400">

### Opiskelija listaus
<img src="https://raw.githubusercontent.com/jasminmo/ot-harjoitustyo/master/dokumentaatio/kuvat/opiskelijat.png" width="400">

### Kaikkien suoritusten listaus
<img src="https://raw.githubusercontent.com/jasminmo/ot-harjoitustyo/master/dokumentaatio/kuvat/kaikki-suoritukset.png" width="400">

## Opiskelijan näkymä

### Opiskelijan kirjautuminen
Opiskelija kirjautuu sähkopostillaan ja salasanallaan.

### Opiskelijan suoritusten listaus
Kirjauduttuaan opiskelijan näkee listauksen kaikista suorittamistaan kursseista.
<img src="https://raw.githubusercontent.com/jasminmo/ot-harjoitustyo/master/dokumentaatio/kuvat/opiskelijan-suoritukset.png" width="400">
Uuden suorituksen voi lisätä taulukon pohjalla olevan lomakkeen avulla.
