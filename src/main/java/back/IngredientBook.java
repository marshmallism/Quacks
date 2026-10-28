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
        costs = new ArrayList<>();
        // initializes costs
        switch (color) {
            case ORANGE -> {
                costs.add(3);
            }
            case BLUE -> {
                if (set == 3) {
                    costs.add(4);
                    costs.add(8);
                    costs.add(14);
                } else {
                    costs.add(5);
                    costs.add(10);
                    costs.add(19);
                }
            }
            case RED -> {
                switch (set) {
                    case 1 -> {
                        costs.add(6);
                        costs.add(10);
                        costs.add(16);
                    }
                    case 2 -> {
                        costs.add(4);
                        costs.add(8);
                        costs.add(14);
                    }
                    case 3 -> {
                        costs.add(5);
                        costs.add(8);
                        costs.add(15);
                    }
                    case 4 -> {
                        costs.add(7);
                        costs.add(11);
                        costs.add(17);
                    }
                }
            }
            case YELLOW -> {
                if (set == 2) {
                    costs.add(9);
                    costs.add(13);
                    costs.add(19);
                }
                costs.add(8);
                costs.add(12);
                costs.add(18);
            }
            case GREEN -> {
                if (set == 1 || set == 4) {
                    costs.add(4);
                    costs.add(8);
                    costs.add(14);
                } else if (set == 2){
                    costs.add(6);
                    costs.add(11);
                    costs.add(18);
                } else {
                    costs.add(6);
                    costs.add(11);
                    costs.add(21);
                }
            }
            case BLACK -> {
                costs.add(1);
            }
            case PURPLE -> {
                if (set == 1) {
                    costs.add(9);
                } else if (set == 2) {
                    costs.add(12);
                } else if (set == 3) {
                    costs.add(10);
                } else {
                    costs.add(11);
                }
            }
        }
    }
}
