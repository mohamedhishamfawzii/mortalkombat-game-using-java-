package com.game.gui;

import com.game.arena.Arena;
import com.game.arena.CurrentArena;
import com.game.characters.Character;
import com.game.characters.CurrentCharacter;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Vector;

/**
 * Created by mohamedsherif on 5/1/16.
 */
public class SinglePlayerCreator extends MultiplayerCreator {
    protected JComboBox<String> difficultyOptions;
    private int difficulty;

    @Override
    public void initializeGC() {
        characters.add("Sub Zero");
        characters.add("Scorpion");
        characters.add("Jax");
        characters.add("Sonya");
        characters.add("LiuKang");
        characters3Options = new JComboBox<>(characters);
        Vector<String> difficulties = new Vector<String>();
        difficulties.add("Easy");
        difficulties.add("Medium");
        difficulties.add("Hard");
        difficultyOptions = new JComboBox<String>(difficulties);
        setBounds(390, 185, 500, 350);

        setResizable(false);
        back2.setLayout(null);
        back2.add(characters3Options);
        characters3Options.setBounds(250, 100, 200, 20);
        back2.add(difficultyOptions);
        difficultyOptions.setBounds(250, 50, 200, 20);
        back2.add(arenaOptions);
        arenaOptions.setBounds(250, 150, 200, 20);
        back2.add(btnStart);
        btnStart.setBounds(150, 250, 200, 50);
        add(back2);

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
        characters3Options.addItemListener(new ItemListener() {
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
        /*characters2Options.addItemListener(new ItemListener() {
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
        });*/

        difficultyOptions.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    JComboBox s = (JComboBox) e.getSource();
                    if (((String) s.getSelectedItem()).equals("Easy")) {
                        difficulty = 0;
                    } else if (((String) s.getSelectedItem()).equals("Medium")) {
                        difficulty=1;
                    } else if (((String) s.getSelectedItem()).equals("Hard")) {
                        difficulty=3;
                    }
                }
            }
        });

        btnStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SinglePlayerFrame(cc, ca, randCharacter(),difficulty);
            }


            @Override
            public void mouseEntered(MouseEvent e) {

                btnStart.setIcon(new ImageIcon("Data/start2.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnStart.setIcon(new ImageIcon("Data/start.png"));
            }
        });
    }

    /*  private JLabel lblChooseCharacter = new JLabel("Choose Character");
      private JLabel lblChooseArena = new JLabel("Choose Arena");
      private JLabel lblChooseNumberOfRounds = new JLabel("Choose Number Of Rounds");
      private JLabel lblTournament = new JLabel("Tournament");

      private JComboBox<String> cbxCharacter = new JComboBox<String>(Character.getCharacters());
      private JComboBox<String> cbxArena = new JComboBox<String>(Arena.getArenas());
      private JComboBox<String> cbxRounds = new JComboBox<String>();

      private JButton btnPlay = new JButton("Play");

      private int noOfMatches;

      private CurrentArena ca = CurrentArena.SOUL;
      private CurrentCharacter cc = CurrentCharacter.SUBZERO;
      public SinglePlayerCreator(){
          addWindowListener(new java.awt.event.WindowAdapter() {
              @Override
              public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                  MainMenu.clip1.stop();
              }
          });
          setLayout(null);
          setSize(470,415);
          setVisible(true);
          setResizable(false);
          setTitle("Single Player Mode");
          lblChooseCharacter.setBounds(10,160,300,50);
          lblChooseArena.setBounds(10,220,300,50);
          lblChooseNumberOfRounds.setBounds(10,280,300,50);
          cbxCharacter.setBounds(310,160,150,50);
          cbxArena.setBounds(310,220,150,50);
          cbxRounds.setBounds(310,280,150,50);
          btnPlay.setBounds(335,340,100,50);

          cbxRounds.addItem("2");
          cbxRounds.addItem("3");
          cbxRounds.addItem("4");

          add(lblChooseArena);
          add(lblChooseCharacter);
          add(lblChooseNumberOfRounds);
          add(cbxArena);
          add(cbxCharacter);
          add(cbxRounds);
          add(btnPlay);

          cbxArena.addItemListener(new ItemListener() {
              @Override
              public void itemStateChanged(ItemEvent e) {
                  if(e.getStateChange() == ItemEvent.SELECTED){
                      JComboBox s =(JComboBox) e.getSource();
                      if( ((String)s.getSelectedItem()).equals("Soul") ){
                          ca = CurrentArena.SOUL;
                      }else if( ((String)s.getSelectedItem()).equals("VMoon") ){
                          ca = CurrentArena.VMOON;
                      } else if(((String)s.getSelectedItem()).equals("Training")){
                          ca = CurrentArena.TRAINING;
                      } else {
                          ca = CurrentArena.FLESHPITS;
                      }
                  }
              }
          });

          cbxCharacter.addItemListener(new ItemListener() {
              @Override
              public void itemStateChanged(ItemEvent e) {
                  if (e.getStateChange() == ItemEvent.SELECTED) {
                      JComboBox s = (JComboBox) e.getSource();
                      if (((String) s.getSelectedItem()).equals("Soul")) {
                          cc = CurrentCharacter.SUBZERO;
                      } else if (((String) s.getSelectedItem()).equals("Scorpion")) {
                          cc = CurrentCharacter.SCORPION;
                      }else if (((String) s.getSelectedItem()).equals("Sonya")) {
                          cc = CurrentCharacter.SONYA;
                      }else if (((String) s.getSelectedItem()).equals("Jax")) {
                          cc = CurrentCharacter.JAX;
                      }else if (((String) s.getSelectedItem()).equals("LiuKang")) {
                          cc = CurrentCharacter.LIUKANG;
                      }
                  }
              }
          });

          cbxRounds.addItemListener(new ItemListener() {
              @Override
              public void itemStateChanged(ItemEvent e) {
                  if(e.getStateChange() == ItemEvent.SELECTED){
                      JComboBox s =(JComboBox) e.getSource();
                      if( ((String)s.getSelectedItem()).equals("2") ){
                          SinglePlayerFrame.noOfMatches = 2;
                      }else if(((String)s.getSelectedItem()).equals("3")){
                          SinglePlayerFrame.noOfMatches = 3;
                      }else if (((String)s.getSelectedItem()).equals("4")){
                          SinglePlayerFrame.noOfMatches = 4;
                      }
                  }
              }
          });



          btnPlay.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  dispose();
                  new SinglePlayerFrame(cc,ca,randCharacter());
              }
          });

      }
      }*/
    public CurrentCharacter randCharacter() {
        Random r = new Random();
        switch (r.nextInt(5)) {
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
}
