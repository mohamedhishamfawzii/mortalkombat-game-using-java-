package com.game.characters;

import com.game.powers.Powers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mohamedhisham on 4/15/16.
 */
public class Sonya extends Character {
    public Sonya(){
        super(2000,new ArrayList<Powers>(),3,new ImageIcon("Data/sonyaface.png"));
        try {
            stillImage = ImageIO.read(getClass().getResource("/Data/sonya-walk-1.png"));
            punchImage = ImageIO.read(getClass().getResource("/Data/sonyaPunch.png"));
            jumpImage = ImageIO.read(getClass().getResource("/Data/sonyaJump.png"));
            hitImage = ImageIO.read(getClass().getResource("/Data/sonyaHit.png"));


            for (int i = 1; i < 10; i++) {
                walk[i - 1] = ImageIO.read(getClass().getResource("/Data/sonya-walk-" + i + ".png"));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
