package com.game.gui;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * Created by mohamedhisham on 5/7/16.
 */
public class Credits extends JFrame {

    private JLabel shr ;
    private JLabel man ;
    private JLabel hish ;
    private JLabel back ;
    public Credits(){
        this.setSize(1280,720);
        back = new JLabel(new ImageIcon("Data/back.jpg"));
        back.setLayout(new GridLayout(4,1) );
        back.setSize(1280,720);
        back.setVisible(true);
        shr = new JLabel(new ImageIcon("Data/SHR.png"));
        man = new JLabel(new ImageIcon("Data/MAN.png"));
        hish = new JLabel(new ImageIcon("Data/HISH.png"));
        back.add(shr);
        back.add(man);
        back.add(hish);
        this.add(back);
        shr.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                shr.setIcon(new ImageIcon("Data/SHR1.png"));
            }
            public void mouseExited(MouseEvent e) {
                shr.setIcon(new ImageIcon("Data/SHR.png"));

            }
        });
        man.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                man.setIcon(new ImageIcon("Data/MAN1.png"));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                man.setIcon(new ImageIcon("Data/MAN.png"));
            }
        });

        hish.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hish.setIcon(new ImageIcon("Data/HISH1.png"));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                hish.setIcon(new ImageIcon("Data/HISH.png"));
            }
        });
        play();
    }
    public static void play() {
        try {
            File file = new File("Data/credits.wav");
            Clip clip1 = AudioSystem.getClip();
            clip1.open(AudioSystem.getAudioInputStream(file));
            clip1.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
