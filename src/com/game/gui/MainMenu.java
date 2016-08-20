package com.game.gui;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.sound.sampled.*;

/**
 * Created by mohamedhisham on 4/17/16.
 */
public class MainMenu extends JFrame {

    public static boolean prevCreated = false;
    private JLabel back = new JLabel(new ImageIcon("Data/back1.jpg"));
    private JLabel lblMultiplayer = new JLabel();
    private JLabel lblSinglePlayer = new JLabel();
    private JLabel lblCredits = new JLabel();
    private JLabel lblExitGame = new JLabel();
    private JLabel rules = new JLabel();
    private JLabel labels = new JLabel();
    public static Clip clip1 ;
    public static File file;
    public  static File file1;
    public static Clip clip;


    public static MainMenu createMainMenu(){
        if (!prevCreated){
            prevCreated = true;
            return new MainMenu();
        } else {
            return null;
        }
    }

    private MainMenu(){
        initializeMainMenu();
    }

    private void initializeMainMenu(){
        setTitle("Fight Club");
        setSize(1280,720);
        setBackground(Color.GRAY);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        back.setSize(1280,720);
        back.setLayout(null);
        back.setVisible(true);
        setResizable(true);
        Container c = getContentPane();
        labels.setBounds(0,200,640,400);
        labels.setLayout(new GridLayout(5,1));

        labels.add(lblSinglePlayer);
        labels.add(lblMultiplayer);
        labels.add(lblCredits);
        labels.add(rules);
        labels.add(lblExitGame);
        back.add(labels);
        c.add(back);

        try {
            file = new File("Data/track.wav");
            clip1 = AudioSystem.getClip();
            clip1.open(AudioSystem.getAudioInputStream(file));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            file1 = new File("Data/rules.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file1));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        lblMultiplayer.setIcon(new ImageIcon("Data/singleplayer11.png"));
        lblSinglePlayer.setIcon(new ImageIcon("Data/tounament11.png"));
        lblCredits.setIcon(new ImageIcon("Data/cridets11.png"));
        rules.setIcon(new ImageIcon("Data/rules.png"));
        lblExitGame.setIcon(new ImageIcon("Data/exitgame11.png"));
        lblMultiplayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MultiplayerCreator g = new MultiplayerCreator();
                g.setVisible(true);
                if (clip1.isRunning())
                    clip1.stop();
                else
                    clip1.start();


            }
            @Override
            public void mouseEntered (MouseEvent a){

                lblMultiplayer.setIcon(new ImageIcon("Data/singleplayer22.png"));
            }
            @Override
            public void mouseExited (MouseEvent a){
                lblMultiplayer.setIcon(new ImageIcon("Data/singleplayer11.png"));
            }
        });

        lblSinglePlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                SinglePlayerCreator g = new SinglePlayerCreator();
                g.setVisible(true);
                clip1.start();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                lblSinglePlayer.setIcon(new ImageIcon("Data/tournament22.png"));

            }
            public void mouseExited (MouseEvent a){
                lblSinglePlayer.setIcon(new ImageIcon("Data/tounament11.png"));
            }


        });
        lblCredits.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblCredits.setIcon(new ImageIcon("Data/cridets22.png"));
            }
            public void mouseExited(MouseEvent e) {
                lblCredits.setIcon(new ImageIcon("Data/cridets11.png"));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                Credits crd = new Credits();
                crd.setVisible(true);

            }
        });

        lblExitGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
            public void mouseEntered(MouseEvent e) {
                lblExitGame.setIcon(new ImageIcon("Data/exitgame22.png"));
            }
            public void mouseExited(MouseEvent e) {
                lblExitGame.setIcon(new ImageIcon("Data/exitgame11.png"));
            }


        });
        rules.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {rules.setIcon(new ImageIcon("Data/rules2.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                rules.setIcon(new ImageIcon("Data/rules.png"));
            }
            public void mouseClicked(MouseEvent e) {
                // playrules();
                if (clip.isRunning())
                    clip.stop();
                else
                    clip.start();


            }
        });

    }




}



