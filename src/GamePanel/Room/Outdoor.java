package GamePanel.Room;

import GamePanel.Sprite.Creature;
import GamePanel.Sprite.Sprite;
import static Interface.Components.gamePanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Outdoor extends Room{
    
    private Sprite creature;
    private BufferedImage backgroundImage;

    public Outdoor() {
        createBackground();
        setCreature("img/images.jpg");
    }
    @Override
    public void createBackground() {
        try {
            backgroundImage = ImageIO.read(new File ("img/outdoor.png"));
        } catch (IOException ex) {
            System.out.println("Hallo");
        }
    }

    @Override
    protected void setCreature(String path) {
        creature = new Creature(path, 250, 250);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //draw background image
        g.drawImage(backgroundImage, 0, 0, null);
        
        creature.draw((Graphics2D) g);

        // Note for updating the sprite
        // There is a redraw method where you can specify a box that is redrawn
    }
}
