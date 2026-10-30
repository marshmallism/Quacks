package back;
import java.util.*;
import static java.lang.System.*;

public class IngredientsAndRubies {

    private int rubies;
    private Map<String, Integer> remaining;
    private Map<String,Map<Integer, Integer>> costs;

    public IngredientsAndRubies(int set) {
        rubies = set;
        remaining = new TreeMap<String, Integer>();
        costs = new TreeMap<String,Map<Integer, Integer>>();
    }

    public Ingredient takeIngredient(ChipColor color, int value) {

    }

    public void returnRuby() {

    }

    public int getCost(ChipColor color, int value) {

    }

    public int getRemaining() {

    }

    }
