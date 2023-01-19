package GamePanel.Sprite;

import javax.swing.*;
import java.awt.*;

public class Sprite {
    int posX;
    int posY;

    int height;
    int width;

    public Sprite(String imgsrc, int posX, int posY) {
        ImageIcon image = new ImageIcon(imgsrc);
    }

    void draw(Graphics2D graphics2D){

    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    void moveX(int add){

    }

    void moveY(int add){

    }

    void move(int add){

    }
}
