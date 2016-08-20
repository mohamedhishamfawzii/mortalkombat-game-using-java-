package com.game.characters;

import com.game.powers.Powers;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;

public abstract class Character{
    protected int health;
    protected ArrayList<Powers> power;
    protected int xp;
    protected ImageIcon faceIcon;
    private static Vector<String> characters = new Vector<String>();


    protected BufferedImage stillImage;
    protected BufferedImage jumpImage;
    protected BufferedImage punchImage;
    protected BufferedImage hitImage;
    protected Rectangle rect;


    protected BufferedImage[] walk;


    public Character(int health, ArrayList<Powers> power, int xp, ImageIcon icon) {
        walk = new BufferedImage[9];
        this.health = health;
        this.power = power;
        this.xp = xp;
        this.faceIcon = icon;
    }

    public BufferedImage getHitImage() {
        return hitImage;
    }

    public void setHitImage(BufferedImage hitImage) {
        this.hitImage = hitImage;
    }

    public BufferedImage getStillImage() {
        return stillImage;
    }

    public void setStillImage(BufferedImage stillImage) {
        this.stillImage = stillImage;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public BufferedImage[] getWalk() {
        return walk;
    }

    public void setWalk(BufferedImage[] walk) {
        this.walk = walk;
    }

    public BufferedImage getPunchImage() {
        return punchImage;
    }

    public BufferedImage getJumpImage(){
        return jumpImage;
    }

    public static Vector<String> getCharacters() {
        characters.add("Sub Zero");
        characters.add("Scorpion");
        characters.add("Jax");
        characters.add("Sonya");
        characters.add("LiuKang");

        return characters;
    }

    public ImageIcon getFaceIcon(){
        return faceIcon;
    }

}
