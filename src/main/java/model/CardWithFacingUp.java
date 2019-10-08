package model;

/**
 *
 * Card that default face is face up
 */
public class CardWithFacingUp extends Card {
    public CardWithFacingUp(Card card) {
        super(card,true);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
