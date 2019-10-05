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
    private int turn;

    public static final Random random = new Random(System.currentTimeMillis());

    public GameState(){
        deck = new Deck();
        playersCards = new ArrayList<>(4);
        discardedCards = new ArrayList<>(52);
        turn = random.nextInt(4);

        IntStream.range(0,4).forEach(value -> playersCards.add(new LinkedList<>()));
        IntStream.range(0,4).forEach(i -> {
            discardedCards.add(new CardWithFacingUp(deck.next()));
            IntStream.range(0,4).forEach(j -> {
                playersCards.get(i).add(deck.next());
            });
        });
    }

    public List<List<Card>> getPlayersCards() {
        return playersCards;
    }

    public void setPlayersCards(List<List<Card>> playersCards) {
        this.playersCards = playersCards;
    }

    public List<Card> getDiscardedCards() {
        return discardedCards;
    }

    public void setDiscardedCards(List<Card> discardedCards) {
        this.discardedCards = discardedCards;
    }

    public int getTurn() {
        return turn;
    }
}
