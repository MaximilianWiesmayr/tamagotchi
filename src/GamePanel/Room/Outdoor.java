package GamePanel.Room;

import GamePanel.Sprite.Sprite;
import static Interface.Components.gamePanel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Outdoor extends Room{

    public Outdoor(Sprite creature) {
        super(creature);
        
    }

    
    @Override
    public void createBackground() {
        try {
            gamePanel.setBackgroundImage(ImageIO.read(new File("img/outdoor.png")));
        } catch (IOException ex) {
            System.out.println("Hallo");
        }
    }
}
