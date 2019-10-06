package model;

import org.apache.log4j.Logger;

import java.util.List;

public class SmartBot extends Player {

    private final static Logger logger = Logger.getLogger(String.valueOf(SmartBot.class));

    public SmartBot(int index, String gameName) {
        super(index,gameName);
    }

    @Override
    public Card logic(GameState gameState) {
        List<Card> discardedCards = gameState.getDiscardedCards();
        List<Card> myCards = gameState.getPlayersCards().get(getIndex());
        Card card = null;

        // write logic

        logger.debug(gameState.getGameName() + " " + "Player " + getIndex() + " played " + card);
        return card;
    }
}
