package back;

public class PlacedChip {
    Chip chip;
    int position;
    public PlacedChip(Chip chip, int position) {
        this.chip = chip;
        this.position = position;
    }
    public Chip getChip() {
        return chip;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
}
