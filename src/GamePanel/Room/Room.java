package GamePanel.Room;

import GamePanel.Sprite.Creature;
import GamePanel.Sprite.Sprite;

import javax.swing.*;

public class Room extends JPanel {
    Sprite creature;

    public Room(Sprite creature){
        this.creature = creature;
        createBackground();
    }

    private void createBackground(){

    }
}
