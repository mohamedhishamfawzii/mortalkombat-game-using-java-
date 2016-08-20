package com.game.player;

import com.game.characters.*;
import com.game.characters.Character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.ListIterator;

/**
 * Created by mohamedsherif on 4/17/16.
 */
public class Player {
    private static final int WALK_SPEED=2;
    private static final int FRAME_CHANGE=6;


    private String playerName;
    private int playerHealth = 100;
    private int posX = 100;
    private int posY = 300;
    private int jump_count=0;
    private boolean isHit =false;
    private boolean hitAgain =true;


    public Rectangle rect;

    public boolean jumping=false;
    public boolean jumpAgain=true;

    private Character playerCharacter;
    private BufferedImage crntImage ;
    private CurrentState state = CurrentState.STILL;
    private boolean isFlipped;
    public int jumpHeight = 0;

    private int currentFrameNumber;
    private int moveCounter=0;

    public Player(CurrentCharacter a,boolean isFlipped){
        this.isFlipped = isFlipped;
        initializeVars(a);
        if(isFlipped){
            posX = 900;
        }else{
        }
        crntImage = playerCharacter.getStillImage();
        rect = new Rectangle(posX,posY,crntImage.getWidth(),crntImage.getHeight());
    }

    private void setFrameNumber() {
        currentFrameNumber  = moveCounter/FRAME_CHANGE;
        currentFrameNumber %= 9;

        if(moveCounter>FRAME_CHANGE*9){
            moveCounter=0;
        }

        if(moveCounter<0){
            moveCounter=FRAME_CHANGE*9;
        }
    }
    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public void updateRect(){
        rect.setBounds(posX,posY,crntImage.getWidth(),crntImage.getHeight());
    }


    public void player1MoveForward(){
        posX=posX+ WALK_SPEED;
        updateRect();
        if(!jumping) {
            setFrameNumber();
            crntImage = playerCharacter.getWalk()[currentFrameNumber];
            moveCounter++;
        }
    }

    public void player1MoveBackward(){
        posX=posX- WALK_SPEED;
        updateRect();
        if(!jumping) {
            setFrameNumber();
            crntImage = playerCharacter.getWalk()[currentFrameNumber];
            moveCounter--;
        }
    }
    public void player2MoveForward(){
        posX=posX- WALK_SPEED;
        updateRect();
        if(!jumping) {
            setFrameNumber();
            crntImage = playerCharacter.getWalk()[8-currentFrameNumber];
            moveCounter--;
        }
    }

    public void player2MoveBackward(){
        posX=posX+ WALK_SPEED;
        updateRect();
        if(!jumping) {
            setFrameNumber();
            crntImage = playerCharacter.getWalk()[8-currentFrameNumber];
            moveCounter++;
        }
    }
    public void punch(){
        crntImage = playerCharacter.getPunchImage();
    }
    public void doJump(){
        if(!jumping && jumpAgain) {
            jump();
        }
    }

    public void stop() {
        isHit=false;
        crntImage = playerCharacter.getStillImage();
    }

    public boolean isHit() {
        return isHit;
    }

    public void hit(){
        crntImage=playerCharacter.getHitImage();
        isHit=true;
        hitAgain=false;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public boolean isHitAgain() {
        return hitAgain;
    }

    public void setHitAgain(boolean hitAgain) {
        this.hitAgain = hitAgain;
    }

    public void checkJump(){
        if(jumping) {
            jumpAgain = false;
            crntImage=playerCharacter.getJumpImage();
            if (jump_count < 30) {
                posY -= 6;
                updateRect();
            } else {
                posY += 6;
                updateRect();
            }

            jump_count++;

            if (jump_count >= 60) {
                jumping = false;
                crntImage=playerCharacter.getStillImage();
                jump_count = 0;
            }
        }
    }



    public BufferedImage getCrntImage() {
        return crntImage;
    }

    public void setCrntImage(BufferedImage crntImage) {
        this.crntImage = crntImage;
    }

    public Rectangle getRect() {
        return rect;
    }

    private void jump(){
        this.jumping=true;
        this.jump_count=0;
    }

    private void initializeVars(CurrentCharacter a){
        if(isFlipped){
            switch (a){
                case SCORPION:
                    playerCharacter = new ScorpionFLIPPED();
                    break;
                case SUBZERO:
                    playerCharacter = new SubZeroFLIPPED();
                    break;
                case JAX:
                    playerCharacter = new JaxFLIPPED();
                    break;
                case LIUKANG:
                    playerCharacter = new LiuKangFLIPPED();
                    break;
                case SONYA:
                    playerCharacter = new SonyaFLIPPED();
                    break;
            }
        }
        else{
            switch (a){
                case SCORPION:
                    playerCharacter = new Scorpion();
                    break;
                case SUBZERO:
                    playerCharacter = new SubZero();
                    break;
                case JAX:
                    playerCharacter = new Jax();
                    break;
                case LIUKANG:
                    playerCharacter = new LiuKang();
                    break;
                case SONYA:
                    playerCharacter = new Sonya();
                    break;
             }
        }
    }

    public ImageIcon getCharacterFace(){
        return playerCharacter.getFaceIcon();
    }

    public ImageIcon healthbarUpdater (){
        if (playerHealth <= 90 && playerHealth >= 80 )
            return new ImageIcon("Data/healthbar9080.png");
        else if (playerHealth < 80 && playerHealth >= 50 )
            return new ImageIcon("Data/healthbar706050.png");
        else if (playerHealth < 50 && playerHealth >= 30 )
            return new ImageIcon("Data/healthbar4030.png");
        else if (playerHealth < 30 && playerHealth >= 10 )
            return new ImageIcon("Data/healthbar2010.png");
        else if (playerHealth < 10 && playerHealth >= 0 )
            return new ImageIcon("Data/healthbar0.png");
        return new ImageIcon("Data/healthbar100.png");
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX += posX;
    }

    public int getPlayerHealth() {
        return this.playerHealth;
    }
    public  void setPlayerHealth(int h) {
        this.playerHealth= h ;
    }



    /*public boolean intersects( Player p) {
        return (((p.posX-170>= this.posX) && (p.posX -170 < (this.posX -170 + this.PLAYER_WIDTH+120))) || ((this.posX-170 >= p.posX-170) && (this.posX-170 < (p.posX-170+ p.PLAYER_WIDTH+120)))) &&
                (((p.posY >= this.posY) && (p.posY < (this.posY + this.PLAYER_HEIGHT-300))) || ((this.posY >= p.posY) && (this.posY < (p.posY + p.PLAYER_HEIGHT-300))));
    }*/

    public boolean intersects(Player p){
        return (rect.intersects(p.getRect()));
    }
}

