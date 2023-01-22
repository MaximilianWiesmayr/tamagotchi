package GamePanel.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Sprite {

    ImageIcon image;
    int posX;
    int posY;

    int height;
    int width;

    public Sprite(String imgsrc, int posX, int posY) {
        this.image = new ImageIcon(imgsrc); // Allows to get image through the file path
        this.posY = posY;
        this.posX = posX;
        this.height = this.image.getIconHeight();
        this.width = this.image.getIconWidth();

    }

    public void draw(Graphics2D g){
        g.drawImage(this.image.getImage(),posX,posY,this.image.getImageObserver()); // draws the image at the position
        // ImageObeserver is something to get Information about the image while it is constructed to know if it was
        // succesful or if it failed
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
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

    public void moveX(int add){
        this.posX += add;
    }

    public void moveY(int add){
        this.posY += add;
    }

    public void move(){

    }

    public Image getImage() {
        return image.getImage(); // Returns the actual image, might be needed outside
    }
}
