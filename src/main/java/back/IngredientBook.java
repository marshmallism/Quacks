package back;

import java.awt.image.BufferedImage;
import java.util.*;

public class IngredientBook {
    ChipColor color;
    ArrayList<Integer> costs;
    private static int set;
    private BufferedImage image;

    // creates a new ingredient book with the set given
    public IngredientBook(int set, ChipColor color, BufferedImage image) {
        this.set = set;
        this.color = color;
        this.image = image;
        // initializes costs
        switch (set) {
            case 1 -> {

            }
            case 2 -> {

            }
            case 3 -> {

            }
            case 4 -> {

            }
        }
    }
}
