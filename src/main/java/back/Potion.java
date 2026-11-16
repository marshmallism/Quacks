package back;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map.*;
import java.util.*;

public class Potion {
    //potion board values
    private static final int[] COINS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 15, 16, 16, 17, 17, 18, 18, 19, 19, 20, 20, 21, 21, 22, 22, 23, 23, 24, 24, 25, 25, 26, 26, 27, 27, 28, 28, 29, 29, 30, 30, 31, 31, 32, 32, 33, 35};
    private static final int[] VPS = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 12, 12, 13, 13, 13, 14, 14, 15};
    private static final boolean[] RUBY_SPACE = {false, false, false, false, false, true, false, false, false, true, false, false, false, true, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, true, false, false, false, true, false, true, false, false, false, true, false, true, false, false, false, true, false, false, false, true, false, true, false};
    ArrayList<PlacedChip> placedChips;
    BufferedImage image;
    int dropletPosition;
    int ratOffset;
    int currentPosition;
    boolean exploded;

    //set rules
    int blueShieldRemaining;
    boolean explosionProtected;
    boolean doubleNextChip;
    public Potion() {
        try {
            image = ImageIO.read(new File("src/main/resources/The Boards/Cauldron.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        resetRound();
    }
    public void resetRound() {
        placedChips = new ArrayList<>();
        currentPosition = 0;
        ratOffset = 0;
        exploded = false;
        blueShieldRemaining = 0;
        explosionProtected = false;
        doubleNextChip = false;
    }
    public int getPosition() {
        return currentPosition;
    }
    public void moveDroplet(int s) {
        dropletPosition = Math.min(53, dropletPosition + s);
    }
    public int getRatOffset() {
        return ratOffset;
    }
    public void setRatOffset(int offset) {
        ratOffset = offset;
    }
    public int getStartSpace() {
        // the starting space is the droplet position plus the rat offset, but not exceeding 53
        return Math.min(53, dropletPosition + ratOffset);
    }
    public int getLastSpace() {
        if (placedChips.isEmpty())
            return getStartSpace();
        return placedChips.size()-1;
    }
    public int getScoringSpace() {
        // the scoring space is the last space plus one, but not exceeding 54
        return Math.min(54, getLastSpace()+1);
    }
    public int getCoins() {
        return COINS[getScoringSpace()];
    }
    public int getVPs() {
        return VPS[getScoringSpace()];
    }
    public boolean hasRuby() {
        return RUBY_SPACE[getScoringSpace()];

    }
    public static int getCoinsForSpace(int space) {
        return COINS[Math.min(54, space)];
    }
    public static int getVPsForSpace(int space) {
        return VPS[Math.min(54, space)];
    }
    public static boolean hasRubyForSpace(int space) {
        return RUBY_SPACE[Math.min(54, space)];
    }
    public int getWhiteSum() {
        int sum = 0;
        for (PlacedChip pc : placedChips) {
            if (pc.getChip().getColor() == ChipColor.WHITE) {
                sum += pc.getChip().getValue();
            }
        }
        return sum;
    }
    public int getExplosionThreshold(int set) {
        if (set == 3) {
            int yellowCount = countIngredient(ChipColor.YELLOW);
            if (yellowCount >= 3)
                return 9;
            if (yellowCount >= 1)
                return 8;
        }
        return 7;
    }
    public int countIngredient(ChipColor color) {
        int count = 0;
        for (PlacedChip pc : placedChips) {
            if (pc.getChip().getColor() == color) {
                count++;
            }
        }
        return count;
    }
    public boolean isExploded() {
        return exploded;
    }
    public boolean isExplosionProtected() {
        return explosionProtected;
    }
    public void advanceLastChip(int spaces) {
        if (!placedChips.isEmpty()) {
            PlacedChip last = placedChips.getLast();
            last.setPosition(last.getPosition() + spaces);
            currentPosition += spaces;
        }
    }
    public void placeChip(Chip c, Player p, int set) {
        StringBuilder log = new StringBuilder();
        int move = c.getValue();

        //red set 4
        if (set == 4 &&  c.getColor() == ChipColor.WHITE && c.getValue() == 1) {
            if (countIngredient(ChipColor.RED) >= 1) {
                move = 2;
                log.append("Red set 4: White 1 chip moves 2 spaces because a red chip is present. ");
            }
        }
        //red set 1
        if (set == 1 && c.getColor() == ChipColor.RED) {
            int orangeCount = countIngredient(ChipColor.ORANGE);
            if (orangeCount >= 3) {
                move += 2;
                log.append("Red set 1: Red chip moves 2 extra spaces because 3 or more orange chips are present. ");
            } else if (orangeCount >= 1) {
                move += 1;
                log.append("Red set 1: Red chip moves 1 extra space because at least 1 orange chip is present. ");
            }
        }
        //red set 3
        if (set == 3 && c.getColor() == ChipColor.RED && !placedChips.isEmpty()) {
            PlacedChip last = placedChips.getLast();
            if (last.getChip().getColor() == ChipColor.WHITE) {
                move += last.getChip().getValue();
                log.append("Red set 3: Red chip moves extra spaces equal to the value of the last placed white chip. ");
            }
        }
        //yellow set 1
        if (set == 1 && c.getColor() == ChipColor.YELLOW && !placedChips.isEmpty()) {
            PlacedChip last = placedChips.getLast();
            if (last.getChip().getColor() == ChipColor.WHITE) {
                placedChips.removeLast();
                p.addChipToBag(last.getChip());
                log.append("Yellow set 1: Last placed white chip is removed and returned to the player's bag. ");
            }
        }
        //yellow set 4
        if (set == 4 && c.getColor() == ChipColor.YELLOW) {
            int yellowCount = countIngredient(ChipColor.YELLOW);
            if (yellowCount < 3) {
                move += yellowCount + 1;
            }
        }
        //yellow set 2
        if (doubleNextChip) {
            move *= 2;
            doubleNextChip = false;
            log.append("Yellow set 2: Next chip's movement is doubled. ");
        }
        int targetPosition = Math.min(53, currentPosition + move);
        placedChips.add(new PlacedChip(c, targetPosition));

        //yellow set 2 for next chip
        if (set == 2 && c.getColor() == ChipColor.YELLOW) {
            doubleNextChip = true;
            log.append("Yellow set 2: Next chip's movement will be doubled. ");
        }

        //blue set 3 and 4
        if (c.getColor() == ChipColor.BLUE && hasRubyForSpace(targetPosition)) {
            if (set == 3) {
                p.addRubies(1);
                log.append("Blue set 3: Player gains 1 ruby for placing a blue chip on a ruby space. ");
            } else if (set == 4) {
                p.addTotalScore(c.getValue());
                log.append("Blue set 4: Player gains ").append(c.getValue()).append(" victory points for placing a blue chip on a ruby space. ");
            }
        }
        //check explosion
        int limit = getExplosionThreshold(set);
        if (getWhiteSum() > limit) {
            exploded = true;
            if (blueShieldRemaining > 0) {
                explosionProtected = true;
                log.append("Explosion protected by blue shield. ");
            } else {
                log.append("Potion exploded! ");
            }
        }
        //update blue set 2 shield counter
        if (blueShieldRemaining > 0) {
            blueShieldRemaining--;
        }
        if (set == 2 && c.getColor() == ChipColor.BLUE) {
            blueShieldRemaining = c.getValue();
            log.append("Blue set 2: Player gains a shield for the next").append(c.getValue()).append(" chip(s)!]");
        }
        System.out.println(log.toString());
    }

    public Chip removeLastChipIfWhite(Bag bag) {
        if (placedChips.isEmpty() || exploded) {
            return null;
        }
        PlacedChip last = placedChips.getLast();
        if (last.getChip().getColor() == ChipColor.WHITE) {
            placedChips.removeLast();
            currentPosition -= last.getChip().getValue();
            bag.addChip(last.getChip());
            return last.getChip();
        }

        return null;
    }
}
