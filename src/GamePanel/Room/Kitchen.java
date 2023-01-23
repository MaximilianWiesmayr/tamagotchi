package GamePanel.Room;

import GamePanel.Sprite.Sprite;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Kitchen extends Room{

    public Kitchen(Sprite creature) {
        super(creature);
        
        
    }

    
    @Override
    public void createBackground() {
        try {
            gamePanel.setBackgroundImage(ImageIO.read(new File ("img/kitchen.jpg")));
        } catch (IOException ex) {
            System.out.println("Hallo");
        }
    }
    
}
