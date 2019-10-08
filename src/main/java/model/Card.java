package model;

import java.util.Objects;

/**
 *
 * Simple card that default face is face down
 */
public class Card {

    private Value value;
    private Suit suit;
    private boolean isFront;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
        isFront = false;
    }

    protected Card(Card card,boolean isFront) {
        this.suit = card.getSuit();
        this.value = card.getNumber();
        this.isFront = isFront;
    }

    public Value getNumber() {
        return value;
    }

    public void setNumber(Value number) {
        this.value = number;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public boolean isFront() {
        return isFront;
    }

    public void setFront(boolean front) {
        isFront = front;
    }

    @Override
    public String toString() {
        return "Card{" + suit +' '+ value +  '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Card card = (Card) o;
        return value == card.value &&
                suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, suit);
    }
}
