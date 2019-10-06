package util;

import model.Card;
import model.GameState;
import model.Value;

import java.util.List;

public class GenericCardUtil {
    public static int TOTAL_CARD = 52;

    public static boolean isPisti(GameState gameState) {
        List<Card> discardedCards = gameState.getDiscardedCards();
        int discardedCardSize = gameState.getCollectedCardIndex()+1;
        return discardedCardSize+2 == discardedCards.size() &&
                (discardedCards.get(0).equals(discardedCards.get(1)));
    }

    public static boolean canIGetAllDiscardedCards(GameState gameState){
        List<Card> discardedCards = gameState.getDiscardedCards();
        return  ((discardedCards.get(discardedCards.size()-1).equals(discardedCards.get(discardedCards.size()-2)))
                 || discardedCards.get(discardedCards.size()-1).getNumber().equals(Value.JACK));
    }

}
