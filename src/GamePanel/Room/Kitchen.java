package GamePanel.Room;

import GamePanel.Sprite.Creature;
import GamePanel.Sprite.Food;
import Interface.Components;
import Interface.Globals;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

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
        //create timer for actionPerfomed and update methods, makes Kitchen ActionListener
        timer = new Timer(1, this);
        
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //draw background image
        g.drawImage(backgroundImage, 0, 0, null);
        
        creature.draw((Graphics2D) g);
        //draw the cookie
       if (food != null)
       {
           food.draw((Graphics2D) g);
       }
    }

    @Override
    public void startGame() {      
        //Spawn cookie
        food = new Food();
        playing = true;
        timer.start();
    }
    //position of cookie is set new to make the cookie move with the curser
    @Override
    public void update() {
        if(playing && dragged){
            food.setPosX(currentMouseX - food.getWidth()/2);
            food.setPosY(currentMouseY - food.getHeight()/2);
        }
        //when cookie is dropped, it will reset to the original position
        else if (playing && !dragged){
            food.resetPos();
        }
        
        repaint();
    }
    //stopps the game and removes the cookie from the screen
    @Override
    public void stopGame() {
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
       
        if(playing && dragged && creature.getMouth().contains(e.getPoint())){   //checks if the cookie was release above the mouth of the creature
            eatenCookies++;
            food = new Food();
            statusPanel.eatBar.gainPercentage(2);
            labelCookies.setText("Eaten Cookies: "+ eatenCookies);      //percentage gets added to the need bar and label gets set with the new score
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
  
        if (playing && !dragged && food.getBounds().contains(e.getPoint())) {   //checks if cookie was clicked and mouse was above the cookie
            currentMouseX = (int) e.getPoint().getX();
            currentMouseY = (int) e.getPoint().getY();
            dragged= true;
        }
        else if(playing && dragged){
            currentMouseX = (int) e.getPoint().getX();      //if the cookie was already taken, only the position of the mouse is updated -> lets the game run smoother
            currentMouseY = (int) e.getPoint().getY();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
