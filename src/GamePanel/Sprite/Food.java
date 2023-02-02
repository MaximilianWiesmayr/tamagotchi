package GamePanel.Sprite;

import Interface.Components;
import Interface.Globals;
import java.util.Random;

public class Food extends Sprite implements Globals, Components{
    private int posX;
    private int posY;
    private int startPosX;
    private int startPosY;
    private int minPosX = 0;
    private int maxPosX = WINDOW_WIDTH - getWidth();
    private int minPosY = 0;      
    private int maxPosY = 300 - getHeight(); 
    private Random rand = new Random();
    public Food() {
        super(SRC_FOOD, 200, 200);
        this.startPosX = rand.nextInt(maxPosX);
        this.startPosY = rand.nextInt(maxPosY);
        setPosX(this.startPosX);
        setPosY(this.startPosY);

    }
    
    public void resetPos(){
        setPosX(startPosX);
        setPosY(startPosY);
    }
}
