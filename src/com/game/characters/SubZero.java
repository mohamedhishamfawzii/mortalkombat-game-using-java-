package com.game.characters;

import com.game.powers.Powers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mohamedsherif on 4/12/16.
 */
public class SubZero extends Character {

    public SubZero(){
        super(2000,new ArrayList<Powers>(),0,new ImageIcon("Data/subzeroface.png"));
        try {
            stillImage = ImageIO.read(getClass().getResource("/Data/walk-1.png"));
            punchImage = ImageIO.read(getClass().getResource("/Data/subzeroPunch.png"));
            jumpImage = ImageIO.read(getClass().getResource("/Data/jump.png"));
            hitImage = ImageIO.read(getClass().getResource("/Data/subzeroHit.png"));

            for (int i = 1; i < 10; i++) {
                walk[i - 1] = ImageIO.read(getClass().getResource("/Data/walk-" + i + ".png"));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
