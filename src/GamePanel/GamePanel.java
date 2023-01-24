package GamePanel;

import GamePanel.Room.Kitchen;
import GamePanel.Room.Outdoor;
import GamePanel.Room.Room;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.*;


public class GamePanel extends JPanel {

  
    private Room room;

    public GamePanel() {
        
        room = new Kitchen();
        this.setLayout(new BorderLayout());
        add(room, BorderLayout.CENTER);
        
    }

    public void setRoom(Room room) {
        this.remove(this.room);
        this.room = room;
        add(this.room, BorderLayout.CENTER);
        revalidate();
        //repaint();
        //change panel with button and description
    }
    
    
}
