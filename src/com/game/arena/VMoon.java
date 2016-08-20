package com.game.arena;

import javax.swing.*;

/**
 * Created by mohamedsherif on 4/15/16.
 */
public class VMoon extends Arena{
    public VMoon(){
        super("Data/VMoon.jpg");
    }
    @Override
    public JPanel setArena(){
        return this;
    }
}
