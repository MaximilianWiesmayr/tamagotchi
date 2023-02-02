package StatusPanel;

import GamePanel.GameStartPanel;
import Interface.Components;
import Interface.Globals;
import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class NeedBar extends JProgressBar implements Components, Globals, ChangeListener {
    Timer timer;
    
    public NeedBar(){
        super();
        addChangeListener(this);
        setValue(100);      //in the beginning 100%
        
        //change look of Bar
        setStringPainted(true);     //show percentage 
        setForeground(COLOR_BAR_FG_GOOD);
        setBackground(COLOR_BAR_BG);
        setBorder(BorderFactory.createLineBorder(black, 1, true));

        startTimer();
    }

    /**
     * more than 30% -> green
     * less or equal 30% -> orange
     * less or equal 10% -> red
     * if 0% -> death
    */
    @Override
    public void stateChanged(ChangeEvent e) {
        if(this.getValue() > 30) setForeground(COLOR_BAR_FG_GOOD);
        else if(this.getValue() <= 30 && this.getValue() > 10) setForeground(COLOR_BAR_FG_BAD);
        else if(this.getValue() <= 10) setForeground(COLOR_BAR_FG_WORSE);
    }

    private void startTimer(){
        //loosing percentage over time
        timer = new Timer(FAST, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                loosePercentage(1);
            }
        });
        timer.start();
        //barSpeed(SLOW);  // for testing different speeds
    }

    // changes speed of the decay of the bars
    public void setBarSpeed(int delay){
        if(delay == STOP){
            timer.stop();
        } else {
            timer.stop();
            timer.setDelay(delay);
            timer.start();
        }
    }
    
    public void loosePercentage(int n){
        setValue(getValue()-n);     //n% are subtracted
        if(getValue() <= 0){
            gamePanel.gameStartPanel.creatureDied();
        }
    }

    public void gainPercentage(int n){
        setValue(getValue()+(n*3));
    }

    public void setPercentage(int n) {
        setValue(n);
    }
}
