package front;
import back.QuacksGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class GameScreenPanel extends JPanel implements MouseListener, KeyListener {
    private static final int ART_WIDTH = 1920;
    private static final int ART_HEIGHT = 1080;

    // Clickable boxes (x, y, width, height)
    Rectangle instruction = new Rectangle(640, 30, 1, 1);
    Rectangle scoreboard = new Rectangle();
    Rectangle[] options = new Rectangle[16];

    private static final Rectangle START_BOX        = new Rectangle(805, 510, 315, 75);
    private static final Rectangle INSTRUCTIONS_BOX = new Rectangle(805, 611, 315, 72);
    private static final Rectangle QUIT_BOX         = new Rectangle(805, 713, 315, 72);

    public QuacksGame g;
    BufferedImage[] diceImages;
    BufferedImage bg;
    BufferedImage[] gameImages;
    public GameScreenPanel(int numPlayers, int set) {
        QuacksGame g = new QuacksGame(numPlayers, set);
        diceImages = new BufferedImage[5];
        gameImages = new BufferedImage[7];
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.addMouseListener(this);
        this.addKeyListener(this);

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
