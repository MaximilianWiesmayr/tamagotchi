package GamePanel;

import GamePanel.Room.Kitchen;
import GamePanel.Room.Outdoor;
import GamePanel.Room.Room;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.*;


public class GamePanel extends JPanel {

  
    private Room room;
    private GameStartPanel gameStartPanel;

    public GamePanel() {
        room = new Kitchen();
        gameStartPanel = new GameStartPanel(room);

        this.setLayout(new BorderLayout());
        add(gameStartPanel, BorderLayout.SOUTH);
        add(room, BorderLayout.CENTER);
        
    }

    public void setRoom(Room room) {
        remove(this.room);
        gameStartPanel.changeRoom(room);
        this.room = room;
        add(this.room, BorderLayout.CENTER);
        revalidate();
        //repaint();
        //change panel with button and description
    }
    
    
}
