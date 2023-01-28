package GamePanel.Sprite;

import GamePanel.Room.Room;
import Interface.*;
import java.util.Random;

public class Waterdrop extends Sprite implements Globals, Components {
    
    private int minPosX = 0;
    private int maxPosX = WINDOW_WIDTH - getWidth();
    private int minPosY = 0 - getHeight();      //first the waterdrop should not be visible
    private int maxPosY;        //get it via Bathroom (when Waterdrop is instantiated)
    
    public Waterdrop(int maxPosY, int delay) {
        super(SRC_WATERDROP, 50, -50);     //position here doesn't matter
        this.maxPosY = maxPosY;
        setPosX(random(minPosX, this.maxPosX));  //random position for x coordinate
        setPosY(minPosY - delay);       //start at top, including delay
    }
    
    public void performMove(){
        if(getPosY() < maxPosY ) {      //as long as the waderdrop is visible
            moveY(WATERDROP_SPEED);     //the waterdrop moves down (after repaint is called)
        } else {                                        //when the bottom is reached
            newPosition();
        }
    }
    
    //returns random int between min and max (both inclusive)
    private int random(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;     //nextInt(bound) returns an int between 0 and bound (exclusive)
    }
    
    public void newPosition(){
        setPosX(random(minPosX, this.maxPosX));     //new random xPosition
        setPosY(minPosY);                           //begin at the top
    }
}
