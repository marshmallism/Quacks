package front;
import javax.swing.*;
import java.awt.*;
public class QuacksFrame extends JFrame{
    private static final int WIDTH = 960;
    private static final int HEIGHT = 540;

    public QuacksFrame() {
        setTitle("Quacks of Quedlinburg");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        pack();
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }
}
