package GamePanel.Sprite;

import Interface.Globals;

public class Creature extends Sprite implements Globals {
    
    private int addX = 0;
    private int minPosX = 0;
    private int maxPosX = WINDOW_WIDTH - getWidth();    //creature should always stay in window
    
    public Creature(String imgsrc, int posX, int posY){
        super(imgsrc, posX, posY);
    }
    
    public void moveLeft(boolean isDirty){
        if(getPosX() > minPosX) addX = -CREATURE_SPEED;     //as long as PosX is inside Window, value of addX is negative
        else addX = 0;

        //Image for movement to the left
        if(isDirty) setImage(CREATURE_DIRTY_LEFT);  //dirty
        else setImage(CREATURE_NORMAL_LEFT);        //clean
    }
    
    public void moveRight(boolean isDirty){
        if(getPosX() < maxPosX) addX = CREATURE_SPEED;      //as long as PosX is inside Window, value of addX is positive
        else addX = 0;
        
        //Image for movement to the right
        if(isDirty) setImage(CREATURE_DIRTY_RIGHT);  //dirty
        else setImage(CREATURE_NORMAL_RIGHT);        //clean
    }
    
    public void stop(){
        addX = 0;
    }
    
    //performs move - in order to see that, repaint() has to be called
    public void performMove(){
        moveX(addX);
    }
    
}
