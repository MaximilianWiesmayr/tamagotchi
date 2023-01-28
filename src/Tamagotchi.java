import Interface.Components;
import static Interface.Globals.*;
import javax.swing.*;
import java.awt.*;

public class Tamagotchi extends JFrame implements Components {

    public Tamagotchi(){
        super("Tamagotchi");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);     
        add(statusPanel, BorderLayout.NORTH);  //statusPanel from Components
        add(gamePanel, BorderLayout.CENTER); // from Components
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
    
}