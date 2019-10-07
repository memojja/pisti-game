package model;

import java.util.ArrayList;
import java.util.Random;
import util.GenericCardUtil;

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
        cards = new ArrayList<>(53);
        List<Card> singletonDeck = SingletonDeck.getDeck().getCards();
        singletonDeck.stream()
            .forEach(card -> cards.add(card));
        shuffle();
    }

    public boolean hasNext() {
        return iteratorPosition < GenericCardUtil.TOTAL_CARD;
    }

    public Card next() {
        return cards.get(iteratorPosition++);
    }

    private void shuffle(){
        Collections.shuffle(cards);
        iteratorPosition = 0;
    }

    public List<Card> getCards() {
        return cards;
    }
}
