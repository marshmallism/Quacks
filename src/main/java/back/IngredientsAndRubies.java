package back;
import java.util.*;
import static java.lang.System.*;

public class IngredientsAndRubies {

    private static final int TOTAL_RUBIES = 20;

    private int rubies;
    private Map<ChipColor, Map<Integer, Integer>> remaining;
    private Map<ChipColor, Map<Integer, Integer>> costs;
    
    public IngredientsAndRubies(int set) {
        rubies = TOTAL_RUBIES;
        remaining = new TreeMap<ChipColor, Map<Integer, Integer>>();
        costs = new TreeMap<ChipColor, Map<Integer, Integer>>();
        fillRemaining();
        fillCosts(set);
    }

    public Chip takeIngredient(ChipColor color, int value) { //takes ingredient from pile
        if (getRemaining(color, value) <= 0) {
            return null;
        }
        
        remaining.get(color).put(value, getRemaining(color, value) - 1);
        return new Chip(color, value);
    }

    public boolean takeRuby() { //takes one ruby from the pile, false if none are left
    if (rubies <= 0) {
        return false;
    }
    rubies--;
    return true;
}

    public void returnRuby() { //returns ruby back to ruby pile
        rubies++;
    }

    public int getCost(ChipColor color, int value) { //gets the cost using chip and a value and returns it
        Map<Integer, Integer> map = costs.get(color); //map of the costs in the costs map
        
        if (map == null || !map.containsKey(value)) {
            return -1;
        }
        
        return map.get(value);
    }
    private void fillRemaining() { //fils the remaining map
        addRemaining(ChipColor.WHITE, 1, 20);
        addRemaining(ChipColor.WHITE, 2, 8);
        addRemaining(ChipColor.WHITE, 3, 4);

        addRemaining(ChipColor.ORANGE, 1, 20);

        addRemaining(ChipColor.GREEN, 1, 15);
        addRemaining(ChipColor.GREEN, 2, 10);
        addRemaining(ChipColor.GREEN, 4, 13);

        addRemaining(ChipColor.BLUE, 1, 14);
        addRemaining(ChipColor.BLUE, 2, 10);
        addRemaining(ChipColor.BLUE, 4, 10);

        addRemaining(ChipColor.RED, 1, 12);
        addRemaining(ChipColor.RED, 2, 8);
        addRemaining(ChipColor.RED, 4, 10);

        addRemaining(ChipColor.YELLOW, 1, 13);
        addRemaining(ChipColor.YELLOW, 2, 6);
        addRemaining(ChipColor.YELLOW, 4, 10);

        addRemaining(ChipColor.PURPLE, 1, 15);

        addRemaining(ChipColor.BLACK, 1, 18);
    }

     private void addRemaining(ChipColor color, int value, int count) { //helps the fillRemaining() in adding it to the map
        if (!remaining.containsKey(color)) {
            remaining.put(color, new TreeMap<Integer, Integer>());
        }
        remaining.get(color).put(value, count);
    }

    

   public int getRemaining(ChipColor color, int value) {
    Map<Integer, Integer> map = remaining.get(color); // map inside the remaining map
    if (map == null || !map.containsKey(value)) {
        return 0;
    }
    return map.get(value);
}

    public int getRuby() {
        return rubies;
    }

    private void fillCosts(int set) { //fills the cost map
        addCost(ChipColor.ORANGE, 1, 3);
        addCost(ChipColor.BLACK, 1, 10);

        switch (set) {
            case 1:
                addCosts(ChipColor.GREEN, 4, 8, 14);
                addCosts(ChipColor.BLUE, 5, 10, 19);
                addCosts(ChipColor.RED, 6, 10, 16);
                addCosts(ChipColor.YELLOW, 8, 12, 18);
                addCost(ChipColor.PURPLE, 1, 9);
                break;
            case 2:
                addCosts(ChipColor.GREEN, 6, 11, 18);
                addCosts(ChipColor.BLUE, 5, 10, 19);
                addCosts(ChipColor.RED, 4, 8, 14);
                addCosts(ChipColor.YELLOW, 9, 13, 19);
                addCost(ChipColor.PURPLE, 1, 12);
                break;
            case 3:
                addCosts(ChipColor.GREEN, 6, 11, 21);
                addCosts(ChipColor.BLUE, 4, 8, 14);
                addCosts(ChipColor.RED, 5, 9, 15);
                addCosts(ChipColor.YELLOW, 8, 12, 18);
                addCost(ChipColor.PURPLE, 1, 10);
                break;
            default: 
                addCosts(ChipColor.GREEN, 4, 8, 14);
                addCosts(ChipColor.BLUE, 5, 10, 19);
                addCosts(ChipColor.RED, 7, 11, 17);
                addCosts(ChipColor.YELLOW, 8, 12, 18);
                addCost(ChipColor.PURPLE, 1, 11);
        }
    }

    private void addCost(ChipColor color, int value, int cost) { //helps the fillCosts() in filling if only one type of coin
        if (!costs.containsKey(color)) {
            costs.put(color, new TreeMap<Integer, Integer>());
        }
        costs.get(color).put(value, cost);
    }

    private void addCosts(ChipColor color, int cost1, int cost2, int cost4) { //helps the fillCosts() in filling if multiple types of coins
        addCost(color, 1, cost1);
        addCost(color, 2, cost2);
        addCost(color, 4, cost4);
    }

    }
