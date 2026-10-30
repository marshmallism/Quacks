package back;

import java.util.TreeMap;

public class Player {
    private String name;
    private TreeMap<Integer, Integer> chips; // key: chip value, value: number of chips
    private Pot pot;
    private int currentScore;
    private int totalScore;
    private boolean flaskFull;
    private int rubies;
    private int ratTails;
    private boolean exploded;
    private boolean stopped;
    private int dropletPos;
    private int ratStonePos;
    private boolean isRollDie;
    private boolean recievesVP;
    private boolean recievesCoins;
    private Bag bag;

    public Player(String name) {
        this.name = name;
        chips = new TreeMap<Integer, Integer>();
        pot = new Pot();
        flaskFull = true;
        rubies = 1;
        bag = new Bag();
    }
    public void roundReset() {
        bag.roundReset();
        pot.resetPot();
        totalScore += currentScore;
        currentScore = 0;
    }
    public void placeInPot(Chip chip) {
        pot.addChip(chip);
    }
    public void moveDroplet(int spaces) {
        dropletPos += spaces;
    }
    public boolean spendRubies(int amount) {
        if (rubies >= amount) {
            rubies -= amount;
            return true;
        }
        return false;
    }
    public int getBagSize() {
        return bag.getAvailableChips().size();
    }
    public int getCurrentPosition() {
        return pot.getPosition();
    }
    public void refillFlask() {
        flaskFull = true;
    }
    public void useFlask() {
        flaskFull = false;
    }
    public void addRubies(int amount) {
        rubies += amount;
    }
    public void setRatTails(int amount) {
        ratTails = amount;
    }
    public void explode() {
        exploded = true;
    }
    public void stopDrawing() {
        stopped = true;
    }
    public void setRatStonePos(int pos) {
        ratStonePos = pos;
    }
    public void setIsRollDie(boolean isRollDie) {
        this.isRollDie = isRollDie;
    }
    public void setRecievesVP(boolean recievesVP) {
        this.recievesVP = recievesVP;
    }
    public void setRecievesCoins(boolean recievesCoins) {
        this.recievesCoins = recievesCoins;
    }
    //getters
    public String getName() {return name;}
    public TreeMap<Integer, Integer> getChips() {return chips;}
    public Pot getPot() {return pot;}
    public int getCurrentScore() {return currentScore;}
    public int getTotalScore() {return totalScore;}
    public boolean isFlaskFull() {return flaskFull;}
    public int getRubies() {return rubies;}
    public int getRatTails() {return ratTails;}
    public boolean isExploded() {return exploded;}
    public boolean isStopped() {return stopped;}
    public int getDropletPos() {return dropletPos;}
    public int getRatStonePos() {return ratStonePos;}
    public boolean isRollDie() {return isRollDie;}
    public boolean isRecievesVP() {return recievesVP;}
    public boolean isRecievesCoins() {return recievesCoins;}
    public Bag getBag() {return bag;}

}
