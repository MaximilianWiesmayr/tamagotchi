package GamePanel.Room;

import GamePanel.Sprite.*;
import Interface.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Bathroom extends Room implements Globals, Components, KeyListener, ActionListener {

    //Array with Waterdrops
    private Waterdrop[] waterdrop = new Waterdrop[2];
    //Timer -> in order to have an update method (which is called every delay of timer)
    private Timer timer;
    //for Images
    private int isDirty = 1;            //for minigame, 0: not dirty, 1: dirty
    private boolean isRight = true;     //for minigame, important for start/stop
    //number of collected Waterdrops
    public int collectedWaterdrops = 0;
    //Label for that
    JLabel labelWaterdrops;

    
    public Bathroom() {
        super(new Creature(0, true, 230, 300), "img/bathroom.jpg"); //Creature normal right
        
        //initialize Waterdrops
        for(int i=0; i<waterdrop.length; i++){
            //in the beginning same space between waterdrops (regardless of the number)
            int space = backgroundImage.getHeight()/waterdrop.length;
            waterdrop[i] = new Waterdrop(backgroundImage.getHeight(), i * space);   //space as delay
        }
        
        //get a scoreLabel for number of collected waterdrops and add it to Panel
        labelWaterdrops = getScoreLabel("Collected Waterdrops: ", collectedWaterdrops);
        add(labelWaterdrops);
        
        //make KeyListener work
        addKeyListener(this);
        setFocusable(true);
        
        //creates Timer with delay = 1 and Bathroom as ActionListener
        timer = new Timer(1, this);
    }
    
    //Paints Bg, Creature, Waterdrops
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //draw background image
        g.drawImage(backgroundImage, 0, 0, null);
        //draw Creature
        creature.draw((Graphics2D) g);
        //draw Waterdrops
        for(int i=0; i<waterdrop.length; i++){
            waterdrop[i].draw((Graphics2D) g);
        }
    }
    
    @Override
    public void startGame() {
        System.out.println("started Bathroom game");

        if (statusPanel.cleanBar.getValue() < 100) isDirty = 1;     //check if dirty and set int
        
        //set correct Creature-Image (after stop - start) -> isDirty as type and isRight is for direction
        creature.setAppearance(isDirty, isRight);
        
        timer.start();  //start Timer -> therefore actionPerformed() (and update()) is called
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //controlled by timer how often it is called
        update();    
    }
    
    //GameLoop
    @Override
    public void update(){  
        this.requestFocus();    //KeyListener and ActionListener both work
        
        //Movement
        creature.performMove();     //moves Creature
        for(int i=0; i<waterdrop.length; i++){  //moves Waterdrops
            waterdrop[i].performMove();
        }
        
        //Collision
        for(int i=0; i<waterdrop.length; i++){
            if(creature.collides(waterdrop[i])){    //if Creature and Waterdrop collide
                collectedWaterdrops++;              //count Waterdrops
                labelWaterdrops.setText("Collected Waterdrops: " + collectedWaterdrops);    //update Label
                statusPanel.cleanBar.gainPercentage(1);     //fill CleanBar
                waterdrop[i].newPosition();
            }
        }
        
        //if CleanBar 100% than no longer dirty
        int barVal = statusPanel.cleanBar.getValue();        //get value from CleanBar
        if(barVal >= 100){
            isDirty = 0;
            creature.setAppearance(isDirty, isRight);       //change Img right away
        }

        //make changes visible
        repaint();
    }

    //if Stop Button is clicked
    @Override
    public void stopGame() {
        System.out.println("stopped Bathroom game");
        timer.stop();
    }
    

    //by pressing keys add-values for movement will be set
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                creature.moveLeft(isDirty);    //sets direction to left
                isRight = false;        //relevant for img
                break;
            case KeyEvent.VK_RIGHT:
                creature.moveRight(isDirty);   //sets direction to right
                isRight = true;         //relevant for img
                break;
        }
    }

    //if keys are released add-values for movement will be 0
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                creature.stop();    //for both cases: stop moving creature
                break;
        }
    }
    
    public void keyTyped(KeyEvent e) {}
        
}
