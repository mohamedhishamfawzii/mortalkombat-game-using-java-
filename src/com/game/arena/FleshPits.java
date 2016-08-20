package com.game.arena;

import javax.swing.*;

/**
 * Created by mohamedsherif on 4/15/16.
 */
public class FleshPits extends Arena {

    public FleshPits(){
        super("Data/FleshPits.png");
    }

    @Override
    public JPanel setArena(){
        return this;
    }
}
