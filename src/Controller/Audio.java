package Controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;

public class Audio {
    private final Random rand = new Random();
    private Media BGM;
    private Media SFX;
    private MediaPlayer BGMPlayer;
    private MediaPlayer SFXPlayer;
    private Double BGMVol;
    private Double SFXVol;
    private String Path;
    private int randomNum = rand.nextInt((9 - 1) + 1) + 1;

    /**
     * Constuctor, plays a random audio for MainMenu
     */
    public Audio() {
        try {
            BufferedReader FILE = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/Controller/SETUP.dat")));
            FILE.readLine();
            FILE.readLine();
            String Text = FILE.readLine();
            Double N = (double) Integer.parseInt(Text);
            N = N / 100;
            BGMVol = N;
            if (BGMPlayer != null)
                BGMPlayer.setVolume(N);
            Text = FILE.readLine();
            N = (double) Integer.parseInt(Text);
            N = N / 100;
            SFXVol = N;
            if (SFXPlayer != null)
                SFXPlayer.setVolume(N);
            FILE.close();
        } catch (IOException ignored) {
        }
    }

    /** Plays a Background Music
     *
     * @param BGMname File Name
     */
    public void playBGM(String BGMname) {
        if (BGM != null) {
            BGMPlayer.stop();
        }
        try {
            Path = (new File("src/Audio/BGM/" + BGMname + ".mp3")).getCanonicalPath();
            Path = Path.replace(" ", "%20");
            Path = Path.replace("\\", "/");
            BGM = new Media("file:///" + Path);
            BGMPlayer = new MediaPlayer(BGM);
            setVolume();
            BGMPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            BGMPlayer.setAutoPlay(true);
        } catch (IOException ignored) {
        }
    }

    /**
     * Plays a random Background Music
     */
    public void playBGM() {
        if (BGM != null) {
            BGMPlayer.stop();
        }
        try {
            Path = (new File("src/Audio/BGM/MT" + randomNum + ".mp3")).getCanonicalPath();
            Path = Path.replace(" ", "%20");
            Path = Path.replace("\\", "/");
            BGM = new Media("file:///" + Path);
            BGMPlayer = new MediaPlayer(BGM);
            setVolume();
            BGMPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            BGMPlayer.setAutoPlay(true);
        } catch (IOException ignored) {
        }
    }

    /**
     * Stop a BGM
     */
    public void stopBGM() {
        Timeline tl = new Timeline();
        KeyValue k0 = new KeyValue(BGMPlayer.volumeProperty(), BGMVol);
        KeyValue k1 = new KeyValue(BGMPlayer.volumeProperty(), 0);
        KeyFrame F0 = new KeyFrame(Duration.ZERO, k0);
        KeyFrame F1 = new KeyFrame(new Duration(2200), k1);
        tl.getKeyFrames().addAll(F0, F1);
        tl.setOnFinished(e -> BGMPlayer.stop());
        tl.play();
    }

    /**
     * Plays a SFX
     *
     * @param SFXname File Name
     */
    public void playSFX(String SFXname) {
        try {
            Path = (new File("src/Audio/SFX/" + SFXname + ".wav")).getCanonicalPath();
            Path = Path.replace(" ", "%20");
            Path = Path.replace("\\", "/");
            SFX = new Media("file:///" + Path);
            SFXPlayer = new MediaPlayer(SFX);
            setVolume();
            SFXPlayer.setAutoPlay(true);
        } catch (IOException ignored) {
        }
    }

    /**
     * Updates volume
     */
    public void setVolume() {
        if (BGMPlayer != null)
            BGMPlayer.setVolume(BGMVol);
        if (SFXPlayer != null)
            SFXPlayer.setVolume(SFXVol);
    }

    /**
     * Set a new Volume for the app
     *
     * @param BGM the new BGM Volume
     * @param SFX the new SFX Volume
     */
    public void setVolume(double BGM, double SFX) {
        BGMVol = BGM;
        SFXVol = SFX;
        if (BGMPlayer != null)
            BGMPlayer.setVolume(BGMVol);
        if (SFXPlayer != null)
            SFXPlayer.setVolume(SFXVol);
    }

    /**
     * Temporally modifies Background music for testing purpose in setup screen
     *
     * @param V Volume for Test
     */
    public void testBGMVol(Double V) {
        BGMPlayer.setVolume(V);
    }

    /**
     * Temporally modifies sound effect for testing purpose in setup screen
     *
     * @param V Volume for Test
     */
    public void testSFXVol(Double V) {
        try {
            Path = (new File("src/Audio/SFX/se_changeItem.wav")).getCanonicalPath();
            Path = Path.replace(" ", "%20");
            Path = Path.replace("\\", "/");
            SFX = new Media("file:///" + Path);
            SFXPlayer = new MediaPlayer(SFX);
            SFXPlayer.setVolume(V);
            SFXPlayer.setAutoPlay(true);
        } catch (IOException ignored) {
        }
    }

    /**
     * Get the Volume of Background Music
     *
     * @return Volume of Background Music
     */
    public Double getBGMVol() {
        return BGMVol;
    }

    /**
     * Get the Volume of Sound Effects
     *
     * @return Volume of Sound Effects
     */
    public Double getSFXVol() {
        return SFXVol;
    }

    /**
     * Plays an specific SFX
     * This functions has been made in order to be
     * used with KeyFrame in order to play a SFX in
     * a specific moment of the Timeline.
     * Use it in the first parameter of KeyFrame(Duration, ....)
     *
     * @param SFXName Name of the SFX to be played
     * @return double 0.0
     */
    public double get0AndPlay(String SFXName) {
        try {
            Path = (new File("src/Audio/SFX/" + SFXName + ".wav")).getCanonicalPath();
            Path = Path.replace(" ", "%20");
            Path = Path.replace("\\", "/");
            Media SFX = new Media("file:///" + Path);
            SFXPlayer = new MediaPlayer(SFX);
            setVolume();
            SFXPlayer.setAutoPlay(true);
        } catch (IOException ignored) {
        }
        return 0;
    }
}
