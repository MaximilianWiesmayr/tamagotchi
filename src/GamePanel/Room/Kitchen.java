package GamePanel.Room;

//import GamePanel.Sprite.Creature;
//import GamePanel.Sprite.Sprite;
import static Interface.Globals.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.imageio.ImageIO;

public class Kitchen extends Room{
//    private Creature creature; -> is now in Room defined
//    private BufferedImage backgroundImage;
    
    public Kitchen() {
        creaturePosX = 230;
        creaturePosY = 300;
        //Path to backgroundimage
        bgSrc = "img/kitchen.jpg";
        
        createBackground();
        setCreature(CREATURE_NORMAL_RIGHT);
        
//        createBackground();
//        setCreature("normal");
        //repaint();
    }
    
//    @Override
//    public void createBackground() {
//        try {
//            backgroundImage = ImageIO.read(new File ("img/kitchen.jpg"));
//        } catch (IOException ex) {
//            System.out.println("Hallo");
//        }
//        
//    }

//    @Override
//    is now defined in Room
//    protected void setCreature(String appearance) {
//        creature = new Creature(appearance, 250, 250);
//    }
    
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
