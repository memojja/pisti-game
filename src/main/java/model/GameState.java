package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import org.apache.log4j.Logger;
import util.GenericCardConstant;

/**
 *
 * A class that only uses game state
 */
public class GameState {

    private Deck deck;
    private List<List<Card>> playersCards;
    private List<Card> discardedCards;
    private int collectedCardIndex = 0;
    private int giveCardCount = 0;
    private int turn;
    private int userActionCount = 0;
    private String gameName;

    private final static Logger logger = Logger.getLogger(String.valueOf(GameState.class));
    public static final Random random = new Random(System.currentTimeMillis());

    public GameState(String gameName){
        deck = new Deck();
        playersCards = new ArrayList<>(4);
        discardedCards = new ArrayList<>(GenericCardConstant.TOTAL_CARD);
        turn = random.nextInt(4);

        fillDiscardedCardWithFacingUpCards();
        giveFourCardAllOfPlayer();
        this.gameName = gameName;
    }

    /**
     * To give 4 cards to all players
     *
     */
    public void giveFourCardAllOfPlayer(){
        try {
            IntStream.range(0,4)
                .forEach(i-> {
                    IntStream.range(0,4).forEach(j->{
                        playersCards.get(i).add(deck.next());
                    });
                });
            giveCardCount++;
        }catch (IndexOutOfBoundsException e){
            logger.debug("IndexOutOfBoundsException" + giveCardCount,e);
        }

    }

    /**
     *
     * increment user turn
     */
    public void incrementTurn(){
        userActionCount++;
        turn = turn == 3 ? 0 : ++turn;
    }

    public boolean isFinished() {
        return giveCardCount == 3 && dontHavePlayersCard();
    }

    public int getCollectedCardIndex() {
        return collectedCardIndex;
    }

    public void setCollectedCardIndex(int collectedCardIndex) {
        this.collectedCardIndex = collectedCardIndex;
    }

    public int getGiveCardCount() {
        return giveCardCount;
    }

    public List<List<Card>> getPlayersCards() {
        return playersCards;
    }

    public List<Card> getDiscardedCards() {
        return discardedCards;
    }

    public int getTurn() {
        return turn;
    }

    public String getGameName() {
        return gameName;
    }

    public int getUserActionCount() {
        return userActionCount;
    }

    public void setUserActionCount(int userActionCount) {
        this.userActionCount = userActionCount;
    }

    /**
     * fill discarded cards list with four facing up cards at have initialize
     *
     */
    private void fillDiscardedCardWithFacingUpCards() {
        IntStream.range(0,4).forEach(i -> {
            playersCards.add(new LinkedList<>());
            discardedCards.add(new CardWithFacingUp(deck.next()));
        });
    }

    /**
     * check if players have a card
     * @return boolean
     */
    private boolean dontHavePlayersCard() {
        return playersCards.get(0).size() == 0 &&
                playersCards.get(1).size() == 0 &&
                playersCards.get(2).size() == 0 &&
                playersCards.get(3).size() == 0;
    }
}
