package com.game.characters;

import com.game.powers.Powers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mohamedsherif on 4/12/16.
 */
public class Scorpion extends Character {

    public Scorpion(){
        super(1800,new ArrayList<Powers>(),2,new ImageIcon("Data/scorpionface.png"));
        try {
            stillImage = ImageIO.read(getClass().getResource("/Data/scorpion-walk-1.png"));
            punchImage = ImageIO.read(getClass().getResource("/Data/scorpionPunch.png"));
            jumpImage = ImageIO.read(getClass().getResource("/Data/scorpionJump.png"));
            hitImage = ImageIO.read(getClass().getResource("/Data/scorpionHit.png"));

            for (int i = 1; i < 10; i++) {
                walk[i - 1] = ImageIO.read(getClass().getResource("/Data/scorpion-walk-" + i + ".png"));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
