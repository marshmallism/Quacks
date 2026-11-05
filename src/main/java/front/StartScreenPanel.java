package front;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

//draws the first screen
public class StartScreenPanel extends JPanel implements MouseListener {
    // All artwork is 1920x1080, so the button boxes below are in that coordinate space.
    private static final int ART_WIDTH = 1920;
    private static final int ART_HEIGHT = 1080;

    // Clickable boxes (x, y, width, height)
    private static final Rectangle START_BOX        = new Rectangle(805, 510, 315, 75);
    private static final Rectangle INSTRUCTIONS_BOX = new Rectangle(805, 611, 315, 72);
    private static final Rectangle QUIT_BOX         = new Rectangle(805, 713, 315, 72);

    // Decorative images (not clickable)
    private BufferedImage background;
    private BufferedImage cauldron;
    private BufferedImage logo;

    // Image with the three buttons on it
    private BufferedImage buttons;

    public StartScreenPanel() {
        try {
            background = ImageIO.read(new File("Background/Game screen (2).png"));
            cauldron = ImageIO.read(new File("Background/CouldronFront.png"));
            logo = ImageIO.read(new File("Background/Logo.png"));
            buttons = ImageIO.read(new File("Background/FrontButton.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int w = getWidth();
        int h = getHeight();
        g.drawImage(background,0, 0, w, h, null);
        g.drawImage(cauldron, 0, 0, w, h, null);
        g.drawImage(logo, 0, 0, w, h, null);
        g.drawImage(buttons, 0, 0, w, h, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() != MouseEvent.BUTTON1) {
            return; // left button only
        }
        // Convert the click from panel pixels to 1920x1080 artwork pixels
        int x = e.getX() * ART_WIDTH / getWidth();
        int y = e.getY() * ART_HEIGHT / getHeight();

        if (START_BOX.contains(x, y)) {
            QuacksRunner.showGame();
        } else if (INSTRUCTIONS_BOX.contains(x, y)) {
            QuacksRunner.showInstructionsPanel();
        } else if (QUIT_BOX.contains(x, y)) {
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
