package GamePanel.Sprite;

import Interface.*;

public class Waterdrop extends Sprite implements Globals, Components {
    
    private int minPosY = 0 - getHeight();      //first the waterdrop should not be visible
    private int maxPosY;        //get it via Bathroom (when Waterdrop is instantiated)
    
    public Waterdrop(int maxPosY, int delay) {
        super(SRC_WATERDROP, 50, -50);     //position here doesn't matter
        this.maxPosY = maxPosY;
        setPosX(random(getMinPosX(), getMaxPosX()));  //random position for x coordinate
        setPosY(minPosY - delay);       //start at top, including delay
    }
    
    public void performMove(){
        if(getPosY() < maxPosY ) {      //as long as the waterdrop is visible
            moveY(WATERDROP_SPEED);     //the waterdrop moves down (after repaint is called)
        } else {                                        //when the bottom is reached
            newPosition();
        }
    }
    
    public void newPosition(){
        setPosX(random(getMinPosX(), getMaxPosX()));     //new random xPosition
        setPosY(minPosY);                           //begin at the top
    }
}
