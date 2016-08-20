package com.game;

import com.game.gui.MainMenu;

import javax.swing.*;

/**
 * Created by mohamedsherif on 4/12/16.
 */
public class Main {
    public static void main(String[] args) {
        MainMenu main = MainMenu.createMainMenu();
        try{
            main.setVisible(true);
        } catch (NullPointerException e){
            JOptionPane.showConfirmDialog(null,null,"Error Game is Already Running",JOptionPane.OK_CANCEL_OPTION);
        }

    }
}
