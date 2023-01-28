package GamePanel.Sprite;

import Interface.Globals;

public class Creature extends Sprite implements Globals {
    
    private int addX = 0;
    
    public Creature(String imgsrc, int posX, int posY){
        super(imgsrc, posX, posY);
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

        //Image for movement to the right
        switch (useImg) {
            case 0: // Clean Sprite
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
        
        //Image for movement to the right
        switch (useImg) {
            case 0: // Clean Sprite
                setImage(CREATURE_NORMAL_RIGHT);
                break;
            case 1: // Clean Dirty
                setImage(CREATURE_DIRTY_RIGHT);
                break;
            case 2: // Outdoor
                setImage(CREATURE_OUTDOOR_RIGHT);
                break;
        }
    }
    
    public void stop(){
        addX = 0;
    }
    
    //performs move - in order to see that, repaint() has to be called
    public void performMove(){
        moveX(addX);
    }


    
}
