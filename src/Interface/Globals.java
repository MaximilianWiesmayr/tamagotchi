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

    String CREATURE_DEAD = "img/creature_dead.png";

    String DEATHSCREEN = "img/deathscreen.jpg";
    
    String SRC_WATERDROP = "img/waterdrop.png";
    String SRC_FOOD = "img/food.png";

    String GAMEDESCRIPTION_KITCHEN = "Fütter dein Tierchen indem du die Cookies zu seinem Mund führst.                \n \n";
    String GAMEDESCRIPTION_BATHROOM = "Wassertropfen fallen vom Duschkopf.                                                                     " +
            "\n Versuche sie mit deinem Tierchen aufzufangen um es zu waschen.\n" +
            " Steuern kannst du dein Tierchen mit der linken und rechten Pfeiltaste";
    String GAMEDESCRIPTION_OUTDOOR = "Klicke so schnell wie möglich die linke und rechte Pfeiltaste hintereinander \n um von einem Ende zum Anderen zu gelangen.\n" +
            " Damit dein Tierchen auch etwas Bewegung bekommt.";

    //NeedBar speeds
    //interval between bar updates in ms
    int SLOW = 1500;
    int FAST = 1000;
    int STOP = 0;

    //Revive Chance
    int REVIVECHANCE = 1;
    
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

    Color COLOR_BUTTON_ROOM = new Color(153, 222, 221);

    Color COLOR_BUTTON_START = new Color(146, 232, 142);
    Color COLOR_BUTTON_STOP = new Color(232, 166, 142);
    Color COLOR_BUTTON_REVIVE = new Color(230, 169, 232);

    Color COLOR_DESCRIPTION = Color.BLACK;
    
    //Bathroom Minigame
    int CREATURE_SPEED = 5;
    int WATERDROP_SPEED = 3;
}
