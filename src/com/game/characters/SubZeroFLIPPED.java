package com.game.characters;

import com.game.powers.Powers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mohamedsherif on 4/12/16.
 */
public class SubZeroFLIPPED extends Character {

    public SubZeroFLIPPED(){
        super(2000,new ArrayList<Powers>(),0,new ImageIcon("Data/subzeroface.png"));
        try {
            stillImage = ImageIO.read(getClass().getResource("/Data/walk-1FLIPPED.png"));
            punchImage = ImageIO.read(getClass().getResource("/Data/subzeroPunchFLIPPED.png"));
            jumpImage = ImageIO.read(getClass().getResource("/Data/jumpFLIPPED.png"));
            hitImage = ImageIO.read(getClass().getResource("/Data/subzeroHitFLIPPED.png"));

            for (int i = 1; i < 10; i++) {
                walk[i - 1] = ImageIO.read(getClass().getResource("/Data/walk-" + i + "FLIPPED.png"));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
