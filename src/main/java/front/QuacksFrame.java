package front;
import javax.swing.*;
public class QuacksFrame extends JFrame{
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;

    public static final GameScreenPanel gameScreen = new GameScreenPanel();
    public static final InstructionsPanel instructionsPanel = new InstructionsPanel();
    public static final ScoringTrackPanel scoringPanel = new ScoringTrackPanel();
    public static final StartScreenPanel startScreen = new StartScreenPanel();

    public QuacksFrame() {
        setTitle("Quacks of Quedlinburg");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setLayout(null);

        add(startScreen);
    }
}
