package com.game.gui;

import com.game.arena.*;
import com.game.characters.CurrentCharacter;
import com.game.player.Player;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.HashSet;


/**
 * Created by yoman on 4/16/2016.
 */

public class MultiplayerPanel extends JPanel implements KeyListener{
    protected Player player1;
    protected Player player2;
    private Arena crtArena;
    protected JFrame ParentFrame;
    private JLabel lblHealthBar1 = new JLabel();
    private JLabel lblCharacterIcon1 = new JLabel();

    private JLabel lblHealthBar2 = new JLabel();
    private JLabel lblCharacterIcon2 = new JLabel();
    public  HashSet<Integer> keys = new HashSet<Integer>();

    public MultiplayerPanel(CurrentCharacter a, CurrentArena ar, CurrentCharacter b, JFrame ParentFrame) {
        initializeVars(ar);
        this.ParentFrame = ParentFrame;
        player1 = new Player(a,false);
        player2 = new Player(b,true);
        setLayout(null);
        crtArena.arenaLabel.setLayout(null);
        lblHealthBar1.setLayout(null);
        lblCharacterIcon1.setIcon(player1.getCharacterFace());
        lblCharacterIcon2.setIcon(player2.getCharacterFace());
        lblHealthBar1.setBounds(20,0,500,60);
        lblCharacterIcon1.setBounds(70,0,100,60);
        lblHealthBar2.setBounds(800,0,500,60);
        lblCharacterIcon2.setBounds(850,0,100,60);
        add(lblCharacterIcon1);
        add(lblHealthBar1);
        add(lblHealthBar2);
        add(lblCharacterIcon2);
        setDoubleBuffered(true);

       // crtArena.arenaLabel.add(lblCharacterIcon1);
        //crtArena.arenaLabel.add(lblHealthBar1);
        this.add(crtArena);
        crtArena.setBounds(0, -5, 1280, 720);
        tmrCharacterPrint.start();
        setFocusable(true);
        addKeyListener(this);
    }

    protected Timer tmrCharacterPrint = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setTmrCharacterPrintListener();
            gameOver();
            manageKeys();
            pcPlayer();
           /* if (player1.intersects(player2)){
                keys.remove(KeyEvent.VK_A);
                keys.remove(KeyEvent.VK_RIGHT);
            }*/
            player1.updateRect();
            player2.updateRect();
            repaint();
        }
    });

    public void pcPlayer(){

    }

    public void manageKeys(){
        player2.checkJump();
        player1.checkJump();


        if (keys.contains(KeyEvent.VK_LEFT)&& !keys.contains(KeyEvent.VK_UP)  && player1.getPosX()>100) {
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
        if (keys.contains(KeyEvent.VK_D)&& !keys.contains(KeyEvent.VK_E)  && player2.getPosX()<900) {
            player2.player2MoveBackward();
        }
        if (keys.contains(KeyEvent.VK_A)&& !keys.contains(KeyEvent.VK_E) && !player1.intersects(player2)) {
            player2.player2MoveForward();
        }
        if (keys.contains(KeyEvent.VK_E) && !player2.jumping) {
            player2.stop();
            player2.punch();
            if(player1.intersects(player2))
                player1.hit();
        }
        if(!keys.contains(KeyEvent.VK_E)){
            player1.setHit(false);
        }
        if (keys.contains(KeyEvent.VK_W)&& !keys.contains(KeyEvent.VK_E)){
            player2.doJump();
        }
        if (!keys.contains(KeyEvent.VK_W)){
            player2.jumpAgain =true;
        }
        if(!keys.contains(KeyEvent.VK_D) && !keys.contains(KeyEvent.VK_A) && !keys.contains(KeyEvent.VK_E ) && !player2.jumping && !player2.isHit()){
            player2.stop();
        }
    }


    protected void setTmrCharacterPrintListener(){
        lblHealthBar1.setIcon(player1.healthbarUpdater());
        lblHealthBar2.setIcon(player2.healthbarUpdater());
    }

    protected void gameOver(){
        if(player2.getPlayerHealth() <=0){
            JOptionPane.showMessageDialog(null, "GAME OVER\nPlayer 1 Wins", "Game Over", JOptionPane.WARNING_MESSAGE);
            tmrCharacterPrint.stop();

            ParentFrame.dispose();
        }else if(player1.getPlayerHealth()<=0){
            JOptionPane.showMessageDialog(null, "GAME OVER\nPlayer 2 Wins", "Game Over", JOptionPane.WARNING_MESSAGE);
            ParentFrame.dispose();
            tmrCharacterPrint.stop();
        }
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(player1.getCrntImage(),player1.getPosX(),player1.getPosY(),null);
        g2.drawImage(player2.getCrntImage(),player2.getPosX(),player2.getPosY(),null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            keys.add(KeyEvent.VK_RIGHT);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            keys.add(KeyEvent.VK_LEFT);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            keys.add(KeyEvent.VK_SPACE);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            keys.add(KeyEvent.VK_UP);
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            keys.add(KeyEvent.VK_D);
        }
        if(e.getKeyCode() == KeyEvent.VK_A) {
            keys.add(KeyEvent.VK_A);
        }
        if (e.getKeyCode() == KeyEvent.VK_W){
            keys.add(KeyEvent.VK_W);
        }
        if (e.getKeyCode() == KeyEvent.VK_E){
            keys.add(KeyEvent.VK_E);

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            keys.remove(KeyEvent.VK_SPACE);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            keys.remove(KeyEvent.VK_RIGHT);

        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            keys.remove(KeyEvent.VK_LEFT);

        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            keys.remove(KeyEvent.VK_UP);
            if (player1.intersects(player2)){
                playPunch();
                player2.setPlayerHealth(player2.getPlayerHealth()-10);
                //player2.hit();
        }}
        if (e.getKeyCode() == KeyEvent.VK_E){
            keys.remove(KeyEvent.VK_E);
            if (player1.intersects(player2)) {
                playPunch();
                player1.setPlayerHealth(player1.getPlayerHealth() - 10);
                //player1.hit();

            }
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            keys.remove(KeyEvent.VK_A);

        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            keys.remove(KeyEvent.VK_W);
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            keys.remove(KeyEvent.VK_D);


        }
    }

    private void initializeVars(CurrentArena aa){
        switch (aa){
            case SOUL:
                this.crtArena = new Soul();
                break;
            case VMOON:
                this.crtArena = new VMoon();
                break;
            case FLESHPITS:
                this.crtArena = new FleshPits();
                break;
            case TRAINING:
                this.crtArena = new Training();
                break;
        }
    }
    public static void playPunch() {
        try {
            File file = new File("Data/PUNCH.wav");
            Clip clip1 = AudioSystem.getClip();
            clip1.open(AudioSystem.getAudioInputStream(file));
            clip1.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static void playjump() {
        try {
            File file = new File("Data/PUNCH.wav");
            Clip clip1 = AudioSystem.getClip();
            clip1.open(AudioSystem.getAudioInputStream(file));
            clip1.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}