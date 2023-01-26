package Interface;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;

public interface Globals {
    String CREATURE_NORMAL = "";
    String CREATURE_DIRTY = "";

    String GAMEDESCRIPTION_KITCHEN = "Kitchengame";
    String GAMEDESCRIPTION_BATHROOM = "Bathroomgame";
    String GAMEDESCRIPTION_OUTDOOR = "Outdoorgame";

    //NeedBar speeds
    int SLOW = 2000;
    int FAST = 1000;
    int STOP = 0;
    
    Font LABEL_FONT = new Font("Arial", PLAIN, 12); 
    
    //Colors for ProgressBar (NeedBar)
    Color COLOR_BAR_BG = new Color(230, 230, 230);    //background color of bar
    Color COLOR_BAR_FG_GOOD = new Color(37, 201, 31);      //foreground color of bar
    Color COLOR_BAR_FG_BAD = new Color(216, 158, 41);
    Color COLOR_BAR_FG_WORSE = new Color(216, 70, 41);
    
    String DESCRIPTION_GAME_KITCHEN = "";
    String DESCRIPTION_GAME_OUTDOOR = "";
    String DESCRIPTION_GAME_BATHROOM = "";
}
