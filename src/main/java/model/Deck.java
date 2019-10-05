package model;

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

    // all games can be use same deck
    private static List<Card> cards;

    public Deck(){
        cards = SingletonDeck.getDeck().getCards();
        shuffle();
        System.out.println(cards);
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

}
