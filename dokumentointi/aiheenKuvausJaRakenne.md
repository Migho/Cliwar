**Aihe:** Toteutetaan peli nimeltään Cliwar. Pelissä kaksi pelaajaa pelaavat toisiaan vastaan splitscreenillä. Molemmilla pelaajilla on oma hahmo ja käytössään yhteiset kortit, joita he voivat pelata: kortit vaihtuvat ajoittain ja niiden pelaaminen voi vaikuttaa omaan, vastustajan, tai molempien peliin. Kummallakin pelaajalla on oma korttipakkansa, mutta korttipakat eivät toimi kuten korttipakat toimivat yleensä (eli jonona). Molemmilla pelaajilla on energiaa ja tuottavat sitä ajan myötä itselleen lisää. Energian avulla voi pelata kortteja, joiden avulla voi vaikuttaa pelin kulkuun. Jos vihollisen HP tippuu nollaan, häviää pelin. Peli on nopeuspeli, ja sen kesto on arviolta pari minuuttia.

Esimerkkejä korteista: lisää itselle magic- tai physical damage resistancea, vahingoita vastustajaa magic- tai physical damagella, nosta omaa energiaratea, vahingoita molempia jne.

**Käyttäjät:** Erilaisia käyttäjiä ei ole. On vain kaksi pelaajaa, joilla molemmilla on samat oikeudet.

**Kaikkien käyttäjien toiminnot:**
- Aloita peli
  - Peli voidaan aloittaa jos edellinen peli on juuri loppunut tai ohjelma on juuri käynnistetty.

- Aktivoi kortti
  - Pelaaja voi nostaa kortin jos sillä on tarpeeksi kortin vaatimaa energiaa. Toiminnon jälkeen energiaa vähenee pelaajalta kortin määrittämän verran ja kortin efektit aktivoituvat.

- Siirrä kortinvalitsinta
  - Pelaaja voi siirtää valitsintaan milloin tahansa. Tällöin valitsin siirtyy pelaajan näppäilyjen mukaan joko vasemmalle tai oikealle.

![Alt text](Luokkakaavio.jpg)

**Rakennekuvaus**
Peli on jaettu kahteen eri pakettiin: system ja gui. Paketin GUI luokkiin on laitettu kirjain G, jotta ne eivät menisi sekaisin paketin SYSTEM samankaltaisten luokkien kanssa (Poikkeuksena Sounds, joka ei piirrä mitään). Luokka Launcher, joka on paketissa SYSTEM, käynnistää sovelluksen toiminnan. Luokka Glauncher käynnistää graafisen toiminnan.

SYSTEMin luokka Controller ja GUIn luokka Gcontroller yhdistävät omien pakettiensa luokkien toiminnallisuuden toimivaksi kokonaisuudeksi. Gcontollerin toiminta on varsin simppeli: se tietyin väliajoin uudelleenpiirtää muiden luokkien tarjoamat asiat ruudulle. Loput GUIn luokat Ghands, Gcards, Gstats, Gbackground ja Gplayers toimivat Gcontrollerin täydessä alaisuudessa ja piirtävät näytölle sen kokonaisuuden mitä niiden nimet implikoivat. Sounds puolestaan toistaa taustamusiikin.

SYSTEM on hieman monimutkaisempi paketti. Lyhyesti: luokkaryhmä Table, CardUpdater ja Deck huolehtivat korttien päivittämisestä pöydällä. Luokkaryhmä ButtonController ja ButtonListener huolehtivat käyttäjän toimintaan reagoimisesta. Luokkaryhmä Gameboard, CardDatabase, Player ja EnergyUpdater huolehtivat sen sijaan virtuaalisen pelaajahahmon statistiikasta ja korttien efektien aktivoinnista. Controller yhdistää nämä toiminnallisuudet.

Sekvenssikaavio, joka kuvaa ohjelman (logiikkapuolen) käynnistymistä:
![Alt text](Sekvenssikaavio-aloitus.jpg)
Sekvenssikaavio, joka kuvaa sitä, kun pelaaja siirtää valitsinta ja aktivoi kortin:
![Alt text](Sekvenssikaavio-kortinValinta.jpg)

