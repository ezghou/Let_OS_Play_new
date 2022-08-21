package main;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * This class controls the background music and the sfx.
 *
 * @author  EzGhou
 * @author  Therese Nuelle Roca
 */
public class Sounds {

    Clip clip;
    URL musicURL;

    String correct= "/sound/correct.wav";
    String mozart = "/sound/mozart-symphony41-3.wav";
    String wrong = "/sound/wrong.wav";
    String buttonClick = "/sound/buttonClick.wav";
    String MainMusic = "/sound/Komiku_-_12_-_Bicycle.wav";

    /**
     * Play the required music or sfx.
     * @param num The number corresponds the music or sfx.
     */
    public void soundChoice(int num){
        try{
            switch(num){
                case 1:
                    musicURL = getClass().getResource(mozart);
                    break;
                case 2:
                    musicURL = getClass().getResource(correct);
                    break;
                case 3:
                    musicURL = getClass().getResource(wrong);
                    break;
                case 4:
                    musicURL = getClass().getResource(buttonClick);
                    break;
                case 5:
                    musicURL = getClass().getResource(MainMusic);
                    break;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicURL);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {

        }
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



