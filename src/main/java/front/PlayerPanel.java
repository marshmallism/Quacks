package front;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.util.Objects;

public class PlayerPanel extends JPanel implements MouseListener {
    private static final int ART_WIDTH = 1920;
    private static final int ART_HEIGHT = 1080;

    int numPlayers;
    int set;
    BufferedImage[] images;
    int scrollLength, scrollHeight;
    Font fancy;
    String state = "players";

    // Clickable boxes (x, y, width, height)
    private static final Rectangle TW0_PLAYERS = new Rectangle(320, 618, 275, 135);
    private static final Rectangle THREE_PLAYERS = new Rectangle(823, 618, 275, 135);
    private static final Rectangle FOUR_PLAYERS = new Rectangle(1325, 618, 275, 135);
    private static final Rectangle SET_ONE = new Rectangle(805, 510, 315, 75);
    private static final Rectangle SET_TWO = new Rectangle(805, 611, 315, 72);
    private static final Rectangle SET_THREE = new Rectangle(805, 713, 315, 72);
    private static final Rectangle SET_FOUR = new Rectangle(805, 713, 315, 72);


    public PlayerPanel() {
        images = new BufferedImage[3];
        try {
            images[0] = ImageIO.read(Objects.requireNonNull(PlayerPanel.class.getResource("/Background/SetScreen.png")));
            images[1] = ImageIO.read(Objects.requireNonNull(PlayerPanel.class.getResource("/Background/HowManyPlayerScreen.png")));
            images[2] = ImageIO.read(Objects.requireNonNull(PlayerPanel.class.getResource("/Background/Scroll.png")));
//            File fontFile = new File("/resources/Fonts/EFCO Brookshire.ttf");
//            Font baseFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
//            fancy = baseFont.deriveFont(Font.PLAIN, 48);
        } catch (Exception e) {
            e.printStackTrace();
        }
        addMouseListener(this);
    }
    public void paint(Graphics g) {
        int w = getWidth();
        int h = getHeight();
        scrollLength = w/7;
        scrollHeight = h/8;
        int xPadding, middle, middlePadding;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2d.setFont(fancy);
//        FontMetrics metrics = g2d.getFontMetrics(fancy);
        if (state.equals("players")) {
            g2d.drawImage(images[0], 0, 0, w, h, null);
            xPadding = w/6;
            middle = w - 2 * xPadding;
            middlePadding = (middle - scrollLength * 3) / 2;
            for (int i = 0; i < 3; i++) {
                g2d.drawImage(images[2], scrollLength * i + middlePadding * i + xPadding, h / 7 * 4, scrollLength, scrollHeight, null);
                String text = i + 2 + "";
//                int x = (scrollLength - metrics.stringWidth(text)) / 2;
//                int y = ((scrollHeight - metrics.getHeight()) / 2) + metrics.getAscent();
//                g2d.drawString(text, x + scrollLength * i + middlePadding * i + xPadding, y + h / 7 * 4);
            }
        } else if (state.equals("set")) {
            g2d.drawImage(images[1], 0, 0, w, h, null);
            xPadding = w/6;
            middle = w - 2 * xPadding;
            middlePadding = (middle - scrollLength * 4) / 3;
            for (int i = 0; i < 4; i++) {
                g2d.drawImage(images[2], scrollLength * i + middlePadding * i + xPadding, h / 7 * 4, scrollLength, scrollHeight, null);
                String text = i + 1 + "";
//                int x = (scrollLength - metrics.stringWidth(text)) / 2;
//                int y = ((scrollHeight - metrics.getHeight()) / 2) + metrics.getAscent();
//                g2d.drawString(text, x + scrollLength * i + middlePadding * i + xPadding, y + h / 7 * 4);
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() != MouseEvent.BUTTON1) {
            return; // left button only
        }
        int x = e.getX() * ART_WIDTH / getWidth();
        int y = e.getY() * ART_HEIGHT / getHeight();
        if (state.equals("players")) {
            if (TW0_PLAYERS.contains(x, y)) {
                numPlayers = 2;
            } else if (THREE_PLAYERS.contains(x, y)) {
                numPlayers = 3;
            } else if (FOUR_PLAYERS.contains(x, y)) {
                numPlayers = 4;
            }
            state = "set";
            repaint();
        } else if (state.equals("set")) {
            if (SET_ONE.contains(x, y)) {
                set = 1;
            } else if (SET_TWO.contains(x, y)) {
                set = 2;
            } else if (SET_THREE.contains(x, y)) {
                set = 3;
            } else if (SET_FOUR.contains(x, y)) {
                set = 4;
            }
            QuacksRunner.showGame(numPlayers, set);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
