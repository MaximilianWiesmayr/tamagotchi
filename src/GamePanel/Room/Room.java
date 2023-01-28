package GamePanel.Room;

import GamePanel.Sprite.Creature;
import Interface.Components;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public abstract class Room extends JPanel implements Components {
    //all protected, so that childs have access 
    protected int creaturePosX;
    protected int creaturePosY;
    protected Creature creature;
    
    protected BufferedImage backgroundImage;
    protected String bgSrc;
    
    public Room(){
       
    }
    
//    //override method to change the backgroundimage
//    abstract protected void createBackground();
    
    public void createBackground() {
        try {
            backgroundImage = ImageIO.read(new File(bgSrc));
        } catch (IOException ex) {
            System.out.println("Fehler beim Laden des Hintergrundbildes");
        }
    }
    
    protected void setCreature(String imgsrc) {
        creature = new Creature(imgsrc, creaturePosX, creaturePosY);
    }
    
    abstract public void startGame();

    abstract public void stopGame();
    
}
