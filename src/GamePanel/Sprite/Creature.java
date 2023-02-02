package GamePanel.Sprite;

import Interface.Globals;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Creature extends Sprite implements Globals {
    
    private int addX = 0;
    
    public Creature(int useImg, boolean isRight, int posX, int posY){
        super(CREATURE_NORMAL_RIGHT, posX, posY);   //as default - will be changed in next line
        setAppearance(useImg, isRight);
    }

    /**
     * Checks if the creature can be moved left and allows or denies the movement
     * @param useImg int which creature image should be used
     *               0 - Normal
     *               1 - Dirty
     *               2 - Outdoor
     */
    public void moveLeft(int useImg){
        if(getPosX() > this.getMinPosX()) addX = -CREATURE_SPEED;     //as long as PosX is inside Window, value of addX is negative
        else addX = 0;

        //correct Image for movement to the right
        setAppearance(useImg, false);
//        switch (useImg) {
//            case 0: // Clean Sprite
//                setImage(CREATURE_NORMAL_LEFT);
//                break;
//            case 1: // Clean Dirty
//                setImage(CREATURE_DIRTY_LEFT);
//                break;
//            case 2: // Outdoor
//                setImage(CREATURE_OUTDOOR_LEFT);
//                break;
//        }
    }

    /**
     * Checks if the creature can be moved right and allows or denies the movement
     * @param useImg int which creature image should be used
     *               0 - Normal
     *               1 - Dirty
     *               2 - Outdoor
     */
    public void moveRight(int useImg){
        if(getPosX() < this.getMaxPosX()) addX = CREATURE_SPEED;      //as long as PosX is inside Window, value of addX is positive
        else addX = 0;
        
        //correct Image for movement to the right
        setAppearance(useImg, true);
//        switch (useImg) {
//            case 0: // Clean Sprite
//                setImage(CREATURE_NORMAL_RIGHT);
//                break;
//            case 1: // Clean Dirty
//                setImage(CREATURE_DIRTY_RIGHT);
//                break;
//            case 2: // Outdoor
//                setImage(CREATURE_OUTDOOR_RIGHT);
//                break;
//        }
    }
    
    public void stop(){
        addX = 0;
    }
    
    //performs move - in order to see that, repaint() has to be called
    public void performMove(){
        moveX(addX);
    }

    //sets correct Appearane/Image of Creature based on type (useImg) and direction (left/right)
    public void setAppearance(int useImg, boolean isRight){
        if(isRight){    //Images where creature is looking to right side
            switch (useImg) {
            case 0: // Clean Normal
                setImage(CREATURE_NORMAL_RIGHT);
                break;
            case 1: // Clean Dirty
                setImage(CREATURE_DIRTY_RIGHT);
                break;
            case 2: // Outdoor
                setImage(CREATURE_OUTDOOR_RIGHT);
                break;
            case 3: // Dead
                setImage(CREATURE_DEAD);
            }
        } else {    //Images where creature is looking to left side
            switch (useImg) {
            case 0: // Clean Normal
                setImage(CREATURE_NORMAL_LEFT);
                break;
            case 1: // Clean Dirty
                setImage(CREATURE_DIRTY_LEFT);
                break;
            case 2: // Outdoor
                setImage(CREATURE_OUTDOOR_LEFT);
                break;
            }
        }
    }
    public Rectangle getMouth(){
     return new Rectangle (getPosX()+150, getPosY()+80, 60, 60);   
    }
    
    
    
}
