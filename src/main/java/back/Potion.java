package back;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map.*;
import java.util.*;

public class Potion {
    TreeMap<Integer, Chip> placedChips;
    BufferedImage image;
    int currentPosition;
    public Potion() {
        try {
            image = ImageIO.read(new File("src/main/resources/The Boards/Cauldron.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        currentPosition = 0;
    }
    public void addChip(Chip c) {
        Entry last = getChip(placedChips.size()-1);
        int position;
        if (last != null) {
            position = (int) last.getKey() + c.getValue();
        } else {
            position = c.getValue();
        }
        placedChips.put(position, c);
        currentPosition += position;
    }
    public Entry<Integer, Chip> getChip(int index) {
        SortedSet entries = (SortedSet) placedChips.entrySet();
        Entry lastEntry = (Entry) entries.getLast();
        if (lastEntry != null) {
            return lastEntry;
        }
        return null;
    }

    public int getPosition() {
        return currentPosition;
    }
}
