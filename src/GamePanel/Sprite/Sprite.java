package GamePanel.Sprite;

import Interface.Globals;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Sprite implements Globals {

    ImageIcon image;
    private int posX;
    private int posY;

    private int height;
    private int width;

    private int minPosX;
    private int maxPosX;

    public Sprite(String imgsrc, int posX, int posY) {
        this.image = new ImageIcon(imgsrc); // Allows to get image through the file path
        this.posY = posY;
        this.posX = posX;
        this.height = this.image.getIconHeight();
        this.width = this.image.getIconWidth();
        this.minPosX = 0;
        this.maxPosX = WINDOW_WIDTH - this.width;    //sprite should always stay in window
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

    public int getMaxPosX() {
        return maxPosX;
    }
    public int getMinPosX() {
        return minPosX;
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
    
    public void setImage(String newImgsrc) {
        image = new ImageIcon(newImgsrc);
        //if image is changed, width height and maxPosX have to be updated
        this.height = this.image.getIconHeight();
        this.width = this.image.getIconWidth();
        this.maxPosX = WINDOW_WIDTH - this.width;    //sprite should always stay in window
    }
    
    public Rectangle getBounds() {
        return new Rectangle(posX, posY, width, height);    //Returns a rectangle at the position of the image
    }
    
    public boolean collides (Sprite otherSprite) {
        return this.getBounds().intersects(otherSprite.getBounds());    //Returns if Sprite collides with other Sprite or not
    }
    
    //returns random int between min and max (both inclusive)
    protected int random(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;     //nextInt(bound) returns an int between 0 and bound (exclusive)
    }
}
