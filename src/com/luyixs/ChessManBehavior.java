package com.luyixs;

import javax.swing.*;
import java.io.FileInputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class ChessManBehavior extends JLabel {
    boolean died = false;
    ChessManBehavior(Icon image){
        super(image);
    }

    public void playSounds(int man){
        if (man> 25 && man < 30){
            try{
                FileInputStream fileInputStream = new FileInputStream("sounds/cannon.wav");
                AudioStream audioSystem = new AudioStream(fileInputStream);
                AudioPlayer.player.start(audioSystem);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (man>= 0 && man <= 25){
            try{
                FileInputStream fileInputStream = new FileInputStream("sounds/5390.wav");
                AudioStream audioSystem = new AudioStream(fileInputStream);
                AudioPlayer.player.start(audioSystem);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (man>= 30 && man < 32 ){
            try{
                FileInputStream fileInputStream = new FileInputStream("sounds/5390.wav");
                AudioStream audioSystem = new AudioStream(fileInputStream);
                AudioPlayer.player.start(audioSystem);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void playEatSounds(ChessManBehavior playQ[]){
        playQ[32].setVisible(true);
    }
    public void playImage(ChessManBehavior playQ[]){
        playQ[33].setVisible(true);
    }
    public void playEatSounds() {
        try {
            FileInputStream fileau = new FileInputStream("src/sounds/knj.wav");
            AudioStream as = new AudioStream(fileau);
            AudioPlayer.player.start(as);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void playPanJiang() {
        try {
            FileInputStream fileau = new FileInputStream("src/sounds/elpx.wav");
            AudioStream as = new AudioStream(fileau);
            AudioPlayer.player.start(as);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
