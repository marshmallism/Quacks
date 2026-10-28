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
        IngredientBook.set = set;
        this.color = color;
        this.image = image;
        costs = new ArrayList<>();
        // initializes costs
        switch (color) {
            //white is missing bc can't buy
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
    //returns cost of the specified index; 0 is the first chip, 1 is the second, 2 is the third
    public int getCost(int index) {
        return costs.get(index);
    }

    //applies rule to a player, according to the set, color, and index chip
    public void applyRule(Player p, int index) {
        Bag b = p.getBag();
        switch (color) {
            //orange and white don't have special rules
            case BLUE -> {

            }
            case RED -> {}
            case YELLOW -> {}
            case GREEN -> {}
            case BLACK -> {}
            case PURPLE -> {}

        }
    }
}
