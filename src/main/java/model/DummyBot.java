package model;

import org.apache.log4j.Logger;

import java.util.List;

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
            if (myCard.equals(discardedCards.get(discardedCards.size() - 1))) {
                card = myCard;
                break;
            }
            if (myCard.getNumber().equals(Value.JACK)) {
                card = myCard;
            }
        }

        card = card != null ?  card : myCards.get(GameState.random.nextInt(myCards.size()));
        logger.debug(gameState.getGameName() + " " + "Player " + getIndex() + " played " + card);
        return card;
    }
}
