package model;

import org.apache.log4j.Logger;

import java.util.List;

/**
 *
 * A bot that has dummy logic
 */
public class DummyBot extends Player {

    private final static Logger logger = Logger.getLogger(String.valueOf(DummyBot.class));

    public DummyBot(int index, String gameName) {
        super(index,gameName);
    }

    @Override
    public Card logic(GameState gameState) {
        List<Card> discardedCards = gameState.getDiscardedCards();
        List<Card> myCards = gameState.getPlayersCards().get(getIndex());
        Card card = null;

        for (Card myCard : myCards) {
            if (myCard.getNumber().equals(discardedCards.get(discardedCards.size() - 1).getNumber())) {
                card = myCard;
                break;
            }
            if (myCard.getNumber().equals(Value.JACK)) {
                card = myCard;
            }
        }

        try {
            card = card != null ?  card : myCards.get(GameState.random.nextInt(myCards.size()));
        }catch (IllegalArgumentException e){
            logger.debug(gameState.getGameName() + " " + "Player " + getIndex() + " dont have card ",e);
        }
        logger.debug(gameState.getGameName() + " " + "Player " + getIndex() + " played " + card);
        return card;
    }
}
