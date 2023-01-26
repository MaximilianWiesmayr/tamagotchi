package GamePanel.Room;

import GamePanel.Sprite.Creature;
import GamePanel.Sprite.Sprite;
import Interface.Components;

import javax.swing.*;

public abstract class Room extends JPanel implements Components{

    public Room(){
       
    }
    //override method to change the backgroundimage
    abstract protected void createBackground();
    
    abstract protected void setCreature(String path);
    
    abstract public void startGame();

    abstract public void stopGame();
}
