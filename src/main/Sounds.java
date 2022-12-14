/**
 * This class controls the background music and the sfx.
 *
 * @author  EG Renz Go
 * @author  Therese Nuelle Roca
 * @author  Erica Talahiban
 */

package main;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sounds {

    Clip clip;
    URL musicURL;

    String correct= "/sound/correct.wav";
    String mozart = "/sound/mozart-symphony41-3.wav";
    String wrong = "/sound/wrong.wav";
    String buttonClick = "/sound/buttonClick.wav";
    String MainMusic = "/sound/Komiku_-_12_-_Bicycle.wav";
    String lockdownBG = "/sound/Sneaky-Snitch.wav";
    String OSnakes_bgm= "/sound/OSnakes_main.wav";
    String OSnakes_quiz = "/sound/OSnakes_quiz.wav";
    String OSnakes_click = "/sound/OSnakes_click.wav";
    String OSnakes_eat = "/sound/OSnakes_eat.wav";
    String OSnakes_win = "/sound/OSnakes_win.wav";
    String OSnakes_gameOver = "/sound/OSnakes_gameOver.wav";

    /**
     * Play the required music or sfx.
     * @param num The number corresponds the music or sfx.
     */
    public void soundChoice(int num){
        try{
            switch (num) {
                case 1 -> musicURL = getClass().getResource(mozart);
                case 2 -> musicURL = getClass().getResource(correct);
                case 3 -> musicURL = getClass().getResource(wrong);
                case 4 -> musicURL = getClass().getResource(buttonClick);
                case 5 -> musicURL = getClass().getResource(MainMusic);
                case 6 -> musicURL = getClass().getResource(lockdownBG);
                case 7 -> musicURL = getClass().getResource(OSnakes_bgm);
                case 8 -> musicURL = getClass().getResource(OSnakes_quiz);
                case 9 -> musicURL = getClass().getResource(OSnakes_click);
                case 10 -> musicURL = getClass().getResource(OSnakes_eat);
                case 11 -> musicURL = getClass().getResource(OSnakes_win);
                case 12 -> musicURL = getClass().getResource(OSnakes_gameOver);
            }

            assert musicURL != null;
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicURL);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException ignored) { }
    }

    /**
     * Play the music a 100x
     * Specifically for the background music
     */
    public void playLoop(){
        clip.loop(100);
    }

    /**
     * Pauses the music.
     */
    public void stop(){
        clip.stop();
    }
}



