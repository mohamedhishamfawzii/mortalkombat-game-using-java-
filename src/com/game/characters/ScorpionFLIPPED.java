package com.game.characters;

import com.game.powers.Powers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mohamedsherif on 4/12/16.
 */
public class ScorpionFLIPPED extends Character {

    public ScorpionFLIPPED(){
        super(1800,new ArrayList<Powers>(),2,new ImageIcon("Data/scorpionface.png"));
        try {
            stillImage = ImageIO.read(getClass().getResource("/Data/scorpion-walk-1FLIPPED.png"));
            punchImage = ImageIO.read(getClass().getResource("/Data/scorpionPunchFLIPPED.png"));
            jumpImage = ImageIO.read(getClass().getResource("/Data/scorpionJumpFLIPPED.png"));
            hitImage = ImageIO.read(getClass().getResource("/Data/scorpionHitFLIPPED.png"));

            for (int i = 1; i < 10; i++) {
                walk[i - 1] = ImageIO.read(getClass().getResource("/Data/scorpion-walk-" + i + "FLIPPED.png"));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
