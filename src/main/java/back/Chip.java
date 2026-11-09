package back;

public class hip {
    private final ChipColor color;
    private final int value;

    public Chip(ChipColor color, int value) {
        this.color = color;
        this.value = value;
    }

    public ChipColor getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }
    public String toString() {
        return color.name() + " " + value;
    }
}
