package back;

import front.GameScreenPanel;

import java.util.*;

public class QuacksGame {
    public enum Phase {
        FORTUNE, POTION, EVALUATION, END
    }
    ArrayList<Player> players;
    static int NUM_PLAYERS;
    static int round;
    static int currentPlayer;
    static Phase phase;
    static int set;
    static FortuneDeck deck;
    static IngredientsAndRubies supply;
    static HashSet<Player> stoppedPlayers;
    static int explosionLimit;
    static FortuneCard currentFortune;

    public QuacksGame(int numPlayers, int s) {
        NUM_PLAYERS = numPlayers;
        set = set;
        players = new ArrayList<>();
        for (int i = 1; i < numPlayers; i++) {
            players.add(new Player("Player" + i, s));
        }
    }

    public void startNewRound() {
        round++;
        for (Player p : players) {
            p.roundReset();
        }
    }
    public void handleDraw(int index, Chip c) {
        currentPlayer = index;
        String log = players.get(currentPlayer).placeInPot(c);

    }
    public void handleEvaluation() {

    }
    public void drawFortune() {
        currentFortune = deck.nextCard();
        if (currentFortune.getType() == FortuneType.PURPLE) {
            FortuneRule rule = currentFortune.getRule();
            switch (rule) {
                case A_GOOD_START: {
                    GameScreenPanel.
                    break;
                }
                case AN_OPPORTUNISTIC_MOMENT: break;
                case RAT_INFESTATION: break;
                case CHOOSE_WISELY: break;
                case YOU_ONLY_GET_TO_CHOOSE_ONE: break;
                case ROLL_THE_DIE: break;
                case BEGINNERS_BONUS: break;
                case RATS_ARE_YOUR_FRIENDS: break;
                case WHEEL_AND_DEAL: break;
                case LESS_IS_MORE: break;
                case JUST_IN_TIME: break;
                case THE_POT_IS_FILLING_UP: break;
                case CHARITY: break;
            }
        }
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public Phase getPhase() {
        return phase;
    }
}
