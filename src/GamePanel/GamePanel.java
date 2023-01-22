package GamePanel;

import GamePanel.Sprite.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {

    private Sprite sprite;

    public GamePanel() {

        sprite = new Sprite("C:\\FH St. Pölten\\User Interface Programmierung\\tamagotchi\\src\\Sprites\\images.jpg", 250, 250);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        sprite.draw((Graphics2D) g);

        // Note for updating the sprite
        // There is a redraw method where you can specify a box that is redrawn
    }

}
