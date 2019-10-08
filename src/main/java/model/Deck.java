package model;

import java.util.ArrayList;
import util.GenericCardConstant;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * Uses the Iterator Pattern to iterate through the cards in the deck.
 */
public class Deck implements Iterator<Card> {


    private int iteratorPosition = 0;

    // all games can be use same deck to reduce memory allocation
    private List<Card> cards;

    public Deck(){
        cards = new ArrayList<>(GenericCardConstant.TOTAL_CARD);
        final List<Card> singletonDeck = SingletonDeck.getDeck().getCards();
        cards.addAll(singletonDeck);
        shuffle();
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     *
     * @return boolean
     */
    public boolean hasNext() {
        return iteratorPosition < GenericCardConstant.TOTAL_CARD;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the cards
     */
    public Card next() {
        return cards.get(iteratorPosition++);
    }

    /**
     * To shuffling cards.
     */
    private void shuffle(){
        Collections.shuffle(cards);
        iteratorPosition = 0;
    }

    /**
     * Returns the cards
     *
     * @return cards
     */
    public List<Card> getCards() {
        return cards;
    }
}
