package GamePanel;

import GamePanel.Room.*;
import java.awt.BorderLayout;

import javax.swing.*;


public class GamePanel extends JPanel {
  
    private Room room;
    public GameStartPanel gameStartPanel;

    public GamePanel() {
        room = new Kitchen();
        gameStartPanel = new GameStartPanel(room);

        this.setLayout(new BorderLayout());
        add(gameStartPanel, BorderLayout.SOUTH);
        add(room, BorderLayout.CENTER);
        
    }

    public void setRoom(Room room) {
        remove(this.room);
        this.room = room;
        gameStartPanel.changeRoom(this.room);
        add(this.room, BorderLayout.CENTER);
        revalidate();
        repaint();
    }


}
