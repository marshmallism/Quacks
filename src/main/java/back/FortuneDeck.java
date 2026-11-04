package back;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import static back.FortuneRule.*;
import static back.FortuneType.*;

public class FortuneDeck {
    ArrayList<FortuneCard> cards = new ArrayList<FortuneCard>();
    BufferedImage[] purple = new BufferedImage[13];
    BufferedImage[] blue = new BufferedImage[11];
    public FortuneDeck() {
        try {
            for (int i = 0; i < 13; i++) {
                purple[i] = ImageIO.read(new File("F"+(i+1)));
            }
            for (int i = 0; i < 11; i++) {
                blue[i] = ImageIO.read(new File("FB"+(i+1)));
            }
        }
        catch (Exception E) {
            System.out.println("Exception Input Error");
            return;
        }
        //create purple cards
        int index = 0;
        cards.add(new FortuneCard(PURPLE, A_GOOD_START, purple[index++]));
        cards.add(new FortuneCard(PURPLE, AN_OPPORTUNISTIC_MOMENT, purple[index++]));
        cards.add(new FortuneCard(PURPLE, RAT_INFESTATION, purple[index++]));
        cards.add(new FortuneCard(PURPLE, CHOOSE_WISELY, purple[index++]));
        cards.add(new FortuneCard(PURPLE, YOU_ONLY_GET_TO_CHOOSE_ONE, purple[index++]));
        cards.add(new FortuneCard(PURPLE, ROLL_THE_DIE, purple[index++]));
        cards.add(new FortuneCard(PURPLE, BEGINNERS_BONUS, purple[index++]));
        cards.add(new FortuneCard(PURPLE, RATS_ARE_YOUR_FRIENDS, purple[index++]));
        cards.add(new FortuneCard(PURPLE, WHEEL_AND_DEAL, purple[index++]));
        cards.add(new FortuneCard(PURPLE, LESS_IS_MORE, purple[index++]));
        cards.add(new FortuneCard(PURPLE, JUST_IN_TIME, purple[index++]));
        cards.add(new FortuneCard(PURPLE, THE_POT_IS_FILLING_UP, purple[index++]));
        cards.add(new FortuneCard(PURPLE, CHARITY, purple[index]));
        
        //create blue cards
        index = 0;
        cards.add(new FortuneCard(BLUE, THE_POT_IS_FULL, blue[index++]));
        cards.add(new FortuneCard(BLUE, WELL_STIRRED, blue[index++]));
        cards.add(new FortuneCard(BLUE, LIVING_IN_LUXURY, blue[index++]));
        cards.add(new FortuneCard(BLUE, A_SECOND_CHANCE, blue[index++]));
        cards.add(new FortuneCard(BLUE, STRONG_INGREDIENT, blue[index++]));
        cards.add(new FortuneCard(BLUE, SEASONED_PERFECTLY, blue[index++]));
        cards.add(new FortuneCard(BLUE, SCHADENFREUDE, blue[index++]));
        cards.add(new FortuneCard(BLUE, ITS_SHINING_EXTRA_BRIGHT, blue[index++]));
        cards.add(new FortuneCard(BLUE, LUCKY_DEVIL, blue[index++]));
        cards.add(new FortuneCard(BLUE, PUMPKIN_PATCH_PARTY, blue[index++]));
        cards.add(new FortuneCard(BLUE, MAGIC_POTION, blue[index]));
    }
    //draw and remove a random card from the deck
    public FortuneCard nextCard() {
        int randIndex = (int)(Math.random() * cards.size());
        return cards.remove(randIndex);
    }
}
