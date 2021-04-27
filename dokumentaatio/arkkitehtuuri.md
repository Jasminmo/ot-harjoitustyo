# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne seuraa kolmitasoista kerrosarkkitehtuuria.
Koodin pakkausrakenne on seuraava:
<img src="https://raw.githubusercontent.com/Jasminmo/ot-harjoitustyo/master/dokumentaatio/kuvat/pakkaus.png" width="400">


Pakkaus _opinnot.dao_ huolehtii tietojen pysyväistallennuksesta,
_opinnot.domain_ sisältää sovelluslogiikan, ja
_opinnot.ui_ sisältää käyttöliittymän.


## Sovelluslogiikka

Sovelluksen loogisen datamallin muodostavat luokat [Kurssi](https://github.com/Jasminmo/ot-harjoitustyo/blob/master/Opinnot/src/main/java/org/otharjoitus/opinnot/domain/Kurssi.java),
[Opiskelija](https://github.com/Jasminmo/ot-harjoitustyo/blob/master/Opinnot/src/main/java/org/otharjoitus/opinnot/domain/Opiskelija.java) ja
[Suoritus](https://github.com/Jasminmo/ot-harjoitustyo/blob/master/Opinnot/src/main/java/org/otharjoitus/opinnot/domain/Suoritus.java) jotka kuvaavat kursseja, opiskelijoita sekä opintosuorituksia:

<img src="https://raw.githubusercontent.com/Jasminmo/ot-harjoitustyo/master/dokumentaatio/kuvat/luokkakaavio.png" width="400">

Toiminnallisista kokonaisuuksista vastaa luokka [KurssiSuoritusService](https://github.com/Jasminmo/ot-harjoitustyo/Opinnot/blob/master/src/main/java/org/otharjoitus/domain/KurssiSuoritusService.java).

## Tietojen pysyväistallennus

Pakkauksen _opinnot.dao_ luokat _FileKurssiDao_, _FileOpiskelijaDao_ sekä _FileSuoritusDao_ huolehtivat tietojen tallettamisesta tiedostoihin.

Luokat seuraavat [Data Access Object](https://en.wikipedia.org/wiki/Data_access_object)-suunnittelumallia.

Sovelluslogiikan testauksessa hyödynnetään pakkauksessa _opinnot.dao_ olevia rajapintoja siten,
että testeissä käytetään tiedostoon tallentavien
DAO-olioiden sijaan keskusmuistiin tallentavia toteutuksia.

### Tiedostot

Sovellus tallettaa tiedot erillisiin tiedostoihin.

Sovelluksen juureen sijoitettu konfiguraatiotiedosto [config.properties](https://github.com/Jasminmo/ot-harjoitustyo/blob/master/config.properties) määrittelee tiedostojen nimet.

Sovellus tallettaa kurssit seuraavassa formaatissa
<pre>
1234;Testi kurssi;10
</pre>
eli ensin kurssitunnus ja puolipisteellä erotettuna kurssin nimi sekä opintopisteet.

Opiskelijoiden tiedot ovat seuraavassa formaatissa
<pre>
54321;Malli, Oppilas;oppilas.malli@helsinki.fi;salainen-sana
</pre>
eli ensin opiskelijanumero ja puolipisteellä erotettuna nimi, sähköposti sekä salasana.

Opiskelijoiden suoritukset tallettaa tiedot seuraavassa formaatissa
<pre>
12345;54321;2021-27-04
</pre>
Ensimmäisenä on kurssitunniste, toisena opiskelijatunnus, kolmantena tieto siitä milloin kurssi on suoritettu.

### Päätoiminnallisuudet

Kuvataan seuraavaksi sovelluksen toimintalogiikka sekvenssikaaviona.

#### Tietojen listaus

<img src="https://raw.githubusercontent.com/Jasminmo/ot-harjoitustyo/master/dokumentaatio/kuvat/listaa-tiedot.png" width="400">

<img src="https://raw.githubusercontent.com/Jasminmo/ot-harjoitustyo/master/dokumentaatio/kuvat/tulosta-tiedot.png" width="400">

### käyttöliittymä

Käyttöliittymä on tällä hetkellä tekstuaalinen, mutta tarkoituksena on käyttää graafista käyttöliittymää.
