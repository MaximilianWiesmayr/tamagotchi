package Interface;
import BottomPanel.BottomPanel;
import GamePanel.GamePanel;
import StatusPanel.StatusPanel;

public interface Components {
    StatusPanel statusPanel = new StatusPanel();
    GamePanel gamePanel = new GamePanel();
    BottomPanel bottomPanel = new BottomPanel();  
}
