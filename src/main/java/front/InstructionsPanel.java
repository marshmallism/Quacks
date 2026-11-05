package front;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;


public class InstructionsPanel extends JPanel implements MouseListener {
    // All artwork is 1920x1080
    private static final int ART_WIDTH = 1920;
    private static final int ART_HEIGHT = 1080;

    // Size of the card, and where its top-left corner is inside each page image
    private static final int CARD_WIDTH = 832;
    private static final int CARD_HEIGHT = 620;
    private static final int[] CARD_X = {557, 501, 546};
    private static final int[] CARD_Y = {187, 277, 232};

    // Where the card is drawn: centered in the 1920x1080 artwork
    private static final int DRAW_X = (ART_WIDTH - CARD_WIDTH) / 2;
    private static final int DRAW_Y = (ART_HEIGHT - CARD_HEIGHT) / 2;

    // Button boxes
    private static final Rectangle BACK_BOX   = new Rectangle(40, 548, 142, 44);
    private static final Rectangle RETURN_BOX = new Rectangle(253, 548, 317, 44);
    private static final Rectangle NEXT_BOX   = new Rectangle(642, 548, 140, 44);

    private BufferedImage background;
    private ArrayList<BufferedImage> pages = new ArrayList<BufferedImage>(); // cropped cards
    private int pageNum;

    public InstructionsPanel() {
        pageNum = 0;
        try {
            background = ImageIO.read(new File("Background/Game screen (2).png"));
            for (int i = 0; i < 3; i++) {
                BufferedImage full = ImageIO.read(new File("Background/Instructions page " + (i + 1) + ".png"));
                pages.add(full.getSubimage(CARD_X[i], CARD_Y[i], CARD_WIDTH, CARD_HEIGHT));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        addMouseListener(this);
    }

    // Called when the panel is opened so the instructions always start on page 1
    public void resetPage() {
        pageNum = 0;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int w = getWidth();
        int h = getHeight();
        g.drawImage(background, 0, 0, w, h, null);

        // Draw the card scaled to the panel,  in the same place
        int x = DRAW_X * w / ART_WIDTH;
        int y = DRAW_Y * h / ART_HEIGHT;
        int cardW = CARD_WIDTH * w / ART_WIDTH;
        int cardH = CARD_HEIGHT * h / ART_HEIGHT;
        g.drawImage(pages.get(pageNum), x, y, cardW, cardH, null);
    }

    // Is the click (in 1920x1080 coordinates) inside this button?
    private boolean hit(Rectangle box, int x, int y) {
        return x >= DRAW_X + box.x && x <= DRAW_X + box.x + box.width
                && y >= DRAW_Y + box.y && y <= DRAW_Y + box.y + box.height;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() != MouseEvent.BUTTON1) {
            return; // left button only
        }
        int x = e.getX() * ART_WIDTH / getWidth();
        int y = e.getY() * ART_HEIGHT / getHeight();

        if (hit(RETURN_BOX, x, y)) {
            QuacksRunner.showStartScreen();
        } else if (hit(NEXT_BOX, x, y) && pageNum < pages.size() - 1) {
            pageNum++;     // no Next button on the last page
            repaint();
        } else if (hit(BACK_BOX, x, y) && pageNum > 0) {
            pageNum--;     // no Back button on the first page
            repaint();
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
