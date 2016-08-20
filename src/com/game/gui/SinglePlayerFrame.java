package com.game.gui;

import com.game.arena.CurrentArena;
import com.game.characters.CurrentCharacter;

import javax.swing.*;

/**
 * Created by mohamedsherif on 5/1/16.
 */
public class SinglePlayerFrame extends JFrame {
    private CurrentArena crntArena;
    private CurrentCharacter crntCharacter;
    public static int noOfMatches;
    SinglePlayerPanel singlePlayerPanel;

    public SinglePlayerFrame(CurrentCharacter cc, CurrentArena ca, CurrentCharacter cc1, int difficulty){
        noOfMatches = noOfMatches - 1;
        this.crntArena = ca;
        this.crntCharacter = cc;
        setSize(1280,720);
        setVisible(true);
        setResizable(false);
        singlePlayerPanel = new SinglePlayerPanel(crntCharacter,crntArena,cc1,this,difficulty);
        add(singlePlayerPanel);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                singlePlayerPanel.tmrCharacterPrint.stop();
            }
        });
    }



    /*public void nextMatch(CurrentCharacter cc, CurrentArena ca, CurrentCharacter cc1){
        if(noOfMatches > 0){
            dispose();
            new SinglePlayerFrame(cc,ca,cc1);
        }else{
            singlePlayerPanel.tmrCharacterPrint.stop();
            dispose();

            //JOptionPane.showMessageDialog(null, "Tournament Ended", "Tournament", JOptionPane.WARNING_MESSAGE);
        }
    }*/
}
