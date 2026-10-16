package back;

import java.util.*;

public class Bag {
    private final List<Chip> availableChips = new ArrayList<>();
    private final List<Chip> drawnChips = new ArrayList<>();

    public Bag() {
        resetBag();
    }

    public void resetBag() {
        availableChips.clear();
        drawnChips.clear();
        // white chips: 4x1, 2x2, 1x3, 1 orange chip, 1 green chip
        for (int i = 0; i < 4; i++) availableChips.add(new Chip(ChipColor.WHITE, 1));
        for (int i = 0; i < 2; i++) availableChips.add(new Chip(ChipColor.WHITE, 2));
        availableChips.add(new Chip(ChipColor.WHITE, 3));
        availableChips.add(new Chip(ChipColor.ORANGE, 1));
        availableChips.add(new Chip(ChipColor.GREEN, 1));
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(availableChips);
    }

    public Chip draw() {
        if (availableChips.isEmpty()) return null;
        Chip chip = availableChips.removeFirst();
        drawnChips.add(chip);
        return chip;
    }

    public void returnChip(Chip c) {
        drawnChips.remove(c);
        availableChips.add(c);
        shuffle();
    }

    public void addChip(Chip chip) {
        availableChips.add(chip);
    }

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
