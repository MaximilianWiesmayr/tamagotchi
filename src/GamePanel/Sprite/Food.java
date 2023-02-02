package GamePanel.Sprite;

import Interface.Components;
import Interface.Globals;

public class Food extends Sprite implements Globals, Components{

    private int startPosX;
    private int startPosY;
    private int minPosY = 0;      
    private int maxPosY = 300 - getHeight(); 

    public Food() {
        super(SRC_FOOD, 200, 200);
        this.startPosX = random(getMinPosX(), getMaxPosX());
        this.startPosY = random(this.minPosY, this.maxPosY);
        setPosX(this.startPosX);
        setPosY(this.startPosY);

    }
    
    public void resetPos(){
        setPosX(startPosX);
        setPosY(startPosY);
    }
}
