package GamePanel;

import GamePanel.Room.Room;
import Interface.Components;
import Interface.Globals;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class GameStartPanel extends JPanel implements Globals, Components {
    JTextArea descriptionArea;
    JButton startStopButton;
    Room room;

    int chance = 0;
    public GameStartPanel(Room room){
        this.room = room;
        startStopButton = new JButton("Start");
        startStopButton.addActionListener(e -> {
            if(Objects.equals(startStopButton.getText(), "Start")){
                startGameOfCurrRoom();
            } else if(Objects.equals(startStopButton.getText(), "Stop")) {
                stopGameOfCurrRoom();
            } else {
                tryReviving();
            }
        });
        descriptionArea = new JTextArea();
        descriptionArea.setDisabledTextColor(COLOR_DESCRIPTION);
        descriptionArea.setEnabled(false);
        setDescription(room.getClass().getName());

        setLayout(new GridBagLayout());
        add(descriptionArea, setTextAreaDimensions(new GridBagConstraints()));
        add(startStopButton, setButtonDimensions(new GridBagConstraints()));
    }

    public void creatureDied(){
        if(Objects.equals(startStopButton.getText(), "Stop")){
            this.room.stopGame();
        }
        statusPanel.cleanBar.setBarSpeed(STOP);
        statusPanel.exerciseBar.setBarSpeed(STOP);
        statusPanel.eatBar.setBarSpeed(STOP);
        startStopButton.setText("try revive");
        descriptionArea.setVisible(false);
        this.room.creature.setAppearance(3, true);
        this.room.repaint();
    }

    private void tryReviving() {
        if((int)(Math.random() * chance) < REVIVECHANCE) {
            chance++;
            startStopButton.setText("Start");
            descriptionArea.setVisible(true);
            statusPanel.cleanBar.setPercentage(100);
            statusPanel.exerciseBar.setPercentage(100);
            statusPanel.eatBar.setPercentage(100);
            if(this.room.getClass().toString().contains("Outdoor")){
                this.room.creature.setAppearance(2, true);
            } else {
                this.room.creature.setAppearance(0, true);
            }
            changeUIAccesability(true, FAST);
            this.room.repaint();
        } else {
            try {
                this.room.backgroundImage = ImageIO.read(new File(DEATHSCREEN));
            } catch (IOException e){
                System.out.println("Fehler beim Laden des Hintergrundbildes");
            }
            this.room.scoreLabel.setVisible(false);
            this.setVisible(false);
            bottomPanel.setVisible(false);

            this.room.repaint();
        }
    }

    private void stopGameOfCurrRoom() {
        this.room.stopGame();
        startStopButton.setText("Start");
        descriptionArea.setVisible(true);
        changeUIAccesability(true, FAST);
    }

    private void startGameOfCurrRoom() {
        changeUIAccesability(false, SLOW);
        startStopButton.setText("Stop");
        descriptionArea.setVisible(false);
        this.room.startGame();
    }

    private void changeUIAccesability(boolean mouseListener, int speed){
        if(!mouseListener) {
            bottomPanel.bathroomButton.removeMouseListener(bottomPanel.bathroomButton);
            bottomPanel.outdoorButton.removeMouseListener(bottomPanel.outdoorButton);
            bottomPanel.kitchenButton.removeMouseListener(bottomPanel.kitchenButton);
        }else {
            bottomPanel.bathroomButton.addMouseListener(bottomPanel.bathroomButton);
            bottomPanel.outdoorButton.addMouseListener(bottomPanel.outdoorButton);
            bottomPanel.kitchenButton.addMouseListener(bottomPanel.kitchenButton);
        }
        statusPanel.cleanBar.setBarSpeed(speed);
        statusPanel.exerciseBar.setBarSpeed(speed);
        statusPanel.eatBar.setBarSpeed(speed);
    }

    private GridBagConstraints setButtonDimensions(GridBagConstraints constraints) {
        //constraints.ipady = 20;
        constraints.ipadx = 50;
        constraints.insets = new Insets(20,40,20,40);
        constraints.gridwidth = 1;
        constraints.gridx = 2;
        constraints.gridy = 0;

        return constraints;
    }

    private GridBagConstraints setTextAreaDimensions(GridBagConstraints constraints) {
        constraints.ipady = 30;
        constraints.ipadx = 100;
        constraints.insets = new Insets(5,0,0,0);
        constraints.gridwidth = 2;
        constraints.gridx = 0;
        constraints.gridy = 0;

        return constraints;
    }

    public void changeRoom(Room room){
        this.room = room;
        setDescription(room.getClass().getName());
    }

    private void setDescription(String roomName){
        switch (roomName) {
            case "GamePanel.Room.Kitchen" -> descriptionArea.setText(GAMEDESCRIPTION_KITCHEN);
            case "GamePanel.Room.Bathroom" -> descriptionArea.setText(GAMEDESCRIPTION_BATHROOM);
            case "GamePanel.Room.Outdoor" -> descriptionArea.setText(GAMEDESCRIPTION_OUTDOOR);
            default -> descriptionArea.setText("somethings wrong here");
        }
    }

}
