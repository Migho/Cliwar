package gui;

import sun.audio.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import system.Player;

public class Sounds {

    private AudioInputStream calmAudio;
    private AudioInputStream panicAudio;
    private Clip calmClip;
    private Clip panicClip;
    private Player player1, player2;

    /**
     * Tämä luokka soittaa musiikkia. Se vaatii parametreikseen molemmat
     * pelaajat, sillä musiikki vaihtuu kun jomman kumman HP on alle 10.
     * @param player1       Pelaaja 1 -olio
     * @param player2       Pelaaja 2 -olio. Järjestys ei ole pakollinen.
     */
    public Sounds(Player player1, Player player2) {
        try {
            //calmAudio = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/music/music.wav"));
            calmAudio = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream("/music/music.wav")));
            calmClip = AudioSystem.getClip();
            calmClip.open(calmAudio);
            panicAudio = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream("/music/panicmusic.wav")));
            panicClip = AudioSystem.getClip();
            panicClip.open(panicAudio);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException uae) {
            System.out.println("Virhe ladattaessa ääntä: " + uae);
        }
        this.player1 = player1;
        this.player2 = player2;
        playCalm();
    }

    /**
     * Metodi tarkistaa pitääkö kappaletta vaihtaa.
     */
    public void doSoundRoutine() {
        if (!panicClip.isActive() && (player1.getStats()[0] < 10 || player2.getStats()[0] < 10)) {
            calmClip.stop();
            playPanic();
        }
    }

    private void playCalm() {
        calmClip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    private void playPanic() {
        panicClip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
