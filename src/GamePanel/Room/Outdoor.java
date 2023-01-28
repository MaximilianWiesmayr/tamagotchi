package GamePanel.Room;

import GamePanel.Sprite.Creature;
import Interface.Components;
import Interface.Globals;
//import GamePanel.Sprite.Sprite;
//import static Interface.Components.gamePanel;
import javax.swing.*;

import static Interface.Globals.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;

public class Outdoor extends Room implements Globals, Components, KeyListener, ActionListener {
    

    private boolean isRight = true;
    private boolean nextButtonIsA = true;

    private int completedLaps = 0;

    JLabel lapLabel;

    private Timer timer;

    /**
     * Constructor for Outdoors
     */
    public Outdoor() {
        //Position of creature
        creaturePosX = 0;
        creaturePosY = 300;
        //Path to backgroundimage
        bgSrc = "img/outdoor.png";
        
        createBackground();
        setCreature(CREATURE_OUTDOOR_RIGHT);

        //Label for number of completed laps
        this.lapLabel = new JLabel("Completed Laps: " + this.completedLaps);
        this.lapLabel.setFont(LABEL_FONT_MINIGAME_SCORE);
        this.lapLabel.setForeground(COLOR_LABEL_MINIGAME_SCORE_FG);
        this.lapLabel.setBackground(COLOR_LABEL_MINIGAME_SCORE_BG);
        this.lapLabel.setOpaque(true);
        add(this.lapLabel);

        //make KeyListener work
        this.addKeyListener(this);
        this.setFocusable(true);

        // Generates Timer
        timer = new Timer(10, this);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //draw background image
        g.drawImage(backgroundImage, 0, 0, null);

        // Draw Creature
        creature.draw((Graphics2D) g);

        // Note for updating the sprite
        // There is a redraw method where you can specify a box that is redrawn
    }

    /**
     * Start the Game of the Room
     */
    @Override
    public void startGame() {
        timer.start();
    }

    /**
     * Update the Room Contents
     */
    @Override
    public void update() {
        this.requestFocus();    //KeyListener and ActionListener both work

        creature.performMove(); // Move the Creature once
        creature.stop(); // Stop the Creature
        this.repaint(); // Repaint the Panel
    }

    /**
     * Stop the Game of the Room
     */
    @Override
    public void stopGame() {
        timer.stop();
    }

    /**
     * Reacts to a performed listener action
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        update(); // Update the game
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Reacts to the Pressing of a Key
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        System.out.println(KeyEvent.VK_LEFT);
        // Listen to a  or left arrwo Key
        if (e.getKeyChar() == 'a' || e.getKeyCode() == KeyEvent.VK_LEFT) {
            // Check if the Button can be pressed
            if (nextButtonIsA) {
                // Moves the Creature left or Right
                if (isRight) {
                    creature.moveRight(2);    //sets direction to right
                } else {
                    creature.moveLeft(2);    //sets direction to left
                }
                nextButtonIsA = false; // D has to be pressed to move creature
            }
        }
        if (e.getKeyChar() == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            // Check if the Button can be pressed
            if (!nextButtonIsA) {
                // Moves the Creature left or Right
                if (isRight) {
                    creature.moveRight(2);    //sets direction to right
                } else {
                    creature.moveLeft(2);    //sets direction to left
                }
                nextButtonIsA = true; // A has to be pressed to move creature
            }
        }

        // When the Creature reaches the right window edge ()
        if (creature.getMaxPosX() <= creature.getPosX() && isRight) {
            isRight = false; // Change direction to left
            this.completedLaps++; // add lap
            this.lapLabel.setText("Completed Laps: " + this.completedLaps); // Update Label
            statusPanel.exerciseBar.gainPercentage(10); // Add to the Excercise Bar
        }
        // When the Creature reaches the left window edge
        if (creature.getMinPosX() >= creature.getPosX() && !isRight) {
            isRight = true; // Change direction to right
            this.completedLaps++; // add lap
            this.lapLabel.setText("Completed Laps: " + this.completedLaps); // Update Label
            statusPanel.exerciseBar.gainPercentage(10); // Add to the Excercise Bar
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
