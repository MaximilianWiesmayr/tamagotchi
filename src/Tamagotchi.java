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
        setVisible(true);
    }


}