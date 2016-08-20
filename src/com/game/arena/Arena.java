package com.game.arena;

import javax.swing.*;
import java.util.Vector;

/**
 * Created by mohamedsherif on 4/12/16.
 */
public abstract class Arena extends JPanel {
    protected String fileName;
    protected ImageIcon arenaIcon;
    public JLabel arenaLabel;
    private static Vector<String> arenas;

    protected Arena(String fileName){
        this.fileName = fileName;
        this.arenaIcon = new ImageIcon(this.fileName);
        arenaLabel = new JLabel(arenaIcon);
        add(arenaLabel);
    }

    public abstract JPanel setArena();

    public JLabel getArenaLabel() {
        return arenaLabel;
    }

    private static void initializeArenas(){
        arenas = new Vector<String>();
        arenas.add("Soul");
        arenas.add("VMoon");
        arenas.add("Training");
        arenas.add("FleshPits");
    }

    public static Vector<String> getArenas(){
        initializeArenas();
        return arenas;
    }
}
