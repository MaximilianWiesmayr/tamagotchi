package GamePanel.Room;

import GamePanel.Sprite.Creature;
//import GamePanel.Sprite.Sprite;
//import static Interface.Globals.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.imageio.ImageIO;

public class Kitchen extends Room{
    
    public Kitchen() {
        super(new Creature(0, true, 230, 300), "img/kitchen.jpg");  //Creature normal right
        
        
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
    public void startGame() {
        System.out.println("started Kitchen game");
    }

    @Override
    public void update() {
        System.out.println("updated Kitchen game");
    }

    @Override
    public void stopGame() {
        System.out.println("stopped Kitchen game");
    }
}
