package GamePanel.Room;

import GamePanel.Sprite.Creature;
import GamePanel.Sprite.Food;
import Interface.Components;
import Interface.Globals;
//import GamePanel.Sprite.Sprite;
//import static Interface.Globals.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.Timer;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.imageio.ImageIO;

public class Kitchen extends Room implements Globals, Components, ActionListener, MouseListener, MouseMotionListener{
    private Food food;
    private int eatenCookies = 0;
    private JLabel labelCookies;
    private Timer timer;
    private int currentMouseX;
    private int currentMouseY;
    private boolean dragged;
    private boolean playing;
    
    public Kitchen() {
        super(new Creature(0, true, 230, 300), "img/kitchen.jpg");  //Creature normal right
        
        //get a scoreLabel for number of eaten cookies and add it to Panel
        labelCookies = getScoreLabel("Eaten Cookies: ", eatenCookies);
        add(labelCookies);
        timer = new Timer(1, this);
        addMouseListener(this);
        addMouseMotionListener(this);
        //
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //draw background image
        g.drawImage(backgroundImage, 0, 0, null);
        
        creature.draw((Graphics2D) g);
        
       if (food != null)
       {
           food.draw((Graphics2D) g);
       }

        // Note for updating the sprite
        // There is a redraw method where you can specify a box that is redrawn
    }

    @Override
    public void startGame() {
        System.out.println("started Kitchen game");
        
        //Spawn cookie
        food = new Food();
        playing = true;
        timer.start();
    }

    @Override
    public void update() {
        //System.out.println("updated Kitchen game");
//        this.food.setPosX(x);
        if(playing && dragged){
            food.setPosX(currentMouseX - food.getWidth()/2);
            food.setPosY(currentMouseY - food.getHeight()/2);
        }
        else if (playing && !dragged){
            food.resetPos();
        }
        
        repaint();
    }

    @Override
    public void stopGame() {
        System.out.println("stopped Kitchen game");
        dragged = false;
        playing = false;
        food = null;
        update();
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
        if(playing && dragged && creature.getMouth().contains(e.getPoint())){
            eatenCookies++;
            food = new Food();
            statusPanel.eatBar.gainPercentage(2);
            labelCookies.setText("Eaten Cookies: "+ eatenCookies);
        }
        
        dragged = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
  
        if (playing && !dragged && food.getBounds().contains(e.getPoint())) {
            currentMouseX = (int) e.getPoint().getX();
            currentMouseY = (int) e.getPoint().getY();
            dragged= true;
        }
        else if(playing && dragged){
            currentMouseX = (int) e.getPoint().getX();
            currentMouseY = (int) e.getPoint().getY();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
