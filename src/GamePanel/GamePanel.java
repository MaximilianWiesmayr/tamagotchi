package GamePanel;

import GamePanel.Sprite.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class GamePanel extends JPanel {

    private Sprite sprite;
    private BufferedImage backgroundImage;

    public GamePanel() {

        sprite = new Sprite("C:\\FH St. Pölten\\User Interface Programmierung\\tamagotchi\\src\\Sprites\\images.jpg", 250, 250);
        
        //load kitchen image first
        try {
            backgroundImage = ImageIO.read(new File ("img/kitchen.jpg"));
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        sprite.draw((Graphics2D) g);
        //draw background image
        g.drawImage(backgroundImage, 0, 0, null);

        // Note for updating the sprite
        // There is a redraw method where you can specify a box that is redrawn
    }
    //set background and repaint panel
    public void setBackgroundImage(BufferedImage backgroundImage) {
        this.backgroundImage = backgroundImage;
        this.repaint();
    }
    //get current sprite
    public Sprite getSprite() {
        return sprite;
    }
    
    
    
}
