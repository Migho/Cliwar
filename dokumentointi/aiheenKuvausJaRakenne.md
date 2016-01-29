**Aihe:** Toteutetaan peli nimeltään Cliwar. Pelissä kaksi pelaajaa pelaavat toisiaan vastaan splitscreenillä. Molemmilla pelaajilla on oma hahmo ja käytössään yhteiset kortit, joita he voivat pelata: kortit vaihtuvat ajoittain ja niiden pelaaminen voi vaikuttaa omaan, vastustajan, tai molempien peliin. Kummallakin pelaajalla on oma korttipakkansa, mutta korttipakat eivät toimi kuten korttipakat toimivat yleensä (eli jonona). Molemmilla pelaajilla on energiaa ja tuottavat sitä ajan myötä itselleen lisää. Energian avulla voi pelata kortteja, joiden avulla voi vaikuttaa pelin kulkuun. Jos vihollisen HP tippuu nollaan, häviää pelin. Peli on nopeuspeli, ja sen kesto on arviolta 2-5min.

Esimerkkejä korteista: lisää itselle lisää HP:ta, lisää itselle magic- tai physical damage resistancea, vahingoita vastustajaa magic- tai physical damagella, nosta omaa energialimittiä, vie viholliselta HP:ta itselle, vahingoita molempia jne.

**Käyttäjät:** Erilaisia käyttäjiä ei ole. On vain kaksi pelaajaa, joilla molemmilla on samat oikeudet.

**Kaikkien käyttäjien toiminnot:**
- Aloita peli
  - Peli voidaan aloittaa jos edellinen peli on juuri loppunut tai ohjelma on juuri käynnistetty.

- Aktivoi kortti
  - Pelaaja voi nostaa kortin jos sillä on tarpeeksi kortin vaatimaa energiaa. Toiminnon jälkeen energiaa vähenee pelaajalta kortin määrittämän verran ja kortin efektit aktivoituvat.

- Siirrä kortinvalitsinta
  - Pelaaja voi siirtää valitsintaan milloin tahansa. Tällöin valitsin siirtyy pelaajan näppäilyjen mukaan joko vasemmalle tai oikealle.
