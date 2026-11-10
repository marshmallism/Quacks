package front;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;

public class PlayerPanel extends JPanel implements MouseListener {
    int numPlayers;
    int set;
    BufferedImage[] images;
    int scrollLength = getWidth()/9 * 2;
    int scrollHeight = 400;
    public PlayerPanel() {
        images = new BufferedImage[2];
        try {
            images[0] = ImageIO.read(new File("src/main/resources/Background/SetScreen.png"));
            images[1] = ImageIO.read(new File("src/main/resources/Background/Scroll.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void paint(Graphics g) {
        g.drawImage(images[0], 0, 0, getWidth(), getHeight(), null);
        if (numPlayers!=0) {
            g.drawString("Players:" + numPlayers, getWidth()/2, getHeight()/2);
        }
        for (int i = 0; i < 3; i++) {
            g.drawImage(images[1], scrollLength * i + getWidth()/9 * (i+1),getHeight()/2, scrollLength, scrollHeight, null);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {

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
