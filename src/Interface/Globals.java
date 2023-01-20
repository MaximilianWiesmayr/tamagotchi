package Interface;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;

public interface Globals {
    String CREATURE_NORMAL = "";
    String CREATURE_DIRTY = "";
    
    Font LABEL_FONT = new Font("Arial", PLAIN, 12); 
    
    //Colors for ProgressBar (NeedBar)
    Color COLOR_BAR_BG = new Color(230, 230, 230);    //background color of bar
    Color COLOR_BAR_FG_GOOD = new Color(37, 201, 31);      //foreground color of bar
    Color COLOR_BAR_FG_BAD = new Color(216, 158, 41);
    Color COLOR_BAR_FG_WORSE = new Color(216, 70, 41);
}
