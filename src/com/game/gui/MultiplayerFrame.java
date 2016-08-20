package com.game.gui;

import com.game.arena.*;
import com.game.characters.CurrentCharacter;

import javax.swing.*;

public class MultiplayerFrame extends JFrame{
    private MultiplayerPanel gPanel;

    public MultiplayerFrame(CurrentCharacter a, CurrentArena b, CurrentCharacter c){
        setSize(1280,720);
        setVisible(true);
        setResizable(false);
        gPanel = new MultiplayerPanel(a,b,c,this);
        add(gPanel);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                gPanel.tmrCharacterPrint.stop();
            }
        });
    }
}