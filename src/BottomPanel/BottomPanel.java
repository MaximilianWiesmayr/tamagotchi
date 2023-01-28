package BottomPanel;

import GamePanel.Room.*;
import Interface.Components;
import StatusPanel.NeedBar;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import static Interface.Globals.LABEL_FONT_STATUSPANEL;

public class BottomPanel extends JPanel {

    public RoomButton bathroomButton;
    public RoomButton kitchenButton;
    public RoomButton outdoorButton;

    //3 Panels - for each button
    private JPanel bathroomPanel;
    private JPanel kitchenPanel;
    private JPanel outdoorPanel;

    public BottomPanel() {
        //3 buttons to change the rooms
        bathroomButton = new RoomButton("Bathroom");
        kitchenButton = new RoomButton("Kitchen");
        outdoorButton = new RoomButton("Outdoor");

        //Panel for each button
        bathroomPanel = createPanel(bathroomButton);
        kitchenPanel = createPanel(kitchenButton);
        outdoorPanel = createPanel(outdoorButton);

        this.setLayout(new GridLayout(1, 3));    //GridLayout with 1 row and 3 cols
        this.add(bathroomPanel);
        this.add(kitchenPanel);
        this.add(outdoorPanel);
    }

    //Creates a Panel which includes the button
    private JPanel createPanel(RoomButton button) {
        JPanel panel = new JPanel();
        panel.add(button);
        return panel;
    }
}
