package front;

import javax.swing.*;

public class QuacksRunner {
    private static QuacksFrame frame;
    public static final GameScreenPanel gameScreen = new GameScreenPanel();
    public static final InstructionsPanel instructionsPanel = new InstructionsPanel();
    public static final ScoringTrackPanel scoringPanel = new ScoringTrackPanel();
    public static final StartScreenPanel startScreen = new StartScreenPanel();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            frame = new QuacksFrame();
            frame.setVisible(true);
            showStartScreen();
        });
    }

    // Shows one panel and hides the rest
    private static void show(JPanel panel) {
        gameScreen.setVisible(false);
        instructionsPanel.setVisible(false);
        scoringPanel.setVisible(false);
        startScreen.setVisible(false);

        panel.setBounds(0, 0, QuacksFrame.getFrameWidth(), QuacksFrame.getFrameHeight());
        frame.add(panel);
        panel.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }

    public static void showStartScreen() {
        show(startScreen);
    }
    public static void showGame() {
        show(gameScreen);
    }
    public static void showInstructionsPanel() {
        instructionsPanel.resetPage();
        show(instructionsPanel);
    }
    public static void showScoringTrackPanel() {
        show(scoringPanel);
    }
}
