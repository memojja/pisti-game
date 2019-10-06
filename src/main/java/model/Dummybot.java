package model;

import java.util.List;

public class Dummybot extends Player {
    public Dummybot(int index) {
        super(index);
    }

    @Override
    public Card logic(GameState gameState) {
        List<Card> discardedCards = gameState.getDiscardedCards();
        List<Card> myCards = gameState.getPlayersCards().get(getIndex());
        int jokerIndex = 99;

        for (int i = 0; i < myCards.size() ; i++) {
            if(myCards.get(i).equals(discardedCards.get(discardedCards.size()-1))){
                return myCards.get(i);
            }
            if(myCards.get(i).getNumber().equals(Value.JACK)){
                jokerIndex = i;
            }
        }

       if(jokerIndex != 99){
            return myCards.get(jokerIndex);
        }
        System.out.println(getIndex() + "= " +myCards.size());
        return myCards.get(GameState.random.nextInt(myCards.size()));
    }
}
