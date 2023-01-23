package GamePanel.Room;

import GamePanel.Sprite.Sprite;
import static Interface.Components.gamePanel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bathroom extends Room {

    public Bathroom(Sprite creature) {
        super(creature);
        
    }

   
    @Override
    public void createBackground() {
        try {
            gamePanel.setBackgroundImage(ImageIO.read(new File("img/bathroom.jpg")));
        } catch (IOException ex) {
            System.out.println("Hallo");
        }
    }
}
