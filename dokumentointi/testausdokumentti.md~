Ohjelman toiminta on omasta mielestäni testattu tarpeeksi kattavasti.

LINE COVERAGE: 80%
MUTATION COVERAGE: 60%

**ButtonController**: Kaikki metodit ja järkevät asiat testattu.
**CardDataBase**: Testaamatta jätetty esim korttien määrän oikeellisuus, sillä se olisi vaatinut tiedoston avaamista JUnit-testissä (joka puolestaan olisi toteutettu täysin samalla tavalla kuin metodin oma tiedoston avaamissysteemi).
**CardUpdater**: Kaikki metodit ja järkevät asiat testattu. Huomioi että näiden testien suoritus vie aikaa.
**Controller**: Kaikki (helposti?) testattavat asiat testattu. Metodi nostaKortti() on valitettavan tärkeä logiikan osa, joka olisi ollut luonnollista testata perusteellisesti: peli on kuitenkin luotu siten, että uusia kortteja ja korttipakkoja voi muuttaa asetuksista ilman koodin muuttamista. Tämä vaikeuttaa testaamista, kun nostettavaa korttia ei voi tietää. Nostettavan kortin selvittäminen olisi taas kasvattanut testin kokoa kovin suureksi ja monimutkaiseksi.
**Deck**: Samat selitykset kuin CardDataBase -luokassa. Metodit joita ei ole testattu toimivat varsin yksinkertaisesti, ja nojautuvat täysin siihen että asetustiedostot on luettu oikein.
**EnergyUpdater**: Kaikki metodit ja järkevät asiat testattu.
**Gameboard**: Kaikki tarpeellinen testattu. Metodit startActivity() ja lopetaPeli() käytännössä vain välittävät pelin alkamista/lopettamista eteenpäin ja niiden toimivuus on testattu muissa testeissä.
**KeyboardListener**: Luokka jolle ei ole lainkaan omaa testiluokkaa. En kokenut tarpeelliseksi testata: luokka itsestään vain kuuntelee kuutta eri näppäintä ja niiden perusteella käskyttää luokkaa ButtonController. Hyvin yksinkertainen luokka joka ei tee juuri mitään.
**Player**: Kaikki metodit ja järkevät asiat testattu.
**Table**: Kaikki järkevät asiat testattu, paitsi metodit stopRunning() ja startActivity(), jotka eivät tee muuta kuin aloita tai lopeta cardUpdater -luokan toiminnan. CardUpdater -luokan toiminta on testattu kokonaisuudessaan sen omassa testiluokassa.

Pelissä ei pitäisi olla bugeja, mutta jostain syystä pari kertaa suorittaessa netbeans jämähti kohtaan "Building..". Pelin taustaääni lähti kuitenkin pyörimään, mutta sovellusikkunaa ei käynnistynyt. Uudelleenajo ratkaisi aian ongelman. En tiedä mistä bugi johtui ja sitä esiintyi harvoin.
