package back;

import java.util.ArrayList;

import static back.FortuneRule.*;
import static back.FortuneType.*;

public class FortuneDeck {
    ArrayList<FortuneCard> cards = new ArrayList<FortuneCard>();

    public FortuneDeck() {

        //create purple cards
        cards.add(new FortuneCard(PURPLE, A_GOOD_START, image));
        cards.add(new FortuneCard(PURPLE, AN_OPPORTUNISTIC_MOMENT, image));
        cards.add(new FortuneCard(PURPLE, RAT_INFESTATION, image));
        cards.add(new FortuneCard(PURPLE, CHOOSE_WISELY, image));
        cards.add(new FortuneCard(PURPLE, YOU_ONLY_GET_TO_CHOOSE_ONE, image));
        cards.add(new FortuneCard(PURPLE, ROLL_THE_DIE, image));
        cards.add(new FortuneCard(PURPLE, BEGINNERS_BONUS, image));
        cards.add(new FortuneCard(PURPLE, RATS_ARE_YOUR_FRIENDS, image));
        cards.add(new FortuneCard(PURPLE, WHEEL_AND_DEAL, image));
        cards.add(new FortuneCard(PURPLE, LESS_IS_MORE, image));
        cards.add(new FortuneCard(PURPLE, JUST_IN_TIME, image));
        cards.add(new FortuneCard(PURPLE, THE_POT_IS_FILLING_UP, image));
        cards.add(new FortuneCard(PURPLE, CHARITY, image));
        //create blue cards
        cards.add(new FortuneCard(BLUE, THE_POT_IS_FULL, image));
        cards.add(new FortuneCard(BLUE, WELL_STIRRED, image));
        cards.add(new FortuneCard(BLUE, LIVING_IN_LUXURY, image));
        cards.add(new FortuneCard(BLUE, A_SECOND_CHANCE, image));
        cards.add(new FortuneCard(BLUE, STRONG_INGREDIENT, image));
        cards.add(new FortuneCard(BLUE, SEASONED_PERFECTLY, image));
        cards.add(new FortuneCard(BLUE, SCHADENFREUDE, image));
        cards.add(new FortuneCard(BLUE, ITS_SHINING_EXTRA_BRIGHT, image));
        cards.add(new FortuneCard(BLUE, LUCKY_DEVIL, image));
        cards.add(new FortuneCard(BLUE, PUMPKIN_PATCH_PARTY, image));
        cards.add(new FortuneCard(BLUE, MAGIC_POTION, image));

    }
    //draw and remove a random card from the deck
    public FortuneCard nextCard() {
        int randIndex = (int)(Math.random() * cards.size());
        return cards.remove(randIndex);
    }
}
