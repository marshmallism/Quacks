package front;
import javax.swing.*;
public class QuacksFrame extends JFrame{
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;

    public QuacksFrame() {
        setTitle("Quacks of Quedlinburg");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setLayout(null);
    }
}
