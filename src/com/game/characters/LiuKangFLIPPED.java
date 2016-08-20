package com.game.characters;

import com.game.powers.Powers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class LiuKangFLIPPED extends Character {

    public LiuKangFLIPPED(){
        super(2500,new ArrayList<Powers>(),1,new ImageIcon("Data/liukangface.png"));
        try {
            stillImage = ImageIO.read(getClass().getResource("/Data/Liu Kang-walk-1FLIPPED.png"));
            punchImage = ImageIO.read(getClass().getResource("/Data/liukangPunchFLIPPED.png"));
            jumpImage = ImageIO.read(getClass().getResource("/Data/liukangJumpFLIPPED.png"));
            hitImage = ImageIO.read(getClass().getResource("/Data/liukangHitFlipped.png"));

            for (int i = 1; i < 9; i++) {
                walk[i - 1] = ImageIO.read(getClass().getResource("/Data/Liu Kang-walk-" + i + "FLIPPED.png"));
            }
            walk[8] = ImageIO.read(getClass().getResource("/Data/Liu Kang-walk-8FLIPPED.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
