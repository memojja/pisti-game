package model;

import java.util.stream.Stream;

public enum Suit {
    SPADES(0),DIAMOND(1),CLUB(2),HEARTS(3);

    private int value;

    Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Stream<Suit> stream(){
        return Stream.of(Suit.values());
    }

    @Override
    public String toString() {
        if(value == 0) return "Spades";
        else if(value == 1) return "Diamond";
        else if(value == 2) return "Club";
        else if(value == 3) return "Hearts";
        else throw new RuntimeException("Suit index must be between 0 and 3");
    }
}
