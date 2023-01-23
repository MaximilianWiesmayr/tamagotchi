package GamePanel.Room;

import GamePanel.Sprite.Creature;
import GamePanel.Sprite.Sprite;
import Interface.Components;

import javax.swing.*;

public class Room extends JPanel implements Components{
    Sprite creature;

    public Room(Sprite creature){
        this.creature = creature;
        createBackground();
    }
    //override method to change the backgroundimage
    public void createBackground() {

    }
}
