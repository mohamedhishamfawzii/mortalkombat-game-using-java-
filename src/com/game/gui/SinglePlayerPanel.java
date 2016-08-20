package com.game.gui;

import com.game.arena.CurrentArena;
import com.game.characters.CurrentCharacter;
import com.game.player.Player;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * Created by mohamedsherif on 5/1/16.
 */
public class SinglePlayerPanel extends MultiplayerPanel {
    SinglePlayerFrame tf;
    CurrentArena ca;
    CurrentCharacter cc;
    private int PCToggle =0;
    private boolean playsound = true;
    private int damage;


    public SinglePlayerPanel(CurrentCharacter player1, CurrentArena ca, CurrentCharacter player2 , SinglePlayerFrame ParentFrame, int difficulty){
        super(player1,ca,player2,ParentFrame);
        this.ca = ca;
        this.cc = player1;
        super.player2 = new Player(player2,true);
        tf = ParentFrame;
        if(difficulty==0)
            damage=1;
        else if(difficulty==1)
            damage=3;
        else if(difficulty==3)
            damage=5;
    }

    @Override
    protected void gameOver(){
        if(player2.getPlayerHealth() <=0){
            JOptionPane.showMessageDialog(null, "GAME OVER\nYou Win!", "Game Over", JOptionPane.WARNING_MESSAGE);
            tmrCharacterPrint.stop();
            ParentFrame.dispose();
            //tf.nextMatch(cc,ca,randCharacter());
            //System.exit(0);
        }else if(player1.getPlayerHealth()<=0){
            JOptionPane.showMessageDialog(null, "GAME OVER\nPC Wins", "Game Over", JOptionPane.WARNING_MESSAGE);
            //tf.nextMatch(cc,ca,randCharacter());
            tmrCharacterPrint.stop();
            ParentFrame.dispose();
            //System.exit(0);
        }
    }

    public CurrentCharacter randCharacter(){
        Random r = new Random();
        switch (r.nextInt()%5){
            case 0:
                return CurrentCharacter.JAX;
            case 1:
                return CurrentCharacter.LIUKANG;
            case 2:
                return CurrentCharacter.SCORPION;
            case 3:
                return CurrentCharacter.SONYA;
            case 4:
                return CurrentCharacter.SUBZERO;
        }
        return CurrentCharacter.SUBZERO;
    }

    @Override
    public void manageKeys() {
        player2.checkJump();
        player1.checkJump();


        if (keys.contains(KeyEvent.VK_LEFT)&& !keys.contains(KeyEvent.VK_UP) && player1.getPosX()>0) {
            player1.player1MoveBackward();
        }
        if (keys.contains(KeyEvent.VK_RIGHT)&& !keys.contains(KeyEvent.VK_UP) && !player2.intersects(player1)) {
            player1.player1MoveForward();
        }
        if (keys.contains(KeyEvent.VK_UP) && !player1.jumping) {
            player1.stop();
            player1.punch();
            if(player2.intersects(player1))
                player2.hit();
        }
        if(!keys.contains(KeyEvent.VK_UP)){
            player2.setHit(false);
        }
        if (keys.contains(KeyEvent.VK_SPACE) && !keys.contains(KeyEvent.VK_UP)){
            player1.doJump();
        }
        if (!keys.contains(KeyEvent.VK_SPACE)){
            player1.jumpAgain =true;
        }
        if(!keys.contains(KeyEvent.VK_LEFT) && !keys.contains(KeyEvent.VK_RIGHT) && !keys.contains(KeyEvent.VK_UP ) && !player1.jumping && !player1.isHit()){
            player1.stop();
        }
    }


    public void pcPlayer(){
        if(PCToggle <= 3){
            if(player2.intersects(player1)){
                player2.stop();
                player2.punch();
                player1.hit();
                player1.setPlayerHealth(player1.getPlayerHealth()-damage);
                if(playsound){
                    playPunch();
                    playsound=false;
                }
               // player2.moveForward();
                PCToggle++;
            }else {
                playsound = true;
                player2.player2MoveForward();
            }
        }
        else if (PCToggle >3){
            player2.player2MoveBackward();
            if(player2.getPosX()>=900){
                PCToggle=0;
            }
        }
    }
}
