package com.game.characters;

import com.game.powers.Powers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mohamedhisham on 4/15/16.
 */
public class SonyaFLIPPED extends Character {
    public SonyaFLIPPED(){
        super(2000,new ArrayList<Powers>(),3,new ImageIcon("Data/sonyaface.png"));
        try {
            stillImage = ImageIO.read(getClass().getResource("/Data/sonya-walk-1FLIPPED.png"));
            punchImage = ImageIO.read(getClass().getResource("/Data/sonyaPunchFLIPPED.png"));
            jumpImage = ImageIO.read(getClass().getResource("/Data/sonyaJumpFLIPPED.png"));
            hitImage = ImageIO.read(getClass().getResource("/Data/sonyaHitFLIPPED.png"));

            for (int i = 1; i < 10; i++) {
                walk[i - 1] = ImageIO.read(getClass().getResource("/Data/sonya-walk-" + i + "FLIPPED.png"));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
