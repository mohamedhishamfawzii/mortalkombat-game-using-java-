package com.game.characters;

import com.game.powers.Powers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mohamedhisham on 4/15/16.
 */
public class Jax extends Character {

    public Jax() {
        super(1800,new ArrayList<Powers>(),6,new ImageIcon("Data/jaxface.png"));
        try {
            stillImage = ImageIO.read(getClass().getResource("/Data/jax-walk-1.png"));
            punchImage = ImageIO.read(getClass().getResource("/Data/jaxPunch.png"));
            jumpImage = ImageIO.read(getClass().getResource("/Data/jaxJump.png"));
            hitImage = ImageIO.read(getClass().getResource("/Data/jaxHit.png"));


            for (int i = 1; i < 10; i++) {
                walk[i - 1] = ImageIO.read(getClass().getResource("/Data/jax-walk-" + i + ".png"));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
