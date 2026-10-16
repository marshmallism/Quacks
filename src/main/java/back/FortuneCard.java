package back;

import java.awt.image.BufferedImage;

public class FortuneCard {
    private final FortuneType type;
    private final FortuneRule rule;
    private final BufferedImage image;

    public FortuneCard(FortuneType type, FortuneRule rule, BufferedImage image) {
        this.type = type;
        this.rule = rule;
        this.image = image;
    }

    public FortuneType getType() { return type; }
    public FortuneRule getRule() { return rule; }
    public BufferedImage getImage() { return image; }

    @Override
    public String toString() {
        return "[" + type.name() + "] " + rule.name() + ": " + image;
    }
}