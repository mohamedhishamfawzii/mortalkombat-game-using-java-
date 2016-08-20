package com.game.gui;

import com.game.arena.Arena;
import com.game.arena.CurrentArena;
import com.game.characters.Character;
import com.game.characters.CurrentCharacter;

import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;

public class MultiplayerCreator extends JFrame {
    protected String playerName;
    protected JLabel back2 = new JLabel(new ImageIcon("Data/BACK2.png"));
    Vector<String> characters = new Vector<String>();



    protected JComboBox<String> arenaOptions = new JComboBox<String>(Arena.getArenas());
    protected JComboBox<String> charactersOptions = new JComboBox<String>(Character.getCharacters());
    protected JComboBox<String> characters2Options = new JComboBox<String>(Character.getCharacters());
    protected JComboBox<String> characters3Options;

    protected JLabel btnStart = new JLabel(new ImageIcon("Data/start.png"));
    protected JLabel back = new JLabel(new ImageIcon("Data/BACK.png"));


    protected CurrentArena ca = CurrentArena.SOUL;
    protected CurrentCharacter cc = CurrentCharacter.SUBZERO;
    protected CurrentCharacter aa =  CurrentCharacter.SUBZERO;

     public MultiplayerCreator(){
        initializeGC();
         addWindowListener(new java.awt.event.WindowAdapter() {
             @Override
             public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                 MainMenu.clip1.stop();
             }
         });
    }

    public void initializeGC() {

        setBounds(390, 185, 500, 350);

        setResizable(false);
        back.setLayout(null);
        back.add(charactersOptions);
        charactersOptions.setBounds(250, 100, 200, 20);
        back.add(characters2Options);
        characters2Options.setBounds(250, 50, 200, 20);
        back.add(arenaOptions);
        arenaOptions.setBounds(250, 150, 200, 20);
        back.add(btnStart);
        btnStart.setBounds(150, 250, 200, 50);
        add(back);

        arenaOptions.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    JComboBox s = (JComboBox) e.getSource();
                    if (((String) s.getSelectedItem()).equals("Soul")) {
                        ca = CurrentArena.SOUL;
                    } else if (((String) s.getSelectedItem()).equals("VMoon")) {
                        ca = CurrentArena.VMOON;
                    } else if (((String) s.getSelectedItem()).equals("Training")) {
                        ca = CurrentArena.TRAINING;
                    } else {
                        ca = CurrentArena.FLESHPITS;
                    }
                }
            }
        });
        charactersOptions.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    JComboBox s = (JComboBox) e.getSource();
                    if (((String) s.getSelectedItem()).equals("Soul")) {
                        cc = CurrentCharacter.SUBZERO;
                    } else if (((String) s.getSelectedItem()).equals("Scorpion")) {
                        cc = CurrentCharacter.SCORPION;
                    } else if (((String) s.getSelectedItem()).equals("LiuKang")) {
                        cc = CurrentCharacter.LIUKANG;
                    } else if (((String) s.getSelectedItem()).equals("Sonya")) {
                        cc = CurrentCharacter.SONYA;
                    } else if (((String) s.getSelectedItem()).equals("Jax")) {
                        cc = CurrentCharacter.JAX;
                    }
                }
            }
        });
        characters2Options.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    JComboBox s = (JComboBox) e.getSource();
                    if (((String) s.getSelectedItem()).equals("Soul")) {
                        aa = CurrentCharacter.SUBZERO;
                    } else if (((String) s.getSelectedItem()).equals("Scorpion")) {
                        aa = CurrentCharacter.SCORPION;
                    } else if (((String) s.getSelectedItem()).equals("LiuKang")) {
                        aa = CurrentCharacter.LIUKANG;
                    } else if (((String) s.getSelectedItem()).equals("Sonya")) {
                        aa = CurrentCharacter.SONYA;
                    } else if (((String) s.getSelectedItem()).equals("Jax")) {
                        aa = CurrentCharacter.JAX;
                    }
                }
            }
        });
        btnStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new MultiplayerFrame(aa,ca,cc);
            }


            @Override
            public void mouseEntered(MouseEvent e) {

             btnStart.setIcon (new ImageIcon("Data/start2.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnStart.setIcon (new ImageIcon("Data/start.png"));
            }
        });
    }}
