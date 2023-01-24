package GamePanel.Room;

import GamePanel.Sprite.Creature;
import GamePanel.Sprite.Sprite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Kitchen extends Room{
    private Sprite creature;
    private BufferedImage backgroundImage;
    
    public Kitchen() {
        
        createBackground();
        setCreature("img/images.jpg");
        repaint();
    }

    
    @Override
    public void createBackground() {
        try {
            backgroundImage = ImageIO.read(new File ("img/kitchen.jpg"));
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

    @Override
    protected void startGame() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
