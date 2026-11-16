package front;
import back.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.*;
import static front.QuacksRunner.*;

public class GameScreenPanel extends JPanel implements MouseListener, KeyListener {
    private static final int ART_WIDTH = 1920;
    private static final int ART_HEIGHT = 1080;

    // Clickable boxes (x, y, width, height)
    Rectangle instruction = new Rectangle(640, 30, 298, 103);
    Rectangle scoreboard = new Rectangle(981, 30, 298, 103);
    Rectangle fortune = new Rectangle(822, 1728, 274, 108);
    Rectangle[] options = new Rectangle[16];

    public QuacksGame g;
    BufferedImage[] diceImages;
    BufferedImage bg;
    BufferedImage[] gameImages;
    public GameScreenPanel(int numPlayers, int set) {
        g = new QuacksGame(numPlayers, set);
        diceImages = new BufferedImage[5];
        gameImages = new BufferedImage[8];
        try {
            diceImages[0] = ImageIO.read(Objects.requireNonNull(GameScreenPanel.class.getResource("/Dice/2VPDice.png")));
            diceImages[1] = ImageIO.read(Objects.requireNonNull(GameScreenPanel.class.getResource("/Dice/DropletForwardDice.png")));
            diceImages[2] = ImageIO.read(Objects.requireNonNull(GameScreenPanel.class.getResource("/Dice/PumpkinDice.png")));
            diceImages[3] = ImageIO.read(Objects.requireNonNull(GameScreenPanel.class.getResource("/Dice/RubyDice.png")));
            diceImages[4] = ImageIO.read(Objects.requireNonNull(GameScreenPanel.class.getResource("/Dice/VictoryPointDice.png")));
            bg = ImageIO.read(Objects.requireNonNull(GameScreenPanel.class.getResource("/Background/GameScreen.png")));
            gameImages[0] = ImageIO.read(Objects.requireNonNull(GameScreenPanel.class.getResource("/FlaskBagRubyExplosion/Bag.png")));
            gameImages[1] = ImageIO.read(Objects.requireNonNull(GameScreenPanel.class.getResource("/FlaskBagRubyExplosion/BlueFlask.png")));
            gameImages[2] = ImageIO.read(Objects.requireNonNull(GameScreenPanel.class.getResource("/FlaskBagRubyExplosion/Explosion.png")));
            gameImages[3] = ImageIO.read(Objects.requireNonNull(GameScreenPanel.class.getResource("/FlaskBagRubyExplosion/GreenFlask.png")));
            gameImages[4] = ImageIO.read(Objects.requireNonNull(GameScreenPanel.class.getResource("/FlaskBagRubyExplosion/RedFlask.png")));
            gameImages[5] = ImageIO.read(Objects.requireNonNull(GameScreenPanel.class.getResource("/FlaskBagRubyExplosion/Ruby.png")));
            gameImages[6] = ImageIO.read(Objects.requireNonNull(GameScreenPanel.class.getResource("/FlaskBagRubyExplosion/YellowFlask.png")));
            gameImages[7] = ImageIO.read(Objects.requireNonNull(GameScreenPanel.class.getResource("/The Boards/Cauldron.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.addMouseListener(this);
        this.addKeyListener(this);

    }
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
        drawPlayers(g2);
    }

    public void drawPlayers(Graphics2D g2) {
        ArrayList<Player> players = g.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            g2.drawImage(gameImages[7], getWidth()/40, getHeight()/6, getWidth()/10*3, getHeight()/3, null);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton()!=MouseEvent.BUTTON1)
            return;
        int x = e.getX();
        int y = e.getY();
        if (instruction.contains(x, y)) {
            showInstructionsPanel();
        } else if (scoreboard.contains(x, y)) {
            showScoringTrackPanel();
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
