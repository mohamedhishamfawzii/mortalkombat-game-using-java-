package com.game.characters;

import com.game.powers.Powers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mohamedhisham on 4/15/16.
 */
public class JaxFLIPPED extends Character {

    public JaxFLIPPED() {
        super(1800,new ArrayList<Powers>(),6,new ImageIcon("Data/jaxface.png"));
        try {
            stillImage = ImageIO.read(getClass().getResource("/Data/jax-walk-1FLIPPED.png"));
            punchImage = ImageIO.read(getClass().getResource("/Data/jaxPunchFLIPPED.png"));
            jumpImage = ImageIO.read(getClass().getResource("/Data/jaxJumpFLIPPED.png"));
            hitImage = ImageIO.read(getClass().getResource("/Data/jaxHitFLIPPED.png"));

            for (int i = 1; i < 10; i++) {
                walk[i - 1] = ImageIO.read(getClass().getResource("/Data/jax-walk-" + i + "FLIPPED.png"));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
