package StatusPanel;

import Interface.Globals;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class NeedBar extends JProgressBar implements Globals, ChangeListener {
    public NeedBar(){
        super();
        addChangeListener(this);
    }

    @Override
    public void setValue(int n) {
        super.setValue(n);
    }

    //if 0% dann tod
    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
