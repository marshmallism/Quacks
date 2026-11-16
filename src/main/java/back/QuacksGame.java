package back;

import java.util.*;

public class QuacksGame {
    ArrayList<Player> players;
    static int NUM_PLAYERS;
    static int round;
    static int currentPlayer;
    static int phase;
    static int set;
    static ArrayList<FortuneCard> deck;
    static IngredientsAndRubies supply;
    static HashSet<Player> stoppedPlayers;
    static int explosionLimit;

    public QuacksGame(int numPlayers, int s) {
        NUM_PLAYERS = numPlayers;
        set = set;
        players = new ArrayList<>();
        for (int i = 1; i < numPlayers; i++) {
            players.add(new Player("Player" + i, s));
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
