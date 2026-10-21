package back;

import java.util.*;

public class Bag {
    private final List<Chip> availableChips = new ArrayList<>();
    private final List<Chip> drawnChips = new ArrayList<>();

    //creates a new bag with the default chips
    public Bag() {
        resetBag();
    }

    //resets the bag to the default chips
    public void resetBag() {
        availableChips.clear();
        drawnChips.clear();
        // white chips: 4x1, 2x2, 1x3; 1 orange chip; 1 green chip
        for (int i = 0; i < 4; i++) availableChips.add(new Chip(ChipColor.WHITE, 1));
        for (int i = 0; i < 2; i++) availableChips.add(new Chip(ChipColor.WHITE, 2));
        availableChips.add(new Chip(ChipColor.WHITE, 3));
        availableChips.add(new Chip(ChipColor.ORANGE, 1));
        availableChips.add(new Chip(ChipColor.GREEN, 1));
        shuffle();
    }

    //shuffles the available chips in the bag
    public void shuffle() {
        Collections.shuffle(availableChips);
    }

    //draws a random chip from the bag and adds it to the drawn chips list
    public Chip draw() {
        if (availableChips.isEmpty()) return null;
        Chip chip = availableChips.removeFirst();
        drawnChips.add(chip);
        return chip;
    }

    //returns a chip to the bag and removes it from the drawn chips list
    public void returnChip(Chip c) {
        drawnChips.remove(c);
        availableChips.add(c);
        shuffle();
    }

    //adds a chip to the bag
    public void addChip(Chip chip) {
        availableChips.add(chip);
    }

    //resets the bag for a new round, returning all drawn chips to the available chips list and shuffling
    //this includes any bought chips
    public void roundReset() {
        availableChips.addAll(drawnChips);
        drawnChips.clear();
        shuffle();
    }

    public List<Chip> getAvailableChips() {
        return availableChips;
    }

    public List<Chip> getDrawnChips() {
        return drawnChips;
    }
}
