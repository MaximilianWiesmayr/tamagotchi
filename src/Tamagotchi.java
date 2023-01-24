import GamePanel.Room.*;
import Interface.Components;

import javax.swing.*;
import java.awt.*;

public class Tamagotchi extends JFrame implements Components {

    public Tamagotchi(){
        super("Tamagotchi");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,700);
        setResizable(false);
        add(statusPanel, BorderLayout.NORTH);  //statusPanel from Components
        add(gamePanel, BorderLayout.CENTER); // from Components
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
    }


}