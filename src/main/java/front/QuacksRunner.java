package front;

import javax.swing.*;

public class QuacksRunner {
    private static QuacksFrame frame;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            frame = new QuacksFrame();
            frame.setVisible(true);
        });
    }
    public static void showGame() {
        startScreen.setVisible(false);
        instructionsPanel.setVisible(false);
        add(gameScreen);
    }
    public static void showInstructionsPanel() {

    }
    public static void hideInstructionsPanel() {

    }
    public static void showScoringTrackPanel() {

    }
    public static void hideScoringTrackPanel() {

    }
}
