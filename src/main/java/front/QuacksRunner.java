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
        });
    }
    public static void showStartScreen() {
        frame.add(startScreen);
        startScreen.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }
    public static void showGame() {
        startScreen.setVisible(false);
        instructionsPanel.setVisible(false);
        scoringPanel.setVisible(false);
        frame.add(gameScreen);
        frame.revalidate();
        frame.repaint();
    }
    public static void showInstructionsPanel() {
        gameScreen.setVisible(false);
        startScreen.setVisible(false);
        frame.add(instructionsPanel);
        instructionsPanel.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }
    public static void showScoringTrackPanel() {
        gameScreen.setVisible(false);
        startScreen.setVisible(false);
        instructionsPanel.setVisible(false);
        frame.add(scoringPanel);
        scoringPanel.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }
}
