package Interface;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;

public interface Globals {
    int WINDOW_WIDTH = 700;
    int WINDOW_HEIGHT = 650;
    
    String CREATURE_NORMAL_RIGHT = "img/creature_no_rainbow_right.png";
    String CREATURE_NORMAL_LEFT = "img/creature_no_rainbow_left.png";
    String CREATURE_DIRTY_RIGHT = "img/creature_no_rainbow_dirty_right.png";
    String CREATURE_DIRTY_LEFT = "img/creature_no_rainbow_dirty_left.png";


    String CREATURE_OUTDOOR_RIGHT = "img/creature_with_rainbow_right.png";
    String CREATURE_OUTDOOR_LEFT = "img/creature_with_rainbow_left.png";
    
    String SRC_WATERDROP = "img/waterdrop.png";

    String GAMEDESCRIPTION_KITCHEN = "Kitchengame";
    String GAMEDESCRIPTION_BATHROOM = "Bathroomgame";
    String GAMEDESCRIPTION_OUTDOOR = "Outdoorgame";

    //NeedBar speeds
    int SLOW = 2000;
    int FAST = 1000;
    int STOP = 0;
    
    //Fonts
    Font LABEL_FONT_STATUSPANEL = new Font("Arial", PLAIN, 12);
    Font LABEL_FONT_MINIGAME_SCORE = new Font("Arial", PLAIN, 18);
    
    //Colors 
    //ProgressBar (NeedBar)
    Color COLOR_BAR_BG = new Color(230, 230, 230);    //background color of bar
    Color COLOR_BAR_FG_GOOD = new Color(37, 201, 31);      //foreground color of bar
    Color COLOR_BAR_FG_BAD = new Color(216, 158, 41);
    Color COLOR_BAR_FG_WORSE = new Color(216, 70, 41);
    //Bathroom Minigame
    Color COLOR_LABEL_MINIGAME_SCORE_FG = new Color(121, 85, 152);
    Color COLOR_LABEL_MINIGAME_SCORE_BG = new Color(231, 215, 246);
    
    //Bathroom Minigame
    int CREATURE_SPEED = 5;
    int WATERDROP_SPEED = 3;
}
