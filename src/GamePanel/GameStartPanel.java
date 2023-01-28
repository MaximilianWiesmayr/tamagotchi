package GamePanel;

import GamePanel.Room.Room;
import Interface.Components;
import Interface.Globals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class GameStartPanel extends JPanel implements Globals, Components {
    JTextArea descriptionArea;
    JButton startStopButton;
    Room room;
    public GameStartPanel(Room room){
        this.room = room;
        startStopButton = new JButton("Start");
        startStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Objects.equals(startStopButton.getText(), "Start")){
                    startGameOfCurrRoom();
                } else {
                    stopGameOfCurrRoom();
                }
            }
        });
        descriptionArea = new JTextArea();
        descriptionArea.setEnabled(false);
        setDescription(room.getClass().getName());

        setLayout(new GridBagLayout());
        add(descriptionArea, setTextAreaDimensions(new GridBagConstraints()));
        add(startStopButton, setButtonDimensions(new GridBagConstraints()));
    }

    private void stopGameOfCurrRoom() {
        this.room.stopGame();
        bottomPanel.bathroomButton.setEnabled(true);
        bottomPanel.outdoorButton.setEnabled(true);
        bottomPanel.kitchenButton.setEnabled(true);
        statusPanel.cleanBar.setBarSpeed(SLOW);
        statusPanel.exerciseBar.setBarSpeed(SLOW);
        statusPanel.eatBar.setBarSpeed(SLOW);
        startStopButton.setText("Start");
    }

    private void startGameOfCurrRoom() {
        bottomPanel.bathroomButton.setEnabled(false);
        bottomPanel.outdoorButton.setEnabled(false);
        bottomPanel.kitchenButton.setEnabled(false);
        statusPanel.cleanBar.setBarSpeed(STOP);
        statusPanel.exerciseBar.setBarSpeed(STOP);
        statusPanel.eatBar.setBarSpeed(STOP);
        startStopButton.setText("Stop");
        this.room.startGame();
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
        constraints.ipady = 60;
        constraints.ipadx = 400;
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
