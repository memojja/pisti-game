package model;

import java.util.ArrayList;
import java.util.List;
import util.GenericCardConstant;

/**
 *
 * Singleton class for a deck of cards to reduce memory allocation.
 */
public class SingletonDeck {

    private static SingletonDeck singletonDeck;

    private static List<Card> cards;


    private SingletonDeck(){
        cards = new ArrayList<>(GenericCardConstant.TOTAL_CARD);
        fillDeck();
    }

    /**
     * Return thread safe singleteton deck
     *
     * @return
     */
    public static SingletonDeck getDeck() {
        if(singletonDeck == null){
            synchronized (SingletonDeck.class){
                singletonDeck = new SingletonDeck();
            }
        }
        return singletonDeck;
    }


    /**
     *
     * fill 52 card to deck
     *
     */
    private void fillDeck() {
        Suit.stream().forEach(suit -> {
            Value.stream().forEach(value -> {
                cards.add(new Card(suit,value));
            });
        });
    }

    /**
     * Return cards inside the deck
     *
     * @return cards
     */
    public List<Card> getCards() {
        return cards;
    }

}
