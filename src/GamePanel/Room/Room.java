package GamePanel.Room;

import GamePanel.Sprite.Creature;
import Interface.Components;
import static Interface.Globals.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public abstract class Room extends JPanel implements Components {
    
    //every Room hast a creature and a background
    public Creature creature;
    public BufferedImage backgroundImage;

    public JLabel scoreLabel;
    
    public Room(Creature creature, String bgSrc){   
        //Create Background
        try {
            backgroundImage = ImageIO.read(new File(bgSrc));
        } catch (IOException ex) {
            System.out.println("Fehler beim Laden des Hintergrundbildes");
        }
        
        this.creature = creature;
    }
    
    //Returns a JLabel for displaying the score of the minigame
    protected JLabel getScoreLabel(String scoreText, int score){
        scoreLabel = new JLabel(scoreText + score);
        scoreLabel.setFont(LABEL_FONT_MINIGAME_SCORE);
        scoreLabel.setForeground(COLOR_LABEL_MINIGAME_SCORE_FG);
        scoreLabel.setBackground(COLOR_LABEL_MINIGAME_SCORE_BG);
        scoreLabel.setOpaque(true);
        return scoreLabel;
    }

    
    abstract public void startGame();

    abstract public void update();

    abstract public void stopGame();
    
}
