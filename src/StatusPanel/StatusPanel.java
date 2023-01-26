package StatusPanel;

import Interface.Globals;
import java.awt.*;
import javax.swing.*;

public class StatusPanel extends JPanel implements Globals {
    //3 NeedBars
    public NeedBar cleanBar;
    public NeedBar eatBar;
    public NeedBar exerciseBar;
    
    //3 Panels - for each Bar 1
    private JPanel cleanPanel;
    private JPanel eatPanel;
    private JPanel exercisePanel;
    
    public StatusPanel(){
        //3 Bars for needs
        cleanBar = new NeedBar();
        eatBar = new NeedBar();
        exerciseBar = new NeedBar();
        
        //Panel for each needBar to have also text before
        cleanPanel = createPanel("cleanliness:", cleanBar);
        eatPanel = createPanel("hunger:", eatBar);
        exercisePanel = createPanel("sportiness:", exerciseBar);
        
        this.setLayout(new GridLayout(1,3));    //GridLayout with 1 row and 3 cols
        this.add(cleanPanel);
        this.add(eatPanel);
        this.add(exercisePanel);
    }
    
    //Creates a Panel which includes the LabelText and the PrgressBar (NeedBar)
    private JPanel createPanel(String labelText, JProgressBar bar){
        JPanel panel = new JPanel();
        JLabel label = new JLabel(labelText);
        label.setFont(LABEL_FONT);
        panel.add(label);
        panel.add(bar);
        return panel;
    }
            
}
