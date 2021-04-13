# Opiskelu

## Sovelluksen tarkoitus

Sovelluksen avulla opiskelijoiden on mahdollista pitää kirjaa suorittamistaan kursseista.

## Huomio Javan versioista

JavaFX aiheuttaa päänvaivaa ohjelmiston konfiguroinnin suhteen. Tässä repositoriossa olevan koodin _pitäisi_ toimia riippumatta käyttämästäsi Javan versiosta. Koodi toimii ainakin laitoksen cubbli-Linuxeissa olevilla Java:n versiolla 11. 

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/Jasminmo/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/Jasminmo/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _Opinnot-1.0-SNAPSHOT.jar_.

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_

## Javan ja Mavenin asennusohjeita Macille Homebrew'n kautta

Homebrew on Linuxin pakettimanagereita vastaava pakettimanageri MacOS-käyttöjärjestelmälle. Nämä ohjeet toimivat ainakin MacOS:n versiolle 10.15. [Asennusohjeet Homebrew'lle.](https://brew.sh/index_fi)

### Javan asennus
Homebrew'n asennuksen jälkeen Javan saa asennettua Macille yksinkertaisesti esimerkiksi komennolla

```
brew install adoptopenjdk
```
### Mavenin asennus ja paluu Javan versioon 11
Mavenin saa asennettua komennolla

```
brew install maven
```

Tällöin Mavenin oletuksena käyttämä Java-versio on Java 15. Java-versioon 11 päästään asentamalla Java 11 komennolla

```
brew install java11
```
Lisäksi täytyy osoittaa Mavenille Javan versio 11. Mavenin versiolla 3.6.3_1 tämä tapahtuu muokkaamalla tiedostoa: /usr/local/Cellar/maven/3.6.3_1/bin/mvn esim. nanolla komennolla

```
sudo nano /usr/local/Cellar/maven/3.6.3_1/bin/mvn
```
HUOM Muista tarkistaa mikä versio Mavenista asentui ja muokkaa tiedostopolkuun oikea versio version 3.6.3_1 tilalle

Muokkaa rivi
```
JAVA_HOME="${JAVA_HOME:-/usr/local/opt/openjdk/libexec/openjdk.jdk/Contents/Home}" exec "/usr/local/Cellar/maven/
```
Muotoon
```
JAVA_HOME="${JAVA_HOME:-/usr/local/opt/openjdk@11/libexec/openjdk.jdk/Contents/Home}" exec "/usr/local/Cellar/maven/
```
Eli muokkaa polkuun ```openjdk``` ```openjdk@11``` ja tallenna tiedosto. Nyt voit tarkistaa komennolla ```mvn --version```, että Maven käyttää Javan versiota 11.

Käyttöjärjestelmän Java version vaihtaminen onnistuu esimerkiksi lisäämällä tiedoston: ```~/.zshrc``` (vanhemmilla MacOS-käyttöjärjestelmillä ```~/.bashrc```) loppuun rivi
```
export JAVA_HOME=/usr/local/opt/openjdk@11/libexec/openjdk.jdk/Contents/Home/
```
Muista käynnistää lisäyksen jälkeen terminaali uudestaan, jolloin komento ```java --version``` näyttää versioksi 11.

