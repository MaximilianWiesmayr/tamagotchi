package BottomPanel;

import GamePanel.Room.Bathroom;
import GamePanel.Room.Kitchen;
import GamePanel.Room.Outdoor;
import Interface.Components;
import Interface.Globals;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class RoomButton extends JButton implements Globals, MouseListener, Components {
    
    private String name;
    
    public RoomButton(String name){
        super(name);
        this.name = name;
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //depending on the button, different room is created
        switch (name) {
            case "Kitchen":
                Kitchen k = new Kitchen(gamePanel.getSprite());
                break;
            case "Bathroom":
                Bathroom b = new Bathroom(gamePanel.getSprite());
                break;
            case "Outdoor":
                Outdoor o = new Outdoor(gamePanel.getSprite());
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
