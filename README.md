# Saatesanat
JakartaEE ja Microprofile muodostavat yhdessä arkkitehtuurin Java-pohjaisille "enterprise" applikaatioille. Harjoituksessa on luotu tyhjä esimerkkiprojekti, jota olisi tarkoitus laajentaa.

Tukimateriaali esimerkiksi täällä https://eclipse-ee4j.github.io/jakartaee-tutorial/toc.html. Huomioi, että Jakarta on uusi nimi Java Enterprise editionille, joten etsinnöissä kannattaa käyttää apuna myös Java EE termiä. 

Harjoituksessa käytetään seuraavia JakartaEE ominaisuuksia:
  * JAX-RS
  * EJB
  * JPA

Lisäksi harjoituksessä käytetään seuraavia Microprofilen ominaisuuksia:
  * Config
  * Health

Käytä harjoitukseen 2-4h ja palauta se esim. githubin kautta tai muulla tavoin. Jos jokaista kohtaa et osaa/ymmärrä/ehdi, niin kuvaa lyhyesti miten olisit halunnut asian tehdä. Jos et pääse sisään projektin rakenteeseen, niin toteuta alla olevat 10 harjoitusta valitsemallasi ohjelmointikielellä

IDEnä voit käyttää esimerkiksi IntelliJ:tä (ilmainen kokeiluversio https://www.jetbrains.com/idea/), johon saat projektin avautumaan avaamalla projektin juuressa olevan pom.xml tiedoston sillä ja valitsemalla että haluat sen avautuvan projektina.

# Esiehdot 
1. Asenna Java (JDK 8 tai uudempi)
  * https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
  * Testaus komentorivilla: java -version
2. Asenna Maven 3 tai uudempi
  * https://maven.apache.org/download.cgi
  * Testaus komentorivilla: mvn -version
3. Vaihtoehto A: Lokaaliymppäristö 
  * Lataa ja pura Wildfly
  * https://www.wildfly.org/downloads/
  * Pura ladattu zip
  * Kokeile käynnistää serveri sen juuresta hakemistosta /bin standalone.sh tai standalone.bat skriptilla (suosittelen ajoa komentoriviltä)
  * serverin pitäisi vastata käynnistyksen jälkeen http://localhost:8080 osoitteessa
  * serverin saa suljettua ctrl/cmd + c komentorivillä tai shutdown skriptilla /bin kansiosta
3. Vaihtoehto B: Docker (suositus)
  * Asenna docker: https://www.docker.com/

# Kääntäminen (projektikansion juuressa)
mvn clean package

Tämä luo ajettavan tiedoston projektin juureen: target/ping.war

# Ajaminen/jakelu

### Vaihtoehto A: Lokaali

1. Serverin tulee olla päällä (vastaa http://localhost:8080/)
2. Kopioi käännöksen lopputulos (ping.war) serverin hakemistoon /standalone/deployments kansioon
* serveri lataa applikaation
* tähän kannattaa tehdä skripti, joka kääntää ja kopioi lopputuloksen serverille
3. Applikaation tulisi vastata nyt osoitteessa http://localhost:8080/ping/resources/test
4. HUOM! Kantana käytetään muistissa olevaa kantaa, joka resetoituu joka deploymentilla/uudelleenkäynnistyksellä

### Vaihtoehto B: Docker

1. Mac/Linux: aja projektin juuresta buildAndRunDocker.sh
  * Applikaation tulisi vastata nyt osoitteessa http://localhost:8080/ping/resources/test  
  * HUOM! Kantana käytetään muistissa olevaa kantaa, joka resetoituu joka käynnistyksellä
2. Windows: ks. kommennot ylläolevasta skriptistä ja luo niistä oma .bat tai aja komentorivillä

# Tehtävät
0. Kommentoi kunkin luokan alkuun minkä tulkitset sen tarkoitukseksi
1. Luo testirajapinnan tervehdystekstiin toinen property, joka tulee osaksi vastausta   
2. Muuta osoitteen http://localhost:8080/ping/resources/ping/{nimi} niin, että se kokeilee palauttaa nimen mukaisen tuloksen kannasta. Jos kannasta ei löydy tulosta, niin palautetaan kannan kaikki arvot
3. Lisää HTTP rajapinnat uusien Pongien luonnille, päivittämiselle ja poistolle. 
   * Käytä hyväksi esim. curlia tai postmania rajapintojen testaamisessa
4. Luo vapaavalintainen entiteetti ja sille perus tietokantaoperaatiot
5. Lisää sovelluksen käynnistymiseen muutaman testiobjektin luonti luodulle entiteetille   
6. Luo HTTP rajapinta, joka listaa kaikki kannassa olevat luomasi rivit
7. Luo HTTP rajapinta, joka vie kumpaankin tauluun (Pong tauluun ja luomaasi) yhden uuden objektin. 
   * Huolehdi, että operaatiolle luodaan aina uusi transaktio (vinkki container managed transactions)
8. Muuta /ping/resources/ping/{nimi} rajapinta palauttamaan tekstiä Jsonin tilalla
9. Lisää luomallesi resurssille testi osaksi health checkkiä 
   * http://localhost:9990/health
   * HUOM! huomaa, että porttinumero health checkissä on eri
10. Jätä kommentti minkä koit haastavimmaksi tehtävässä ja kauanko suurinpiirtein käytit aikaa
