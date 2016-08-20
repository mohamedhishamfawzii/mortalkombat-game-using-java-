package com.game.arena;

import javax.swing.*;

/**
 * Created by mohamedsherif on 4/15/16.
 */
public class Training extends Arena{
    public Training(){
        super("Data/Training.png");
    }
    @Override
    public JPanel setArena(){
        return this;
    }
}
