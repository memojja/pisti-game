package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class GameState {

    private Deck deck;
    private List<List<Card>> playersCards;
    private List<Card> discardedCards;
    private int collectedCardIndex = 0;
    private int giveCardCount = 0;
    private int turn;
    private String gameName;

    public static final Random random = new Random(System.currentTimeMillis());

    public GameState(String gameName){
        deck = new Deck();
        playersCards = new ArrayList<>(4);
        discardedCards = new ArrayList<>(52);
        turn = random.nextInt(4);

        fillDiscardedCardWithFacingUpCards();
        giveFourCardAllOfPlayer();
        this.gameName = gameName;
    }

    public void giveFourCardAllOfPlayer(){
        IntStream.range(0,4)
                .forEach(i-> {
                    IntStream.range(0,4).forEach(j->{
                        playersCards.get(i).add(deck.next());
                    });
                });
        giveCardCount++;
    }

    public void incrementTurn(){
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

    private void fillDiscardedCardWithFacingUpCards() {
        IntStream.range(0,4).forEach(i -> {
            playersCards.add(new LinkedList<>());
            discardedCards.add(new CardWithFacingUp(deck.next()));
        });
    }

    private boolean dontHavePlayersCard() {
        return playersCards.get(0).size() == 0 &&
                playersCards.get(1).size() == 0 &&
                playersCards.get(2).size() == 0 &&
                playersCards.get(3).size() == 0;
    }
}
