package GamePanel.Room;

import GamePanel.Sprite.Creature;
//import GamePanel.Sprite.Sprite;
//import static Interface.Components.gamePanel;
import static Interface.Globals.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;

public class Outdoor extends Room{
    
//    private Creature creature; -> is now defined in Room
//    private BufferedImage backgroundImage;

    public Outdoor() {
        //Position of creature
        creaturePosX = 230;
        creaturePosY = 300;
        //Path to backgroundimage
        bgSrc = "img/outdoor.png";
        
        createBackground();
        setCreature(CREATURE_NORMAL_RIGHT);
    }
    
//    @Override
//    public void createBackground() {
//        try {
//            backgroundImage = ImageIO.read(new File ("img/outdoor.png"));
//        } catch (IOException ex) {
//            System.out.println("Hallo");
//        }
//    }

//    @Override
////    is now defined in Room
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
        System.out.println("started Outdoor game");
    }

    @Override
    public void stopGame() {
        System.out.println("stopped Outdoor game");
    }
}
