package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Singleton class for a deck of cards to reduce memory allocation.
 */
public class SingletonDeck {

    private static SingletonDeck singletonDeck;

    private static List<Card> cards;


    private SingletonDeck(){
        cards = new ArrayList<>(52);
        fillDeck();
    }

    public static SingletonDeck getDeck() {
        if(singletonDeck == null){
            synchronized (SingletonDeck.class){
                singletonDeck = new SingletonDeck();
            }
        }
        return singletonDeck;
    }

    public List<Card> getCards() {
        return cards;
    }

    private void fillDeck() {
        Suit.stream().forEach(suit -> {
            Value.stream().forEach(value -> {
                cards.add(new Card(suit,value));
            });
        });
    }

}
