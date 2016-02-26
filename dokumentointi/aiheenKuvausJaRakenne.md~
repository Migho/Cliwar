**Aihe:** Toteutetaan peli nimeltään Cliwar. Pelissä kaksi pelaajaa pelaavat toisiaan vastaan splitscreenillä. Molemmilla pelaajilla on oma hahmo ja käytössään yhteiset kortit, joita he voivat pelata: kortit vaihtuvat ajoittain ja niiden pelaaminen voi vaikuttaa omaan, vastustajan, tai molempien peliin. Kummallakin pelaajalla on oma korttipakkansa, mutta korttipakat eivät toimi kuten korttipakat toimivat yleensä (eli jonona). Molemmilla pelaajilla on energiaa ja tuottavat sitä ajan myötä itselleen lisää. Energian avulla voi pelata kortteja, joiden avulla voi vaikuttaa pelin kulkuun. Jos vihollisen HP tippuu nollaan, häviää pelin. Peli on nopeuspeli, ja sen kesto on arviolta 2-5min.

Esimerkkejä korteista: lisää itselle lisää HP:ta, lisää itselle magic- tai physical damage resistancea, vahingoita vastustajaa magic- tai physical damagella, nosta omaa energialimittiä, vie viholliselta HP:ta itselle, vahingoita molempia jne.

**Käyttöohjeet**
Pelin pelaaminen on yksinkertaista: peli alkaa kun sen käynnistää, ja pelissä on kummallakin pelaajalla kolme eri nappia:

Pelaaja 1: A=vasen, S=valitse kortti, D=oikea.
Pelaaja 2: B=vasen, N=valitse kortti, M=oikea. 

Molemmilla pelaajilla on oma ruutunsa pelilaudalla, jota voi siirtää kortista toiseen yllä olevilla näppäimillä. Valitse kortti -näppäimellä kortti valitaan, ja sen efektit astuvat voimaan vain mikäli pelaajalla on tarpeeksi energiaa (statsit näkyvät ylhäällä). Valitettavasti vielä korteissa ei lue paljonko ne vievät energiaa, tai mitä niistä tapahtuu. Ehkä jonain päivänä.

Kun pelaajan HP tippuu negatiiviseksi, hän on hävinnyt pelin ja vastapuoli on voittaja.

**Käyttäjät:** Erilaisia käyttäjiä ei ole. On vain kaksi pelaajaa, joilla molemmilla on samat oikeudet.

**Kaikkien käyttäjien toiminnot:**
- Aloita peli
  - Peli voidaan aloittaa jos edellinen peli on juuri loppunut tai ohjelma on juuri käynnistetty.

- Aktivoi kortti
  - Pelaaja voi nostaa kortin jos sillä on tarpeeksi kortin vaatimaa energiaa. Toiminnon jälkeen energiaa vähenee pelaajalta kortin määrittämän verran ja kortin efektit aktivoituvat.

- Siirrä kortinvalitsinta
  - Pelaaja voi siirtää valitsintaan milloin tahansa. Tällöin valitsin siirtyy pelaajan näppäilyjen mukaan joko vasemmalle tai oikealle.

![Alt text](Luokkakaavio.jpg)
Sekvenssikaavio, joka kuvaa ohjelman (logiikkapuolen) käynnistymistä:

**Rakennekuvaus**
Peli on jaettu kahteen eri pakettiin: system ja gui. Paketin GUI kaikkiin luokkiin on laitettu kirjain G (luokkakaaviossa kirjainyhdistelmä GUI), jotta ne eivät menisi sekaisin paketin SYSTEM samankaltaisten luokkien kanssa. Luokka Launcher, joka on paketissa SYSTEM, käynnistää sovelluksen toiminnan. Luokka Glauncher käynnistää graafisen toiminnan.

SYSTEMin luokka Controller ja GUIn luokka Gcontroller yhdistävät omien pakettiensa luokkien toiminnallisuuden toimivaksi kokonaisuudeksi. Gcontollerin toiminta on varsin simppeli: se tietyin väliajoin uudelleenpiirtää muiden luokkien tarjoamat asiat ruudulle. Loput GUIn luokat Ghands, Gcards, Gstats, Gbackground ja myöhemmin lisätty Gplayers toimivat Gcontrollerin täydessä alaisuudessa ja piirtävät näytölle sen kokonaisuuden mitä niiden nimet implikoivat.

SYSTEM on hieman monimutkaisempi paketti. Lyhyesti: luokkaryhmä Table, CardUpdater ja Deck huolehtivat korttien päivittämisestä pöydällä. Luokkaryhmä ButtonController ja ButtonListener huolehtivat käyttäjän toimintaan reagoimisesta. Luokkaryhmä Gameboard, CardDatabase, Player ja EnergyUpdater huolehtivat sen sijaan virtuaalisen pelaajahahmon statistiikasta ja korttien efektien aktivoinnista. Controller yhdistää nämä toiminnallisuudet.

![Alt text](Sekvenssikaavio-aloitus.jpg)
Sekvenssikaavio, joka kuvaa sitä, kun pelaaja siirtää valitsinta ja aktivoi kortin:
![Alt text](Sekvenssikaavio-kortinValinta.jpg)

