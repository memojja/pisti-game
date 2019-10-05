package model;

import java.util.stream.Stream;

public enum Value {
    ACE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),JACK(11),QUEEN(12),KING(13);

    private int value;

    Value(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Stream<Value> stream() {
        return Stream.of(Value.values());
    }

    @Override
    public String toString() {
        if(value == 1) return "A";
        else if(value == 11) return "J";
        else if(value == 12) return "Q";
        else if(value == 13) return "K";
        else return String.valueOf(value);
    }
}
