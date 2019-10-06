package model;

import org.apache.log4j.Logger;

import java.util.List;

public class Dummybot extends Player {

    private final static Logger logger = Logger.getLogger(String.valueOf(Dummybot.class));

    public Dummybot(int index,String gameName) {
        super(index,gameName);
    }

    @Override
    public Card logic(GameState gameState) {
        List<Card> discardedCards = gameState.getDiscardedCards();
        List<Card> myCards = gameState.getPlayersCards().get(getIndex());
        Card card = null;

        for (int i = 0; i < myCards.size() ; i++) {
            if(myCards.get(i).equals(discardedCards.get(discardedCards.size()-1))){
                card = myCards.get(i);
                break;
            }
            if(myCards.get(i).getNumber().equals(Value.JACK)){
                card = myCards.get(i);
            }
        }

        card = card != null ?  card : myCards.get(GameState.random.nextInt(myCards.size()));

        logger.debug(gameState.getGameName() + " " + "Player " + getIndex() + " played " + card);

        return card;
    }
}
