package com.game.arena;

import javax.swing.*;

/**
 * Created by mohamedsherif on 4/12/16.
 */
public class Soul extends Arena {
    public Soul(){
        super("Data/soul.jpg");
    }

    @Override
    public JPanel setArena(){
        return this;
    }
}
