package back;
public class FortuneCard {
    private final String name;
    private final String description;
    private final FortuneCardType type;

    public FortuneCard(String name, String description, FortuneCardType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public FortuneCardType getType() { return type; }

    @Override
    public String toString() {
        return "[" + type.name() + "] " + name + ": " + description;
    }
}